<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Adminisztrátori nyitóoldal</title>
</head>
<body>
	<div class="container">
		<h1>Adminisztrátori nyitóoldal</h1>
		<jsp:include page="adminNavigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="1" />
		</jsp:include>
		<p>Üdvözöljük ${loggedInUser.firstName}!</p>
		<c:if test='${param.message != null && param.message.equals("successfulBankAccountCreation")}'>
			<div class="alert alert-success alert-dismissible fade show" role="alert">
				<strong>Az új bankszámla sikeresen létrehozva.</strong>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
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