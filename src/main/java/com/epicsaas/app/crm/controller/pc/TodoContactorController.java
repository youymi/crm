/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.util.List;

import com.epicsaas.app.crm.appobject.AttentionAO;
import com.epicsaas.app.crm.appobject.ContactAO;
import com.epicsaas.app.crm.appobject.TodoContactorAO;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.TodoContactorCriteria;
import com.epicsaas.app.crm.service.ICompanyService;
import com.epicsaas.app.crm.service.IContactService;
import com.epicsaas.app.crm.service.ITodoContactorService;
import com.epicsaas.app.crm.service.TodoContactorService;
import com.epicsaas.framework.mybatis.Page;
import com.epicsaas.service.biz.userbase.dto.UserDTO;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Main控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/todoContactor")
public class TodoContactorController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

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
    public String hello(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        //将当前运用名称传到前端
        model.addAttribute("appId", "crm");
        model.addAttribute("appName", "客户关系管理");

        //UserDTO  user =SessionAPI.getInstance().getSessionUtil().getUserFromRequest(request);
        UserDTO user = new UserDTO();
        user.setId("1");
        int pageNo = Integer.parseInt(request.getParameter("pageNo") == null ? "1" : request.getParameter("pageNo"));

        Page page = new Page();
        page.setBegin(0);
        page.setLength(10);
        page.setPageNo(pageNo);

        TodoContactorCriteria example = new TodoContactorCriteria();
        example.createCriteria().andUserIdEqualTo(user.getId());
        example.setOrderByClause("contact_date desc");
        example.setPage(page);

        ServiceResult<Integer> countRet = todoContactorService.countByCriteria(example);
        if (countRet.isSucceed()) {
            page.setTotalRecords(countRet.getData());
            model.addAttribute("page", page);// 翻页数据
        }

        ServiceResult<List<TodoContactorAO>> todoContactorListRet = todoContactorService.selectByCriteria(example);
        if (todoContactorListRet.isSucceed() && !CollectionUtils.isEmpty(todoContactorListRet.getData())) {
            for (TodoContactorAO todoContactorAO : todoContactorListRet.getData()) {
                todoContactorAO.setCompanyAO(companyService.getById(todoContactorAO.getCompanyId()).getData());
            }
            model.addAttribute("todoContactorList", todoContactorListRet.getData());
        }
        return MVCViewName.APP_CRM_PC_IE9_TODOCONTACTOR_TODOCONTACTOR.toString();
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
     * 保存公司信息
     * @param model
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public String saveOrUpdate(@Valid ContactAO contactAO, Model model, HttpServletRequest request,
            HttpServletResponse response, HttpSession session) {

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());

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
        return MVCViewName.APP_CRM_PC_IE9_MAIN_FORM.toString();
    }

    /**
     * 删除公司信息 （系统管理员才有权限操作）
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
        return null;
    }

}
