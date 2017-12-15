<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

google.charts.load('current', {'packages':['corechart']});

google.charts.setOnLoadCallback(drawJobCharts);
google.charts.setOnLoadCallback(drawAveragePointOverJobCharts);
google.charts.setOnLoadCallback(drawGenderCharts);
google.charts.setOnLoadCallback(drawAveragePointOverGenderCharts);

function drawAveragePointOverJobCharts(){
	var data = google.visualization.arrayToDataTable([['Status', 'Average Point']
	<c:forEach items="${piechartAveragePointJobData}" var="entry">
    ,[ '${entry.key}', ${entry.value}]
</c:forEach>]);
	
    var options = {
      vAxis: {
    	  minValue: 3,
      },
      width: 500,
      height: 500,
      title: "Average rating over Job status",
      bar: {groupWidth: "95%"},
      legend: { position: "none" },
    };
	var container1 = document.getElementById('columnchart1');
	var chart1 = new google.visualization.ColumnChart(container1);
	chart1.draw(data, options);
}

function drawAveragePointOverGenderCharts(){
	var data = google.visualization.arrayToDataTable([['Gender', 'Average Point']
	<c:forEach items="${piechartAveragePointGenderData}" var="entry">
    ,[ '${entry.key}', ${entry.value}]
</c:forEach>]);
	
    var options = {
      vAxis: {
    	  minValue: 3,
      },
      width:  500,
      height: 500,
      title: "Average rating over Job status",
      bar: {groupWidth: "95%"},
      legend: { position: "none" },
    };
	var container1 = document.getElementById('columnchart2');
	var chart1 = new google.visualization.ColumnChart(container1);
	chart1.draw(data, options);
}


function drawJobCharts(){

	var data1 = google.visualization.arrayToDataTable([
		['Status','Number']
	    <c:forEach items="${piechartJobData}" var="entry">
	    ,[ '${entry.key}', ${entry.value}]
	</c:forEach>]); 
	
	var options1 = {
	  title: 'Job status percentage',
      width:  500,
      height: 500,
          legend: { position: "none" },
	};
	var container1 = document.getElementById('piechart1');
	var chart1 = new google.visualization.PieChart(container1);
	chart1.draw(data1, options1);
}

function drawGenderCharts(){

	var data2 = google.visualization.arrayToDataTable([
	    ['Score', 'Male', 'Female'],
	    <c:forEach items="${barChartGenderData}" var="entry">
	    [ '${entry.key}', ${entry.value[0]}, ${entry.value[1]}],
	</c:forEach>
	  ]);

	var options = {
	  title: 'Review static by gender',
	  bars: 'horizontal', // Required for Material Bar Charts.
      vAxis: {
          title: 'Scores'
        },
      hAxis: {
          title: 'Voter No.'
        },
        width:  500,
        height: 500,
        legend: { position: "none" },
	};
	var container = document.getElementById('barchart_material');
	var chart2 = new google.visualization.BarChart(container);
	
	chart2.draw(data2, options);
}
</script>



<h2><spring:message code="page.analysis.header"></spring:message></h2>
<p><spring:message code="page.analysis.description"></spring:message></p>

<ul class="nav nav-tabs">
	<li class="active col-md-6" style="text-align:center"><a data-toggle="tab" href="#menu1"><spring:message code="page.analysis.menu1.label"></spring:message></a></li>
	<li class="col-md-6" style="text-align:center"><a data-toggle="tab" href="#menu2"><spring:message code="page.analysis.menu2.label"></spring:message></a></li>
</ul>

<div class="tab-content">

	<div id="menu1" class="tab-pane fade active in">
		<table class="col-md-12">
			<tr class="col-md-12">
				<td class="col-md-6"><div id="piechart1" class="graph"></div></td>
				<td class="col-md-6"><div id="columnchart1" class="graph"></div></td>
			</tr>
		</table>

	</div>
	<div id="menu2" class="tab-pane fade">
		
		<table class="col-md-12">
			<tr class="col-md-12">
				<td class="col-md-6"><div id="barchart_material" class="graph"></div></td>
				<td class="col-md-6"><div id="columnchart2" class="graph"></div></td>
			</tr>
		</table>
		
	</div>

</div>
