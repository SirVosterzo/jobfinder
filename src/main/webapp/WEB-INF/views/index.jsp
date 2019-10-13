<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!doctype html>
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
:root { 
	--backgroud: #6363CE;
	--card-background: #CED3DC;
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
		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="nav-link active" href="#">Active</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="true">Disabled</a></li>
		</ul>
	</div>
	<div class="container">
		<div class="container">
			<h1>Job Title</h1>
		</div>
		<div id="jobDescription" class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="container-fluid card" style="width: 100%;">
					<div class="card-body">
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Aenean iaculis vehicula odio, id ultricies
							ligula dictum at. Sed sodales lectus aliquet felis molestie
							ultrices. Lorem ipsum dolor sit amet, consectetur adipiscing
							elit. Vestibulum in commodo justo, sit amet aliquet ante.
							Vestibulum commodo ex id ipsum facilisis malesuada. Integer
							sollicitudin odio sed dui iaculis, eu bibendum nunc tincidunt.
							Donec porttitor sed lorem ut ullamcorper. Nunc auctor urna a
							dapibus facilisis. Ut in ex at turpis iaculis imperdiet non vel
							tortor. Vestibulum tincidunt, purus iaculis ornare vestibulum,
							arcu lectus mollis felis, ac sollicitudin orci sem at sapien. Nam
							maximus nunc dapibus, egestas nunc et, imperdiet diam. Cras eget
							erat a enim fermentum feugiat. Curabitur posuere sem diam,
							viverra dictum nibh pellentesque sit amet. Interdum et malesuada
							fames ac ante ipsum primis in faucibus. Etiam malesuada justo a
							dui venenatis, eu iaculis ligula consequat. In ut ante sed lorem
							porttitor posuere at eget velit. Proin dictum aliquet felis, eget
							mollis magna commodo lobortis. Vestibulum sem eros, congue vitae
							elit id, lobortis ullamcorper sem. Nam tempor justo eget lectus
							fermentum, a suscipit nisl lacinia. Cras fringilla odio aliquet
							ipsum dignissim lobortis. Nulla quis tellus lorem. Sed sed ex vel
							nisl placerat ultrices sit amet non ex. Cras viverra metus et
							dignissim consectetur. Ut nec nisi ex.</p>
						<a href="#" class="card-link">Card link</a> <a href="#"
							class="card-link">Another link</a>
					</div>
				</div>
				</div>
			</div>
		</div>
		<div id="workersInfo" class="container">
			<div class="row">
				<div class="col-lg-5">

					<div class="container-fluid card" style="width: 25rem;">
						<img src="/resources/img/avatar1.png" class="card-img-top mx-auto"
							style="width: 15rem" alt="...">
						<div class="card-body">
							<h5 class="card-title">Maker</h5>
							<h5 class="card-title rating">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
							</h5>
							<h6 class="card-subtitle mb-2 text-muted">Company name</h6>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="card-link">Card link</a> <a href="#"
								class="card-link">Another link</a>
						</div>
					</div>

				</div>
				<div class="col"></div>
				<div class="col-lg-5">

					<div class="container-fluid card" style="width: 25rem;">
						<img src="/resources/img/avatar2.png" class="card-img-top mx-auto"
							style="width: 15rem" alt="...">
						<div class="card-body">
							<h5 class="card-title">Doer</h5>
							<h5 class="card-title rating">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</h5>
							<h6 class="card-subtitle mb-2 text-muted">Profession</h6>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="card-link">Card link</a> <a href="#"
								class="card-link">Another link</a>
						</div>
					</div>

				</div>
			</div>
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