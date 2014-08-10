<div class="contact-main">
		<div class="contact-info">
			<span>客户信息</span>
			<span class="btn   customer-btn">新增</span>
			<span class="btn   customer-btn">删除</span>
		</div>
		
		<div class="customer-form">
			
				<div class="p-relative formcell">
					<form id="cutsomerForm">
					<div class="w5 left"><input type="checkbox" ></div>
					<div class="w15 left">姓名</div>
					<div class="w15 left">职务</div>
					<div class="w15 left">电话</div>
					<div class="w15 left">电子邮件</div>
					<div class="w20 left">操作</div>
					<div class="clear-both"></div>
					</form>
				</div>
				
				<div class="p-relative formcell">
					<form  action="${servePath}/pc/customer/saveContact">
					<div class="w5 left"><input type="checkbox" ></div>
					<div class="w15 left"><input type="text" name="" value="张三" class="readonly" readonly></div>
					<div class="w15 left"><input type="text" name="" value="张三" class="readonly" readonly></div>
					<div class="w15 left"><input type="text" name="" value="张三" class="readonly" readonly></div>
					<div class="w15 left"><input type="text" name="" value="张三" class="readonly" readonly></div>
					<div class="w20 left">
						<span class="modify-icon j-modify"></span>
						<span class="btn-save j-save hide">保存</span>
					</div>
					<div class="clear-both"></div>
					</form>
				</div>	
						
			
		 
			
		</div>	
		
</div>		