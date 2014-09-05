/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.epicpaas.sdk.core.api.ServiceResult;
import com.epicpaas.sdk.core.api.logging.Logger;
import com.epicpaas.sdk.core.api.logging.LoggerFactory;
import com.epicsaas.app.crm.appobject.AttentionAO;
import com.epicsaas.app.crm.dao.gen.AttentionGeneratedMapper;
import com.epicsaas.app.crm.entity.gen.AttentionCriteria;
import com.epicsaas.common.dao.base.BaseGeneratedMapper;
import com.epicsaas.common.service.base.AbstractBaseAOService;

@Service
public class AttentionService extends AbstractBaseAOService<AttentionAO, AttentionCriteria> implements
        IAttentionService {

    private static Logger LOG = LoggerFactory.getLogger(AttentionService.class);

    @Resource
    private AttentionGeneratedMapper attentionGeneratedMapper;

    @Override
    protected BaseGeneratedMapper<AttentionAO, AttentionCriteria> getGeneratedMapper() {
        return attentionGeneratedMapper;
    }

    @Override
    public ServiceResult<Boolean> attens(String userId, String customerIds) {

        if (StringUtils.isNotBlank(customerIds)) {
            String[] arrayId = customerIds.split(",");

            if (arrayId.length > 0) {
                List<String> ids = CollectionUtils.arrayToList(arrayId);
                AttentionCriteria ac = new AttentionCriteria();
                ac.createCriteria().andUserIdEqualTo(userId).andCompanyIdIn(ids);
                attentionGeneratedMapper.deleteByCriteria(ac);

                for (String id : arrayId) {
                    AttentionAO ao = new AttentionAO();
                    ao.setCompanyId(id);
                    ao.setUserId(userId);
                    ao.setContactDate(new Date());
                    attentionGeneratedMapper.insert(ao);

                }
            }
        }
        return new ServiceResult<Boolean>(true);
    }

}
