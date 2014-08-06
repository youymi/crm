package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicsaas.app.crm.appobject.DataDictionaryAO;
import com.epicsaas.app.crm.dao.gen.DataDictionaryGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.DataDictionaryCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;

@Service
public class DataDictionaryService extends
		AbstractBaseAOService<DataDictionaryAO, DataDictionaryCriteria>
		implements IDataDictionaryService {
	
	private static Logger LOG = LoggerFactory.getLogger(DataDictionaryService.class);

    @Resource
    private DataDictionaryGeneratedMapper dataDictionaryGeneratedMapper;

    
	@Override
	protected BaseGeneratedMapper<DataDictionaryAO, DataDictionaryCriteria> getGeneratedMapper() {
		return dataDictionaryGeneratedMapper;
	}
}
