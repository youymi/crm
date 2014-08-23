/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.util.Date;
import java.util.List;

import com.epicsaas.app.crm.appobject.DataDictionaryAO;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.DataDictionaryCriteria;
import com.epicsaas.app.crm.service.IDataDictionaryService;
import com.epicsaas.framework.util.DateTimeUtils;
import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Hello控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/setting")
public class SettingController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);
    
    @Resource
    private IDataDictionaryService dataDictionaryService;
    

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String setting(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());

        
        DataDictionaryCriteria dataDictionaryCriteria = new DataDictionaryCriteria();
        dataDictionaryCriteria.createCriteria().andIdIsNotNull();
        ServiceResult<List<DataDictionaryAO>> ret=  dataDictionaryService.selectByCriteria(dataDictionaryCriteria);
        if(ret.isSucceed() && !CollectionUtils.isEmpty(ret.getData())){
        	model.addAttribute("dataDictionaryList", ret.getData());
        			}
        return MVCViewName.APP_CRM_PC_IE9_SETTING_INDEX.toString();
    }
    
    
			@RequestMapping(value = "/saveDataDictionary", method = { RequestMethod.GET,	RequestMethod.POST })
			public ModelAndView saveDataDictionary( @Valid DataDictionaryAO data , Model model, HttpServletRequest request) {
				LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(),request.getHeader("user-agent"));
				LOG.info("SessionId %s", request.getSession().getId());
				
				dataDictionaryService.saveOrUpdate(data);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("redirect:/pc/setting");
				return mv;
			}
}
