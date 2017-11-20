<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<table class="table">
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
		      <td><fmt:formatDate pattern='yyyy-MM-dd' value='${review.birthday}' /></td>
		      <td><c:out value="${review.sex} " /></td>
		      <td><c:out value="${review.country} " /></td>
		      <td><c:out value="${review.jobStatus} " /></td>
		      <td><c:out value="${review.rating_score} " /></td>
		      <td><c:out value="${review.rating_content} " /></td>
		    </tr>
		  </c:forEach>
  		</tbody>
</table>