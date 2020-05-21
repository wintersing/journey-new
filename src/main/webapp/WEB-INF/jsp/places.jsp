<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<title>旅游攻略,自由行 - 人在旅途</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface"
	rel="stylesheet">

<link rel="stylesheet" href="/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/css/animate.css">

<link rel="stylesheet" href="/css/owl.carousel.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/css/magnific-popup.css">

<link rel="stylesheet" href="/css/aos.css">

<link rel="stylesheet" href="/css/ionicons.min.css">

<link rel="stylesheet" href="/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/css/jquery.timepicker.css">


<link rel="stylesheet" href="/css/flaticon.css">
<link rel="stylesheet" href="/css/icomoon.css">
<link rel="stylesheet" href="/css/style.css">
</head>

<body>

	<%@ include file="part/header.jsp"%>

	<div class="hero-wrap js-fullheight"
		style="background-image: url('/images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-9 text-center ftco-animate"
					data-scrollax=" properties: { translateY: '70%' }">
					<p class="breadcrumbs"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
						<span class="mr-2"><a href=""></a></span> <span></span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">景点</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar order-md-last ftco-animate">
					<div class="sidebar-wrap ftco-animate">
						<h3 class="heading mb-4">寻找景点</h3>
						<form action="/places/search">
							<div class="fields">
								<div class="form-group">
									<input name="cityName" type="text" class="form-control"
										value="${placesParam.cityName }" placeholder="请输入您要所搜的城市">
								</div>
								<div class="form-group">
									<input type="submit" value="Search"
										class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</form>
					</div>
					<div class="sidebar-wrap ftco-animate">
						<h3 style="color: darkgoldenrod;" class="heading mb-4">旅游日记</h3>
						<c:forEach var="blogItem" items="${blogList }">
						<div class="block-21 mb-4 d-flex">
							<a class="blog-img mr-4" style="background-image: url(${blogItem.avatarUrl });"></a>

							<div class="text">
							<c:choose>
								<c:when test="${reqURI eq '/places' }">
									<h3 class="heading"><a href="/blog/${blogItem.cityid }/${blogItem.id }/${pageToken-1 }?recommend=2">${blogItem.title }</a></h3>
								</c:when>
								<c:otherwise>
									<h3 class="heading"><a href="/blog/${blogItem.cityid }/${blogItem.id }/${pageToken-1 }">${blogItem.title }</a></h3>
								</c:otherwise>
							</c:choose>
								</h3>
								<div class="meta">
									<div><a><span class="icon-calendar"></span>${fn:substring(blogItem.publishDateStr,0,10) }</a></div>
									<div><a><span class="icon-map-marker"></span> ${blogItem.city }</a></div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
					</div>
				<!-- END-->
				<div class="col-lg-9">
							<div class="row">
								<c:forEach var="placesItem" begin="0"
									end="${fn:length(placesList)}" items="${placesList }">
									<div class="col-sm col-md-6 col-lg-4 ftco-animate">
										<div class="destination">
											<c:choose>
												<c:when test="${reqURI == '/places' }">
													<a href="/places/${placesItem.id }?recommend=2"
														class="img img-2 d-flex justify-content-center align-items-center"
														style="background-image: url(${placesItem.imageUrls[0] });">
														<div
															class="icon d-flex justify-content-center align-items-center">
															<span class="icon-link"></span>
														</div>
													</a>
												</c:when>
												<c:otherwise>
													<a
														href="/places/${placesItem.id }?cityid=${placesParam.cityid }&sort=${placesParam.sort }"
														class="img img-2 d-flex justify-content-center align-items-center"
														style="background-image: url(${placesItem.imageUrls[0] });">
														<div
															class="icon d-flex justify-content-center align-items-center">
															<span class="icon-link"></span>
														</div>
													</a>
												</c:otherwise>
											</c:choose>

											<div class="text p-3">
												<div class="d-flex">
													<div class="one">
														<h3>
															<a href="#">${placesItem.title }</a>
														</h3>
														<p class="rate">
															<fmt:parseNumber var="rating" type="number"
																value="${placesItem.rating}" />
															<c:forEach begin="1" end="${rating }">
																<i class="icon-star"></i>
															</c:forEach>
															<c:if test="${placesItem.rating%1 > 0}">
																<i class="icon-star-half"></i>
															</c:if>
															<span>${placesItem.rating}/5.0分</span>
														</p>
													</div>
													<div class="two">
														<span class="price"> <c:choose>
																<c:when test="${placesItem.price > '0' }">
														
														￥${placesItem.price }
														
													</c:when>
																<c:otherwise>
																	<p style="font-size: 15px">免费开放</p>
																</c:otherwise>
															</c:choose>
														</span>
													</div>
												</div>
												<p ${placesItem.subtitle }</p>
												<p class="days openinghours">开放时间：${placesItem.openingHours }</p>
												<hr>
												<p class="bottom-area d-flex">
													<span><i class="icon-map-o"></i><span style="padding-left: 6px;">${placesItem.city }</span></span>
													<span class="ml-auto"><a href="#">查看</a></span>
												</p>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<div class="row mt-5">
								<div class="col text-center">
									<div class="block-27">
										<c:choose>
											<c:when test="${pageToken-5 <= 0}">
												<c:set var="begin_" value="1" scope="page" />
											</c:when>
											<c:otherwise>
												<c:set var="begin_" value="${pageToken-5}"
													scope="page" />
											</c:otherwise>
										</c:choose>
										<ul>
											<li id="toLeft"><a
												href="${reqURI }?cityid=${placesParam.cityid}&pageToken=${pageToken-2 }&hasNext=${hasNext}&sort=${placesParam.sort}">&lt;</a></li>
											<c:forEach var="j" begin="${begin_ }" end="${pageToken-1 }">
												<li id="li-${j }"><a
													href="${reqURI}?cityid=${placesParam.cityid}&pageToken=${j }&hasNext=${hasNext}&sort=${placesParam.sort}">${j }</a></li>
											</c:forEach>
											<c:if test="${hasNext == '1' }">
												<li id="li-${pageToken }"><a
													href="${reqURI}?cityid=${placesParam.cityid}&pageToken=${pageToken }&hasNext=${hasNext}&sort=${placesParam.sort}">${pageToken }</a></li>
											</c:if>
											<li id="toRight"><a
												href="${reqURI}?cityid=${placesParam.cityid}&pageToken=${pageToken }&hasNext=${hasNext}&sort=${placesParam.sort}">&gt;</a></li>
										</ul>
									</div>
								</div>
							</div>
				</div>
				<!-- .col-md-8 -->
			</div>
		</div>
	</section>
	<!-- .section -->

	<%@ include file="part/footer.jsp"%>

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script src="/js/jquery.min.js"></script>
	<script src="/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/jquery.easing.1.3.js"></script>
	<script src="/js/jquery.waypoints.min.js"></script>
	<script src="/js/jquery.stellar.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/jquery.magnific-popup.min.js"></script>
	<script src="/js/aos.js"></script>
	<script src="/js/jquery.animateNumber.min.js"></script>
	<script src="/js/bootstrap-datepicker.js"></script>
	<script src="/js/scrollax.min.js"></script>

	<script src="/js/google-map.js"></script>
	<script src="/js/main.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#li-${pageToken-1 }").prop("class", "active");
			if ("${pageToken-1 }" == "1") {
				$("#li-1 > a").prop("class", "entry");
				$("#toLeft > a").prop("class", "entry");
			}
			if ("${hasNext }" == "0") {
				$("#toRight > a").prop("class", "entry");
				$("#li-${pageToken-1 } > a").prop("class", "entry");
			}
		});
	</script>
</body>
</html>