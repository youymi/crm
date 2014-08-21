/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 * 
 * All rights reserved.
 */
package com.epicsaas.app.crm.appobject;

import java.io.Serializable;
import com.epicsaas.app.crm.entity.gen.CustomerAssgin;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * 应用对象 - CustomerAssgin.
 *
 * <p>
 * 该类于 2014-08-06 10:21:41 首次生成，后由开发手工维护。
 * </p>
 *
 * @author <a href="mailto:DL88250@gmail.com">Liang Ding</a>
 * @version 1.0.0.0, Aug 06, 2014
 */
@JsonSerialize(include = Inclusion.NON_EMPTY)
public final class CustomerAssginAO extends CustomerAssgin implements Serializable {

    /**
     * 默认的序列化 id.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
