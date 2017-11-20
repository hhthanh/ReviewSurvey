<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="pre-scrollable">
	<table class="table-striped table-condensed">
		<thead>
			<tr>
				<th><c:out value="Họ Tên" /></th>
				<th><c:out value="Ngày sinh " /></th>
				<th><c:out value="Giới tính " /></th>
				<th><c:out value="Quốc tịch " /></th>
				<th><c:out value="Tình trạng nghề nghiệp " /></th>
				<th><c:out value="Điểm review " /></th>
				<th><c:out value="Nội dung Review " /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${surveylist}" var="review">
				<tr>
					<td><c:out value="${review.fullname}" /></td>
					<td><fmt:formatDate pattern='yyyy-MM-dd'
							value='${review.birthday}' /></td>
					<td><c:out value="${review.sex} " /></td>
					<td><c:out value="${review.country} " /></td>
					<td><c:out value="${review.jobStatus} " /></td>
					<td><c:out value="${review.rating_score} " /></td>
					<td><c:out value="${review.rating_content} " /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<div class="inline" id="piechart1"></div>
	<div class="inline" id="barchart_material"></div>
</div>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
        	['Status','Number'],
            <c:forEach items="${piechartData}" var="entry">
            [ '${entry.key}', ${entry.value}],
        </c:forEach>
]);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart1'));

        chart.draw(data, options);
      }
    </script>

<script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Score', 'Male', 'Female'],
          <c:forEach items="${barChartData}" var="entry">
          [ '${entry.key}', ${entry.value[0]}, ${entry.value[1]}],
      </c:forEach>
        ]);

        var options = {
          chart: {
            title: 'Review static by gender',
            subtitle: 'Number of male and femail rating upon each score',
          },
          bars: 'horizontal' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>