<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/customer","/app/crm/css/common","/plugins/jquery-ui","/app/crm/css/index","/app/crm/css/cmxform","/app/crm/css/style"] />
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
	<div class="customer-info">客户：</div>
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
					<div class="formcell-title left"><span class="required-lab">*</span>客户类型</div>
					<div class="formcell-cell left">
						<select type="text" name="type">
							<option value="潜在客户">潜在客户</option>
						</select>
					</div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required-lab">*</span>客户名称</div>
					<div class="formcell-cell1 left"><input type="text" name="name" required /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required required-lab">*</span>区域</div>
					<div class="formcell-cell left">
					<input type="text" name="regin" required />
						<#--
						<select type="text" name="regin">
							<option value="北京">北京</option>
						</select>
						-->
					</div>
					<div class="formcell-title left"><span class="required required-lab">*</span>行业</div>
					<div class="formcell-cell left">
						<input type="text" name="trade" required/>
						<#--
						<select type="text" name="customerNO">
							<option value="dd">潜在客户</option>
						</select>
						-->
					</div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required required-lab" required>*</span>电话</div>
					<div class="formcell-cell left"><input type="text" name="phone" /></div>
					
					 <div class="formcell-title left"><span class="required required-lab" required>*</span>传真</div>
					<div class="formcell-cell left"><input type="text" name="fax" required /></div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">地址</div>
					<div class="formcell-cell1 left"><input type="text" name="address" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">网址</div>
					<div class="formcell-cell1 left"><input type="text" name="url" /></div>
					 
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
	
</div>	

</DIV>
</DIV>
</div>
</@common>
