<#include "../common/basePage.ftl">
 <@addCSS ["/app/crm/css/customer","/app/crm/css/common"] />

<@common title="客户管理">		 
	<div class="customer-info">客户：</div>
	<div class="customer-main">
	
		<div class="customer-info1">
			<span>客户信息</span>
			<span class="btn   customer-btn">保存</span>
			<span class="btn   customer-btn">清空</span>
		</div>
		<div class="customer-form">
			<form id="cutsomerForm">
			
				<div class="p-relative formcell">
					<div class="formcell-title left">客户编号</div>
					<div class="formcell-cell left"><input type="text" name="customerNO" /></div>
					<div class="formcell-title left"><span class="required">*</span>客户类型</div>
					<div class="formcell-cell left">
						<select type="text" name="customerNO">
							<option value="dd">潜在客户</option>
						</select>
					</div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>客户名称</div>
					<div class="formcell-cell1 left"><input type="text" name="customerNO" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left"><span class="required">*</span>区域</div>
					<div class="formcell-cell left">
						<select type="text" name="customerNO">
							<option value="dd">潜在客户</option>
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
					<div class="formcell-cell left"><input type="text" name="customerNO" /></div>
					
					 <div class="formcell-title left"><span class="required">*</span>传真</div>
					<div class="formcell-cell left"><input type="text" name="customerNO" /></div>
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">地址</div>
					<div class="formcell-cell1 left"><input type="text" name="customerNO" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">网址</div>
					<div class="formcell-cell1 left"><input type="text" name="customerNO" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
				<div class="p-relative formcell">
					<div class="formcell-title left">主营业务</div>
					<div class="formcell-cell1 left"><input type="text" name="customerNO" /></div>
					 
					<div class="clear-both"></div>
				</div>
				<div class="p-relative formcell">
					<div class="formcell-title left">职员数</div>
					<div class="formcell-cell1 left"><input type="text" name="customerNO" /></div>
					 
					<div class="clear-both"></div>
				</div>
				
			</form>
			
			
		</div>	
		
		<#include "contact.ftl">
	</div>
	
</@common>