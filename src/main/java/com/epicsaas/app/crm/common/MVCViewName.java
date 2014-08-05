/*
 * Copyright (c) 2012, Yunnan Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.common;

/**
 * 视图名枚举，请使用当前目录的GenerateMVCViewName类自动更新本枚举类。 <br/> <br/> 枚举条目定义规则如下: <br/> 视图名：/framework/common/view.ftl ===》
 * FRAMEWORK_COMMON_VIEW("/framework/common/view") <br/> <br/> <b>注意:</b> 如果视图名包含<b>'-'</b>, 那么该字符自动忽略。例如： <br/>
 * 视图名：/framework/common/xxx-view.ftl ===》 FRAMEWORK_COMMON_XXXVIEW("/framework/common/xxx-view")
 *
 * @author Yuanjun.Li
 * @author Liyuan Li
 *
 */
public enum MVCViewName {

	// @#############
	APP_CRM_PC_IE10_HELLO_INDEX("/app/crm/pc/ie10/hello/index"),
	APP_CRM_PC_IE68_HELLO_INDEX("/app/crm/pc/ie6-8/hello/index"),
	APP_CRM_PC_IE9_HELLO_INDEX("/app/crm/pc/ie9/hello/index"),
	APP_CRM_PC_IE9_SETTING_INDEX("/app/crm/pc/ie9/setting/index"),
	APP_CRM_PC_IE9_MAIN_INDEX("/app/crm/pc/ie9/main/index"),
	APP_CRM_PC_IE9_MAIN_FORM("/app/crm/pc/ie9/main/form"),
	APP_CRM_PC_IE9_WIDGET_INDEX("/app/crm/pc/ie9/widget/index"),
	APP_CRM_PC_OTHER_HELLO_INDEX("/app/crm/pc/other/hello/index");
// @#############
    
    
    // 成员变量
    private String viewName;

    // 构造方法
    private MVCViewName(String viewName) {
        this.viewName = viewName;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.viewName;
    }
}
