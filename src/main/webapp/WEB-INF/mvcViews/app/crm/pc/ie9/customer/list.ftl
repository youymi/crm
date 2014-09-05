<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/customer","/app/crm/css/common","/app/crm/css/demo","/app/crm/css/zTreeStyle/zTreeStyle","/app/crm/css/index","/app/crm/css/style"] />
<@addJS ["/app/crm/js/jquery-1.8.3","/app/crm/js/jquery.ztree.all-3.5","/app/crm/js/customer"] />
<@common title="客户管理">		 

<script type="text/javascript" src="/saasportal/pc/component/header/customizedjs"></script>
<div class="saaswrapper">
	<DIV class="content" >
	
<#include "../common/header.ftl">
	<DIV class="container-fluid" style="margin-top: 12px">
	
	         <!-- 底部蓝色线条 -->
			<DIV style="padding-top: 5px; margin-top: 2px; margin-bottom: 5px; border-top-color: rgb(0, 136, 204); border-top-width: 0px; border-top-style: solid;">
			</DIV>

		
		<div class="customer-form toptree p-relative" id="contact-main">

			<div>
			<#if group?? && group == "manager">
			<span class="btn customer-btn" onclick="window.open('${servePath}/pc/customer')">新增</span>
			<span class="btn customer-btn j-delete" data-parentid="customer-list" data-url="${servePath}/pc/company/delete" >删除</span>
			</#if>
			<#if group?? && (group == "manager" || group == "leader")>
			<span class="btn customer-btn j-open-orgtree" data-mainid="customer-list"  data-posturl="${servePath}/pc/company/assign" data-url="${staticServePath}/orgtree">分配</span>
			</#if>
			
			<span class="btn customer-btn j-atten " data-mainid="customer-list" data-url="${servePath}/pc/attention/atten">关注</span>
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
					<div class="w5 left"><input type="checkbox" class="checkbox"  data-id="" ></div>
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
					<td class="w15  "> <span class="j-open-orgtree" data-id="${(data.id)!}" data-posturl="${servePath}/pc/company/assign" data-url="${staticServePath}/orgtree">分配</span> | 
					<span class="j-atten" data-id="${(data.id)!}" data-url="${servePath}/pc/attention/atten">关注</span></td>
				 
					</form>
				</div>	
		</tr>
		</#list> 
		</table>
		</div>
			
		</div>	
		
	</div>
	</DIV>

</div>
</@common>
