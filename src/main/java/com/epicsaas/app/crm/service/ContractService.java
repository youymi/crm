/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epicsaas.app.crm.appobject.ContractAO;
import com.epicsaas.app.crm.dao.gen.ContractGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.ContractCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

@Service
public class ContractService extends AbstractBaseAOService<ContractAO, ContractCriteria> implements IContractService {

    private static Logger LOG = LoggerFactory.getLogger(ContractService.class);

    @Resource
    private ContractGeneratedMapper contractGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ContractAO, ContractCriteria> getGeneratedMapper() {
        return contractGeneratedMapper;
    }

}
