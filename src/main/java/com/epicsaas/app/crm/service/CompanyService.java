/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.dao.gen.CompanyGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.CompanyCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.ServiceResult;
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

    @Override
    public ServiceResult<Boolean> assign(String ids, String destId, String destName) {
        if (StringUtils.isNotBlank(ids)) {
            String[] arrayId = ids.split(",");
            if (arrayId.length > 0) {
                for (String id : arrayId) {
                    CompanyAO c = new CompanyAO();
                    c.setId(id);
                    c.setUserId(destId);
                    c.setUserName(destName);
                    companyGeneratedMapper.updateByPrimaryKeySelective(c);
                }
            }
        }
        return new ServiceResult<Boolean>(true);
    }

}
