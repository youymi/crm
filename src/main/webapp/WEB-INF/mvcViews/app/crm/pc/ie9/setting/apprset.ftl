<#include "../common/basePage.ftl">
<@addJS ["/plugins/ztree/jquery.ztree.all-3.5.min","/app/appcenter/js/tenant/tenant"]/>
<@addCSS ["/css/zTreeStyle/zTreeStyle","/app/crm/css/tenant"]/>
<@addScript>
<script type="text/javascript">
	var app_id;//定义全局app的id
	var app_name;//定义全局app的name
	var setting = {//ztree加载的setting
		async: {
			enable: true,
			autoParam:["id", "name=n", "level=lv"],
			otherParam:{"otherParam":"zTreeAsyncTest"}
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		check: {
			enable: true
		},
		view: {
			selectedMulti: false
		}
	};
	
	$(document).ready(function(){
		var img_w=114;
		var margin=15;
		var line_length=7;
		var container_w=$(".list_container").width();
		var app_one_mr=(container_w-114*line_length)/(line_length-1);
		var apps=$(".appContainer");
		for(var i=0;i<apps.length;i++){
			if(i==0 || i%(line_length-1)!=0){
				apps.eq(i).css("marginRight",app_one_mr);
			}
		}
	})
	
	$(document).ready(function(){
		$.ajax({//填充组织机构树
			url : '${servePath}/pc/userbase/orgUser',
			type : "POST",
			data : ""
		}).done(function(data) {
			$.fn.zTree.init($("#orgTree"), setting, data.data);
			var treeObj = $.fn.zTree.getZTreeObj("orgTree");
			var nodes = treeObj.transformToArray(treeObj.getNodes());
			$.each(nodes,function(index,value){
				if(value.dataType=="00"){
					value.isParent=true;
					value.iconSkin="icon_depart";
					treeObj.updateNode(value);
				}else{
					value.iconSkin="icon_user";
					treeObj.updateNode(value);
				}
			})
			nodes = treeObj.getNodes();
			$.each(nodes,function(index,value){
				if(value.dataType=="00"){
					value.isParent=true;
					value.iconSkin="icon_depart";
					treeObj.updateNode(value);
				}else{
					value.iconSkin="icon_user";
					treeObj.updateNode(value);
				}
			})
			
	    }).fail(function(jqXHR, error) {
	    	alert(jqXHR.responseText);
	    });
		
	})


	//弹出框
	function show_alert(msg){
		$(".modal-body").text(msg);
		$('#alert_info').modal('show');
	}

	//移动用户到右边选中
	function move_user(){
		var treeObj = $.fn.zTree.getZTreeObj("orgTree");
		var nodes = treeObj.getCheckedNodes(true);
		var str="";
		var flag=false;
		for(var i=0;i<nodes.length;i++){
			var node=nodes[i];
			if(!is_repeat(node.id)) flag=true;
			if(node.dataType=="10" && is_repeat(node.id)){
			    str=str+'<p class="selected_user_one" id="'+node.id+'">'
			    		+node.name+'<a onclick="delete_selected_user(this)" href="#">删除</a>'
			    		+'</p>'
			}
		}
		$("#selected_user_box").append(str);
		if(flag){
			$(".modal-body").text("已存在的公司管理员将会被过滤掉！");
			$('#alert_info').modal('show');
		}
	}
	//判断是否重复选择
	function is_repeat(id){
		var flag=true;
		var selected_users=$("#selected_user_box").find(".selected_user_one");
		$.each(selected_users,function(index,value){
			var selected_user_id=$(value).attr("id");
			if(selected_user_id==id) flag=false;
		})
		return flag;
	}
	//删除选中用户
	function delete_selected_user(tag){
		var selected_users=$("#selected_user_box").find(".selected_user_one");
		if(selected_users.length>1){
			$(tag).parent("p.selected_user_one").remove();	
		}else{
			$(".modal-body").text("必须有一个用户");
			$('#alert_info').modal('show');
			
		}
	}
	//保存
	function save(){
		var selected_users=$("#selected_user_box").find(".selected_user_one");
		var mapstr="";
		$.each(selected_users,function(index,value){
			var id=$(value).attr("id");
			if(index!=0){
				mapstr=mapstr+"&id="+id;
			}else{
				mapstr=mapstr+"id="+id;
			}
		})
		mapstr=mapstr+"&appid="+app_id;
		$.ajax({
			type:"POST",
			url:"${servePath}/pc/tenantCenter/saveAppMgr",
			data:mapstr,
			async:false,
			success:function(data){
				if(data==true){
					$(".modal-body").text("保存成功");
					$('#alert_info').modal('show');
				}
			}
		});
		
	}
	
	
</script>
</@addScript>
<@common title="应用设置" >
<style>
	.img_active{ border:1px solid red;}
	
	.selected_user_one{ padding:5px;border-bottom:1px solid #eee;}
	.selected_user_one a{ float:right;}

</style>

<div class="panel-wrap">
				<div id="select_user_box" class="container" style=" width:100%; margin-top:20px; ">
				   <div class="row mgr_row">
				   		<div class="mgr_selectList">
				   			<div class="panel panel-info" style="overflow-y:auto;">
							    <div class="panel-heading">
							      <h3 class="panel-title">组织机构信息</h3>
							    </div>
							    <div class="panel-body panel_body_tree" style="height:360px; overflow-y:auto;">
							    	<div id="orgTree" class="ztree"></div>
							    </div>
						    </div>
				   		</div>
				   		<div class="mgr_selectList_btn" style="height:400px;">
				   			<button type="button" onclick="move_user()" class="btn btn-primary" style="width:60px; margin-top:180px; margin-left:0px;"> >> </button>
				   		</div>
						<div class="mgr_selectList">
				   			<div class="panel panel-info" style="height:400px; position: relative;">
							    <div class="panel-heading">
							      <h3 class="panel-title">当前人员列表</h3>
							    </div>
							    <div id="selected_user_box" class="panel-body" style="height:310px; overflow-y:auto;">
							    	<#if infos??>
								      	<#list infos as info>
								      		<p class="selected_user_one" id="${info.id}">
									    			${info.name}<a onclick="delete_selected_user(this)" href="#">删除</a>
									    			</p>
													</#list>
									  </#if>
							    </div>
							    <div style="height:50px; width:100%; background:#eee; position: absolute; left:0px; bottom:0px; border-top:1px solid #ccc;">
							    	<button type="button" onclick="save()" class="btn btn-primary" style="float:right; margin:10px;">确认保存</button>
							    </div>
						    </div>
				   		</div>
				   	</div> 
				 </div>
				 
				 <!-- 提示框 -->
					<div id="alert_info" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog modal-sm" style="width:300px;">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					        <h4 class="modal-title" id="myModalLabel">来自网页的提示信息</h4>
					      </div>
					      <div class="modal-body"> 
					      </div>
					      <div class="modal-footer" style="padding:10px;">
					        <button type="button" class="btn btn-default" data-dismiss="modal">知道啦</button>
					      </div>
					    </div>
					  </div>
					</div>
</div>



</@common>