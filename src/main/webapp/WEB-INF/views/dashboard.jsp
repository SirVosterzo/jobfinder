<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>JobFinder | Dashboard</title>
<%@include file="include/imports.jsp"%>
<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="../resources/css/style.css" />
</head>
<body>

	<%@include file="include/header.jsp"%>

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
</body>
</html>