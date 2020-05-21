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
<style type="text/css">
.text {
	margin-right: 15px
}

.comment-pad {
	padding-top: 100px;
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
					<!-- <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.html">主页</a></span> <span>酒店</span></p> -->
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">景点</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar">
					<div class="sidebar-wrap ftco-animate">
						<h3 class="heading mb-4">寻找景点</h3>
						<form action="#">
							<div class="fields">
								<div class="form-group">
									<input name="cityName" type="text" class="form-control"
										value="${placesParam.cityName }" placeholder="请输入您要所搜的城市">
								</div>
								<!-- <div class="form-group">
									<div class="range-slider">
										<span>
										    <input type="number" value="25000" min="0" max="120000"/>	-
										    <input type="number" value="50000" min="0" max="120000"/>
										  </span>
										  <input value="1000" min="0" max="120000" step="500" type="range"/>
										  <input value="50000" min="0" max="120000" step="500" type="range"/>
										  </svg>
										</div>
		             				</div> -->
								<div class="form-group">
									<input type="submit" value="Search"
										class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</form>
					</div>
					<div class="sidebar-wrap ftco-animate">
						<h3 style="color: darkgoldenrod;" class="heading mb-4">新闻资讯</h3>
						<c:forEach var="newsItem" items="${newsList }">
							<p>
								<a target="_blank" class="news" href="${newsItem.url }">${newsItem.title }</a>
							</p>
						</c:forEach>

					</div>

					<!-- <div class="sidebar-wrap ftco-animate">
        			<h3 class="heading mb-4">Star Rating</h3>
        			<form method="post" class="star-rating">
							  <div class="form-check">
									<input type="checkbox" class="form-check-input" id="exampleCheck1">
									<label class="form-check-label" for="exampleCheck1">
										<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i></span></p>
									</label>
							  </div>
							  <div class="form-check">
						      <input type="checkbox" class="form-check-input" id="exampleCheck1">
						      <label class="form-check-label" for="exampleCheck1">
						    	   <p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i></span></p>
						      </label>
							  </div>
							  <div class="form-check">
						      <input type="checkbox" class="form-check-input" id="exampleCheck1">
						      <label class="form-check-label" for="exampleCheck1">
						      	<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i></span></p>
						     </label>
							  </div>
							  <div class="form-check">
							    <input type="checkbox" class="form-check-input" id="exampleCheck1">
						      <label class="form-check-label" for="exampleCheck1">
						      	<p class="rate"><span><i class="icon-star"></i><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i></span></p>
						      </label>
							  </div>
							  <div class="form-check">
						      <input type="checkbox" class="form-check-input" id="exampleCheck1">
						      <label class="form-check-label" for="exampleCheck1">
						      	<p class="rate"><span><i class="icon-star"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i><i class="icon-star-o"></i></span></p>
							    </label>
							  </div>
							</form>
        		</div> -->
				</div>

				<div class="col-lg-9">
					<div class="row">
						<div class="col-md-12 ftco-animate">
							<div class="single-slider owl-carousel">
								<c:choose>
									<c:when test="${fn:length(placesDes.imageUrls) > 20 }">
										<c:set var="end" value="20"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="end" value="${fn:length(placesDes.imageUrls) }"></c:set>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="1" end="${end }" var="imageUrl"
									items="${placesDes.imageUrls }">
									<div class="item">
										<div class="hotel-img"
											style="background-image: url(${imageUrl });"></div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-md-12 hotel-single mt-4 mb-5 ftco-animate">
							<p>
							<h2>${placesDes.title }</h2>
							<h5>${placesDes.subtitle }</h5>
							评分：<span class="star"> <fmt:parseNumber var="rating2"
									type="number" value="${placesDes.rating }" /> <c:forEach
									begin="1" end="${rating2 }">
									<i class="icon-star"></i>
								</c:forEach> <c:if test="${placesDes.rating%1 > 0}">
									<i class="icon-star-half"></i>
								</c:if> ${placesDes.rating } 分
							</span> </span>
							<div class="two">
								门票：<span class="price"> <c:choose>
										<c:when test="${placesDes.price > '0' }">
												
												￥${placesDes.price }
												
											</c:when>
										<c:otherwise>
											<span style="font-size: 15px">免费开放</span>
										</c:otherwise>
									</c:choose>
								</span>
							</div>
							</p>
							<span>开放时间: ${placesDes.openingHours }</span>
							<p class="rate mb-5">
								<span class="loc"><i class="icon-map"></i>${placesDes.city }</span>
								<span class="loc"><i class="icon-map-marker"></i>${placesDes.location }</span>
								<span><a
									href="/hotel/search?lon=${placesDes.geoPoint.lon }&lat=${placesDes.geoPoint.lat }&distance=3km"
									class="reply">>>附近酒店</a></span>
							</p>
							<h4>景区描述</h4>
							<p>${placesDes.description }</p>
							<h4>小提示</h4>
							<span> ${placesDes.tipInfo } </span>
						</div>
						<div class="pt-5 mt-5 comment">
						 <div class="comment-form-wrap pt-5">
							<h3 class="mb-5">发表评论</h3>
							<form id="form-comment-add" class="p-5 bg-light">
							<input id="parent" type="hidden" value="sight" name="parent">
							<input id="parentID" type="hidden" value="${placesDes.id }" name="parentID">
								<div class="form-group">
									<textarea name="content" id="content" cols="60" rows="4"
										class="form-control"></textarea>
								</div>
								<div class="form-group">
									<input type="button" value="发表" onclick="addComment();"
										class="btn py-3 px-4 btn-primary">
								</div>

							</form>
						</div> 

							<div class="comment-pad">
								<h3 class="mb-5">精彩评论</h3>
								<ul class="comment-list">

								</ul>
							</div>
							<!-- END comment-list -->

						</div>
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
						<script src="/js/jquery.validation/1.14.0/jquery.validate.js"></script> 
						<script src="/js/jquery.validation/1.14.0/validate-methods.js"></script> 
						<script src="/js/jquery.validation/1.14.0/messages_zh.js"></script> 

						<script src="/js/main.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		getPalcesComment();
	});
	var commentPage = 1;
	var data = 0;
	$(window).scroll(function() {
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		if (scrollTop + windowHeight == scrollHeight) {
			// 此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
			//var commentPage = $("#commentPage").val();
			if (commentPage > 0) {
				getPalcesComment();
			} else {
				return;
			}
		}
	});
	function getPalcesComment() {
		$.ajax({
			url : '/comment/sight/${placesDes.id }?pageToken='+commentPage+'&data='+data,
			method : 'get',
			ContentType : "application/x-www-form-urlencoded;charset=utf-8",
			dataType : 'json',
			success : function(ret) {
				var dataList = "";
				//判断第一次请求是否有结果
				if (ret.retcode == "100002") {
					commentPage = 0;
					var str = "<div class=\"comment-body\" style=\"padding-left:20px;font-size: 20px;text-align:center;color: #f1a904;\">"
							+ "------你已经看到我的底线了------" + "</div>"
					$('.comment').append(str);
					return;
				}

				$.each(ret.data, function(i, comment) {
					var str = "<li class=\"comment\">"
							+ "<div class=\"vcard bio\">"
							+ "<img src=\""+comment.avatarUrl+"\" alt=\"Image placeholder\">"
							+ "</div>"
							+ "<div class=\"comment-body\">"
							+ "<h3>"
							+ comment.commenterScreenName
							+ "</h3>"
							+ "<p>"
							+ comment.content
							+ "</p>"
							+ "<div class=\"meta\">"
							+ getDate(comment.publishDate)
							+ "</div>"
							+ "</div>"
							+ "</li>"
					dataList = dataList + str
				});
				if (ret.hasNext == true) {
					commentPage += 1;
				} else {
					if (ret.hasNext_data != undefined && ret.hasNext_data == true) {
						commentPage = 1;
						data=1;
					} else {
						commentPage = 0;
					}
				}
				$('.comment-list').append(dataList);
			}
		});
	}
	function getDate(str) {
		var now = new Date(str),
		y = now.getFullYear(),
		m = now.getMonth() + 1,
		d = now.getDate();
		return y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d) + " " + now.toTimeString().substr(0, 8);
	}
	
	function addComment() {
        var parent = $("#parent").val();
        var parentID = $("#parentID").val();
        var content = $("#content").val();
        if (content == "") {
        	layer.msg('请输入评论！',{icon:2,time:1000});
			return;
		}
		$.ajax({
			url : '/addComment',
			method : 'post',
			data:{"parent":parent,"parentID":parentID,"content":content},
			ContentType : "application/x-www-form-urlencoded;charset=utf-8",
			dataType : 'json',
			success : function(ret) {
				if (ret.status) {
					layer.msg('评论成功！',{icon:1,time:1000});
				} else {
					layer.msg(ret.msg,{icon:2,time:1000});
				}
			}
		});
	}
</script>
</html>










