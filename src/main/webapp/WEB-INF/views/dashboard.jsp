<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap&subset=cyrillic,cyrillic-ext,latin-ext"
	rel="stylesheet">

<!-- Material Design -->
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">
<script
	src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>

<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
:root { -
	-backgroud: #6363CE; -
	-card-background: #CED3DC;
}

body {
	background: #6363CE;
}

.container {
	margin-top: 50px;
}

.card {
	transition: box-shadow .3s;
	background: #CED3DC;
	margin-bottom: 20px;
}

.card:hover {
	box-shadow: 0 0 11px black;
}

.checked {
	color: orange;
}

.card img {
	border-radius: 50%;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active" href="/dashboard">Home</a> 
				<a class="nav-item nav-link" href="/profile">Profile</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<c:forEach items="${jobs}" var="job">
				<div class="col-lg-4">
					<div class="container-fluid card" style="width: 100%;">
						<div class="card-body">
							<h5 class="card-title">
								<c:out value="${job.title}" />
							</h5>
							<h6 class="card-subtitle mb-2 text-muted rating">
								<c:out value="${job.company.name}" />
								<c:set var='rating' value='${job.company.rating}' />
								<c:forEach begin="1" end="${job.company.rating}">
									<span class="fa fa-star checked"></span>
								</c:forEach>
								<c:forEach begin="${job.company.rating}" end="4">
									<span class="fa fa-star"></span>
								</c:forEach>
							</h6>
							<p class="card-text">
								<c:out value="${job.description}" />
							</p>
							<a href="#" class="card-link">Card link</a> <a href="#"
								class="card-link">Another link</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>