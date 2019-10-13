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
						<h5 class="card-title">Register</h5>
						<form action="register" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Username</label> <input
									type="text" class="form-control" name="username">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your username with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" name="password">
							</div>
							<button type="submit" class="btn btn-primary">Register</button>
						</form>
					</div>
				</div>

			</div>
			<div class="col"></div>
		</div>
	</div>


</body>
</html>