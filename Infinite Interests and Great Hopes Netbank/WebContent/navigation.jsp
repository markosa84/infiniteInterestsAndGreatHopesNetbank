<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="userHome.jsp"><img src="images/logo.jpg" width="30" height="30" alt=""></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item mx-2<c:if test="${param.activeMenuOption == 1}"> active</c:if>"><a class="nav-link" href="userHome.jsp">Nyitóoldal</a></li>
			<li class="nav-item mx-2<c:if test="${param.activeMenuOption == 2}"> active</c:if>"><a class="nav-link" href="loadBankAccounts">Bankszámlák</a></li>
			<li class="nav-item mx-2<c:if test="${param.activeMenuOption == 3}"> active</c:if>"><a class="nav-link" href="#">Személyes adatok szerkesztése</a></li>
		</ul>
		<ul class="navbar-nav">
			<li class="nav-item mx-2"><a class="nav-link" href="logout">Kijelentkezés</a></li>
		</ul>
	</div>
</nav>