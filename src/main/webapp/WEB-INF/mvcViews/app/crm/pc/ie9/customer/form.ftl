<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/index","/app/crm/css/customer","/app/crm/css/common"] />
<@addJS ["/app/crm/js/customer"] />

	
<@addScript>
<script type="text/javascript">

</script>
</@addScript>

<@common title="客户管理">	

	
<script type="text/javascript" src="/saasportal/static/js/header.js?0.0.1"></script>
 
<div class="saaswrapper">
	<DIV class="content" >
<#include "../common/header.ftl">	

		<DIV  class="search" >
			<DIV class="summary">
				<div class="col-sm-6 customer-info">
					<strong>客户：云南远信科技</strong>
				</div>
				<div class="col-sm-6 pull-right"><a href="#"><img src="${staticServePath}/app/crm/images/go_back.png"></a></div>
			</DIV>
		</DIV>
	
	
	
	<div class="customer-main">
	
		<div class="customer-info1">
			<span>客户信息</span>
			<span class="btn customer-btn j-save-customer">保存</span>
			<span class="btn customer-btn j-clear-customerform">清空</span>
		</div>
		
		<div class="customer-form">
			<form class="j-customer-form" action="${servePath}/pc/customer/saveContact">
				<input name="id" class="id" type="hidden" />
				<div class="p-relative formcell">
					<div class="formcell-title left">客户编号</div>
					<div class="formcell-cell left"><input type="text" name="code" /></div>
					<div class="formcell-title left"><span class="required">*</span>客户类型</div>
					<div class="formcell-cell left">
						<select type="text" name="type">
							<option value="潜在客户">潜在客户</option>
						</select>
					</div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>客户名称</div>
					<div class="formcell-cell1 left"><input type="text" name="name" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>区域</div>
					<div class="formcell-cell left">
						<select type="text" name="regin">
							<option value="北京">北京</option>
						</select>
					</div>
					<div class="formcell-title left"><span class="required">*</span>行业</div>
					<div class="formcell-cell left">
						<select type="text" name="customerNO">
							<option value="dd">潜在客户</option>
						</select>
					</div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>电话</div>
					<div class="formcell-cell left"><input type="text" name="phone" /></div>
					
					 <div class="formcell-title left"><span class="required">*</span>传真</div>
					<div class="formcell-cell left"><input type="text" name="tax" /></div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">地址</div>
					<div class="formcell-cell1 left"><input type="text" name="address" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">网址</div>
					<div class="formcell-cell1 left"><input type="text" name="website" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">主营业务</div>
					<div class="formcell-cell1 left"><input type="text" name="business" /></div>
					 
					<div class="clear-both"></div>
				</div>
				<div class="p-relative formcell">
					<div class="formcell-title left">职员数</div>
					<div class="formcell-cell1 left"><input type="text" name="staffs" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
			</form>
		</div>	
		
		<#include "contact.ftl">
		<#include "contract.ftl">
		<#include "acvitity-form.ftl">
		
	</div>
	
	</DIV>
</div>

</@common>