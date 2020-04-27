<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<!--[if lt IE 7 ]><html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]><html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]><html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]><html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="author" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title></title>

<!-- main JS libs -->
<script src="js/libs/modernizr.min.js"></script>
<script src="js/libs/jquery-1.10.0.js"></script>
<script src="js/libs/jquery-ui.min.js"></script>
<script src="js/libs/bootstrap.min.js"></script>
<style type="text/css">
html {
  height: 100%;
  width: 100%;
  overflow: hidden;
  min-width: 100%;
  min-height: 100%;
}

body {
  height: 100%;
  width: 100%;
  padding: 0;
  margin: 0;
}

.container-fluid{
  height:100%;
  display:table;
  width: 100%;
  padding: 0;
}
.centering {
  float:none;
  margin:0 auto;
}
.row-fluid {height: 100%; display:table-cell; vertical-align: middle;}

</style>
<!-- Style CSS -->
<link href="css/bootstrap.css" media="screen" rel="stylesheet">
<link href="css/style.css" media="screen" rel="stylesheet">

<!-- scripts -->
<script src="js/general.js"></script>

<!-- Include all needed stylesheets and scripts here -->
<!-- styled select -->
<link rel="stylesheet" href="css/cusel.css">
<script src="js/cusel-min.js"></script>
<!-- custom input -->
<script src="js/jquery.customInput.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<!-- Placeholders -->
<script type="text/javascript"
	src="js/jquery.powerful-placeholder.min.js"></script>




<!--[if lt IE 9]><script src="js/respond.min.js"></script><![endif]-->
<!--[if gte IE 9]>
<style type="text/css">
    .gradient {filter: none !important;}
</style>
<![endif]-->
</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
	
			<div class="centering" >
				<div class="col-sm-5 col-sm-offset-3">
					<!-- comment form -->
					<div class="add-comment add-comment-velvet styled" id="addcomments">
						<div class="add-comment-title">
							<h3>Login</h3>
						</div>
						<div class="comment-form">

							<form action="j_spring_security_check" method="post" id="commentForm" class="ajax_form">

								

								<div class="form-inner">

									<div class="field_text">
										<label for="subject" class="label_title">Subject:</label> <input
											type="text" name="j_username" id="subject" value=""
											placeholder="Enter username"
											class="inputtext input_middle required" />
									</div>
									<div class="clear"></div>
									<div class="field_text">
										<label for="subject" class="label_title">Password:</label> <input
											type="password" name="j_password" id="subject" value=""
											placeholder="Enter Password"
											class="inputtext input_middle required" />
									</div>
									<div class="clear"></div>
								</div>

								<div class="rowSubmit">
									<a
										onclick="document.getElementById('commentForm').reset();return false"
										href="#" class="link-reset btn btn-black"><span>Reset</span></a>
									<span class="btn btn-send"><input type="submit"
										id="send" value="Login" /></span>
								</div>
							</form>
						</div>
					</div>
					<!--/ comment form -->
				</div>
			</div>



		</div>
		<!--/ container -->
	</div>
</body>
</html>