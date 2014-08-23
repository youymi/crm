<#include "./util/staticMacro.ftl">
<#include "./util/componentMacro.ftl">

<#macro common title>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html>
	    <head>
	        <title>${title}</title>
	        <@block name="meta">
				<#include "meta.html">
    		</@block> 
    		
    		<@block name="commonCSS">
				<link rel="stylesheet" href="${staticServePath}/plugins/bootstrap/css/bootstrap.min.css?${appVersion}" type="text/css">
				<link type="text/css" rel="stylesheet" href="${staticServePath}/css/reset.css">
				<link type="text/css" rel="stylesheet" href="${staticServePath}/css/base.css">
    		</@block> 
    		
	        <@genCSS/>
	        
			<script type="text/javascript" src="${staticServePath}/plugins/jquery-1.9.1.min.js?${appVersion}"></script>
			<script type="text/javascript" src="${staticServePath}/plugins/bootstrap/js/bootstrap.min.js?${appVersion}"></script>

			<!--[if lt IE 9]>  
				<script type="text/javascript" src="${staticServePath}/plugins/html5shiv.js"></script>
			<![endif]-->
			<!--  
			<script type="text/javascript" src="/saasportal/static/js/header.js?0.0.1"></script>
			-->
			<script>
			      webCfg = {
				      staticServePath: "${staticServePath}",
				      fileServePath: "${(fileServePath)!}",
				      servePath: "${servePath}"
			      };
			</script>
	        
	    </head>
	    <body> 
	    			<@block name="body"/>
	        <#nested/>
	        
	        <@genJS/>
	        <#if javascript??>
	        	${javascript}
	        </#if>
	    </body>
	</html>
</#macro>