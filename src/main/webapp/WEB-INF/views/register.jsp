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
						<h5 class="card-title">Register</h5>
						<form name="register" action="register" method="post">
							<div class="form-group">
								<label for="username">Username</label> <input type="text"
									class="form-control" name="username">
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									class="form-control" name="password">
							</div>
							<div class="form-group">
								<label for="email">Email</label> <input type="email"
									class="form-control" name="email">
							</div>
							<div class="form-group">
								<label for="name">Name</label> <input type="text"
									class="form-control" name="name">
							</div>
							<div class="form-group">
								<label for="surname">Surname</label> <input type="text"
									class="form-control" name="surname">
							</div>
							<div class="form-group">
								<label for="birthday">Birthday</label> <input type="text"
									class="form-control" name="birthday" id="birthday">
							</div>
							<div class="form-group">
								<label for="gender">Gender</label> <select
									class="form-control" id="gender" name="gender">
									<option>M</option>
									<option>F</option>
									<option selected>Not specified</option>
								</select>
							</div>
							<div class="row align-items-center">
								<div class="col-6">
									<button type="submit" class="btn btn-primary">Register</button>
								</div>
								<div class="col-6">
									<a class="card-link float-right" href="/">Login</a>
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
		$(function() {

			$("#birthday").datepicker();
			$("#birthday").datepicker("option", {
				dateFormat : "yy-mm-dd",
				maxDate : "-18Y"
			});

			$.validator.addMethod("maxDate", function(value, element) {
				var curDate = moment();
				var inputDate = moment(value);
				var legalAge = curDate.subtract(18, 'years');
				if (inputDate <= legalAge)
					return true;
				return false;
			}, "Invalid Date!");

			$("form[name='register']")
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
									},
									email : {
										required : true,
										email : true
									},
									name : {
										required : true
									},
									surname : {
										required : true
									},
									birthday : {
										required : true,
										date : true,
										maxDate : true
									},
									gender : {
										required : true
									}
								},
								// Specify validation error messages
								messages : {
									password : {
										minlength : "Your password must be at least 5 characters long"
									},
									birthday : "You must be over 18 years old."
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