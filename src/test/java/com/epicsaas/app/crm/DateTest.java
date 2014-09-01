/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.epicsaas.framework.util.DateTimeUtils;

public class DateTest {

    public List<String> getMonthList(int count, String endTime) {
        //		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        //		SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
        List<String> monthList = new ArrayList<String>();

        Date end = DateTimeUtils.parseStrToDate(endTime, DateTimeUtils.FORMAT_YMD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.MONTH, 0 - count);

        Date begin = calendar.getTime();

        int months = (end.getYear() - begin.getYear()) * 12 + (end.getMonth() - begin.getMonth());

        for (int i = 0; i <= months; i++) {
            calendar = Calendar.getInstance();
            calendar.setTime(begin);
            calendar.add(Calendar.MONTH, i);
            String tmp = DateTimeUtils.formateDateToStr(calendar.getTime(), DateTimeUtils.FORMAT_YMD);
            tmp = tmp.substring(0, tmp.lastIndexOf("-"));
            monthList.add(tmp);
        }

        return monthList;
    }

    public static void main(String[] args) {
        DateTest test = new DateTest();
        String end = DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD);
        System.out.println(end);
        List<String> list = test.getMonthList(7, end);
        System.out.println(list.toString());
    }
}
