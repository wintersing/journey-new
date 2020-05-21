<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <title>旅游攻略,自由行 - 人在旅途</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        .position {
            padding-top: 60px;
            padding-left: 200px;
        }
    </style>
</head>

<body>

    <div>
    <c:if test="${msg eq 'Search No Result' }">
        <img class="position" src="/images/no-result.png">
    </c:if>
    </div>
    <c:if test="${msg eq 'Page Not Found' }">
        <img class="position" src="/images/404.png">
    </c:if>
    </div>
    <c:if test="${msg eq 'Server Internal Error' }">
        <img class="position" src="/images/error.png">
    </c:if>
    </div>

</body>

</html>