/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicsaas.api.userbase.UserBaseAPI;
import com.epicsaas.app.crm.appobject.DataDictionaryAO;
import com.epicsaas.app.crm.appobject.GroupDispAO;
import com.epicsaas.app.crm.common.CrmConst;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.app.crm.entity.gen.DataDictionaryCriteria;
import com.epicsaas.app.crm.service.IDataDictionaryService;
import com.epicsaas.service.biz.session.util.SessionUtil;
import com.epicsaas.service.biz.userbase.dto.GroupDTO;
import com.epicsaas.service.biz.userbase.dto.UserDTO;
import com.epicsaas.service.biz.userbase.entity.gen.GroupCriteria;
import com.epicsaas.service.biz.userbase.service.IGroupService;

/**
 * Hello控制器。
 * 
 */
@Controller
@RequestMapping(value = "/pc/setting")
public class SettingController {

    private static Logger LOG = LoggerFactory.getLogger(HelloController.class);

    private final static String TYPE_CUSTOMERTYPE = "customer_type";

    @Resource
    private IDataDictionaryService dataDictionaryService;

    @Resource
    private SessionUtil sessionUtil;

    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String setting(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");

        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());

        	UserDTO u = sessionUtil.getUserFromRequest(request);
        DataDictionaryCriteria dataDictionaryCriteria = new DataDictionaryCriteria();
        dataDictionaryCriteria.createCriteria().andIdIsNotNull().andTypeEqualTo(TYPE_CUSTOMERTYPE);
        ServiceResult<List<DataDictionaryAO>> ret = dataDictionaryService.selectByCriteria(dataDictionaryCriteria);
        if (ret.isSucceed() && !CollectionUtils.isEmpty(ret.getData())) {
            model.addAttribute("dataDictionaryList", ret.getData());
        }
        GroupCriteria gc = new GroupCriteria();
        gc.createCriteria().andAppIdEqualTo(CrmConst.__APP_ID);
        ServiceResult<List<GroupDTO>> gl = UserBaseAPI.getInstance().getGroupQueryService().selectByCriteria(gc);
        	if (gl  != null && !CollectionUtils.isEmpty(gl.getData())) {
        		List<GroupDTO> groupList = gl.getData();
        		List<GroupDispAO> groups = new ArrayList<>();
        		for (GroupDTO g: groupList) {
        			GroupDispAO ga = new GroupDispAO();
        			ga.setGroup(g);
        			ServiceResult<List<UserDTO>> users = UserBaseAPI.getInstance().getUserQueryService().getUserListByOrgIdAndGroupIds(u.getOrgId(), g.getId());
        			if(users != null && !CollectionUtils.isEmpty(users.getData())) {
        				String names = "";
	        			for (UserDTO user : users.getData()) {
	        				if (names.equals("")) {
	        					names =  user.getName();
	        				} else {
	        					names += "," + user.getName();
	        				}
	        			}
	        			ga.setNames(names);
	        			
        			}
        			groups.add(ga);
        		}
        		model.addAttribute("groups", groups);
        	}
        
        return MVCViewName.APP_CRM_PC_IE9_SETTING_INDEX.toString();
    }

    @RequestMapping(value = "/saveDataDictionary", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView saveDataDictionary(@Valid DataDictionaryAO data, Model model, HttpServletRequest request) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        data.setType(TYPE_CUSTOMERTYPE);
        dataDictionaryService.saveOrUpdate(data);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/pc/setting");
        return mv;
    }

    @RequestMapping(value = "/deleteCustomerType", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object deleteCustomerType(String ids, Model model, HttpServletRequest request, HttpServletResponse response) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        ServiceResult<Boolean> ret = new ServiceResult<Boolean>();
        String idA[] = ids.split(",");
        for (String id : idA) {
            if (StringUtils.isNotBlank(id)) {
                ret = dataDictionaryService.deleteById(id);
            }
        }

        return ret;
    }

    @RequestMapping(value = "/roleAssign", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object assign(String ids, String destName, String destId, Model model, HttpServletRequest request,
            HttpServletResponse response) {
        LOG.info("有访问来自，IP: %s USER-AGENT: %s", request.getRemoteAddr(), request.getHeader("user-agent"));
        LOG.info("SessionId %s", request.getSession().getId());
        UserDTO u = sessionUtil.getUserFromRequest(request);
        IGroupService groupService = UserBaseAPI.getInstance().getGroupService();
        //ServiceResult<Boolean> ret =  companyService.assign(ids, destId, destName);
        ServiceResult<List<UserDTO>> users = UserBaseAPI.getInstance().getUserQueryService()
                .getUserListByOrgIdAndGroupIds(u.getOrgId(), ids);
        if (users != null && !CollectionUtils.isEmpty(users.getData())) {
            List<String> userIds = new ArrayList<String>();
            for (UserDTO user : users.getData()) {
                userIds.add(user.getId());
            }
            groupService.removeUserFromGroup(ids, userIds.toArray(new String[0]));
        }

        ServiceResult<Boolean> ret = groupService.addUser2Group(ids, destId.split(","));

        return ret;
    }
}
