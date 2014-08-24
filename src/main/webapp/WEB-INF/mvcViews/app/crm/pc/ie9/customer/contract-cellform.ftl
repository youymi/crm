<div class="p-relative formcell">
					<form  action="${servePath}/pc/customer/saveContact">
					<input type="hidden" name="companyId" value="${dataId!}"  class="companyId" >
					<input type="hidden" name="id" class="id">
					<div class="w5 left"><input type="checkbox" class="checkbox"></div>
					<div class="w15 left"><input type="text" name="code"   class="editable" ></div>
					<div class="w15 left"><input type="text" name="name"  class="editable"></div>
					<div class="w15 left"><input type="text" name="money"  class="editable"></div>
					<div class="w15 left"><input type="text" name="signDate"   class="editable datepicker"  ></div>
					<div class="w15 left"><input type="text" name="userName"   class="editable"  ></div>
					<div class="w20 left">
						<span class="modify-icon j-modify hide">编辑</span>
						<span class="btn-save j-save " data-url="${servePath}/pc/customer/saveContract">保存</span>
					</div>
					
					<div class="clear-both"></div>
					</form>
</div>	