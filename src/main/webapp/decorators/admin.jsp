<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Admin web điện thoại</title>

<c:url value="/resources/user/js" var="js"></c:url>
<c:url value="/resources" var="resources"></c:url>

<link rel="icon" href="${resources}/admin/images/favicon.ico" type="image/x-icon">
<link href="${resources}/admin/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/admin/css/animate.css" rel="stylesheet" type="text/css" />
<link href="${resources}/admin/css/icons.css" rel="stylesheet" type="text/css" />
<link href="${resources}/admin/css/sidebar-menu.css" rel="stylesheet" />
<link href="${resources}/admin/css/appstyle.css" rel="stylesheet" />
<link href="${resources}/admin/css/fullparamer.css" rel="stylesheet" />
<link rel="stylesheet" href="${resources}/admin/plugins/toastr/toastr.min.css">
	<link rel="stylesheet" type="text/css" href="${resources}/admin/css/pagination.min.css">

</head>
<body style="background-color: #0d5b80">
	<div id="wrapper">

		<%@ include file="/common/admin/header.jsp"%>
		<decorator:body />
		<%@ include file="/common/admin/footer.jsp"%>

	</div>
	
	<script src="${resources}/admin/js/jquery.min.js"></script>
    <script src="${resources}/admin/js/bootstrap.min.js"></script>
    <script src="${resources}/admin/plugins/toastr/toastr.min.js"></script>
    <script src="${url}/plugins/Chart.js/Chart.min.js"></script>


</body>
</html>