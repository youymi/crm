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
	APP_CRM_PC_IE9_COMMON_BASEPAGE("/app/crm/pc/ie9/common/basePage"),
	APP_CRM_PC_IE9_COMMON_FOOTER("/app/crm/pc/ie9/common/footer"),
	APP_CRM_PC_IE9_COMMON_HEADER("/app/crm/pc/ie9/common/header"),
	APP_CRM_PC_IE9_COMMON_INDEX("/app/crm/pc/ie9/common/index"),
	APP_CRM_PC_IE9_COMMON_UTIL_COMPONENTMACRO("/app/crm/pc/ie9/common/util/componentMacro"),
	APP_CRM_PC_IE9_COMMON_UTIL_STATICMACRO("/app/crm/pc/ie9/common/util/staticMacro"),
	APP_CRM_PC_IE9_CUSTOMER_ACVITITYFORM("/app/crm/pc/ie9/customer/acvitity-form"),
	APP_CRM_PC_IE9_CUSTOMER_CONTACT("/app/crm/pc/ie9/customer/contact"),
	APP_CRM_PC_IE9_CUSTOMER_CONTRACT("/app/crm/pc/ie9/customer/contract"),
	APP_CRM_PC_IE9_CUSTOMER_FORM("/app/crm/pc/ie9/customer/form"),
	APP_CRM_PC_IE9_CUSTOMER_LIST("/app/crm/pc/ie9/customer/list"),
	APP_CRM_PC_IE9_HELLO_INDEX("/app/crm/pc/ie9/hello/index"),
	APP_CRM_PC_IE9_MAIN_ATTENTION("/app/crm/pc/ie9/main/attention"),
	APP_CRM_PC_IE9_MAIN_CONTACT("/app/crm/pc/ie9/main/contact"),
	APP_CRM_PC_IE9_MAIN_FORM("/app/crm/pc/ie9/main/form"),
	APP_CRM_PC_IE9_MAIN_INDEX("/app/crm/pc/ie9/main/index"),
	APP_CRM_PC_IE9_SETTING_INDEX("/app/crm/pc/ie9/setting/index"),
	APP_CRM_PC_IE9_WIDGET_INDEX("/app/crm/pc/ie9/widget/index"),
	APP_CRM_PC_OTHER_HELLO_INDEX("/app/crm/pc/other/hello/index"),
	ERROR_500("/error/500");
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
