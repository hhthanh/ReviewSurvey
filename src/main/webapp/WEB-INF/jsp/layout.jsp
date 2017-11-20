<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<!-- default styles -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/star-rating.css"/>" media="all"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/datepicker/css/bootstrap-datepicker.css"/>"
	media="all" rel="stylesheet" type="text/css" />

<!-- important mandatory libraries -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.js"></script>
<script src="<c:url value="/resources/js/star-rating.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/datepicker/js/bootstrap-datepicker.js" />"
	type="text/javascript"></script>
</head>

<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />

	</div>
</body>
</html>
