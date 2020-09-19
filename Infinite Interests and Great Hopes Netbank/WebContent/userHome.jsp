<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Ügyfél nyitóoldal</title>
</head>
<body>
	<div class="container">
		<h1>Ügyfél nyitóoldal</h1>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="userHome.jsp"><img src="images/logo.jpg" width="30" height="30" alt=""></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item mx-2 active"><a class="nav-link" href="userHome.jsp">Nyitóoldal</a></li>
					<li class="nav-item mx-2"><a class="nav-link" href="loadBankAccounts">Bankszámlák</a></li>
					<li class="nav-item mx-2"><a class="nav-link" href="#">Személyes adatok szerkesztése</a></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item mx-2"><a class="nav-link" href="logout">Kijelentkezés</a></li>
				</ul>
			</div>
		</nav>
		<p>Üdvözöljük ${loggedInUser.firstName}!</p>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>