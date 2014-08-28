/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicsaas.common.service.base.IBaseAOService;
import com.epicsaas.app.crm.appobject.CompanyAO;
import com.epicsaas.app.crm.entity.gen.CompanyCriteria;

public interface ICompanyService extends IBaseAOService<CompanyAO, CompanyCriteria> {
	public ServiceResult<Boolean> assign(String ids, String destId,String destName);
}
