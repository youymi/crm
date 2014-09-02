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

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicsaas.api.userbase.UserBaseAPI;
import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.common.CrmConst;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.CompanyCriteria;
import com.epicsaas.app.crm.entity.gen.ContactCriteria;
import com.epicsaas.app.crm.entity.gen.ContractCriteria;
import com.epicsaas.app.crm.service.ICompanyService;
import com.epicsaas.app.crm.service.IContactService;
import com.epicsaas.app.crm.service.IContractService;
import com.epicsaas.service.biz.session.util.SessionUtil;
import com.epicsaas.service.biz.userbase.dto.GroupDTO;
import com.epicsaas.service.biz.userbase.dto.UserDTO;

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

    @Resource
    private SessionUtil sessionUtil;

    /**
     * 联系人
     */
    @Resource
    private IContactService contactService;

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

    /**
     * 应用主入口地址
     * 
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
        // 将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_INDEX.toString();
    }

    @RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
    public String list(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());

        UserDTO u = sessionUtil.getUserFromRequest(request);

        ServiceResult<List<GroupDTO>> gl = UserBaseAPI.getInstance().getUserQueryService().getGroupList(u.getId(),
                CrmConst.__APP_ID);

        ServiceResult<Boolean> retIsTenantManager = UserBaseAPI.getInstance().getGroupQueryService().isTenantManager(
                u.getId());

        ServiceResult<Boolean> retIsAppManager = UserBaseAPI.getInstance().getGroupQueryService().isAppManager(
                u.getId(), CrmConst.__APP_ID);

        CompanyCriteria c = new CompanyCriteria();
        CompanyCriteria.Criteria cc = c.createCriteria();
        cc.andIdIsNotNull();

        if ((retIsTenantManager != null && retIsTenantManager.getData())
                || (retIsAppManager != null && retIsAppManager.getData())) {
            model.addAttribute("group", "manager");

        } else if (gl != null && !CollectionUtils.isEmpty(gl.getData())) {
            List<GroupDTO> gs = gl.getData();
            int count = 0;
            for (GroupDTO g : gs) {
                if (g.getCode().equals(CrmConst.__CRM_LEADER)) {
                    count++;
                    model.addAttribute("group", "leader");
                    break;
                }
            }
            if (count == 0) {
                cc.andUserIdEqualTo(u.getId());
            }

        } else {
            cc.andUserIdEqualTo(u.getId());
        }

        ServiceResult<List<CompanyAO>> ret = companyService.selectByCriteria(c);

        if (ret != null && ret.getData() != null) {
            model.addAttribute("dataList", ret.getData());
        }

        // 将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_CUSTOMER_LIST.toString();
    }

    /**
     * 打开表单页面
     * 
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
        // 将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    /**
     * 保存公司信息
     * 
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveCustomer", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object saveOrUpdate(CompanyAO companyAO, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {
    	  if (companyAO.getCreateDate() == null) {
    		  companyAO.setCreateDate( new Date());
    	  }
    	  
        ServiceResult<CompanyAO> ret = companyService.saveOrUpdateRetAO(companyAO);

        return ret;
    }

    /**
     * 打开某种业务数据，例如：打开数据ID等于dataId的请假申请
     * 
     * @param dataId
     *            业务数据ID
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
        ServiceResult<CompanyAO> ret = companyService.getById(dataId);
        if (ret.isSucceed() && null != ret.getData()) {
            model.addAttribute("company", ret.getData());
        }
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    /**
     * 删除公司信息 （系统管理员才有权限操作）
     * 
     * @param dataId
     *            业务数据ID
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
        // 1 删除该公司的合同信息 （附件信息 删除 ）
        ContractCriteria criteria = new ContractCriteria();
        criteria.createCriteria().andCompanyIdEqualTo(dataId);
        ret = contractService.deleteByCriteria(criteria);

        // 2 删除联系人信息
        ContactCriteria criteria2 = new ContactCriteria();
        criteria2.createCriteria().andCompanyIdEqualTo(dataId);
        ret = contactService.deleteByCriteria(criteria2);

        // 删除公司信息
        ret = companyService.deleteById(dataId);
        return ret;
    }

    /**
     * 删除公司信息 （系统管理员才有权限操作）
     * 
     * @param dataId
     *            业务数据ID
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object delete(String ids, Model model, HttpServletRequest request, HttpServletResponse response) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<Boolean> ret = new ServiceResult<Boolean>();
        String idA[] = ids.split(",");
        for (String id : idA) {
            if (StringUtils.isNotBlank(id)) {
                ret = companyService.deleteById(id);
            }
        }

        return ret;
    }

    @RequestMapping(value = "/assign", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object assign(String ids, String destName, String destId, Model model, HttpServletRequest request,
            HttpServletResponse response) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<Boolean> ret = companyService.assign(ids, destId, destName);

        return ret;
    }

}
