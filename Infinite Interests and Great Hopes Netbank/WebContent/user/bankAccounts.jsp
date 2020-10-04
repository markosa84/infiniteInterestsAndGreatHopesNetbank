<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Bankszámlák</title>
</head>
<body>
	<div class="container">
		<h1>Bankszámlák</h1>
		<jsp:include page="userNavigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="2" />
		</jsp:include>
		<p>Válasszon egyet az alábbi bankszámlák közül!</p>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Bankszámlaszám</th>
					<th class="text-right">Aktuális egyenleg</th>
					<th>Devizanem</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bankAccount" items="${bankAccounts}">
					<tr>
						<td>${bankAccount.bankAccountNumber}</td>
						<td class="text-right"><fmt:formatNumber type="number" groupingUsed="true" value="${bankAccount.currentBalance}" /></td>
						<td>${bankAccount.currencyType}</td>
						<td>
							<form action="loadBankAccountDetails" method="post">
								<input type="hidden" name="bankAccountNumber" value="${bankAccount.bankAccountNumber}">
								<input type="submit" value="Részletek" class="btn btn-primary">
							</form>
						</td>
						<td>
							<form action="loadTransfer" method="post">
								<input type="hidden" name="bankAccountNumber" value="${bankAccount.bankAccountNumber}">
								<input type="submit" value="Átutalás" class="btn btn-primary">
							</form>
						</td>
						<td>
							<form action="loadTransactionHistory" method="post">
								<input type="hidden" name="bankAccountNumber" value="${bankAccount.bankAccountNumber}">
								<input type="submit" value="Tranzakciós előzmények" class="btn btn-primary">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>