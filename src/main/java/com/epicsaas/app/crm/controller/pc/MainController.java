/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.util.ArrayList;
import java.util.List;

//import com.epicsaas.api.session.SessionAPI;
import com.epicsaas.app.crm.appobject.AttentionAO;
import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.appobject.TodoContactorAO;
import com.epicsaas.app.crm.common.CrmConst;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.AttentionCriteria;
import com.epicsaas.app.crm.entity.gen.CompanyCriteria;
import com.epicsaas.app.crm.entity.gen.TodoContactorCriteria;
import com.epicsaas.app.crm.service.IAttentionService;
import com.epicsaas.app.crm.service.ICompanyService;
import com.epicsaas.app.crm.service.ITodoContactorService;
import com.epicsaas.framework.mybatis.Page;
import com.epicsaas.service.biz.userbase.dto.UserDTO;
import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Main控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/main")
public class MainController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private IAttentionService attentionService;
    
    @Resource
    private ITodoContactorService todoContactorService;
    
    @Resource
    	private ICompanyService companyService;
    
    
    /**
     * 应用主入口地址
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String main(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        			//将当前运用名称传到前端
        model.addAttribute("appId", CrmConst.__APP_ID);
        model.addAttribute("appName", CrmConst.__APP_NAME);
        
        //UserDTO  user =SessionAPI.getInstance().getSessionUtil().getUserFromRequest(request);
        UserDTO  user = new UserDTO();
        user.setId("1");
        
        
        Page page = new Page();
		    	page.setBegin(0);
		    	page.setLength(5);
		    	
    				//我关注的客户
        AttentionCriteria example = new AttentionCriteria();
        example.createCriteria().andUserIdEqualTo(user.getId());
        example.setOrderByClause("contact_date desc");
		     example.setPage(page);
        
        ServiceResult<List<AttentionAO>> attentionListRet =  attentionService.selectByCriteria(example);
        if(attentionListRet.isSucceed() && !CollectionUtils.isEmpty(attentionListRet.getData())){
        	for(AttentionAO attentionAO : attentionListRet.getData()){
        		attentionAO.setCompanyAO(companyService.getById(attentionAO.getCompanyId()).getData());
        				}
        	model.addAttribute("attentionList", attentionListRet.getData());
        			}
        				//待联系客户
        TodoContactorCriteria todoContactorCriteria = new TodoContactorCriteria();
        todoContactorCriteria.createCriteria().andUserIdEqualTo(user.getId());
        todoContactorCriteria.setOrderByClause("contact_date desc");
        todoContactorCriteria.setPage(page);
        
        ServiceResult<List<TodoContactorAO>> todoContactorListRet =  todoContactorService.selectByCriteria(todoContactorCriteria);
        if(attentionListRet.isSucceed() && !CollectionUtils.isEmpty(todoContactorListRet.getData())){
        	for(TodoContactorAO todoContactorAO : todoContactorListRet.getData()){
        		todoContactorAO.setCompanyAO(companyService.getById(todoContactorAO.getCompanyId()).getData());
        				}
        	model.addAttribute("todoContactorList", todoContactorListRet.getData());
        			}

        
        
        return MVCViewName.APP_CRM_PC_IE9_MAIN_INDEX.toString();
    }

    /**
     * 应用快速创建某种业务数据如今，例如：快速创建一个请假申请
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
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

}
