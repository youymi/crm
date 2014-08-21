<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/index","/app/crm/css/style"] />
<@addJS [""] />


	
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

});

</SCRIPT>
</@addScript>




<@common title="云客户">		
<script type="text/javascript" src="/saasportal/static/js/header.js?0.0.1"></script>
 
<div class="saaswrapper">
	<DIV class="content" >
	
	<#include "../common/header.ftl">
	

	<DIV class="container-fluid" style="margin-top: 12px">
	
	         <!-- 底部蓝色线条 -->
			<DIV style="padding-top: 5px; margin-top: 2px; margin-bottom: 5px; border-top-color: rgb(0, 136, 204); border-top-width: 2px; border-top-style: solid;">
			</DIV>
			
			<DIV style="margin-top: 40px;">
				<span style="margin-right: 20px"><img alt="待联系客户" src="${staticServePath}/app/crm/images/touch_big.png">待联系客户</span>
			</DIV>
			
			
				<!-- 列表开始 -->
				<DIV>
					<TABLE
						class="table table-bordered table-hover table-condensed table-striped">
						<THEAD>
							<TR>
								<TH width="35" align="left"><INPUT name="selectedAll"
									id="selectedAll" type="checkbox"></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=accountname&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">客户名称&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=membername&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">联系人&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=title&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">职位&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=phone&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">手机号码&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=leadsource&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">客户来源&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=email&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">Email&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=qq&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">QQ&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=smownerid&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">负责人&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=rating&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">客户状态&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									onclick='getListViewEntries_js("Accounts","order_by=ordertotal&amp;start=1&amp;sorder=ASC&amp;viewname=1");'
									href="javascript:;">订单金额&nbsp;</A></TH>
								<TH align="left">编辑 | 删除</TH>
							</TR>
						</THEAD>
						<TBODY>
							<TR id="row_2018">
								<TD><INPUT name="selected_id" id="selected_id_2018"
									type="checkbox" value="2018"></TD>
								<TD><A
									href="http://free.c3crm.com/index.php?action=DetailView&amp;module=Accounts&amp;record=2018&amp;parenttab=Customer">中国万网</A></TD>
								<TD>张斌</TD>
								<TD>经理</TD>
								<TD><A
									href="http://free.c3crm.com/index.php?module=Qunfas&amp;action=ListView&amp;idstring=2018&amp;modulename=Accounts"
									target="main">1888888888</A></TD>
								<TD>客户介绍</TD>
								<TD><A
									href="http://free.c3crm.com/index.php?module=Maillists&amp;action=ListView&amp;idstring=2018&amp;modulename=Accounts"
									target="main"></A></TD>
								<TD>10000</TD>
								<TD>admin</TD>
								<TD>潜在</TD>
								<TD></TD>
								<TD><A title="编辑"
									href="http://free.c3crm.com/index.php?module=Accounts&amp;action=EditView&amp;record=2018&amp;return_module=Accounts&amp;return_action=index&amp;parenttab=&amp;return_viewname=1">&nbsp;<I
										class="cus-pencil"></I>
								</A> | <A
									href='javascript:confirmdelete("index.php?module=Accounts&amp;action=Delete&amp;record=2018&amp;return_module=Accounts&amp;return_action=index&amp;parenttab=&amp;return_viewname=1")'><IMG
										title="刪除" src="客户%20-%20易客CRM开源免费版_php2_files/del.gif"
										border="0"> </A></TD>
							</TR>

						</TBODY>
					</TABLE>
				</DIV>
				
				<!-- 底部开始 -->
				<DIV style="margin-top: 0px; margin-bottom: 0px;">
					<TABLE class="table table-bordered table-hover table-condensed">
						<TBODY>
							<TR>
								<TD style="margin: 0px;" colspan="15">
									<DIV class="span7 pull-left" style="margin-top: 8px;"></DIV>
									<DIV class="span5" style="margin-top: 8px;">
										<DIV class="pagination pagination-mini pagination-right"
											style="margin: 0px;">
											<SMALL style="color: rgb(153, 153, 153);">显示 1 - 8 之
												8&nbsp;</SMALL> <SELECT name="listpagesize" class="pull-right"
												id="listpagesize" style="width: 55px; height: 20px;"
												onchange="getListViewWithPageSize('Accounts',this)"><OPTION
													value="10">10</OPTION>
												<OPTION value="15">15</OPTION>
												<OPTION value="20" selected="">20</OPTION>
												<OPTION value="30">30</OPTION>
												<OPTION value="40">40</OPTION>
												<OPTION value="50">50</OPTION>
												<OPTION value="100">100</OPTION>
												<OPTION value="200">200</OPTION></SELECT><SMALL class="pull-right"
												style="color: rgb(153, 153, 153);">&nbsp;&nbsp;每页条数:&nbsp;&nbsp;</SMALL>
										</DIV>
									</DIV>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>

			</DIV>
	</DIV>



	</DIV>
</div>

</@common>