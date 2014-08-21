/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epicsaas.app.crm.appobject.ContactAO;
import com.epicsaas.app.crm.dao.gen.ContactGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.ContactCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;

@Service
public class ContactService extends AbstractBaseAOService<ContactAO, ContactCriteria> implements IContactService {

    private static Logger LOG = LoggerFactory.getLogger(ContactService.class);

    @Resource
    private ContactGeneratedMapper contactGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<ContactAO, ContactCriteria> getGeneratedMapper() {
        return contactGeneratedMapper;
    }

}
