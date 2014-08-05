<#macro meta>
    <meta charset="utf-8" />
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
</#macro>

<#if debug == "true">
<#assign debug = "-debug">
<#else>
<#assign debug = "">
</#if>


<#macro genCSS>
    <#if css??>
        <#list css as item>
            <link type="text/css" rel="stylesheet" href="${staticServePath}${item}${debug}.css?${appVersion}" >	
        </#list>
    </#if>
</#macro>

<#macro genJS>
    <#if js??>
        <#-- combo 服务器代码合并
        <script type="text/javascript" src="http://10.111.13.14/static/??<#list js as item>${item}${debug}.js<#if item_has_next>,</#if></#list>?${appVersion}"></script>	
        -->
        <#list js as item>
            <script type="text/javascript" src="${staticServePath}${item}${debug}.js?${appVersion}"></script>	
        </#list>
    </#if>
</#macro>

<#macro addCSS path>
    <#if css??>
        <#assign css=css+path>
    <#else>
        <#assign css=path>
    </#if>
</#macro>

<#macro addJS path>
    <#if js??>
      <#assign js=js+path>
    <#else>
      <#assign js=path>
    </#if>
</#macro>

<#macro addScript> 
    <#assign tempScript>
    <#nested> 
    </#assign>
    <#if javascript??>
        <#assign javascript = javascript + tempScript />
    <#else>
        <#assign javascript = tempScript />
    </#if>
</#macro> 