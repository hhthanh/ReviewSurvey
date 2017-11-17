<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:errors path="jobstatus" cssClass="error"></form:errors>
<form:form class="form" action="review" method="post"
	modelAttribute="reviewSurvey" acceptcharset="UTF-8">
	<h2>レビュー</h2>

	<div class="form-group">
		<form:label path="fullname">名前:</form:label>
		<form:input path="fullname" type="text" class="form-control"
			placeholder="Full name" />
	</div>

	<hr>

	<div class="form-group">
		<label>Ngay sinh</label>
		<div id="sandbox-container">
			<div class="input-group">
				<form:input path="birthday" type="text"
					class="form-control datepicker" id="datepicker1" />
				<span class="input-group-addon btn"><i
					class="glyphicon glyphicon-calendar"></i> </span>
			</div>
		</div>
		<script type="text/javascript">
			$('.datepicker').click(function() {
				$('#datepicker1').datepicker('hide');
			});

			$('.btn').click(function() {
				$('#datepicker1').datepicker('show');
			});
		</script>
	</div>

	<hr>

	<div class="form-group">
		<form:label path="sex">Giới tính:</form:label>
		<br> <label>Nam</label>
		<form:radiobutton path="sex" value="m" name="optradio" />
		<label>Nữ </label>
		<form:radiobutton path="sex" value="f" name="optradio" />
	</div>

	<hr>

	<div class="form-group">
		<form:label path="jobStatus">Tình trạng nghề nghiệp</form:label>
		<div>
			<form:select path="jobStatus" class="form-control">
				<form:option value="STUDENT">Sinh viên</form:option>
				<form:option value="EMPLOYED">Có việc làm</form:option>
				<form:option value="UNEMPLOYED">Thất nghiệp</form:option>
			</form:select>
		</div>
	</div>

	<hr>

	<div class="form-group">
		<form:label path="country">国籍</form:label>
		<div>
			<form:select path="country" class="form-control">
				<form:option value="VietNam">ベトナム</form:option>
				<form:option value="NhatBan">日本</form:option>
				<form:option value="Other">その他</form:option>
			</form:select>
		</div>
	</div>

	<hr>

	<div class="form-group">

		<form:input path="rating_score" id="input-21e" value="0" type="text"
			class="rating" data-min="0" data-max="5" data-step="0.5"
			data-size="xs" title="" />

		<form:label path="rating_content" class="redchar">Nội dung review:</form:label>
		<form:input path="rating_content" type="text" class="form-control"
			placeholder="Write your review here" required="true" />
	</div>

	<hr>

	<form:button type="submit" class="btn btn-primary" id="checkBtn">Submit</form:button>
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