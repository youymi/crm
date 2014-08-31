/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.util.Date;
import java.util.List;

import com.epicsaas.api.userbase.UserBaseAPI;
import com.epicsaas.app.crm.appobject.DataDictionaryAO;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.DataDictionaryCriteria;
import com.epicsaas.app.crm.service.IDataDictionaryService;
import com.epicsaas.framework.util.DateTimeUtils;
import com.epicsaas.service.biz.userbase.service.IGroupService;
import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Hello控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/setting")
public class SettingController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);
    
    private final static String TYPE_CUSTOMERTYPE = "customer_type";
    
    @Resource
    private IDataDictionaryService dataDictionaryService;
    

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String setting(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());

        
        DataDictionaryCriteria dataDictionaryCriteria = new DataDictionaryCriteria();
        dataDictionaryCriteria.createCriteria().andIdIsNotNull().andTypeEqualTo(TYPE_CUSTOMERTYPE);
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
				data.setType(TYPE_CUSTOMERTYPE);
				dataDictionaryService.saveOrUpdate(data);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("redirect:/pc/setting");
				return mv;
			}
			
			
			 @RequestMapping(value = "/deleteCustomerType", method = { RequestMethod.GET, RequestMethod.POST })
			    @ResponseBody
			    public Object deleteCustomerType(String ids, Model model, HttpServletRequest request,
			            HttpServletResponse response) {
			        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
			        LOG.info("SessionId %s", request.getSession().getId());
			        ServiceResult<Boolean> ret = new ServiceResult<Boolean>();
			        String idA[] = ids.split(",");
			        for (String id : idA) {
			        	if (StringUtils.isNotBlank(id)) {
			        		 ret = dataDictionaryService.deleteById(id);
			        	}
			        }
			       
			        return ret;
			    }
			 
			    @RequestMapping(value = "/assign", method = { RequestMethod.GET, RequestMethod.POST })
			    @ResponseBody
			    public Object assign(String ids, String destName, String destId,Model model, HttpServletRequest request,
			            HttpServletResponse response) {
			        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
			        LOG.info("SessionId %s", request.getSession().getId());
			        
			        //ServiceResult<Boolean> ret =  companyService.assign(ids, destId, destName);
			        IGroupService groupService = UserBaseAPI.getInstance().getGroupService();
			        ServiceResult<Boolean> ret = groupService.addUser2Group(ids, destId.split(","));
			        
			       
			        
			        return ret;
			    }
}
