<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/index","/app/crm/css/style"] />
<@addCSS ["/app/crm/css/customer","/app/crm/css/common","/app/crm/css/demo","/app/crm/css/zTreeStyle/zTreeStyle"] />
<@addJS ["/app/crm/js/jquery.ztree.all-3.5","/app/crm/js/customer"] />


<@addScript>
<SCRIPT language="JavaScript" type="text/javascript">

$(function() {
    //全选 | 反全选
   $("#selectedAll").click(function() { 
        $('input[name="selected_id"]').prop("checked",this.checked);
    });
    var $selected_id = $("input[name='selected_id']"); 
    $selected_id.click(function(){
        $("#selectedAll").prop("checked",$selected_id.length == $selected_id.filter(":checked").length.length ? true : false);
    });
    
    //全选 | 反全选
    $("#selectedAll2").click(function() { 
         $('input[name="selected_id2"]').prop("checked",this.checked);
   	  });
     var $selected_id = $("input[name='selected_id2']"); 
     $selected_id.click(function(){
         $("#selectedAll2").prop("checked",$selected_id.length == $selected_id.filter(":checked").length.length ? true : false);
     	});

});

/**
 * 删除字典数据
 */
function delDictionary(){
	var CheckCount=0;

	 $('INPUT[type=checkbox][name=selected_id][checked]').each(function(){
			if($(this).attr("checked")){
				CheckCount++;
				var v = $(this);
				alert(v);
			}
		});
	alert($("INPUT[type=checkbox][name=selected_id][checked]").length);

}

</SCRIPT>
</@addScript>




<@common title="云客户">		
<script type="text/javascript" src="/saasportal/pc/component/header/customizedjs"></script>
 
<div class="saaswrapper">
	<DIV class="content" >
	
<#include "../common/header.ftl">
	<DIV class="container-fluid" style="margin-top: 12px">
	
	         <!-- 底部蓝色线条 -->
			<DIV style="padding-top: 5px; margin-top: 2px; margin-bottom: 5px; border-top-color: rgb(0, 136, 204); border-top-width: 0px; border-top-style: solid;">
			</DIV>
			
			
		<div id="customer-type-main" class="contract-main">
				<div class="customer-type-setting">
					<span>客户类型设置</span>
					<span><A  data-toggle="modal" href="#example"><IMG	title="添加" src="${staticServePath}/app/crm/images/add.png"		border="0"></A> </span>
					<span><A href="" class="j-delete"  data-parentid="customer-type-main" data-url="${servePath}/pc/setting/deleteCustomerType" ><IMG	title="删除" src="${staticServePath}/app/crm/images/del.png"	 	border="0"> </A> </span>
				</div>
				
						<TABLE 	class="table  table-hover">
							<THEAD style="background-color: #e2efda;">
								<TR>
								 	<th><INPUT name="selectedAll"	id="selectedAll" type="checkbox" class="j-checkbox"></th>
									<TH>类型名称</TH>
									<TH>类型说明</TH>
									<TH>操作</TH>
								</TR>
							</THEAD>
							<TBODY>
								
					 <#if dataDictionaryList?exists>
									<#list dataDictionaryList  as data>
										<TR id="row_2018" class="formcell">
											<TD><INPUT name="selected_id"	type="checkbox" class="checkbox"  data-id="${data.id!}" value="${data.id!}"/></TD>
											<TD>${data.name!}</TD>
											<TD>${data.value!}</TD>
											<TD>
												<a href="javascript:void()" class="j-edit-customertype" data-id="${data.id!}" data-modal="edit-customer-type" data-name="${data.name!}" data-desc="${data.value!}"><I class="cus-pencil"><IMG	title="分配" src="${staticServePath}/app/crm/images/pencil.png"		border="0"> </I></a> 
											</TD>
										</TR>
									 </#list>
					</#if>
								
							</TBODY>
						</TABLE>	
		</div>		
		
				<div id="example" class="modal">
					<div class="modal-dialog">
								<div class="modal-content" style="background-color: #F6F7F7">
									<div class="modal-header">
										<span>客户类型设置</span>
									</div>
									<div class="modal-body">
										<form  onsubmit="return checkDataDictionary(this)" action="${servePath}/pc/setting/saveDataDictionary" method="post" accept-charset="utf-8" class="form-horizontal" role="form">	
											 <div class="form-group">
											    <label for="inputEmail3" class="col-sm-2 control-label">类型名称</label>
											    <div class="col-sm-10">
											      <input id="dname" name="name" type="text" class="form-control"  placeholder="类型名称">
											    </div>
											  </div>
											  
											  <div class="form-group">
											    <label for="inputPassword3" class="col-sm-2 control-label">类型说明</label>
											    <div class="col-sm-10">
											      <textarea id="dvalue" name="value" class="form-control" placeholder="类型说明"  rows="5"></textarea>
											    </div>
											  </div>
											  
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
													<button type="submit" class="btn btn-primary">保存</button>  
												</div>
										</form>
									</div>
								</div>
							</div>
				</div>
<script type="text/javascript">
	function checkDataDictionary(form){
	
		var name = $(form).find('#dname').val();
		var value =$(form).find$('#dvalue').val();
		
	    if("" == name && ""==value){
	    				alert("类型名称和类型说明不能为空");
	        return false;
	    }else if("" == name){
	    	alert("类型名称不能为空");
	        return false;
	    }else if("" == value){
	    	alert("类型说明不能为空");
	    	return false;
	    }else{
	    	return true;
	    }
	}


</script>







				<div  class=" contract-main  toptree p-relative " >
					<div class="customer-type-setting">
						<span>人员权限设置</span>
					</div>

					<TABLE class="table  table-hover">
						<THEAD style="background-color: #e2efda;">
							<TR>
								<th><INPUT name="selectedAll2" id="selectedAll2"
									type="checkbox"></th>
								<TH>人员角色</TH>
								 
								<TH>角色下人员</TH>
								<TH>操作
								<TH>
							</TR>
						</THEAD>
						<TBODY>

							<#if groups?exists && (groups?size > 0)  >
							 <#list groups as	data>
									<TR id="row_2018">
										<TD><INPUT name="selected_id2" id="selected_id2"
											type="checkbox" value="${(data.group.id)!}"></TD>
										<TD>${(data.group.name)!}</TD>
										<TD>${(data.names)!}</TD>
									 
										<TD><A class="j-open-orgtree" data-id="${data.group.id!}" data-mainid="customer-list"  data-posturl="${servePath}/pc/setting/roleAssign" data-url="${staticServePath}/orgtree" data-checked="true" ><I class="cus-pencil"><IMG
													title="分配" src="${staticServePath}/app/crm/images/pencil.png"
													border="0"> </I></A></TD>
									</TR>
							</#list> 
							</#if>

						</TBODY>
					</TABLE>
				</div>


			</DIV>

		</DIV>
</div>
<#include "modal.ftl"/>
</@common>