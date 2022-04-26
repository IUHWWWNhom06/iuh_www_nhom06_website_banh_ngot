<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html>
<c:url value="/resources/user/css" var="css" />
<c:url value="/resources/user/fonts" var="font" />
<c:url value="/resources/user/js" var="js" />
<head>
<meta charset="UTF-8">
<title>TRANG CHỦ Q-MOBILE</title>

<link rel="stylesheet" type="text/css" href="${css}/index_1.css">
<link rel="stylesheet" type="text/css"
	href="${font}/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${css}/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${css}/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${font}/icon.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="${font}/font-awesome.min.css">
<script src="${js}/jquery.js"></script>
<script src="${js}/popper.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src='${js}/a076d05399.js'></script>
<script src='${js}/index.js'></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<c:url value="/resources/user/images" var="img" />
	<%@ include file="/common/user/header.jsp"%>
	<decorator:body />
	<%@ include file="/common/user/footer.jsp"%>

</body>
</html>