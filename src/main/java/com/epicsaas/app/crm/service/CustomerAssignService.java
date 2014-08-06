package com.epicsaas.app.crm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicsaas.app.crm.appobject.CustomerAssginAO;
import com.epicsaas.app.crm.dao.gen.CustomerAssginGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.CustomerAssginCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;

@Service
public class CustomerAssignService extends
		AbstractBaseAOService<CustomerAssginAO, CustomerAssginCriteria>
		implements ICustomAssignService {
	
	private static Logger LOG = LoggerFactory.getLogger(CustomerAssignService.class);

    @Resource
    private CustomerAssginGeneratedMapper customerAssginGeneratedMapper;


	@Override
	protected BaseGeneratedMapper<CustomerAssginAO, CustomerAssginCriteria> getGeneratedMapper() {
		return customerAssginGeneratedMapper;
	}

}
