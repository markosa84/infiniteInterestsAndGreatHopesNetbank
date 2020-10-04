<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Ügyfél jóváhagyása</title>
</head>
<body>
	<div class="container">
		<h1>Ügyfél jóváhagyása</h1>
		<jsp:include page="adminNavigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="2" />
		</jsp:include>
		<c:if test="${approveSuccessful}">
			<div class="alert alert-success alert-dismissible fade show my-3" role="alert">
				A kijelölt felhasználók sikeresen aktiválásra kerültek.
				<button type="button" class="close" data-dismiss="alert" aria-label="Bezár">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<form action="approveUsers" method="post">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Sorszám</th>
						<th>Felhasználónév</th>
						<th>Regisztráció időpontja</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${usersToBeApproved.isEmpty()}">
						<tr>
							<td colspan="4" class="text-center">Nincs jóváhagyásra váró ügyfél.</td>
						</tr>
					</c:if>
					<c:forEach var="userToBeApproved" items="${usersToBeApproved}" varStatus="loop">
						<tr>
							<td>${loop.count}</td>
							<td>${userToBeApproved.loginName}</td>
							<td>${userToBeApproved.registrationDate}</td>
							<td><input class="form-check-input" type="checkbox" name="selectedUser_${userToBeApproved.loginName}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" class="btn btn-primary float-right" value="Kijelöltek aktiválása">
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>