/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import com.epicsaas.app.crm.appobject.ContractExtAO;
import com.epicsaas.app.crm.dao.gen.ContractExtGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.ContractExtCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;


public class ContractExtService extends AbstractBaseAOService<ContractExtAO, ContractExtCriteria> implements IContractExtService {

    private static Logger LOG = LoggerFactory.getLogger(ContractExtService.class);

    @Resource
    private ContractExtGeneratedMapper contractExtGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ContractExtAO, ContractExtCriteria> getGeneratedMapper() {
        return contractExtGeneratedMapper;
    }

}
