/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epicsaas.app.crm.appobject.ActivityAO;
import com.epicsaas.app.crm.dao.gen.ActivityGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.ActivityCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

@Service
public class ActivityService extends AbstractBaseAOService<ActivityAO, ActivityCriteria> implements IActivityService {

    private static Logger LOG = LoggerFactory.getLogger(ActivityService.class);

    @Resource
    private ActivityGeneratedMapper activityGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ActivityAO, ActivityCriteria> getGeneratedMapper() {
        return activityGeneratedMapper;
    }

}
