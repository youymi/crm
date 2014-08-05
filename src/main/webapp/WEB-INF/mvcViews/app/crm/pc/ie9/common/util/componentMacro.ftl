<#macro component componentId asyn=false callbkname="">
    <#assign componentUri = '${componentService.getComponentPathByName(componentId)}' />
    <#if asyn>
    <script>
        front_framework.component.util.asynchronous.asyn(front_framework.component.util.asynchronous.find(),"${servePath}${componentUri}","${callbkname}");
    </script>
    <#else>
    ${componentFunc("", componentUri)}
    </#if>
</#macro>

<#macro setAttribute  name value>
${request.setAttribute(name, value)}
</#macro>



<#macro widget componentId>
    <#assign componentUri = '${componentService.getComponentPathByName(componentId)}' />
    <#include componentUri/>
</#macro>

 