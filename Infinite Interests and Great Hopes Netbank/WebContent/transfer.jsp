<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Átutalás</title>
</head>
<body>
	<div class="container">
		<h1>Átutalás</h1>
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="2" />
		</jsp:include>
		<div class="mx-auto w-50">
			<form action="saveTransfer" method="post">
				<div class="form-group">
					<label for="bankAccountNumber">Forrás bankszámlaszáma</label>
					<input type="text" class="form-control" name="bankAccountNumber" id="bankAccountNumber" readonly="readonly" value="${param.bankAccountNumber}">
				</div>
				<div class="form-group">
					<label for="toBankAccountNumber">Kedvezményezett bankszámlaszáma</label>
					<input type="text" class="form-control" name="toBankAccountNumber" id="toBankAccountNumber" value="${param.toBankAccountNumber}">
				</div>
				<div class="form-group">
					<label for="beneficiaryName">Kedvezményezett neve</label>
					<input type="text" class="form-control" name="beneficiaryName" id="beneficiaryName" value="${param.beneficiaryName}">
				</div>
				<div class="form-group">
					<label for="amount">Összeg</label>
					<input type="number" class="form-control<c:if test='${validationErrors.containsKey("amountTooMuch")}'> is-invalid</c:if>" name="amount" id="amount" value="${param.amount}">
					<c:if test='${validationErrors.containsKey("amountTooMuch")}'>
						<div class="invalid-feedback">${validationErrors.get("amountTooMuch")}</div>
					</c:if>
				</div>
				<div class="form-group">
					<label for="currencyType">Devizanem</label>
					<input type="text" class="form-control" name="currencyType" id="currencyType" readonly="readonly" value="HUF">
				</div>
				<div class="form-group">
					<label for="transactionComment">Közlemény</label>
					<textarea class="form-control" name="transactionComment" id="transactionComment" rows="3">${param.transactionComment}</textarea>
				</div>
				<button type="submit" class="btn btn-primary">Átutalás indítása</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>