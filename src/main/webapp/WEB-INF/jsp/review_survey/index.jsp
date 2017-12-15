<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="index.table.header.fullname" var="fullname" />
<spring:message code="index.table.header.birthday" var="birthday" />
<spring:message code="index.table.header.gender" var="gender" />
<spring:message code="index.table.header.country" var="country" />
<spring:message code="index.table.header.jobstatus" var="jobstatus" />
<spring:message code="index.table.header.rating.score" var="score" />
<spring:message code="index.table.header.rating.content" var="content" />
<div class="pre-scrollable">
	<table class="table-striped table-condensed">
		<thead>
			<tr>
				<th><c:out value="${fullname}" /></th>
				<th><c:out value="${birthday}" /></th>
				<th><c:out value="${gender}" /></th>
				<th><c:out value="${country}" /></th>
				<th><c:out value="${jobstatus}" /></th>
				<th><c:out value="${score}" /></th>
				<th><c:out value="${content}" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${surveylist}" var="review">
				<tr>
					<td><c:out value="${review.fullname}" /></td>
					<td><fmt:formatDate pattern='yyyy-MM-dd'
							value='${review.birthday}' /></td>
					<td><c:if test='${review.sex eq "m".charAt(0)}'>Male</c:if>
					<c:if test='${review.sex eq "f".charAt(0)}'>Female</c:if></td>
					<td><c:out value="${review.country} " /></td>
					<td><c:out value="${review.jobStatus} " /></td>
					<td><c:out value="${review.rating_score} " /></td>
					<td><c:out value="${review.rating_content} " /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>