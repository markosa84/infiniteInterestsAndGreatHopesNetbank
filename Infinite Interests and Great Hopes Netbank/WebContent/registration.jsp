<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Regisztráció</title>
</head>
<body>
	<!-- 	date_of_birth DATE, -->
	<div class="container w-50">
		<h1>Regisztráció</h1>
		<form action="validateAndSaveRegistration" method="post">
			<div class="form-group">
				<label for="loginName">Bejelentkezési név</label>
				<input type="text" class="form-control<c:if test='${validationErrors.containsKey("loginNameValidationResult")}'> is-invalid</c:if>" name="loginName" id="loginName" placeholder="user123" value="${param.loginName}">
				<c:if test='${validationErrors.containsKey("loginNameValidationResult")}'>
					<div class="invalid-feedback">${validationErrors.get("loginNameValidationResult")}</div>
				</c:if>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="lastName">Vezetéknév</label>
					<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Kovács" value="${param.lastName}">
				</div>
				<div class="form-group col-md-6">
					<label for="firstName">Keresztnév</label>
					<input type="text" class="form-control" name="firstName" id="firstName" placeholder="Béla" value="${param.firstName}">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="password">Jelszó</label>
					<input type="password" class="form-control" name="password" id="password" placeholder="Add meg a jelszavad">
				</div>
				<div class="form-group col-md-6">
					<label for="passwordConfirmation">Jelszó megerősítés</label>
					<input type="password" class="form-control" name="passwordConfirmation" id="passwordConfirmation" placeholder="Jelszavad még egyszer">
				</div>
			</div>
			<div class="form-group">
				<label for="roleId">Szerepkör</label>
				<select name="roleId" id="roleId" class="form-control">
					<option value="0" <c:if test='${param.roleId == null || param.roleId == 0}'>selected="selected"</c:if>>Válasszon egyet...</option>
					<c:forEach var="userRole" items="${userRoles}">
						<option value="${userRole.id}" <c:if test='${param.roleId != null && param.roleId == userRole.id}'>selected="selected"</c:if>>${userRole.displayName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="address">Lakcím</label>
				<input type="text" class="form-control" name="address" id="address" placeholder="1038. Budapest, Fürdő utca 2." value="${param.address}">
			</div>
			<div class="form-group">
				<label for="phone">Telefonszám</label>
				<input type="text" class="form-control" name="phone" id="phone" placeholder="+36 20 123 4567" value="${param.phone}">
			</div>
			<div class="form-group">
				<label for="email">E-mail cím</label>
				<input type="email" class="form-control" name="email" id="email" placeholder="kovacs.bela@domain.org" value="${param.email}">
			</div>
			<div class="form-group">
				<label for="dateOfBirth">Születési dátum</label>
				<input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="1999. 09. 05." value="${param.dateOfBirth}">
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="newsletter" id="newsletter">
					<label class="form-check-label" for="newsletter">Hírlevelet kérek</label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Regisztráció</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>