<div class="contact-main">
		<div class="contact-info">
			<span>联系人</span>
			<span class="btn   customer-btn j-customer-new" data-maineleid="contact-main" data-url="${servePath}/pc/customer/contactCellform">新增</span>
			<span class="btn   customer-btn j-delete" data-parentid="contact-main" data-url="${servePath}/pc/contact/delete">删除</span>
		</div>
		
		<div class="customer-form" id="contact-main">
			
				<div class="p-relative formcell">
					<form id="cutsomerForm">
					<div class="w5 left"><input type="checkbox" class="checkbox j-checkbox" data-parentid="contact-main"></div>
					<div class="w15 left">姓名</div>
					<div class="w15 left">职务</div>
					<div class="w15 left">电话</div>
					<div class="w15 left">电子邮件</div>
					<div class="w20 left">操作</div>
					<div class="clear-both"></div>
					</form>
				</div>
				
				<#if contactList?? >
					<#list contactList as data>
							
					<div class="p-relative formcell">
						<form  action="${servePath}/pc/customer/saveContact">
						<input type="hidden" name="id" value="${(data.id)!}"   >
						<input type="hidden" name="companyId" value="${(data.companyId)!}"  class="companyId" >
						<div class="w5 left"><input type="checkbox"  class="checkbox"></div>
						<div class="w15 left"><input type="text" name="name"  value="${(data.name)!}" class="readonly" readonly></div>
						<div class="w15 left"><input type="text" name="position" value="${(data.position)!}"  class="readonly" readonly></div>
						<div class="w15 left"><input type="text" name="phone"  value="${(data.phone)!}" class="readonly" readonly></div>
						<div class="w15 left"><input type="text" name="email" value="${(data.email)!}"  class="readonly" readonly></div>
						<div class="w20 left">
							<span class="modify-icon j-modify "></span>
							<span class="btn-save j-save hide" data-url="${servePath}/pc/customer/saveContact">保存</span>
						</div>
						<div class="clear-both"></div>
						</form>
					</div>	
							
					</#list>
				</#if>
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
		 
			
		</div>	
		
</div>		