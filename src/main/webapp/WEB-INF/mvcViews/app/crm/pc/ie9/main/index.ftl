<#include "../common/basePage.ftl">
<@addCSS ["/app/crm/css/index",""] />
<@addJS ["/app/crm/js/autopoint"] />

<style type="text/css">
.dropDiv { 
position: absolute; 
z-index: 10; 
display: none; 
cursor: hand; 
} 
.dropDiv .jhover { 
background-color: #F3F3F3; 
} 
.dropDiv .list { 
float:left; 
width:100%; 
} 
.dropDiv .word { 
float:left; 
} 
.dropDiv .view { 
float:right; 
color: gray; 
text-align: right; 
font-size: 10pt; 
} 
td{
cursor:pointer
}
</style>
	
<@addScript>
<script type="text/javascript">

$(function () {
    $('#container2').highcharts({
        chart: { type: 'spline' },
        title: { text: '客户增长趋势'},
        subtitle: { text: '	'},
        xAxis: {
            categories: [
                        // '2014-01', '2014-02', '2014-03', '2014-04', '2014-05', '2014-06', '2014-07', '2014-08', '2014-09'
						 <#if months?exists>
							 <#list months as m>
							 '${m}',
							</#list>
						</#if>
                         
                         ]
                    },
        yAxis: {   
        	title:  {    text: '客户数量'   },
         labels: {  formatter: function() {
                    return this.value +''
               			 } 	}
        			},
        credits: {
            enabled: false // remove high chart logo hyper-link
       			  },
        exporting:{ 
            enabled:false //用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示 
       },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [
                 /**
                 				{
            name: '潜在客户',
            marker: {symbol: 'square'  },
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, { y: 26.5,marker: { symbol: 'url(http://www.highcharts.com/demo/gfx/sun.png)' } }, 23.3]
      						  }, **/
     			<#if mapData2?exists>
      						<#list mapData2?keys as testKey>
       							{
       		  		name: '${testKey}',
       		  		marker: {symbol: 'square'  },
       		  		data:[ 
       		  		<#list mapData2[testKey] as mp>
			       		  	<#list mp?keys as ky>
			       	              ${mp[ky]},
			       	     </#list>
       		  		</#list>
       		  						]
       		  		      		}, 
      				     
      				</#list>
 						</#if>
      				]
    });
});


$(function () {
	
	// Radialize the colors
	Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function(color) {
	    return {
	        radialGradient: { cx: 0.5, cy: 0.3, r: 0.7 },
	        stops: [
	            [0, color],
	            [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
	        ]
	    };
	});
	
	// Build the chart
    $('#container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
     				   },
        title: {  text: ''  },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
       				 },
        credits: {
            enabled: false // remove high chart logo hyper-link
      				  },
        exporting:{ 
            enabled:false //用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示 
      				},
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    },
                    connectorColor: 'silver'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '客户占比',
            data: [
							// ['潜在客户',   45.0],
             <#if mapData?exists>
                 <#list mapData?keys as testKey>
                 		['${testKey}',${mapData[testKey]}],
                 </#list>
             </#if>
            ]
        }]
    });
});

var openURL = "${servePath}/pc/customer/view?id=";

$(function(){ 
	　　$("#searchinput").autopoint({
		url:'${servePath}/pc/main/search',
		openurl:openURL
		}); 
	}); 
	
$("#attention TBODY tr,#todoContacto TBODY tr").bind("click",function(){
	//alert($(this).html())
var id =	$(this).children('td').eq(0).text();
//alert(id);
window.open(openURL+id,"_self")
});
	
</script>
</@addScript>




<@common title="云客户">		

	<script type="text/javascript" src="/saasportal/pc/component/header/customizedjs"></script>
	<!-- Charts  =============================-->
	<script type="text/javascript" src="${staticServePath}/plugins/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="${staticServePath}/plugins/highcharts/modules/exporting.js"></script>

 
<div class="saaswrapper">
	<DIV class="content" >
	
<#include "../common/header.ftl">
	
		<DIV  class="search" >
			<DIV class="summary">
				<form class="form-horizontal" role="form">
				  <div class="form-group has-success has-feedback">
				    <div class="col-sm-6" style="margin-left:28%">
				      <input type="text" class="form-control" id="searchinput" style="float: left;width: 80%">
				      <button class="btn" onclick="callSearch('Basic');" type="button" style="float: left;border: 0px;height: 36px;margin:-1px 0 0 -3px;"><i class="icon-search"></i>&nbsp;搜索</button>
				    </div>
				  </div>
				</form>
			</DIV>
		</DIV>
		
		
		<DIV class="dash-container">
			<DIV class="inner2">
				<DIV class="mydash" id="">
					<DIV class="header">
						<div class="header-title"><span>客户增长趋势曲线</span></div>
					</DIV>
					<DIV style="margin-right: 5px; margin-left: 5px;">
