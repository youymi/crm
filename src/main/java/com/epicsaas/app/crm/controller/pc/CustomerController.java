/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicsaas.app.crm.appobject.ActivityAO;
import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.appobject.ContactAO;
import com.epicsaas.app.crm.appobject.ContractAO;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.ActivityCriteria;
import com.epicsaas.app.crm.entity.gen.ContactCriteria;
import com.epicsaas.app.crm.entity.gen.ContractCriteria;
import com.epicsaas.app.crm.service.IActivityService;
import com.epicsaas.app.crm.service.ICompanyService;
import com.epicsaas.app.crm.service.IContactService;
import com.epicsaas.app.crm.service.IContractService;

@Controller
@RequestMapping("/pc/customer")
public class CustomerController {

    private static Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    /**
     * 联系人
     */
    @Resource
    private IContactService contactService;

    @Resource
    private IContractService contractService;

    @Resource
    private IActivityService activityService;

    @Resource
    private ICompanyService companyService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

            public void setAsText(String value) {

                try {

                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));

                } catch (java.text.ParseException e) {

                    setValue(null);
                }

            };

        });

    }

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String hello(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_CUSTOMER_FORM.toString();
    }

    @RequestMapping(value = "view", method = { RequestMethod.GET, RequestMethod.POST })
    public String view(String id, Model model, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端

        ServiceResult<CompanyAO> ret = companyService.getById(id);
        if (ret != null && ret.getData() != null) {

            model.addAttribute("data", ret.getData());
        }

        //联系人
        ContactCriteria cc = new ContactCriteria();
        cc.createCriteria().andCompanyIdEqualTo(id);
        ServiceResult<List<ContactAO>> contactRet = contactService.selectByCriteria(cc);
        if (contactRet != null && contactRet.getData() != null) {
            model.addAttribute("contactList", contactRet.getData());
        }

        //合同
        ContractCriteria cc2 = new ContractCriteria();
        cc.createCriteria().andCompanyIdEqualTo(id);
        ServiceResult<List<ContractAO>> contractRet = contractService.selectByCriteria(cc2);
        if (contractRet != null && contractRet.getData() != null) {
            model.addAttribute("contractList", contractRet.getData());
        }

        //活动
        ActivityCriteria ac = new ActivityCriteria();
        ac.createCriteria().andCompanyIdEqualTo(id);
        ServiceResult<List<ActivityAO>> acRet = activityService.selectByCriteria(ac);
        if (acRet != null && acRet.getData() != null) {
            model.addAttribute("activityList", acRet.getData());
        }

        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_CUSTOMER_CUSTOMERVIEW.toString();
    }

    @RequestMapping(value = "contactCellform", method = { RequestMethod.GET, RequestMethod.POST })
    public String contactCellform(String dataId, Model model, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        model.addAttribute("dataId", dataId);
        return MVCViewName.APP_CRM_PC_IE9_CUSTOMER_CONTACTCELLFORM.toString();
    }

    @RequestMapping(value = "/saveContact", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object saveContact(ContactAO companyAO, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {

        ServiceResult<ContactAO> ret = contactService.saveOrUpdateRetAO(companyAO);

        return ret;
    }

    @RequestMapping(value = "contractCellform", method = { RequestMethod.GET, RequestMethod.POST })
    public String contractCellform(String dataId, Model model, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        model.addAttribute("dataId", dataId);
        return MVCViewName.APP_CRM_PC_IE9_CUSTOMER_CONTRACTCELLFORM.toString();
    }

    @RequestMapping(value = "/saveContract", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object saveContract(ContractAO companyAO, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {
        LOG.warn("sign date:" + request.getParameter("signDate"));
        ServiceResult<ContractAO> ret = contractService.saveOrUpdateRetAO(companyAO);

        return ret;
    }

    @RequestMapping(value = "activityCellform", method = { RequestMethod.GET, RequestMethod.POST })
    public String activityCellform(String dataId, Model model, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        model.addAttribute("dataId", dataId);
        return MVCViewName.APP_CRM_PC_IE9_CUSTOMER_ACVITITYCELLFORM.toString();
    }

    @RequestMapping(value = "/saveActivity", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object saveactivityCellform(ActivityAO companyAO, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {

        ServiceResult<ActivityAO> ret = activityService.saveOrUpdateRetAO(companyAO);

        return ret;
    }

}
