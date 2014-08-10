/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.ContactCriteria;
import com.epicsaas.app.crm.entity.gen.ContractCriteria;
import com.epicsaas.app.crm.service.ICompanyService;
import com.epicsaas.app.crm.service.IContactService;
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
 * Main控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/company")
public class CompanyController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);
    
    @Resource
    private ICompanyService companyService;
    
    /**
     * 
     * 合同
     */
    @Resource
    private IContractService contractService;
    
    /**
     * 联系人
     */
    @Resource
    private IContactService contactService;

	/**
     * 应用主入口地址
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String hello(Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){

    	
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
    public String create(Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }
    
	/**
     * 保存公司信息
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveCustomer", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object saveOrUpdate(CompanyAO companyAO, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        
        ServiceResult<CompanyAO>  ret= companyService.saveOrUpdateRetAO(companyAO);
       
      
        return ret;
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
    public String create(@PathVariable String dataId, Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<CompanyAO>  ret= companyService.getById(dataId);
        if(ret.isSucceed() && null != ret.getData()){
            model.addAttribute("company", ret.getData());
        }
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }
    
    
	/**
     *  删除公司信息 （系统管理员才有权限操作）
     * @param dataId 业务数据ID
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/delete/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object delete(@PathVariable String dataId, Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<Boolean>  ret= new ServiceResult<Boolean>();
        //1 删除该公司的合同信息 （附件信息 删除 ）
        ContractCriteria criteria = new ContractCriteria();
        criteria.createCriteria().andCompanyIdEqualTo(dataId);
        ret = contractService.deleteByCriteria(criteria);
        
        //2 删除联系人信息
        ContactCriteria criteria2 = new ContactCriteria();
        criteria2.createCriteria().andCompanyIdEqualTo(dataId);
        ret = contactService.deleteByCriteria(criteria2);
        
        //删除公司信息
        ret =companyService.deleteById(dataId);
        return ret;	
    }
    
}
