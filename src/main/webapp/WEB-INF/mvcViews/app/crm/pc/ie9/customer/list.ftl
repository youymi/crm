<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/customer","/app/crm/css/common","/app/crm/css/demo","/app/crm/css/zTreeStyle/zTreeStyle"] />
<@addJS ["/app/crm/js/jquery-1.8.3","/app/crm/js/jquery.ztree.all-3.5","/app/crm/js/customer"] />
<@common title="客户管理">		 
	 
	<div>
		
		<div class="customer-form toptree p-relative" id="contact-main">
			<div>
			<span class="btn customer-btn" onclick="window.open('${servePath}/pc/customer')">新增</span>
			<span class="btn customer-btn j-delete" data-parentid="customer-list" data-url="${servePath}/pc/company/delete" >删除</span>
			<span class="btn customer-btn j-save-customer">分配</span>
			<span class="btn customer-btn j-save-customer">关注</span>
			<span class="btn customer-btn j-clear-customerform">导出</span>
		</div>
		<div style="margin-top:10px;" id="customer-list">
			<table style="width:100%" class="table table-bordered table-striped">
				<thead>
				<tr class="p-relative formcell">
					 
					<th class="w5  "><input type="checkbox" class="checkbox j-checkbox" data-parentid="customer-list" ></th>
					<th class="w15  ">客户编号</th>
					<th class="w15  ">客户名称</th>
					<th class="w15  ">客户类型</th>
					<th class="w15  ">末次联系时间</th>
					<th class="w15  ">负责销售人员</th>
					<th class="w15  ">操作</th>
					 
					 
				</tr>
				</thead>
				
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
		 	<tr class="formcell">
			
					<td class="w5  "> <input type="checkbox" class="checkbox" data-id="${(data.id)!}"></td>
					<td class="w15  ">${(data.code)!}</td>
					<td class="w15 customer-view " onclick="window.open('${servePath}/pc/customer/view?id=${(data.id)!}')">${(data.name)!}</td>
					<td class="w15  ">${(data.type)!}</td>
					<td class="w15  "> </td>
					<td class="w15  ">${(data.userName)!}</td>
					<td class="w15  "> <span class="j-open-orgtree" data-id="${(data.id)!}" data-posturl="${servePath}/pc/company/assign" data-url="${staticServePath}/orgtree">分配</span> | 关注</td>
				 
					</form>
				</div>	
		</tr>
		</#list> 
		<table>
		</div>
			
		</div>	
		
	</div>
	
</@common>
