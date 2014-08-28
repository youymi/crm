/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicsaas.api.session.SessionAPI;
import com.epicsaas.api.userbase.UserBaseAPI;
import com.epicsaas.app.crm.common.MVCViewName;
import com.epicsaas.framework.mybatis.Page;
import com.epicsaas.service.biz.userbase.dto.OrgDTO;
import com.epicsaas.service.biz.userbase.dto.UserDTO;
import com.epicsaas.service.biz.userbase.entity.gen.UserCriteria;
import com.epicsaas.service.biz.userbase.service.IOrgService;
import com.epicsaas.service.biz.userbase.service.IUserService;

@Controller
@RequestMapping(value = "/pc/userbase")
public class UserBaseController {

    @RequestMapping(value = "/userlist")
    public ModelAndView showUserList() {
        //return new ModelAndView(MVCViewName.APP_APPCENTER_PC_IE9_CENTER_USERLIST.toString());
        return null;
    }

    @RequestMapping(value = "/user/{id}")
    public ModelAndView showUser(@PathVariable String id, Model model) {
        if (id != null && !"".equals(id) && !"add".equals(id)) {
            ServiceResult<UserDTO> ret = UserBaseAPI.getInstance().getUserService().getUser(id);
            if (ret != null && ret.getData() != null) {
                model.addAttribute("user", ret.getData());
            }
            model.addAttribute("menuid", "userlist");
        } else if ("add".equals(id)) {
            model.addAttribute("menuid", "adduser");
        }

        return null;
        //return new ModelAndView(MVCViewName.APP_APPCENTER_PC_IE9_CENTER_USER.toString());
    }

    @ResponseBody
    @RequestMapping(value = "/getUserList")
    public Object getUserList(int pageNo, HttpServletRequest request) {
        UserDTO user = SessionAPI.getInstance().getSessionUtil().getUserFromRequest(request);

        IUserService userService = UserBaseAPI.getInstance().getUserService();
        pageNo = pageNo > 0 ? pageNo : 1;
        int begin = 10 * (pageNo - 1);
        Page page = new Page(begin, 10);
        UserCriteria uc = new UserCriteria();
        uc.setPage(page);
        uc.createCriteria().andTenantIdEqualTo(user.getTenantId());
        ServiceResult<List<UserDTO>> dataRet = userService.selectByCriteria(uc);
        ServiceResult<Integer> cntRet = userService.countByCriteria(uc);
        int cnt = cntRet.getData();

        Map<String, Object> rt = new HashMap<String, Object>();
        rt.put("data", dataRet.getData());
        int ym = cnt / page.getLength();
        if (page.getPageCount() * ym < cnt) {
            ym++;
        }
        rt.put("total", ym);
        rt.put("current", pageNo);
        return rt;
    }

    @ResponseBody
    @RequestMapping(value = "/saveUser")
    public Object saveUser(@Valid UserDTO user, BindingResult result, HttpServletRequest request) {
        UserDTO currentUser = SessionAPI.getInstance().getSessionUtil().getUserFromRequest(request);

        IUserService userService = UserBaseAPI.getInstance().getUserService();
        if (user.getId() == null || "".equals(user.getId().trim())) {
            user.setId(null);
            user.setPasswd("123456");
            user.setTenantId(currentUser.getTenantId());
            user.setNamespace(currentUser.getNamespace());

            ServiceResult<Boolean> ueret = userService.isUserExist(user.getCode(), null);
            if (ueret != null && ueret.getData()) {
                return new ServiceResult<Boolean>(false, "用户代号已经存在");
            }
        }

        String orgId = user.getOrgId();
        if (orgId == null || "".equals(orgId.trim())) {
            user.setOrgId(null);
        }
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                sb.append(error.getDefaultMessage() + "<br/>");
            }
            return new ServiceResult<Boolean>(false, sb.toString());
        }
        ServiceResult<UserDTO> ret = userService.saveOrUpdate(user);
        user.setOrgId(orgId);
        if (ret != null && ret.getData() != null) {
            UserBaseAPI.getInstance().getOrgService().resetBelongOrg(ret.getData().getId(), user.getOrgId());
        }
        return ret;
    }

    @RequestMapping(value = "/org")
    public ModelAndView showOrg() {
        //return new ModelAndView(MVCViewName.APP_APPCENTER_PC_IE9_CENTER_ORG.toString());
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/removeOrg/{id}")
    public Object deleteOrg(@PathVariable String id) {
        IOrgService orgService = UserBaseAPI.getInstance().getOrgService();
        ServiceResult<List<OrgDTO>> ret = orgService.getChildren(id);
        if (ret != null && ret.getData() != null && !ret.getData().isEmpty()) {
            return new ServiceResult<Boolean>(false, "请先删除下级部门");
        }

        IUserService userService = UserBaseAPI.getInstance().getUserService();
        ServiceResult<List<UserDTO>> userRet = userService.getUserListByOrg(id);
        if (userRet != null && userRet.getData() != null && !userRet.getData().isEmpty()) {
            return new ServiceResult<Boolean>(false, "请先将部门下人员调整至其他部门");
        }

        return UserBaseAPI.getInstance().getOrgService().delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/orgUser")
    public Object showOrgUserTree() {
        return UserBaseAPI.getInstance().getUserService().getOrgUserTree();
    }

}
