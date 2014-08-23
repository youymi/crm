/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import com.epicsaas.app.crm.appobject.TodoContactorAO;
import com.epicsaas.app.crm.dao.gen.TodoContactorGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.TodoContactorCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;


public class TodoContactorService extends AbstractBaseAOService<TodoContactorAO, TodoContactorCriteria> implements ITodoContactorService {

    private static Logger LOG = LoggerFactory.getLogger(TodoContactorService.class);

    @Resource
    private TodoContactorGeneratedMapper todoContactorGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<TodoContactorAO, TodoContactorCriteria> getGeneratedMapper() {
        return todoContactorGeneratedMapper;
    }

}
