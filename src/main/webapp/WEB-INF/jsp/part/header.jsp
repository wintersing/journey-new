<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="/">人在旅途</a>

			<div class="collapse navbar-collapse navigation" id="ftco-nav">
				<ul class="navbar-nav ml-auto" style="width:300px">
					<li class="nav-item"><a href="/" class="nav-link">主页</a></li>
					<li class="nav-item"><a href="/places" class="nav-link">目的地</a></li>
					<li class="nav-item"><a href="/hotel" class="nav-link">酒店</a></li>
					<li class="nav-item"><a href="/train" class="nav-link">火车</a></li>
				</ul>
			</div>
			
			<div>
				<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${not empty sessionScope.user_session }">
						<li class="nav-item"><a class="nav-link" style="width:170px">欢迎,${sessionScope.user_session.username }</a></li>
						<span class="split">|</span>
						<li class="nav-item"><a href="/logout?reqURI=${reqURI }" style="width:100px" class="nav-link">退出</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a href="/loginView" class="nav-link">登陆</a></li>
						<span class="split">|</span>
						<li class="nav-item"><a href="/registerView" class="nav-link">注册</a></li> 			
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
</body>
</html>