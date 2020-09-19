<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Bejelentkezés</title>
</head>
<body>
	<div class="container w-50">
		<h1>Bejelentkezés</h1>
		<form action="login" method="post">
			<div class="form-group">
				<label for="loginName">Bejelentkezési név</label>
				<input type="text" class="form-control" name="loginName" id="loginName" placeholder="user123">
			</div>
			<div class="form-group">
				<label for="password">Jelszó</label>
				<input type="password" class="form-control" name="password" id="password" placeholder="Add meg a jelszavad">
			</div>
			<button type="submit" class="btn btn-primary">Bejelentkezés</button>
		</form>
		<div class="my-3">
			<a href="loadRegistration">Regisztráció</a>
		</div>
		<c:if test="${invalidLoginNameOrPassword}">
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				<strong>Rossz felhasználónév vagy jelszó.</strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Bezár">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${param.registrationSuccessful}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Sikeres regisztráció.</strong> Az adminisztrátorok jóváhagyása után bejelentkezhet.
				<button type="button" class="close" data-dismiss="alert" aria-label="Bezár">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>