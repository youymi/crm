/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.common;

import com.epicsaas.framework.web.resolver.AbstractMVCViewMatch;

/**
 * 判断视图的名称是否存在于自动生成的枚举类中。
 * 因为枚举类的不易传递性，所以增加该方法。   请勿修改 ！
 * @author Yuanjun.Li
 * @author Liyuan Li
 *
 */
public class MVCViewMatch extends AbstractMVCViewMatch {

    @Override
    public boolean isExistViewName(String viewName) {
        boolean flag = false;
        for (MVCViewName view : MVCViewName.values()) {
            if (view.toString().equals(viewName)) {
                flag = true;
            }
        }
        return flag;
    }

}
