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
</style>
	
<@addScript>
<script type="text/javascript">

$(function () {
    $('#container2').highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Monthly Average Temperature'
        },
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Temperature'
            },
            labels: {
                formatter: function() {
                    return this.value +'°'
                }
            }
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
        series: [{
            name: 'Tokyo',
            marker: {
                symbol: 'square'
            },
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, {
                y: 26.5,
                marker: {
                    symbol: 'url(http://www.highcharts.com/demo/gfx/sun.png)'
                }
            }, 23.3, 18.3, 13.9, 9.6]

        }, {
            name: 'London',
            marker: {
                symbol: 'diamond'
            },
            data: [{
                y: 3.9,
                marker: {
                    symbol: 'url(http://www.highcharts.com/demo/gfx/snow.png)'
                }
            }, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }]
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
        title: {
            text: 'Browser market shares at a specific website, 2014'
        },
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
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                {
                    name: 'Chrome',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['Safari',    8.5],
                ['Opera',     6.2],
                ['Others',   0.7]
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
	
$("tr").bind("click",function(){
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
				<DIV class="mydash" id="">
					<DIV class="header">
						<div class="header-title"><span><a href="${servePath}/pc/attention">我关注的客户 <img alt="我关注的客户" src="${staticServePath}/app/crm/images/select_02.png"></a></span></div>
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
<div id="container"  style="width: 90%; height: 200px; margin: 0 auto"></div>
					</DIV>
				</DIV>
			</DIV>
			
			
			<DIV class="inner">
				<DIV class="mydash" id="">
					<DIV class="header">
						<div class="header-title"><span>销售精英榜</span></div>
					</DIV>
					<DIV style="margin-right: 5px; margin-left: 5px;">

					</DIV>
				</DIV>
			</DIV>
			
			
			<DIV class="inner">
				<DIV class="mydash" id="">
					<DIV class="header">
						<div class="header-title"><span><a href="${servePath}/pc/todoContactor">待联系客户 <img alt="我关注的客户" src="${staticServePath}/app/crm/images/select_02.png"></a></span></div>
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