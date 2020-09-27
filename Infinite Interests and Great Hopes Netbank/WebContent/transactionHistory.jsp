<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Tranzakciós előzmények</title>
</head>
<body>
	<div class="container">
		<h1>Tranzakciós előzmények</h1>
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="activeMenuOption" value="2" />
		</jsp:include>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Sorszám</th>
					<th>Tranzakció azonosító</th>
					<th>Dátum</th>
					<th class="text-right">Összeg</th>
					<th>Devizanem</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="transactionHistory" items="${transactionHistoryEntries}" varStatus="loop">
					<tr>
						<td>${loop.count}</td>
						<td>${transactionHistory.transactionId}</td>
						<td>${transactionHistory.transactionDate}</td>
						<td class="text-right"><fmt:formatNumber type="number" groupingUsed="true" value="${transactionHistory.amount}" /></td>
						<td>${transactionHistory.currencyType}</td>
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