/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import com.epicsaas.app.crm.appobject.AttentionAO;
import com.epicsaas.app.crm.dao.gen.AttentionGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.AttentionCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;


public class AttentionService extends AbstractBaseAOService<AttentionAO, AttentionCriteria> implements IAttentionService {

    private static Logger LOG = LoggerFactory.getLogger(AttentionService.class);

    @Resource
    private AttentionGeneratedMapper attentionGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<AttentionAO, AttentionCriteria> getGeneratedMapper() {
        return attentionGeneratedMapper;
    }

}
