/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epicsaas.app.crm.appobject.ConnecterAO;
import com.epicsaas.app.crm.dao.gen.ConnecterGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.ConnecterCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

@Service
public class ConnecterService extends AbstractBaseAOService<ConnecterAO, ConnecterCriteria> implements
        IConnecterService {

    private static Logger LOG = LoggerFactory.getLogger(ConnecterService.class);

    @Resource
    private ConnecterGeneratedMapper connecterGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ConnecterAO, ConnecterCriteria> getGeneratedMapper() {
        return connecterGeneratedMapper;
    }

}
