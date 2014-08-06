/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.dao.gen.CompanyGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.CompanyCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

@Service
public class CompanyService extends AbstractBaseAOService<CompanyAO, CompanyCriteria> implements ICompanyService {

    private static Logger LOG = LoggerFactory.getLogger(CompanyService.class);

    @Resource
    private CompanyGeneratedMapper companyGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<CompanyAO, CompanyCriteria> getGeneratedMapper() {
        return companyGeneratedMapper;
    }

}
