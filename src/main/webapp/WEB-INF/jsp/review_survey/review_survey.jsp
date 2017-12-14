<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form class="form-horizontal" action="survey" method="POST"
	modelAttribute="reviewSurvey" acceptcharset="UTF-8">
	<spring:message code="page.header" var="page_header" />
	<h2>${page_header}</h2>

	<div class="form-group">
		<spring:message code="fullname.label" var="fullname_label" />
		<form:label path="fullname">${fullname_label}:</form:label>
		<form:input path="fullname" type="text" class="form-control"
			placeholder="${fullname_label}" />
		<form:errors path="fullname" cssClass="alert-danger"></form:errors>
	</div>

	<hr>

	<div class="form-group">
		<spring:message code="birthday.label" var="birthday_label" />
		<label>${birthday_label}</label>
		<div id="sandbox-container">
			<div class="input-group">
				<spring:message code="birthday.invalid" var="birthday_invalid"></spring:message>
				<form:input path="birthday" type="date" class="form-control"
					oninvalid="this.setCustomValidity('${birthday_invalid}')"
					onchange="try{setCustomValidity('')}catch(e){}" />
			</div>
		</div>
		<form:errors path="birthday" cssClass="alert-danger"></form:errors>
	</div>

	<hr>

	<div class="form-group">
		<spring:message code="sex.label" var="sex_label" />
		<spring:message code="sex.male.label" var="sex_male_label" />
		<spring:message code="sex.female.label" var="sex_female_label" />
		<form:label path="sex">${sex_label}:</form:label>
		<br> <label>${sex_male_label }</label>
		<form:radiobutton path="sex" value="m" name="optradio" />
		<label>${sex_female_label } </label>
		<form:radiobutton path="sex" value="f" name="optradio" />
		<br>
		<form:errors path="sex" cssClass="alert-danger"></form:errors>
	</div>

	<hr>

	<div class="form-group">
		<spring:message code="JobStatus.label" var="jobStatus_label" />
		<form:label path="jobStatus">${jobStatus_label }</form:label>
		<div>
			<form:select path="jobStatus" class="form-control">
				<form:option value="">--${jobStatus_label }--</form:option>
				<c:forEach items="${jobStatusList}" var="job_status_option">
					<form:option value="${job_status_option.key}">${job_status_option.value}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<form:errors path="jobStatus" cssClass="alert-danger"></form:errors>
	</div>

	<hr>

	<div class="form-group">
		<spring:message code="Country.label" var="country_label" />
		<form:label path="country">${country_label}</form:label>
		<div>
			<form:select path="country" class="form-control">
				<form:option value="">--${country_label}--</form:option>
				<c:forEach items="${countryList}" var="country_option">
				<form:option value="${country_option.key }">${country_option.value}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<form:errors path="country" cssClass="alert-danger"></form:errors>
	</div>

	<hr>

	<div class="form-group">
		<spring:message code="rating.score.label" var="score_label" />
		<form:label path="rating_score">${score_label}: </form:label>
		<form:input path="rating_score" id="input-21e" value="0" type="text"
			class="rating" data-min="0" data-max="5" data-step="1" data-size="xs"
			title="" />
		<form:errors path="rating_score" cssClass="alert-danger"></form:errors>
		<br>
		<spring:message code="rating.score.content" var="score_content" />
		<spring:message code="rating.score.content.spaceholder"
			var="score_content_spaceholder" />
		<form:label path="rating_content" class="redchar">${score_content}:</form:label>
		<form:input path="rating_content" type="text" class="form-control"
			placeholder="${score_content_spaceholder}" />
			<form:errors path="rating_content" cssClass="alert-danger"></form:errors>
	</div>

	<hr>
	<spring:message code="submit.label" var="submit_label" />
	<form:button type="submit" class="btn btn-primary" id="checkBtn">${submit_label}</form:button>
</form:form>
<script>
	jQuery(document).ready(function() {
		$("#input-21f").rating({
			starCaptions : function(val) {
				if (val < 3) {
					return val;
				} else {
					return 'high';
				}
			},
			starCaptionClasses : function(val) {
				if (val < 3) {
					return 'label label-danger';
				} else {
					return 'label label-success';
				}
			},
			hoverOnClear : false
		});
		var $inp = $('#rating-input');

		$inp.rating({
			min : 0,
			max : 5,
			step : 1,
			size : 'lg',
			showClear : false
		});

		$('#btn-rating-input').on('click', function() {
			$inp.rating('refresh', {
				showClear : true,
				disabled : !$inp.attr('disabled')
			});
		});

		$('.btn-danger').on('click', function() {
			$("#kartik").rating('destroy');
		});

		$('.btn-success').on('click', function() {
			$("#kartik").rating('create');
		});

		$inp.on('rating.change', function() {
			alert($('#rating-input').val());
		});

		$('.rb-rating').rating({
			'showCaption' : true,
			'stars' : '3',
			'min' : '0',
			'max' : '3',
			'step' : '1',
			'size' : 'xs',
			'starCaptions' : {
				0 : 'status:nix',
				1 : 'status:wackelt',
				2 : 'status:geht',
				3 : 'status:laeuft'
			}
		});
		$("#input-21c").rating({
			min : 0,
			max : 8,
			step : 0.5,
			size : "xl",
			stars : "8"
		});
	});
</script>