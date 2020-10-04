<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Bankszámla létrehozása</title>
</head>
<body>
	<div class="container w-50">
		<h1>Bankszámla létrehozása</h1>
		<jsp:include page="adminNavigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="3" />
		</jsp:include>
		<form action="createBankAccount" method="post">
			<div class="form-group">
				<label for="bankAccountNumber">Bankszámlaszám</label>
				<input type="text" class="form-control<c:if test='${validationErrors.containsKey("bankAccountNumberInvalid")}'> is-invalid</c:if>" name="bankAccountNumber" id="bankAccountNumber" placeholder="12345678-12345678-12345678" value="${param.bankAccountNumber}">
				<c:if test='${validationErrors.containsKey("bankAccountNumberInvalid")}'>
					<div class="invalid-feedback">${validationErrors.get("bankAccountNumberInvalid")}</div>
				</c:if>
			</div>
			<div class="form-group">
				<label for="aliasName">Bankszámla elnevezése</label>
				<input type="text" class="form-control<c:if test='${validationErrors.containsKey("aliasNameInvalid")}'> is-invalid</c:if>" name="aliasName" id="aliasName" placeholder="Online Bankszámla" value="${param.aliasName}">
				<c:if test='${validationErrors.containsKey("aliasNameInvalid")}'>
					<div class="invalid-feedback">${validationErrors.get("aliasNameInvalid")}</div>
				</c:if>
			</div>
			<div class="form-group">
				<label for="selectedClientLoginName">Ügyfél</label>
				<select name="selectedClientLoginName" id="selectedClientLoginName" class="form-control">
					<option value="0" <c:if test='${param.selectedClientLoginName == null}'>selected="selected"</c:if>>Válasszon egyet...</option>
					<c:forEach var="client" items="${clients}">
						<option value="${client.loginName}" <c:if test='${param.selectedClientLoginName != null && param.selectedClientLoginName.equals(client.loginName)}'>selected="selected"</c:if>>${client.displayName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="startingMoneyAmount">Kezdő egyenleg</label>
				<input type="number" class="form-control<c:if test='${validationErrors.containsKey("startingMoneyAmountInvalid")}'> is-invalid</c:if>" name="startingMoneyAmount" id="startingMoneyAmount" placeholder="1 000 000" value="${param.startingMoneyAmount}">
				<c:if test='${validationErrors.containsKey("startingMoneyAmountInvalid")}'>
					<div class="invalid-feedback">${validationErrors.get("startingMoneyAmountInvalid")}</div>
				</c:if>
			</div>
			<div class="form-group">
				<label for="currencyType">Devizanem</label>
				<input type="text" class="form-control" name="currencyType" id="currencyType" placeholder="HUF" value="HUF" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="selectedBankAccountTypeId">Bankszámla típusa</label>
				<select name="selectedBankAccountTypeId" id="selectedBankAccountTypeId" class="form-control">
					<option value="0" <c:if test='${param.selectedBankAccountTypeId == null || param.selectedBankAccountTypeId == 0}'>selected="selected"</c:if>>Válasszon egyet...</option>
					<c:forEach var="bankAccountType" items="${bankAccountTypes}">
						<option value="${bankAccountType.id}" <c:if test='${param.selectedBankAccountTypeId != null && param.selectedBankAccountTypeId == bankAccountType.id}'>selected="selected"</c:if>>${bankAccountType.name}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary float-right">Létrehozás</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>