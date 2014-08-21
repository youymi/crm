/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import com.epicsaas.app.crm.common.MVCViewName;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Widget部件控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/widget")
public class WidgetController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String hello(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_WIDGET_INDEX.toString();
    }
}
