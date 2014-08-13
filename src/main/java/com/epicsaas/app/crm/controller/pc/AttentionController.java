/*
 * Copyright (c) 2012, Yunnan Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicsaas.framework.util.DateTimeUtils;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.appobject.AttentionAO;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Attention控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/attention")
public class AttentionController {

    private static Logger LOG = LoggerFactory.getLogger(AttentionController.class);

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getHello(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        mv.setViewName(MVCViewName.APP_CRM_PC_IE9_MAIN_ATTENTION.toString());
        return mv;
    }
    
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView add(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }  
    
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView list(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    
    
    @RequestMapping(value = "/view/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView viewById(@PathVariable String dataId,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    
    @RequestMapping(value = "/update/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView updateById(@PathVariable String dataId,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    @RequestMapping(value = "/delete/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView deleteById(@PathVariable String dataId,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		//将当前运用名称传到前端
 	
        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        
        return mv;
    }
    
    /**
    *异步提交表单
    **/
    @RequestMapping(value = "/submitAJAXForm", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object submitAJAXForm(@Valid AttentionAO source,Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(),DateTimeUtils.FORMAT_YMD_HMS));
		ServiceResult<Object> ret = new ServiceResult<Object>();

        return ret;
    }
    
    
}
