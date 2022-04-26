<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html>
<c:url value="/resources" var="resources" />
<c:url value="/resources/user/css" var="css" />
<head>
<meta charset="UTF-8">
<title>TRANG CHỦ Q-MOBILE</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link rel="stylesheet" href="${resources}/user1/css/base.css">
<link rel="stylesheet" href="${resources}/user1/css/main.css">
<link rel="stylesheet" href="${resources}/user1/css/reponsive.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="${resources}/user1/font/fontawesome-free-5.15.2-web/fontawesome-free-5.15.2-web/css/all.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${css}/index_1.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${resources}/user/css/pagination.min.css">

<title>Mobile Việt Nam | Mua và Bán Trên Ứng Dụng Di Động Hoặc
	Website</title>
</head>
<body>
	<div class="app">
		<%@ include file="/common/user1/header.jsp"%>
		<decorator:body />
		<%@ include file="/common/user1/footer.jsp"%>
	</div>
	
	<script src="${resources}/user/js/jquery.min.js"></script>
    <script src="${resources}/user/js/bootstrap.min.js"></script>
</body>
</html>