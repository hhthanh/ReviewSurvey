<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['bar']});
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawCharts);
function drawCharts(){

	var data1 = google.visualization.arrayToDataTable([
		['Status','Number']
	    <c:forEach items="${piechartData}" var="entry">
	    ,[ '${entry.key}', ${entry.value}]
	</c:forEach>]); 
	
	var options1 = {
	  title: 'Job status percentage',
          width:900,
          height:500
	};
	var container1 = document.getElementById('piechart1');
	container1.style.display = 'block';
	var chart1 = new google.visualization.PieChart(container1);
	chart1.draw(data1, options1);

	var data2 = google.visualization.arrayToDataTable([
	    ['Score', 'Male', 'Female'],
	    <c:forEach items="${barChartData}" var="entry">
	    [ '${entry.key}', ${entry.value[0]}, ${entry.value[1]}],
	</c:forEach>
	  ]);

	var options = {
	  title: 'Review static by gender',
	  bars: 'horizontal', // Required for Material Bar Charts.
      width:900,
      height:500,
      vAxis: {
          title: 'Scores'
        },
      hAxis: {
          title: 'Voter No.'
        }
	};
	var container = document.getElementById('barchart_material');
	container.style.display = 'block';
	var chart2 = new google.visualization.BarChart(container);
	
	chart2.draw(data2, google.charts.Bar.convertOptions(options));
}
</script>



<h2>Data analysis</h2>
<p>Analysis based on collected answers</p>

<ul class="nav nav-tabs">
	<li class="active"><a data-toggle="tab" href="#menu1">Menu 1</a></li>
	<li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
</ul>

<div class="tab-content">

	<div id="menu1" class="tab-pane fade active in">

		<div id="piechart1" class="graph" style="width: 900px; height: 500px;"></div>
	</div>
	<div id="menu2" class="tab-pane fade">

		<div id="barchart_material" class="graph"
			style="width: 900px; height: 500px;"></div>
	</div>

</div>
