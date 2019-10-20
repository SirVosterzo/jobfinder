<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="include/imports.jsp"%>
<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="../resources/css/login.css" />

</style>
<title>Hello, world!</title>
</head>
<body>

	<div class="container">
		<div class="row align-items-center">
			<div class="col"></div>
			<div class="col-lg-5">

				<div class="container-fluid card" style="width: 25rem;">
					<div class="card-body">
						<h5 class="card-title">Login</h5>
						<form action="login" method="post" name="login"
							enctype="application/json">
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> <input
									type="text" class="form-control" name="username" id="username">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" name="password"
									id="password">
							</div>
							<div class="row align-items-center">
								<div class="col-6">
									<button type="submit" class="btn btn-primary">Login</button>
								</div>
								<div class="col-6">
									<a class="card-link float-right" href="/register">Register</a>
								</div>
							</div>
						</form>

					</div>

				</div>

			</div>
			<div class="col"></div>
		</div>
	</div>
	<script>
	
		//Wait for the DOM to be ready
		$(function() {
			
			// Initialize form validation on the registration form.
			// It has the name attribute "registration"
			$("form[name='login']")
					.validate(
							{
								// Specify validation rules
								rules : {
									// The key name on the left side is the name attribute
									// of an input field. Validation rules are defined
									// on the right side
									username : {
										required : true,
									// Specify that email should be validated
									// by the built-in "email" rule
									},
									password : {
										required : true,
										minlength : 5
									}
								},
								// Specify validation error messages
								messages : {
									username : "Please enter a valid username",
									password : {
										required : "Please provide a password",
										minlength : "Your password must be at least 5 characters long"
									},
								},
								// Make sure the form is submitted to the destination defined
								// in the "action" attribute of the form when valid
								submitHandler : function(form) {
									form.submit();
								}
							});
		});
	</script>

</body>
</html>