<div id="container2" style="width: 90%; height: 200px; margin: 0 auto"></div>
					</DIV>
				</DIV>
			</DIV>



			<DIV class="inner">
				<DIV class="mydash" id="attention">
					<DIV class="header">
						<div class="header-title"><span><a href="${servePath}/pc/attention">我关注的客户 >></a></span></div>
					</DIV>
					<DIV style="margin-right: 5px; margin-left: 5px;">
						<TABLE 	class="table  table-hover">
							<THEAD>
								<TR>
								 	<th></th>
									<TH>客户类型</TH>
									<TH>客户名称</TH>
									<TH>联系时间</TH>
								</TR>
							</THEAD>
							<TBODY>
								
							 <#if attentionList?exists>
											<#list attentionList  as attention>
												<TR>
													 <TD><span class="hidden">${attention.companyAO.id!}</span></TD>
														<TD>${attention.companyAO.type!}</TD>
														<TD align="left"><A href="#">${attention.companyAO.name!}</A></TD>
														<TD align="left">${attention.contactDate?string("yyyy-MM-dd")}</TD>
												</TR>
											 </#list>
							</#if>
								
							</TBODY>
						</TABLE>					
					</DIV>
				</DIV>
			</DIV>



			<DIV class="inner">
				<DIV class="mydash" id="">
					<DIV class="header">
						<div class="header-title"><span>当前客户占比</span></div>
					</DIV>
					<DIV style="margin-right: 5px; margin-left: 5px;">
<div id="container"  style="height: 220px; margin: 0 auto"></div>
					</DIV>
				</DIV>
			</DIV>
			
			
			<DIV class="inner">
				<DIV class="mydash" id="">
					<DIV class="header">
						<div class="header-title"><span>销售精英榜</span></div>
					</DIV>
					<DIV style="margin-right: 5px; margin-left: 5px;">
						<!--  
						<div>
							<ul>
								<li>本年度</li>
								<li>本月</li>
							</ul>
						</div>
						-->
						<TABLE 	class="table  table-hover">
							<THEAD>
								<TR>
								 	<th></th>
									<TH>销售人员姓名</TH>
									<TH>合同金额</TH>
									<TH>排名</TH>
								</TR>
							</THEAD>
							<TBODY>
								
							 <#if attentionList?exists>
											<#list attentionList  as attention>
												<TR>
													 <TD><span class="hidden">${attention.companyAO.id!}</span></TD>
														<TD>${attention.companyAO.type!}</TD>
														<TD align="left"><A href="#">${attention.companyAO.name!}</A></TD>
														<TD align="left">${attention.contactDate?string("yyyy-MM-dd")}</TD>
												</TR>
											 </#list>
							</#if>
								
							</TBODY>
						</TABLE>					
					</DIV>
				</DIV>
			</DIV>
			
			
			<DIV class="inner">
				<DIV class="mydash" id="todoContacto">
					<DIV class="header">
						<div class="header-title"><span><a href="${servePath}/pc/todoContactor">待联系客户 >></a></span></div>
					</DIV>
					<DIV style="margin-right: 5px; margin-left: 5px;">

						<TABLE 	class="table table-hover">
							<THEAD>
								<TR>
								 	<th></th>
									<TH>客户类型</TH>
									<TH>客户名称</TH>
									<TH>联系时间</TH>
								</TR>
							</THEAD>
							<TBODY>
								
							 <#if todoContactorList?exists>
											<#list todoContactorList  as attention>
												<TR>
													 <TD><span class="hidden">${attention.companyAO.id!}</span></TD>
														<TD>${attention.companyAO.type!}</TD>
														<TD align="left"><A href="#">${attention.companyAO.name!}</A></TD>
														<TD align="left">${attention.contactDate?string("yyyy-MM-dd")}</TD>
												</TR>
											 </#list>
							</#if>
								
							</TBODY>
						</TABLE>			

					</DIV>
				</DIV>
			</DIV>
			
			<!-- 块模板 -->
			<!-- 
			<DIV class="inner">
				<DIV class="mydash" id="">
					<DIV class="header">
						<div class="header-title"><span>当前客户占比</span></div>
					</DIV>
					<DIV style="margin-right: 5px; margin-left: 5px;">

					</DIV>
				</DIV>
			</DIV>
			 -->
		</DIV>
	</DIV>

</div>


<#include "../common/footer.ftl">
</@common>