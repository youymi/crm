<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/index","/app/crm/css/style"] />
<@addJS [""] />


	
<@addScript>
<script type="text/javascript">

</script>
</@addScript>




<@common title="云客户">		
<script type="text/javascript" src="/saasportal/static/js/header.js?0.0.1"></script>
 
<div class="saaswrapper">
	<DIV class="content" >
	
<#include "../common/header.ftl">
	
	
	<DIV class="container-fluid">
		<DIV style="margin-right: 10px; margin-left: 0px;">
			<DIV>
				<DIV class="pull-left">
					<FORM name="basicSearch" class="form-search pull-left"
						style="margin-bottom: 5px;" action="index.php" method="POST">
						<SELECT name="search_field" class="txtBox" id="bas_searchfield"
							style="width: 130px;"><OPTION value="accountname"
								label="客户名称">客户名称</OPTION>
							<OPTION value="membername" label="联系人">联系人</OPTION>
							<OPTION value="title" label="职位">职位</OPTION>
							<OPTION value="phone" label="手机号码">手机号码</OPTION>
							<OPTION value="leadsource" label="客户来源">客户来源</OPTION>
							<OPTION value="email" label="Email">Email</OPTION>
							<OPTION value="qq" label="QQ">QQ</OPTION>
							<OPTION value="assigned_user_id" label="负责人">负责人</OPTION>
							<OPTION value="rating" label="客户状态">客户状态</OPTION>
							<OPTION value="ordertotal" label="订单金额">订单金额</OPTION>
						</SELECT> <INPUT name="searchtype" type="hidden" value="BasicSearch">
						<INPUT name="module" type="hidden" value="Accounts"> <INPUT
							name="parenttab" type="hidden" value="Customer"> <INPUT
							name="action" type="hidden" value="index"> <INPUT
							name="query" type="hidden" value="true"> <INPUT
							name="search_cnt" type="hidden"> <INPUT
							name="search_text" class="input-large search-query" type="text">
						<BUTTON class="btn btn-small" onclick="callSearch('Basic');"
							type="button">
							<I class="icon-search"></I>&nbsp;搜索
						</BUTTON>
						<BUTTON class="btn btn-small "
							onclick="clearSearchResult('Accounts','BasicSearch');"
							type="button">
							<I class="icon-remove-sign"></I>&nbsp;取消查找
						</BUTTON>
						<BUTTON class="btn btn-small "
							onclick="openAdvanceDialogs('Accounts');" type="button">
							<I class="icon-share-alt"></I>&nbsp;高级搜索
						</BUTTON>
					</FORM>
				</DIV>
				<DIV class="pull-right"></DIV>
				<DIV class="clear"></DIV>
			</DIV>
			<DIV id="tablink">
				<UL class="nav nav-pills" style="margin-bottom: 5px;">
					<LI class="nav-header"
						style="padding-right: 5px; padding-left: 0px;"><I
						class="icon-th-list"></I></LI>
					<LI class="active"><A
						onclick="javascript:getTabView('Accounts','viewname=1',this,1);"
						href="javascript:;">所有</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=11',this,11);"
						href="javascript:;">潜在客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=49',this,49);"
						href="javascript:;">意向客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=50',this,50);"
						href="javascript:;">成交客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=54',this,54);"
						href="javascript:;">列表</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=57',this,57);"
						href="javascript:;">本周待联系客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=64',this,64);"
						href="javascript:;">所有客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=66',this,66);"
						href="javascript:;">所有客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=69',this,69);"
						href="javascript:;">成交客户2</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=70',this,70);"
						href="javascript:;">强成交意愿</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=84',this,84);"
						href="javascript:;">热点客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=86',this,86);"
						href="javascript:;">测试视图</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=87',this,87);"
						href="javascript:;">所有客户</A></LI>
					<LI><A
						onclick="javascript:getTabView('Accounts','viewname=88',this,88);"
						href="javascript:;">高热客户</A></LI>
				</UL>
			</DIV>
			<DIV
				style="padding-top: 5px; margin-top: 2px; margin-bottom: 5px; border-top-color: rgb(0, 136, 204); border-top-width: 2px; border-top-style: solid;">
				<DIV class="pull-left" style="margin-bottom: 5px;">
					<BUTTON class="btn btn-small btn-primary" style="margin-top: 2px;"
						onclick="javascript:location.href='index.php?module=Accounts&amp;action=EditView'">
						<I class="icon-plus icon-white"></I>新增
					</BUTTON>
					<BUTTON class="btn btn-small btn-danger" style="margin-top: 2px;"
						onclick="javascript:return massDelete('Accounts');">
						<I class="icon-trash icon-white"></I>删除
					</BUTTON>
					<DIV class="btn-group" style="margin-top: 2px;">
						<A class="btn btn-small btn-inverse dropdown-toggle"
							href="http://free.c3crm.com/index.php?module=Accounts&amp;action=index#"
							data-toggle="dropdown"><I class="icon-edit icon-white"></I>
							批量操作 <SPAN class="caret"></SPAN> </A>
						<UL class="dropdown-menu">
							<LI><A
								onclick="javascript:quick_edit(this, 'quickedit', 'Accounts');return false;"
								href="http://free.c3crm.com/index.php?module=Accounts&amp;action=index#">批量修改</A></LI>
							<LI><A
								onclick="javascript:change(this,'changeowner');return false;"
								href="http://free.c3crm.com/index.php?module=Accounts&amp;action=index#">修改负责人</A></LI>
						</UL>
					</DIV>
					<!--<button class="btn btn-small btn-inverse" style="margin-top:2px;" onclick="javascript:quick_edit(this, 'quickedit', 'Accounts');return false;" >-->
					<BUTTON class="btn btn-small btn-success" style="margin-top: 2px;"
						onclick="javascript:location.href='index.php?module=Accounts&amp;action=Import&amp;step=1&amp;return_module=Accounts&amp;return_action=index&amp;parenttab=Customer'">
						<I class="icon-download icon-white"></I>导入
					</BUTTON>
					<BUTTON class="btn btn-small btn-success" style="margin-top: 2px;"
						onclick="return selectedRecords('Accounts','Customer')">
						<I class="icon-upload icon-white"></I>导出
					</BUTTON>
					<BUTTON class="btn btn-small " style="margin-top: 2px;"
						onclick="javascript:qunfa_mail(this, 'qunfamail', 'Accounts');return false;">
						<I class="icon-envelope"></I>发送邮件
					</BUTTON>
					<BUTTON class="btn btn-small " style="margin-top: 2px;"
						onclick="javascript:qunfa_sms(this, 'qunfasms', 'Accounts');return false;">
						<I class="icon-comment"></I>发送短信
					</BUTTON>
				</DIV>
				<DIV class="pull-right"></DIV>
			</DIV>
			<DIV class="clear"></DIV>
			<DIV class="small" id="ListViewContents"
				style="width: 100%; position: relative;">
				<DIV tabindex="-1" class="modal hide fade" id="quickedit_form_div"
					role="dialog" aria-hidden="true" aria-labelledby="myModalLabel"></DIV>
				<DIV tabindex="-1" class="modal hide fade" id="gaojisearch"
					role="dialog" aria-hidden="true" aria-labelledby="myModalLabel"
					style="width: 800px; margin-left: -380px;"></DIV>
				<INPUT name="search_url" id="search_url" type="hidden"> <INPUT
					name="idlist" id="idlist" type="hidden"> <INPUT
					name="action" id="action" type="hidden" value="ListView"> <INPUT
					name="module" id="module" type="hidden" value="Accounts"> <INPUT
					name="viewname" id="viewname" type="hidden" value="1"> <INPUT
					name="change_owner" type="hidden"> <INPUT
					name="change_status" type="hidden"> <INPUT name="allids"
					type="hidden">
				<DIV style="margin-top: 0px; margin-bottom: 0px;">
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
				<DIV id="collectcolumntable">
					<SCRIPT>getColumnCollectInf('Accounts','&pgv_pvi=3333855083&Hm_lvt_5c490b208aeecdb2af2f4b6fb696a6fe=1407765777,1407821526&__utma=125730456.789346025.1407821526.1407821526.1407821526.1&__utmz=125730456.1407821526.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none)&PHPSESSID=044af30b3d1b4d43cf5329700d6f0c31');</SCRIPT>
				</DIV>
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
			</DIV>
		</DIV>
	</DIV>



	</DIV>
</div>

</@common>