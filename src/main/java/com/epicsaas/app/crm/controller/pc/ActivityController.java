/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.controller.pc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicsaas.app.crm.service.IActivityService;

@Controller
@RequestMapping(value = "/pc/activity")
public class ActivityController {

    @Resource
    private IActivityService activityService;

    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Object delete(String ids, Model model, HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {

        ServiceResult<Boolean> ret = new ServiceResult<Boolean>();
        String idA[] = ids.split(",");
        for (String id : idA) {
            if (StringUtils.isNotBlank(id)) {
                ret = activityService.deleteById(id);
            }
        }

        return ret;
    }
}
