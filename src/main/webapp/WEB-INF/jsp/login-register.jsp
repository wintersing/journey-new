<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<title>旅游攻略,自由行 - 人在旅途</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet">
	
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

    <link rel="stylesheet" href="/css/bootstrap_.css">
    <link rel="stylesheet" href="/css/style.login_.css">


</head>

<body>

	<%@ include file="part/header.jsp" %>

	<div class="hero-wrap js-fullheight" style="background-image: url('/images/bg_1.jpg');">
		<header id="gtco-header" class="gtco-cover hero-wrap" role="banner">
			<div class="gtco-container">
				<div>
					<div style="position:absolute; height:150px;margin-top: 100px;" class="row no-gutters slider-text js-fullheight align-items-center justify-content-start" data-scrollax-parent="true">
						<div style="margin-top: -200px;" class="col-md-9 ftco-animate mb-5 pb-5 text-center text-md-left" data-scrollax=" properties: { translateY: '70%' }">
							<h1 class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">发现 <br>一个新的地方</h1>
							<p data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">每个人心中，都会有一个古镇情怀，流水江南，烟笼人家</p>
						</div>
					</div>
					<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
						<div class="form-wrap">
							<div class="tab">
								<ul class="tab-menu">
								<c:choose>
									<c:when test="${reqURI eq '/loginView' }">
										<li class="gtco-first active"><a href="#" data-tab="signup">登陆</a></li>
									</c:when>
									<c:otherwise>
										<li class="gtco-first"><a href="#" data-tab="signup">登陆</a></li>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${reqURI eq '/registerView' }">
										<li class="gtco-second active"><a href="#" data-tab="login">注册</a></li>
									</c:when>
									<c:otherwise>
										<li class="gtco-second"><a href="#" data-tab="login">注册</a></li>
									</c:otherwise>
								</c:choose>
								</ul>
								<div class="tab-content">
								<c:choose>
									<c:when test="${reqURI eq '/loginView' }">
										<div class="tab-content-inner active" data-content="signup">
									</c:when>
									<c:otherwise>
										<div class="tab-content-inner" data-content="signup">
									</c:otherwise>
								</c:choose>
										<form id="login" action="/" method="post">
											<div class="row form-group">
												<div class="col-md-12">
													<label for="username">用户名</label>
													<input name="username" type="text" class="form-control" id="username">
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label for="password">密码</label>
													<input name="password" type="password" class="form-control" id="password">
												</div>
											</div>

											<div class="row form-group">
												<div class="col-md-12">
													<input onclick="login();" type="button" class="btn btn-primary" value="登陆">
												</div>
											</div>
										</form>
									</div>
								<c:choose>
									<c:when test="${reqURI eq '/registerView' }">
										<div class="tab-content-inner active" data-content="login">
									</c:when>
									<c:otherwise>
										<div class="tab-content-inner" data-content="login">
									</c:otherwise>
								</c:choose>
										<form id="register" action="/" method="post">
											<div class="row form-group">
												<div class="col-md-12">
													<label for="username_register">用户名</label>
													<input value="" name="username" type="text" class="form-control" id="username_register" autocomplete="off">
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label for="password_register">密码</label>
													<input name="password" type="password" class="form-control" id="password_register" autocomplete="new-password">		
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12">
													<label for="phone">手机号码</label>
													<input name="phone" type="text" class="form-control" id="phone">
												</div>
											</div>
											<div class="row">
												<div class="col-md-7">
													<label for="code">验证码</label>
													<input value="" name="code" type="text" class="form-control" id="code">
												</div>
												<div class="sendMessages">
													<input id="getCode" onclick="sendMessages()" type="button"
														class="btn btn-default btn-sm" value="发送" />
												</div>
											</div>
											<div class="row form-group">
												<div class="col-md-12 register">
													<input onclick="register();" type="button" class="btn btn-primary" value="注册">
												</div>
											</div>
										</form>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>

	<script src="/js/jquery.min.js"></script>
	<script src="/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/js/jquery.waypoints.min.js"></script>
	<script src="/js/jquery.stellar.min.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/aos.js"></script>
	<script src="/js/scrollax.min.js"></script>
	
	<script src="/js/layer/2.4/layer.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/jquery.min.login.js"></script>
	<script src="/js/main.login.js"></script>
	<script>

            var InterValObj; //timer变量，控制时间 
            var count = 60; //间隔函数，1秒执行 
            var curCount; //当前剩余秒数 
            var code = ""; //验证码 
            //发送验证码
            function sendMessages() {
                curCount = count;
                var phone = $("#phone").val();
                if (isMobile(phone)) {
                    //设置button效果，开始计时 
                    $("#getCode").attr("disabled", "true");
                    $("#getCode").val(curCount + "秒");
                    InterValObj = window.setInterval(SetRemainTimes, 1000); //启动计时器，1秒执行一次 
                    //向后台发送处理数据 
                    $.ajax({
                       url: "/sendSMScode",
                       dataType: "json",
                       type: "get",
                       data: {"phone":phone},
                       success: function(data) {
                          //保存验证码
                          if (data.status) {
                        	  layer.msg('验证码发送成功！',{icon:1,time:1000});
							//alert("验证码发送成功！");
						} else {
							layer.msg(data.msg,{icon:2,time:1000});
							//alert(data.msg);
						}
                       }
                    });
                } else {
                	layer.msg('客官，请填写正确的手机号码！',{icon:2,time:1000});
                    //alert("客官，请填写正确的手机号码！");
                }
            }
            //timer处理函数 
            function SetRemainTimes() {
                if (curCount == 0) {
                    window.clearInterval(InterValObj); //停止计时器 
                    $("#getCode").removeAttr("disabled"); //启用按钮 
                    $("#getCode").val("发送");
                    code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效   
                } else {
                    curCount--;
                    $("#getCode").val(curCount + "秒");
                }
			}
            //注册
            function register() {
                var username = $("#username_register").val();
                var password = $("#password_register").val();
                var phone = $("#phone").val();
                var code = $("#code").val();
                if (!isMatcher(username) || !isMatcher(password)) {
                	return layer.msg('用户名，密码在6-20个字母内，可以有数字、下划线或减号，以字母开头',{icon:2,time:1000});
                	//return alert("用户名，密码在6-20个字母内，可以有数字、下划线或减号，以字母开头");
                }
                if (!isMobile(phone)) {
                	return layer.msg('客官，请填写正确的手机号码！',{icon:2,time:1000});
                	//return alert("客官，请填写正确的手机号码！");
                }
                if (code.length != 6) {
                	return layer.msg('请填写正确的验证码！',{icon:2,time:1000});
                	//return alert("请填写正确的验证码！");
				}
            	$.ajax({
                    url: "/register",
                    dataType: "json",
                    type: "post",
                    data: {"username":username,"password":password,"phone":phone,"code":code},
                    success: function(data) {
                       //保存验证码
                       if (data.status) {
                    	   document.getElementById('register').submit();
						} else {
		                	layer.msg(data.msg,{icon:2,time:1000});
							//alert(data.msg);
						}
                    }
                 });
			}
            //登录
            function login() {
                var username = $("#username").val();
                var password = $("#password").val();
                if (!isMatcher(username) || !isMatcher(password)) {
                	return layer.msg("用户名，密码在6-20个字母内，可以有数字、下划线或减号，以字母开头",{icon:2,time:2000});
                	//return alert("用户名，密码在6-20个字母内，可以有数字、下划线或减号，以字母开头");
                }
            	$.ajax({
                    url: "/login",
                    dataType: "json",
                    type: "post",
                    data: {"username":username,"password":password},
                    success: function(data) {
                       //保存验证码
                       if (data.status) {
                    	   document.getElementById('login').submit();
						} else {
		                	layer.msg(data.msg,{icon:2,time:1000});
							//alert(data.msg);
						}
                    }
                 });
			}
            
            
            //校验手机号码
            function isMobile(mobile) {
            	return /^1[34578]\d{9}$/.test(mobile);
			}
            //校验用户名，密码
            function isMatcher(str) {
            	return /^[a-zA-Z][a-zA-Z0-9_-]{5,19}$/.test(str);
			}
        </script>
</body>

</html>