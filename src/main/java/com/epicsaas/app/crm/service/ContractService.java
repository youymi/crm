/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import com.epicsaas.app.crm.appobject.ContractAO;
import com.epicsaas.app.crm.dao.gen.ContractGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.ContractCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;


public class ContractService extends AbstractBaseAOService<ContractAO, ContractCriteria> implements IContractService {

    private static Logger LOG = LoggerFactory.getLogger(ContractService.class);

    @Resource
    private ContractGeneratedMapper contractGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ContractAO, ContractCriteria> getGeneratedMapper() {
        return contractGeneratedMapper;
    }

}
