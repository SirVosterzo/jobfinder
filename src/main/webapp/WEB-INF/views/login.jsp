<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap&subset=cyrillic,cyrillic-ext,latin-ext"
	rel="stylesheet">
<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
:root { -
	-backgroud: #6363CE; -
	-card-background: #CED3DC;
}

body {
	background: #6363CE !important;
	font-family: 'PT Sans', sans-serif !important;
	color: #CED3DC !important;
}

.nav-link {
	color: #CED3DC !important;
}

#workersInfo {
	margin-top: 5%;
}

.card {
	margin-top: 50px;
	background: #CED3DC;
	padding: 10px;
	color: black;
}

.checked {
	color: orange;
}

.card img {
	border-radius: 50%;
}

.error {
	color: red
}
</style>
<title>Hello, world!</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col-lg-5">

				<div class="container-fluid card" style="width: 25rem;">
					<div class="card-body">
						<h5 class="card-title">Login</h5>
						<form action="login" method="post" name="login" enctype="application/json">
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> <input
									type="text" class="form-control" name="username" id="username">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" name="password"
									id="password">
							</div>
							<button type="submit" class="btn btn-primary">Login</button>
						</form>
					</div>
					<div class="card-link">
						<a href="/register">Register</a>
					</div>
				</div>

			</div>
			<div class="col"></div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
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