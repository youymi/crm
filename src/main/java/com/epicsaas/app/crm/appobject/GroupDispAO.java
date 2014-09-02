/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.appobject;

import com.epicsaas.service.biz.userbase.dto.GroupDTO;

public class GroupDispAO {

    private GroupDTO group;

    private String names;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO g) {
        this.group = g;
    }

}
