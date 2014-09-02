/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.util.List;

import com.epicsaas.api.userbase.UserBaseAPI;
import com.epicsaas.app.crm.common.CrmConst;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.service.biz.userbase.dto.GroupDTO;
import com.epicsaas.service.biz.userbase.entity.gen.GroupCriteria;
import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/hello")
public class HelloController {

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
        return MVCViewName.APP_CRM_PC_IE9_HELLO_INDEX.toString();
    }

    @RequestMapping(value = "test", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object test(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        GroupCriteria gc = new GroupCriteria();
        gc.createCriteria().andAppIdEqualTo(CrmConst.__APP_ID);
        ServiceResult<List<GroupDTO>> gl = UserBaseAPI.getInstance().getGroupQueryService().selectByCriteria(gc);
        return gl;
    }

}
