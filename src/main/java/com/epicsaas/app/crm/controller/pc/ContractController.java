/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import com.epicsaas.app.crm.appobject.ContractAO;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.service.IContractService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 合同Controller
 */
@Controller
@RequestMapping(value = "/pc/contract")
public class ContractController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    /**
     * 
     * 合同
     */
    @Resource
    private IContractService contractService;

    /**
     * 应用主入口地址
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String hello(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_INDEX.toString();
    }

    /**
     * 打开表单页面
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
    public String create(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    /**
     * 保存合同信息
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public String saveOrUpdate(@Valid ContractAO contractAO, Model model, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());

        ServiceResult<ContractAO> ret = contractService.saveOrUpdateRetAO(contractAO);
        if (ret.isSucceed() && null != ret.getData()) {
            model.addAttribute("contract", ret.getData());
        }
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    /**
     * 打开某种业务数据，例如：打开数据ID等于dataId的请假申请
     * @param dataId 业务数据ID
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/open/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public String create(@PathVariable String dataId, Model model, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<ContractAO> ret = contractService.getById(dataId);
        if (ret.isSucceed() && null != ret.getData()) {
            model.addAttribute("contract", ret.getData());
        }
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    /**
     * 删除合同信息（添加人有权限）
     * @param dataId 业务数据ID
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/delete/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object delete(@PathVariable String dataId, Model model, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<Boolean> ret = new ServiceResult<Boolean>();
        ret = contractService.deleteById(dataId);
        return ret;
    }

}
