<div class="contract-main">
		<div class="activity-info">
			<span>活动信息</span>
			<span class="btn   customer-btn j-customer-new" data-maineleid="activity-main" data-url="${servePath}/pc/customer/activityCellform">新增</span>
			<span class="btn   customer-btn j-delete"  data-parentid="activity-main" data-url="${servePath}/pc/activity/delete">删除</span>
		</div>
		
		<div class="customer-form" id="activity-main">
			
				<div class="p-relative formcell">
					<form id="cutsomerForm">
					<div class="w5 left"><input type="checkbox" class="checkbox j-checkbox" data-parentid="activity-main" ></div>
					<div class="w15 left">时间</div>
					<div class="w15 left">跟进记录</div>
					<div class="w15 left">跟进人</div>
					 
					<div class="w20 left">操作</div>
					<div class="clear-both"></div>
					</form>
				</div>
				
				 <#if contactList?? >
					<#list activityList as data>
							
					<div class="p-relative formcell">
						<form  action="${servePath}/pc/customer/saveContact">
						<input type="hidden" name="id" value="${(data.id)!}"   >
						<input type="hidden" name="companyId" value="${(data.companyId)!}"  class="companyId" >
						<div class="w5 left"><input type="checkbox"  class="checkbox"></div>
						<div class="w15 left"><input type="text" name="name"  value="${(data.date?string('yyyy-MM-dd'))!}" class="readonly" readonly></div>
						<div class="w15 left"><input type="text" name="position" value="${(data.content)!}"  class="readonly" readonly></div>
						<div class="w15 left"><input type="text" name="phone"  value="${(data.userName)!}" class="readonly" readonly></div>
 						<div class="w20 left">
							<span class="modify-icon j-modify ">编辑</span>
							<span class="btn-save j-save hide " data-url="${servePath}/pc/customer/saveActivity">保存</span>
						</div>
						<div class="clear-both"></div>
						</form>
					</div>	
							
					</#list>
				</#if>
						
			
		 
			
		</div>	
		
</div>		