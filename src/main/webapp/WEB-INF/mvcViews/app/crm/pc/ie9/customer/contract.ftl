<div class="contract-main" >
		<div class="contract-info">
			<span>合同信息</span>
			<span class="btn  customer-btn j-customer-new" data-maineleid="contract-main" data-url="${servePath}/pc/customer/contractCellform" >新增</span>
			<span class="btn   customer-btn j-delete"  data-parentid="contract-main" data-url="${servePath}/pc/contract/delete">删除</span>
		</div>
		
		<div class="customer-form" id="contract-main">
			
				<div class="p-relative formcell">
					<form id="cutsomerForm">
					<div class="w5 left"><input type="checkbox" class="checkbox j-checkbox" data-parentid="contract-main" ></div>
					<div class="w15 left">合同编号</div>
					<div class="w15 left">合同名称</div>
					<div class="w15 left">合同金额</div>
					<div class="w15 left">签订时间</div>
					<div class="w15 left">销售人员</div>
					<div class="w20 left">操作</div>
					<div class="clear-both"></div>
					</form>
				</div>
				
				 
					<#if contractList?? >
					<#list contractList as data>	
						<div class="p-relative formcell">
								<form  action="${servePath}/pc/customer/saveContact">
								<input type="hidden" name="companyId" value="${(data.companyId)!}"  class="companyId" >
								<input type="hidden"  value="${(data.id)!}"  name="id" class="id">
								<div class="w5 left"><input type="checkbox" class="checkbox" ></div>
								<div class="w15 left"><input type="text" name="code"  value="${(data.code)!}" class="readonly" readonly ></div>
								<div class="w15 left"><input type="text" name="name"  value="${(data.name)!}" class="readonly" readonly></div>
								<div class="w15 left"><input type="text" name="money" value="${(data.money)!}" class="readonly" readonly></div>
								<div class="w15 left"><input type="text" name="signDate" value="${(data.signDate?string('yyyy-MM-dd'))!}"  class="editable readonly datepicker"  readonly></div>
								<div class="w15 left"><input type="text" name="userName"  value="${(data.userName)!}" class="readonly" readonly ></div>
								<div class="w20 left">
									<span class="modify-icon j-modify ">编辑</span>
									<span class="btn-save j-save hide " data-url="${servePath}/pc/customer/saveContract">保存</span>
								</div>
								
								<div class="clear-both"></div>
								</form>
						</div>	
		 		</#list>
				</#if>
			
		</div>	
		
</div>		