<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<style type="text/css">
.list, .tab-header {
	width: 14%;
	text-align: center;
}

h3, .space {
	margin-top: 14px;
}

.space {
	padding-top: 2px;
}

.header {
	height: 10px;
}

.list-body {
	margin-top: 20px;
	border: 1px solid #e2e2e2;
}

.list-body:hover {
	margin-top: 20px;
	border: 1px solid #76d1da;
}

.list-head {
	background: #efe9e9;
	margin-bottom: 20px;
}
.entry{
	pointer-events: none;
}
.position {
    width:800px;
}
</style>
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
					<!-- <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.html">Home</a></span> <span>Hotel</span></p> -->
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">火车票</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar order-md-last ftco-animate">
					<div class="sidebar-wrap ftco-animate">
						<h3 class="heading mb-4">查询火车余票</h3>
						<form action="/train/search"  autocomplete="off">
							<div class="fields">
								<div class="form-group">
									<div class="form-field">
										<input name="departureCityName" type="text"
											class="form-control" placeholder="出发地" value="${trainParam.departureCityName }">
									</div>
								</div>
								<div class="form-group">
									<div class="form-field">
										<input name="arrivalCityName" type="text" class="form-control"
											placeholder="目的地" value="${trainParam.arrivalCityName }">
									</div>
								</div>
								<input type="hidden" name="page" value="1"> 
								<input type="hidden" name="limit" value="0">
								<div class="form-group">
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<div class="form-group">
											<div class="form-field">
												<div class="icon">
													<span class="icon-map-marker"></span>
												</div>
												<input id="departureDate" name="departureDate" type="text" 
													class="form-control test-item" placeholder="出发日期"
													 value="${trainParam.departureDate }">
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<input type="submit" value="Search"
										class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</form>
					</div>
					<!-- <div class="sidebar-wrap ftco-animate">
						<h3 style="color: darkgoldenrod;" class="heading mb-4">新闻资讯</h3>
						<div>
							<label class="form-check-label" for="exampleCheck1">
								<p>
									<a target="_blank" class="news"
										href="http:\/\/mini.eastday.com\/mobile\/181221171918949.html">美国老兵筹款要建边境墙后
										另一老兵众筹"买梯子"</a>
								</p>
							</label>
						</div>
						<div>
							<label class="form-check-label" for="exampleCheck1">
								<p>
									<a target="_blank" class="news"
										href="http:\/\/mini.eastday.com\/mobile\/181221171918949.html">美国老兵筹款要建边境墙后
										另一老兵众筹"买梯子"</a>
								</p>
							</label>
						</div>
						<div>
							<label class="form-check-label" for="exampleCheck1">
								<p>
									<a target="_blank" class="news"
										href="http:\/\/mini.eastday.com\/mobile\/181221171918949.html">美国老兵筹款要建边境墙后
										另一老兵众筹"买梯子"</a>
								</p>
							</label>
						</div>
						<div>
							<label class="form-check-label" for="exampleCheck1">
								<p>
									<a target="_blank" class="news"
										href="http:\/\/mini.eastday.com\/mobile\/181221171918949.html">美国老兵筹款要建边境墙后
										另一老兵众筹"买梯子"</a>
								</p>
							</label>
						</div>
						<div>
							<label class="form-check-label" for="exampleCheck1">
								<p>
									<a target="_blank" class="news"
										href="http:\/\/mini.eastday.com\/mobile\/181221171918949.html">美国老兵筹款要建边境墙后
										另一老兵众筹"买梯子"</a>
								</p>
							</label>
						</div>
					</div> -->
				</div>
				<!-- END-->
				<c:choose>
					<c:when test="${not empty trainList }">
						<div class="col-lg-9">
							<div class="row list-head">
								<div class="tab-header">
									<div class="destination header">
										<div class="text p-7">
											<h3>车次</h3>
										</div>
									</div>
								</div>
								<div class="tab-header">
									<div class="destination header">
										<div class="text p-7">
											<h3>发时/到时</h3>
										</div>
									</div>
								</div>

								<div class="tab-header">
									<div class="destination header">
										<div class="text p-7">
											<h3>出站/到站</h3>
										</div>
									</div>
								</div>

								<div class="tab-header">
									<div class="destination header">
										<div class="text p-7">
											<h3>运行时间</h3>
										</div>
									</div>
								</div>
								<div class="tab-header">
									<div class="destination header">
										<div class="text p-7">
											<h3>参考票价</h3>
										</div>
									</div>
								</div>
								<div class="tab-header">
									<div class="destination header">
										<div class="text p-7">
											<h3>剩余票数</h3>
										</div>
									</div>
								</div>
								<div class="tab-header">
									<div class="destination header">
										<div class="text p-7"></div>
									</div>
								</div>
							</div>
							<c:forEach var="trainItem" items="${trainList }">
								<div class="row list-body">
									<div class="list">
										<div class="destination">
											<div class="text p-7">
												<h3>${trainItem.trainNum }</h3>
											</div>
										</div>
									</div>
									<div class="list">
										<div class="destination">
											<div class="text p-7">
												<h3>${trainItem.departDepartTime }</h3>
												<h3>${trainItem.destArriveTime }</h3>
											</div>
										</div>
									</div>

									<div class="list">
										<div class="destination">
											<div class="text p-7">
												<h3>${trainItem.departStationName }</h3>
												<h3>${trainItem.destStationName }</h3>
											</div>
										</div>
									</div>

									<div class="list">
										<div class="destination">
											<div class="text p-7">
												<h3>${trainItem.durationStr }</h3>
											</div>
										</div>
									</div>
									<div class="list">
										<div class="destination">
											<div class="text p-7">
												<c:forEach var="priceItem" items="${trainItem.prices }">
													<h3>${priceItem.seatName }￥${priceItem.price }</h3>
												</c:forEach>
											</div>
										</div>
									</div>
									<div class="list">
										<div class="destination">
											<div class="text p-7">
												<c:forEach var="priceItem" items="${trainItem.prices }">
													<c:choose>
														<c:when test="${priceItem.leftNumber == '99' }">
															<h3>有票</h3>
														</c:when>
														<c:otherwise>
															<h3>余${priceItem.leftNumber }张</h3>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</div>
										</div>
									</div>
									<!-- <div class="list">
										<div class="destination">
											<div class="text p-7">
												<p class="bottom-area d-flex space">
													<span class="ml-auto"><a href="#">现在预定</a></span>
												</p>
												<p class="bottom-area d-flex space">
													<span class="ml-auto"><a href="#">现在预定</a></span>
												</p>
												<p class="bottom-area d-flex space">
													<span class="ml-auto"><a href="#">现在预定</a></span>
												</p>
												<p class="bottom-area d-flex space">
													<span class="ml-auto"><a href="#">现在预定</a></span>
												</p>
											</div>
										</div>
									</div> -->
								</div>
							</c:forEach>
							<div class="row mt-5">
								<div class="col text-center">
									<div class="block-27">
										<c:set var="page" value="${trainParam.page }" />
										<c:set var="maxPage" value="${trainParam.maxPage }" />
										<c:choose>
											<c:when test="${maxPage <= 5 }">
												<c:set var="begin_" value="1" />
												<c:set var="end_" value="${maxPage }" />
											</c:when>
											<c:otherwise>
												<c:set var="allowPage" value="5" />
												<c:choose>
													<c:when test="${page <= 3 && page >= 1  }">
														<c:set var="begin_" value="1" />
														<c:set var="end_" value="${begin_ + allowPage - 1 }" />
													</c:when>
													<c:when test="${page >= maxPage - 2 && page <= maxPage }">
														<c:set var="end_" value="${maxPage }" />
														<c:set var="begin_" value="${end_ - (allowPage - 1) }" />
													</c:when>
													<c:otherwise>
														<c:set var="begin_" value="${page - 2 }" />
														<c:set var="end_" value="${page + 2 }" />
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
										<ul>
											<li id="toLeft"><a href="/train/search?
													departureCityName=${trainParam.departureCityName }&arrivalCityName=${trainParam.arrivalCityName }
													&departureCityCode=${trainParam.departureCityCode }&arrivalCityCode=${trainParam.arrivalCityCode }
													&page=${page-1 }&limit=${trainParam.limit }&maxPage=${maxPage }
													&departureDate=${trainParam.departureDate }">&lt;</a></li>
											<c:forEach var="i" begin="${begin_ }" end="${end_ }">
												<li id="li-${i }"><a
													href="/train/search?
													departureCityName=${trainParam.departureCityName }&arrivalCityName=${trainParam.arrivalCityName }
													&departureCityCode=${trainParam.departureCityCode }&arrivalCityCode=${trainParam.arrivalCityCode }
													&page=${i }&limit=${trainParam.limit }&maxPage=${maxPage }
													&departureDate=${trainParam.departureDate }">${i }</a></li>
											</c:forEach>
											<li id="toRight"><a href="/train/search?
													departureCityName=${trainParam.departureCityName }&arrivalCityName=${trainParam.arrivalCityName }
													&departureCityCode=${trainParam.departureCityCode }&arrivalCityCode=${trainParam.arrivalCityCode }
													&page=${page+1 }&limit=${trainParam.limit }&maxPage=${maxPage }
													&departureDate=${trainParam.departureDate }">&gt;</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>

					</c:when>
					<c:otherwise>
						<div class="col-lg-9"><img class="position" src="/images/train.png"></div>
					</c:otherwise>
				</c:choose>

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
	
	<script src="/js/layer/2.4/layer.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/laydate/laydate.js"></script> <!-- 改成你的路径 -->
	<script type="text/javascript">
		$(document).ready(function(){ 
		   $("#li-${page }").prop("class","active");
			if ("${page }" == "1") {
				$("#li-1 > a").prop("class","entry");
				$("#toLeft > a").prop("class","entry");
			}
			if ("${page }" == "${maxPage }") {
				$("#toRight > a").prop("class","entry");
				$("#li-${maxPage } > a").prop("class","entry");
			}
			
			if ("${timeError}" != "") {
            	layer.msg("时间填写错误！",{icon:2,time:1000});
				//alert("时间填写错误！");
			}
		}); 
		
		laydate.render({
		  elem: '#departureDate',
		  min:getDate(),
		  trigger: 'click'
		});
		
		function getDate() {
		    var now = new Date(),
		    y = now.getFullYear(),
		    m = now.getMonth() + 1,
		    d = now.getDate();
		    return y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d);
		}
	</script>
</body>

</html>