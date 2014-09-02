<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/customer","/app/crm/css/common","/plugins/jquery-ui","/app/crm/css/index","/app/crm/css/style","/app/crm/css/cmxform"] />
<@addJS ["/plugins/jquery-ui","/app/crm/js/jquery-validate","/app/crm/js/validate-meta","/app/crm/js/customer"] />
<@common title="客户管理">
<script type="text/javascript" src="/saasportal/pc/component/header/customizedjs"></script>
<div class="saaswrapper">
	<DIV class="content" >
	
<#include "../common/header.ftl">
	<DIV class="container-fluid" style="margin-top: 12px">
	
	         <!-- 底部蓝色线条 -->
			<DIV style="padding-top: 5px; margin-top: 2px; margin-bottom: 5px; border-top-color: rgb(0, 136, 204); border-top-width: 2px; border-top-style: solid;">
			</DIV>
 
<div class="content-body">
		 
	<div class="customer-info">客户： ${(data.name)!}</div>
	<div class="customer-main">
	
		<div class="customer-info1">
			<span>客户信息</span>
			<span class="btn customer-btn  j-customermodify" data-formid="j-customer-form">编辑</span>
			<span class="btn customer-btn j-save-customer hide">保存</span>
			 
		</div>
		
		<div class="customer-form">
			<form class="j-customer-form" id="j-customer-form" action="${servePath}/pc/customer/saveContact">
				<input name="id" class="id" type="hidden" value="${(data.id)!}" />
				<div class="p-relative formcell">
					<div class="formcell-title left">客户编号</div>
					<div class="formcell-cell left"><input type="text" name="code" value="${(data.code)!}" class="readonly" readonly/></div>
					<div class="formcell-title left"><span class="required">*</span>客户类型</div>
					<div class="formcell-cell left">
						<select type="text" name="type" readonly>
							<#if customerTypeList?? && (customerTypeList?size > 0) >
							<#list customerTypeList as type>
							<option value="${(type.name)!}">${(type.name)!}</option>
							</#list>
							</#if>
						</select>
					</div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>客户名称</div>
					<div class="formcell-cell1 left"><input type="text" name="name" value=" ${(data.name)!}" class="readonly" readonly /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>区域</div>
					<div class="formcell-cell left">
						<input type="text" name="regin" class="readonly" readonly required />
					</div>
					<div class="formcell-title left"><span class="required">*</span>行业</div>
					<div class="formcell-cell left">
					 <input type="text" name="trade" class="readonly" readonly  required/>
					</div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>电话</div>
					<div class="formcell-cell left"><input type="text" name="phone" value="${(data.phone)!}" class="readonly" readonly/></div>
					
					 <div class="formcell-title left"><span class="required">*</span>传真</div>
					<div class="formcell-cell left"><input type="text" name="fax"  value="${(data.fax)!}" class="readonly" readonly/></div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">地址</div>
					<div class="formcell-cell1 left"><input type="text" name="address" value="${(data.address)!}" class="readonly" readonly/></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">网址</div>
					<div class="formcell-cell1 left"><input type="text" name="url" value="${(data.url)!}" class="readonly" readonly/></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">主营业务</div>
					<div class="formcell-cell1 left"><input type="text" name="business" value="${(data.business)!}" class="readonly" readonly/></div>
					 
					<div class="clear-both"></div>
				</div>
				<div class="p-relative formcell">
					<div class="formcell-title left">职员数</div>
					<div class="formcell-cell1 left"><input type="text" name="staffs" value="${(data.staffs)!}" class="readonly" readonly/></div>
					 
					<div class="clear-both"></div>
				</div>
				
			</form>
		</div>	
		
		<#include "contact.ftl">
		<#include "contract.ftl">
		<#include "acvitity-form.ftl">
		
	</div>
	
	</div>
	</div>
	</div>
	</div>
	
</@common>
