!function($) {
	
	window.currentZtreeObj = null;
	
	var  handleAjax = function(data) {
		if (data.succeed) {
			alert(data.msg);

			window.location.reload();
		} else {
			if (data.msg) {
				alert(data.msg);
			} else {
				alert("出错了,亲...");
			}
		}
	};

	var doAajx = function(actionUrl, formSel, paramData, handler) {
		var param = "";
		
		if (formSel) {
			 param += $(formSel).serialize();
		}
		if(paramData) {
			if (param.length > 0) {
				param = "&"+paramData;
			}else {
			param += paramData;
			}
		}

		$.ajax({
			url : actionUrl,
			type : 'POST',
			data : param+"&ajax=true"
		}).done(function(data) {
			if (handler) {
				handler(data);
				return; 
			}
			handleAjax(data);

		}).fail(function(jqXHR, error) {
			alert("出错了...");

		});
	};
	
	var commonSearchHandler = function (data) {
		if (data.code && data.code == 805) {
			alert(data.msg);
			return;
		}
		$(".j-common-table").html(data);
		jpaeInit();
	};
	
	
	
	$(document).on('keyup', '.j-common-search', function() {
		var url = webCfg.servePath + $(this).data("module");
		doAajx(url,false,"customerName="+$(this).val(),commonSearchHandler);

	});
	
	

	$(document).on('click', '.j-common-save', function() {		
		
		$('.j-validate-form').trigger("validate");

		var v = $('.j-validate-form').validator().data('validator');
		
		var isValid = v.isFormValid();
		 
		 
		if (isValid == false) {
			//验证失败
			
			//alert("请检查表单信息（不正确项）");
			return ;
		} 
		
		var url = webCfg.servePath + $(this).data("module");
		var simClass =  $(this).data("class");
		if (simClass) {
		doAajx(url,".j-common-form"+simClass);
		} else {
			doAajx(url,".j-common-form");
		}

	});
	
 
	
	
	$(document).on('click', '.j-common-delete', function() {
		
		if (confirm("确定删除此记录!")) {
		var url = webCfg.servePath + $(this).data("module");
		doAajx(url,false,"id="+$(this).data("id"));
		}
		
	});

	$(document).on('click', '.j-user-save', function() {
		
		$('.j-validate-form').trigger("validate");

		var v = $('.j-validate-form').validator().data('validator');
		
		var isValid = v.isFormValid();
		 
		 
		if (isValid == false) {
			//验证失败
			
			//alert("请检查表单信息（不正确项）");
			return ;
		} 
		
		
		var param = $(".j-user-form").serialize();
		$.ajax({
			url : webCfg.servePath + '/user/save',
			type : 'POST',
			async : false,
			data : param + "&ajax=true"
		}).done(function(data) {

			handleAjax(data);

		}).fail(function(jqXHR, error) {
			alert("服务器出错了...亲 ...");

		});
	});

	$(document).on('click', '.j-user-delete', function() {

		if (confirm("确定删除此用户!")) {

			$.ajax({
				url : webCfg.servePath + '/user/delete',
				type : 'POST',
				data : "id=" + $(this).data("id") + "&ajax=true"
			}).done(function(data) {

				if (data.succeed) {
					alert(data.msg);

					window.location.reload();
				} else {
					if (data.msg) {
						alert(data.msg);
					} else {
						alert("出错了，亲");
					}
				}

			}).fail(function(jqXHR, error) {
				alert("出错了...");

			});

		}
	});
	
	
	//保存客户
	$(document).on('click', '.j-save-customer', function() {

			$.ajax({
				url : webCfg.servePath + '/pc/company/saveCustomer',
				type : 'POST',
				dataType : "json",
				data :  $(".j-customer-form").serialize()
			}).done(function(data) {

				if (data.succeed) {
					 $(".j-customer-form").find(".id").val(data.data.id);
						alert("保存成功！");
					
				} else {
					if (data.msg) {
						alert(data.msg);
					} else {
						alert("出错了，亲");
					}
				}

			}).fail(function(jqXHR, error) {
				alert("出错了...");

			});

		 
	});
	
	//清空客户表单
	$(document).on('click', '.j-clear-customerform', function() {

		$(".j-customer-form").find("input").val("");
		 
	});
	
	
	var readOnly = function($this){
		$this.parents("form").find("input").attr("readonly","readonly").removeClass("editable").addClass("readonly");
	} ;
	
	//表单变为可编辑状态
	$(document).on('click', '.j-modify', function() {
		$(this).parents("form").find("input").removeAttr("readonly").addClass("editable").removeClass("readonly");
		$(this).addClass("hide");
		$(this).next(".j-save").removeClass("hide");
		
	});
	
	
	//客户浏览表单变为可编辑状态
	$(document).on('click', '.j-customermodify', function() {
		$("#"+$(this).data("formid")).find("input").removeAttr("readonly").addClass("editable").removeClass("readonly");
		$(this).addClass("hide");
		$(this).next(".j-save-customer").removeClass("hide"); 
		
	});
	
	//新增操作
	$(document).on('click', '.j-customer-new', function() {
		 var companyId =  $(".j-customer-form").find(".id").val();
		 if (companyId == null || companyId == "") {
			 alert("请先保存客户信息");
			 return ;			 
		 } 
		 
		 $that = $(this);
			 
		 $.ajax({
				url : $that.data("url"),
				type : 'POST',
				dataType : "text",
				data : "dataId=" + companyId
			}).done(function(data) {
				$("#"+$that.data("maineleid")).append($(data));
				$( ".datepicker" ).datepicker();
				 
			}).fail(function(jqXHR, error) {
				alert("出错了...");

			});

	});
	
	$(document).on('click', '.j-checkbox', function() {
		//console.log($(this).prop("checked"));
		if ($(this).prop("checked")) {
			$("#"+$(this).data("parentid")).find(".checkbox").prop("checked",true);
		} else {
			$("#"+$(this).data("parentid")).find(".checkbox").prop("checked",false);
		}
		 
		
	});
	
	
	
	//保存操作
	$(document).on('click', '.j-save', function() {
		 var companyId =  $(".j-customer-form").find(".id").val();
		 if (companyId == null || companyId == "") {
			 alert("请先保存客户信息");
			 return ;			 
		 } 
		 
		 $that = $(this);
		 
		 $.ajax({
				url : $that.data("url"),
				type : 'POST',
				dataType : "json",
				data :  $that.parents("form").serialize()
			}).done(function(data) {
				if (data && data.data) {
					
					$that.parents("form").find(".id").val(data.data.id);
					 $that.addClass("hide");
					 console.log($that.prev().html());
					 $that.prev().removeClass("hide");
					 readOnly($that);
					 alert("保存成功！");
				}
				 
			}).fail(function(jqXHR, error) {
				alert("出错了...");

			});
		 
		 
	});
	
	
	
	$(document).on('click', '.j-cancel-orgtree', function() {
		$(this).parents(".orgtreepop").remove();
	});
	
	
	
	
	
	//选人 操作
	$(document).on('click', '.j-open-orgtree', function() {
		 
		$that = $(this);
		 $.ajax({
				url : $that.data("url"),
				type : 'get',
				dataType : "json"
				 
			}).done(function(data) {
				if (data && data.succeed) {
					var setting = {	};
					$(".toptree.p-relative").append($("<div class='orgtreepop'><div id='treeDemo' class='ztree'></div><div class='middle'><span class='btn btn-primary j-tree-confirm'>确定</span> &nbsp;<span class='btn btn-primary j-cancel-orgtree'>取消</span></div></div>"));
					
					currentZtreeObj = $.fn.zTree.init($("#treeDemo"), setting, data.data);
					//console.log($("#treeDemo").find(".j-tree-confirm"));
					$(".orgtreepop").find(".j-tree-confirm").on("click", function(){
						var nodes = currentZtreeObj.getSelectedNodes();
						if (nodes.length == 0) {
							alert("请选择节点");
							return false;
						}
						var desIds =  "";
						var destNames = "";
						$.each(nodes,function(index,n){
							//console.log(n);
							if (desIds == "") {
								desIds += n.id;
								destNames += n.name;
								return false;
							}
							desIds += "," + n.id;
							destNames +=  "," + n.name;
						});
						
						//console.log(desIds);
						
						var id = $that.data("id");
						if( id != null && id != "") {
							
						} else {
							id = "";
							$("#"+$that.data("mainid")).find(".checkbox:checked").each(function(){
								if ($(this).hasClass("j-checkbox")){
									return true;
								}
									
								if(id=="") {
									id = $(this).data("id");
								} else {
									id += ","+$(this).data("id");
								}
								
							});
						}
						
						console.log(id);
						
						 $.ajax({
								url : $that.data("posturl"),
								type : 'post',
								dataType : "json",
								data : "ids="+id+"&destId="+desIds+"&destName="+destNames
							}).done(function(data) {
								if (data && data.succeed) {
									alert("成功了");
									$(".j-cancel-orgtree").trigger("click");
									location.reload();
								}
							});
						
						
						
					});
					
					//alert("保存成功！");
				}
				 
			}).fail(function(jqXHR, error) {
				alert("出错了...");

			});
		 
		 
	});
	
	
	//删除操作
	$(document).on('click', '.j-delete', function() {
		
		var checkedEle = $("#"+$(this).data("parentid")).find(".checkbox:checked");
		if (checkedEle.size() == 0) {
			alert("没有选中记录");
			return;
		}
		$that = $(this);
		if (confirm("确定删除选中的记录？")) {
		
		var ids = "";
		checkedEle.each(function(index, domEle){
			var $el  = $(domEle);
			if ($el.hasClass("j-checkbox")) {
				return true;
			}
			var id = $el.data("id");
			
			if (id != null && id != "") {
				ids += ","+id;
				return true;
			}
			
			id = $el.parents("form").find("input[name='id']").val();
			if (id == null || id == "") {
				//alert("hi");
				$el.parents(".formcell").remove();
			} else {
				//alert(id);
				ids += ","+id;
			}
		});
		
		//alert(ids);
		 $.ajax({
				url : $that.data("url"),
				type : 'POST',
				dataType : "json",
				data : "ids=" + ids
			}).done(function(data) {
				if (data && data.data) {
					
					checkedEle.each(function(index, domEle){
						var $el  = $(domEle);
						if ($el.hasClass("j-checkbox")) {
							return true;
						}
						
						$el.parents(".formcell").remove();
						 
					});
					 alert("删除成功！");
				}
				 
			}).fail(function(jqXHR, error) {
				alert("出错了...");

			});
		 
		
		}
		 
	});
	
	
	
	//关注
	$(document).on('click', '.j-atten', function() {
		
		var checkedEle = $("#"+$(this).data("mainid")).find(".checkbox:checked");
		if (checkedEle.size() == 0) {
			alert("没有选中记录");
			return;
		}
		$that = $(this);
		if (confirm("确定关注选中的记录？")) {
		
		var ids = "";
		checkedEle.each(function(index, domEle){
			var $el  = $(domEle);
			if ($el.hasClass("j-checkbox")) {
				return true;
			}
			var id = $el.data("id");
			
			if (id != null && id != "") {
				if (ids == ""){
					ids = id;
				} else {
				ids += ","+id;
				}
				return true;
			}
			
			id = $el.parents("form").find("input[name='id']").val();
			if (id == null || id == "") {
				//alert("hi");
				$el.parents(".formcell").remove();
			} else {
				//alert(id);
				ids += ","+id;
			}
		});
		
		alert(ids);
		 $.ajax({
				url : $that.data("url"),
				type : 'POST',
				dataType : "json",
				data : "ids=" + ids
			}).done(function(data) {
				if (data && data.data) {
					
//					checkedEle.each(function(index, domEle){
//						var $el  = $(domEle);
//						if ($el.hasClass("j-checkbox")) {
//							return true;
//						}
//						
//						$el.parents(".formcell").remove();
//						 
//					});
					 alert("成功啦！");
				}
				 
			}).fail(function(jqXHR, error) {
				alert("出错了...");

			});
		 
		
		}
		 
	});
	
	function initDatepicker(){
		jQuery(function(){  
		    $.datepicker.regional['zh-CN'] = {  
		      clearText: '清除',  
		      clearStatus: '清除已选日期',  
		      closeText: '关闭',  
		      closeStatus: '不改变当前选择',  
		      prevText: '<上月',  
		      prevStatus: '显示上月',  
		      prevBigText: '<<',  
		      prevBigStatus: '显示上一年',  
		      nextText: '下月>',  
		      nextStatus: '显示下月',  
		      nextBigText: '>>',  
		      nextBigStatus: '显示下一年',  
		      currentText: '今天',  
		      currentStatus: '显示本月',  
		      monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'],  
		      monthNamesShort: ['一','二','三','四','五','六', '七','八','九','十','十一','十二'],  
		      monthStatus: '选择月份',  
		      yearStatus: '选择年份',  
		      weekHeader: '周',  
		      weekStatus: '年内周次',  
		      dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],  
		      dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],  
		      dayNamesMin: ['日','一','二','三','四','五','六'],  
		      dayStatus: '设置 DD 为一周起始',  
		      dateStatus: '选择 m月 d日, DD',  
		      dateFormat: 'yy-mm-dd',  
		      firstDay: 1,  
		      initStatus: '请选择日期',  
		      isRTL: false  
		    };  
		    $.datepicker.setDefaults($.datepicker.regional['zh-CN']);  
		    $('#datepicker').datepicker({changeMonth:true,changeYear:true});  
		  });  
	}
	
	$(function(){
		initDatepicker();
		if ($( ".datepicker" ).size() > 0) {
			$( ".datepicker" ).datepicker();
		}
		
	});
	
	


}(window.jQuery);