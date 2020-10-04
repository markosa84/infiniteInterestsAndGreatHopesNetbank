<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Személyes adatok</title>
</head>
<body>
	<div class="container w-50">
		<h1>Személyes adatok</h1>
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="3" />
		</jsp:include>
		<c:if test="${saveSuccessful}">
			<div class="alert alert-success alert-dismissible fade show my-3" role="alert">
				Az adatok mentése sikeresen megtörént.
				<button type="button" class="close" data-dismiss="alert" aria-label="Bezár">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<form action="saveProfile" method="post">
			<div class="form-group">
				<label for="loginName">Bejelentkezési név</label>
				<input type="text" class="form-control" name="loginName" id="loginName" placeholder="user123" value="${loggedInUser.loginName}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="newPassword">Új jelszó</label>
				<input type="password" class="form-control<c:if test='${validationErrors.containsKey("passwordDoesNotMatchWithConfirmation")}'> is-invalid</c:if>" name="newPassword" id="newPassword" placeholder="Add meg az új jelszavad">
				<c:if test='${validationErrors.containsKey("passwordDoesNotMatchWithConfirmation")}'>
					<div class="invalid-feedback">${validationErrors.get("passwordDoesNotMatchWithConfirmation")}</div>
				</c:if>
			</div>
			<div class="form-group">
				<label for="newPasswordConfirmation">Új jelszó megerősítés</label>
				<input type="password" class="form-control" name="newPasswordConfirmation" id="newPasswordConfirmation" placeholder="Új jelszavad még egyszer">
			</div>
			<div class="form-group">
				<label for="oldPassword">Régi jelszó</label>
				<input type="password" class="form-control<c:if test='${validationErrors.containsKey("oldPasswordWrong")}'> is-invalid</c:if>" name="oldPassword" id="oldPassword" placeholder="Add meg az aktuális jelszavad">
				<c:if test='${validationErrors.containsKey("oldPasswordWrong")}'>
					<div class="invalid-feedback">${validationErrors.get("oldPasswordWrong")}</div>
				</c:if>
			</div>
			<div class="form-group">
				<label for="lastName">Vezetéknév</label>
				<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Vezetéknév" value="${loggedInUser.lastName}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="firstName">Keresztnév</label>
				<input type="text" class="form-control" name="firstName" id="firstName" placeholder="Keresztnév" value="${loggedInUser.firstName}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="address">Levelezési cím</label>
				<input type="text" class="form-control" name="address" id="address" placeholder="Levelezési cím" value="${loggedInUser.postalAddress}">
			</div>
			<div class="form-group">
				<label for="phone">Telefonszám</label>
				<input type="text" class="form-control" name="phone" id="phone" placeholder="Telefonszám" value="${loggedInUser.phone}">
			</div>
			<div class="form-group">
				<label for="email">E-mail cím</label>
				<input type="email" class="form-control" name="email" id="email" placeholder="E-mail cím" value="${loggedInUser.email}">
			</div>
			<div class="form-group">
				<label for="dateOfBirth">Születési dátum</label>
				<input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth" placeholder="Születési dátum" value="${loggedInUser.dateOfBirth}" readonly="readonly">
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="newsletter" id="newsletter" <c:if test="${loggedInUser.newsletter}">checked="checked"</c:if>>
					<label class="form-check-label" for="newsletter">Hírlevelet kérek</label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Mentés</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>