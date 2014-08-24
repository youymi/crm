<div class="p-relative formcell">
					<form  action="${servePath}/pc/customer/saveContact">
					<input type="hidden" name="id" class="id">
					<input type="hidden" name="companyId" value="${dataId!}"  class="companyId" >
					<div class="w5 left"><input type="checkbox" class="checkbox" ></div>
					<div class="w15 left"><input type="text" name="name"   class="editable" ></div>
					<div class="w15 left"><input type="text" name="position"  class="editable"></div>
					<div class="w15 left"><input type="text" name="phone"  class="editable"></div>
					<div class="w15 left"><input type="text" name="email"   class="editable"  ></div>
					<div class="w20 left">
						<span class="modify-icon j-modify hide">编辑</span>
						<span class="btn-save j-save " data-url="${servePath}/pc/customer/saveContact">保存</span>
					</div>
					<div class="clear-both"></div>
					</form>
</div>	