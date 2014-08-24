<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/customer","/app/crm/css/common"] />
<@addJS ["/app/crm/js/customer"] />
<@common title="客户管理">		 
	 
	<div>
		<div class="customer-form" id="contact-main">
			<table style="width:100%">
				<tr class="p-relative formcell">
					 
					<td class="w5  "><input type="checkbox" ></td>
					<td class="w15  ">客户编号</td>
					<td class="w15  ">客户名称</td>
					<td class="w15  ">客户类型</td>
					<td class="w15  ">末次联系时间</td>
					<td class="w15  ">负责销售人员</td>
					<td class="w15  ">操作</td>
					 
					</form>
				</tr>
				
				<#-- 
				<div class="p-relative formcell">
					<form  action="${servePath}/pc/customer/saveContact">
					<div class="w5 left"><input type="checkbox" ></div>
					<div class="w15 left"><input type="text" name="name"   class="readonly" readonly></div>
					<div class="w15 left"><input type="text" name="position"   class="readonly" readonly></div>
					<div class="w15 left"><input type="text" name="phone"   class="readonly" readonly></div>
					<div class="w15 left"><input type="text" name="emai"   class="readonly" readonly></div>
					<div class="w20 left">
						<span class="modify-icon j-modify"></span>
						<span class="btn-save j-save hide">保存</span>
					</div>
					<div class="clear-both"></div>
					</form>
				</div>	
						
			-->
			
			
		 	<#list dataList as data>
		 	<tr >
			
					<td class="w5  "></td>
					<td class="w15  ">${(data.code)!}</td>
					<td class="w15 customer-view " onclick="window.open('${servePath}/pc/customer/view?id=${(data.id)!}')">${(data.name)!}</td>
					<td class="w15  ">${(data.type)!}</td>
					<td class="w15  "> </td>
					<td class="w15  "></td>
					<td class="w15  "> 分配 | 关注</td>
				 
					</form>
				</div>	
		</tr>
		</#list> 
		<table>	
		</div>	
		
	</div>
	
</@common>
