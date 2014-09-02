/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicsaas.framework.mybatis.Page;
import com.epicsaas.framework.util.DateTimeUtils;
import com.epicsaas.service.biz.session.util.SessionUtil;
import com.epicsaas.service.biz.userbase.dto.UserDTO;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.AttentionCriteria;
import com.epicsaas.app.crm.service.IAttentionService;
import com.epicsaas.app.crm.service.ICompanyService;
import com.epicsaas.app.crm.appobject.AttentionAO;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Attention控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/attention")
public class AttentionController {

    private static Logger LOG = LoggerFactory.getLogger(AttentionController.class);

    @Resource
    private IAttentionService attentionService;
    
    @Resource
    private SessionUtil sessionUtil;

    @Resource
    private ICompanyService companyService;

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getHello(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        // 将当前时间传到前端
        //model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(	new Date(), DateTimeUtils.FORMAT_YMD_HMS));
        // 将当前运用名称传到前端

        //UserDTO  user =SessionAPI.getInstance().getSessionUtil().getUserFromRequest(request);
        UserDTO user = new UserDTO();
        user.setId("1");
        int pageNo = Integer.parseInt(request.getParameter("pageNo") == null ? "1" : request.getParameter("pageNo"));

        Page page = new Page();
        page.setBegin(0);
        page.setLength(10);
        page.setPageNo(pageNo);

        // 我关注的客户
        AttentionCriteria example = new AttentionCriteria();
        example.createCriteria().andUserIdEqualTo(user.getId());
        example.setOrderByClause("contact_date desc");
        example.setPage(page);
        ServiceResult<Integer> countRet = attentionService.countByCriteria(example);
        if (countRet.isSucceed()) {
            page.setTotalRecords(countRet.getData());
            model.addAttribute("page", page);// 翻页数据
        }

        ServiceResult<List<AttentionAO>> attentionListRet = attentionService.selectByCriteria(example);
        if (attentionListRet.isSucceed() && !CollectionUtils.isEmpty(attentionListRet.getData())) {
            for (AttentionAO attentionAO : attentionListRet.getData()) {
                attentionAO.setCompanyAO(companyService.getById(attentionAO.getCompanyId()).getData());
            }
            model.addAttribute("attentionList", attentionListRet.getData());
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject(model);
        mv.setViewName(MVCViewName.APP_CRM_PC_IE9_ATTENTION_ATTENTION.toString());
        return mv;
    }

    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView add(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        // 将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
        // 将当前运用名称传到前端

        ModelAndView mv = new ModelAndView();
        mv.addObject(model);

        return mv;
    }

    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView list(Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        // 将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
        // 将当前运用名称传到前端

        ModelAndView mv = new ModelAndView();
        mv.addObject(model);

        return mv;
    }

    @RequestMapping(value = "/view/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView viewById(@PathVariable String dataId, Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        // 将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
        // 将当前运用名称传到前端

        ModelAndView mv = new ModelAndView();
        mv.addObject(model);

        return mv;
    }

    @RequestMapping(value = "/update/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView updateById(@PathVariable String dataId, Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        // 将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
        // 将当前运用名称传到前端

        ModelAndView mv = new ModelAndView();
        mv.addObject(model);

        return mv;
    }

    @RequestMapping(value = "/delete/{dataId}", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView deleteById(@PathVariable String dataId, Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        // 将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
        // 将当前运用名称传到前端

        ModelAndView mv = new ModelAndView();
        mv.addObject(model);

        return mv;
    }

    /**
     * 异步提交表单
     **/
    @RequestMapping(value = "/submitAJAXForm", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object submitAJAXForm(@Valid AttentionAO source, Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        // 将当前时间传到前端
        model.addAttribute("currentTime", DateTimeUtils.formateDateToStr(new Date(), DateTimeUtils.FORMAT_YMD_HMS));
        ServiceResult<Object> ret = new ServiceResult<Object>();

        return ret;
    }

    @RequestMapping(value = "/atten", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object atten(String ids, String destName, String destId, Model model, HttpServletRequest request,
            HttpServletResponse response) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        UserDTO user = sessionUtil.getUserFromRequest(request);
        ServiceResult<Boolean> ret = attentionService.attens(user.getId(), ids);

        return ret;
    }
    
    @RequestMapping(value = "/removeAtten", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object removeAtten(String ids, String destName, String destId, Model model, HttpServletRequest request,
            HttpServletResponse response) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        UserDTO user = sessionUtil.getUserFromRequest(request);
        AttentionCriteria ac = new AttentionCriteria();
        ac.createCriteria().andUserIdEqualTo(user.getId()).andCompanyIdIn(CollectionUtils.arrayToList(ids.split(",")));
        ServiceResult<Boolean> ret = attentionService.deleteByCriteria(ac);

        return ret;
    }

}
