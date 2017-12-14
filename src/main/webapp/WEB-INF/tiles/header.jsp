<div class="navbar navbar-default navbar-fixedtop">
	<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/ReviewSurvey/review/index">Spring Tiles</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/ReviewSurvey/review/index">Home</a></li>
      <li><a href="survey">Survey</a></li>
      <li><a href="analyze">Analyze</a></li>
    </ul>
  </div>
</div>
<script type="text/javascript">
    $(function() {
        // this will get the full URL at the address bar
        var url = window.location.href;

        // passes on every "a" tag
        $(".navbar a").each(function() {
            // checks if its the same on the address bar
            if (url == (this.href)) {
                $(this).closest("li").addClass("active");
                //for making parent of submenu active
               $(this).closest("li").parent().parent().addClass("active");
            }
        });
    });        
</script>