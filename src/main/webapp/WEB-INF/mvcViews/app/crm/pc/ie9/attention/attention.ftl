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
<script type="text/javascript" src="/saasportal/pc/component/header/customizedjs"></script>
 
<div class="saaswrapper">
	<DIV class="content" >
	
	<#include "../common/header.ftl">
	

	<DIV class="container-fluid" style="margin-top: 12px">
	
	         <!-- 底部蓝色线条 -->
			<DIV style="padding-top: 5px; margin-top: 2px; margin-bottom: 5px; border-top-color: rgb(0, 136, 204); border-top-width: 2px; border-top-style: solid;">
			</DIV>
			
			<DIV style="margin:10px 0 10px 10px">
				<span><img alt="待联系客户" src="${staticServePath}/app/crm/images/touch_big.png">关注客户 <i style="color: red"> 总共：${page.totalRecords!}</i></span>
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
									href="javascript:;">客户编号&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									href="javascript:;">客户名称&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									href="javascript:;">客户类型&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									href="javascript:;">需要联系时间&nbsp;</A></TH>
								<TH align="left"><A class="listFormHeaderLinks"
									href="javascript:;">联系内容&nbsp;</A></TH>
								<TH align="left">操作</TH>
							</TR>
						</THEAD>
						<TBODY>
						
		 <#if attentionList?exists>
						<#list attentionList  as attention>
							<TR id="row_2018">
								<TD><INPUT name="selected_id"	type="checkbox" value="${attention.companyAO.id!}"></TD>
								<TD>${attention.companyAO.code!}</TD>
								<TD>${attention.companyAO.name!}</TD>
								<TD>${attention.companyAO.type!}</TD>
								<TD>${attention.contactDate?string("yyyy-MM-dd")}</TD>
								<TD>${attention.content!}</TD>
								<TD>
								
									<A><I class="cus-pencil"><IMG	title="分配" src="${staticServePath}/app/crm/images/distribution.png"		border="0"> </I></A> | 
									<A><I class="cus-pencil"><IMG	title="关注" src="${staticServePath}/app/crm/images/star_1.png"		border="0"> </I></A>|
									<A><I class="cus-pencil"><IMG	title="联系" src="${staticServePath}/app/crm/images/touch_small.png"		border="0"> </I></A>
									
								</TD>
							</TR>
						 </#list>
		</#if>
		
						</TBODY>
					</TABLE>
				</DIV>
			
					<div class="pull-right">
								<ul class="pagination pagination-sm">
							<#if page?exists>
									<#if page.pageNo==1>
								  	    <li class="disabled"><a>&laquo;</a></li>
								  <#else>
								  				<li><a href="${servePath}/pc/attention?pageNo=${page.pageNo-1}">&laquo;</a></li>
								  </#if>
								  <#if (page.pageNo >1)>
										<#list 1..(page.pageNo-1) as t>
											<li><a href="${servePath}/pc/attention?pageNo=${t}">${t}</a></li>
										</#list>
								  </#if>
								<li class="active"><a href="${servePath}/pc/attention?pageNo=${page.pageNo}">${page.pageNo}</a></li>
								<#if (page.pageCount > page.pageNo)>
									<#list (page.pageNo+1)..page.pageCount as t>
											<li><a href="${servePath}/pc/attention?pageNo=${t}">${t}</a></li>
									</#list>
								</#if>
								
									<#if (page.pageCount == page.pageNo)>
									  	    <li class="disabled"><a>&raquo;</a></li>
	   				 		<#else>
								  				<li><a href="${servePath}/pc/attention?pageNo=${page.pageNo+1}">&raquo;</a></li>
								  </#if>
							</#if>
								</ul>
					</div>
					
					
			</DIV>
	</DIV>



	</DIV>
</div>

</@common>