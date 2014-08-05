/*
 * Copyright (c) 2012, Yunnan Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * 自动根据src/main/webapp/WEB-INF/mvcViews下的模板文件和目录结构生成ViewName条目列表 ,
 * 并同时更新当前目录的MVCViewName.java文件。
 * 
 * @author Yuanjun.Li
 * 
 */
public class GenerateMVCViewName {
    public static final String       freemarkerTemplateDir = "src/main/webapp/WEB-INF/mvcViews";

    public static final String       suffix                = ".ftl";
    private static ArrayList<String> filelist              = new ArrayList<String>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        String classLoaderPath = Thread.currentThread().getContextClassLoader().getResource("")
                .getFile();
        String targetJavaFile = GenerateMVCViewName.class.getResource("").getFile();
        String path = classLoaderPath.replace("target/classes", freemarkerTemplateDir);
        String javaFile = targetJavaFile.replace("target/classes", "src/main/java")
                + File.separator + "MVCViewName.java";
	
	   try {
        	//转路径空格
			path =  URLDecoder.decode(path, "utf-8");
		} catch (Exception e) { e.printStackTrace();}
	
        File folder = new File(path);

        refreshFileList(path);

        StringBuffer sb = new StringBuffer();
        for (String file : filelist) {
            String viewName = file.replace(folder.getAbsolutePath() + File.separator, "").replace(
                    suffix, "");
            String enumItemName = viewName.replace(File.separator, "_").replace("-", "")
                    .toUpperCase();
            viewName = viewName.replace(File.separator, "/");

            String item = enumItemName + "(\"/" + viewName + "\"),";
            sb.append("\t" + item);
            sb.append("\n");
        }

        sb.replace(sb.length() - 2, sb.length() - 1, ";");

        // System.out.println(sb);

        String oldJavaSource = readFile(new File(javaFile));

        // System.out.println(oldJavaSource);

        int start = oldJavaSource.indexOf("@#############") + "@#############".length() + 1;
        int end = oldJavaSource.lastIndexOf("@#############") - 3;

        String newJavaSource = oldJavaSource.substring(0, start) + sb
                + oldJavaSource.substring(end);
        // System.out.println(newJavaSource);

        // 更新Java代码
        writeFile(new File(javaFile), newJavaSource);

        System.out.println("代码已更新，请刷新：" + javaFile);

    }

    public static void writeFile(File file, String newJavaSource) {
        FileOutputStream out = null;
        try {

            out = new FileOutputStream(file);
            out.write(newJavaSource.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void refreshFileList(String strPath) {
        try {
			strPath =URLDecoder.decode(URLEncoder.encode(strPath, "utf-8"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        File dir = new File(strPath);
        File[] files = dir.listFiles();

        if (files == null)
            return;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                refreshFileList(files[i].getAbsolutePath());
            } else {
                if (files[i].getName().endsWith(suffix)) {
                    filelist.add(files[i].getAbsolutePath());
                }
            }
        }
    }

    /**
     * 
     * @param file
     * @return the file content
     */
    public static String readFile(final File file) {
        InputStream in = null;
        StringBuffer sb = new StringBuffer();
        try {

            in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}
