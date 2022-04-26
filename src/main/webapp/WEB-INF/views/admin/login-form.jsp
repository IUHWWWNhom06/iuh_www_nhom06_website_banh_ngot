<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources/admin" var="url" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Admin</title>
<link rel="icon" href="${url}/images/favicon.ico" type="image/x-icon">
<link href="${url}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${url}/css/animate.css" rel="stylesheet" type="text/css" />
<link href="${url}/css/icons.css" rel="stylesheet" type="text/css" />
<link href="${url}/css/appstyle.css" rel="stylesheet" />
</head>

<body class="bg-theme bg-theme1">
	<!-- Start wrapper-->
	<div id="wrapper">

		<div class="card card-authentication1 mx-auto my-5" style="background: transparent">
			<div class="card-body">
				<div class="card-content p-2">
					<div class="text-center">
						<img src="${url}/images/logo-icon.png" alt="logo icon">
					</div>
					<div class="card-title text-uppercase text-center py-3">Đăng
						nhập</div>
					<form action="${pageContext.request.contextPath}/login" method="post">
						<div class="form-group">
							<label for="exampleInputUsername" class="sr-only">Username</label>
							<div class="position-relative has-icon-right">
								<input type="text" class="form-control input-shadow" placeholder="Username" name="username" required>
								<div class="form-control-position">
									<i class="icon-user"></i>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword" class="sr-only">Password</label>
							<div class="position-relative has-icon-right">
								<input type="password" class="form-control input-shadow" placeholder="Password" name="password" required>
								<div class="form-control-position">
									<i class="icon-lock"></i>
								</div>
							</div>
						</div>
						<div>
							<b> <span style="color: #00d9e8"> ${errorMessage}</span></b>
						</div>
						<div class="form-row">
							<div class="form-group col-6">
								<div class="icheck-material-white">
									<input type="checkbox" id="user-checkbox" /> <label
										for="user-checkbox">Ghi nhớ</label>
								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-light btn-block">Đăng
							nhập</button>
							 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</div>

		</div>

	</div>
</body>
</html>
