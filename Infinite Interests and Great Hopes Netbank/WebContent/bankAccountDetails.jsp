<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Bankszámla részletei</title>
</head>
<body>
	<div class="container">
		<h1>Bankszámla részletei</h1>
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="2" />
		</jsp:include>
		<div class="mx-auto w-50">
			<form action="validateAndSaveBankAccountDetails" method="post">
				<div class="form-group">
					<label for="bankAccountNumber">Bankszámlaszám</label>
					<input type="text" class="form-control" name="bankAccountNumber" id="bankAccountNumber" readonly="readonly" value="${bankAccountDetailsDto.bankAccountNumber}">
				</div>
				<div class="form-group">
					<label for="aliasName">Bankszámla neve</label>
					<input type="text" class="form-control<c:if test='${validationErrors.containsKey("aliasNameValidationResult")}'> is-invalid</c:if>" name="aliasName" id="aliasName" value="<c:if test="${param.aliasName != null}">${param.aliasName}</c:if><c:if test="${param.aliasName == null}">${bankAccountDetailsDto.aliasName}</c:if>">
					<c:if test='${validationErrors.containsKey("aliasNameValidationResult")}'>
						<div class="invalid-feedback">${validationErrors.get("aliasNameValidationResult")}</div>
					</c:if>
				</div>
				<div class="form-group">
					<label for="currentBalance">Aktuális egyenleg</label>
					<input type="text" class="form-control" name="currentBalance" id="currentBalance" readonly="readonly" value="<fmt:formatNumber type="number" groupingUsed="true" value="${bankAccountDetailsDto.currentBalance}" />">
				</div>
				<div class="form-group">
					<label for="currencyType">Devizanem</label>
					<input type="text" class="form-control" name="currencyType" id="currencyType" readonly="readonly" value="${bankAccountDetailsDto.currencyType}">
				</div>
				<div class="form-group">
					<label for="bankAccountStatus">Bankszámla állapot</label>
					<input type="text" class="form-control" name="bankAccountStatus" id="bankAccountStatus" readonly="readonly" value="${bankAccountDetailsDto.bankAccountStatus}">
				</div>
				<div class="form-group">
					<label for="bankAccountType">Bankszámla típus</label>
					<input type="text" class="form-control" name="bankAccountType" id="bankAccountType" readonly="readonly" value="${bankAccountDetailsDto.bankAccountType}">
				</div>
				<div class="form-group">
					<label for="lastTransactionTimestamp">Legutóbbi tranzakció</label>
					<input type="text" class="form-control" name="lastTransactionTimestamp" id="lastTransactionTimestamp" readonly="readonly" value="${bankAccountDetailsDto.lastTransactionTimestamp}">
				</div>
				<button type="submit" class="btn btn-primary">Mentés</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>