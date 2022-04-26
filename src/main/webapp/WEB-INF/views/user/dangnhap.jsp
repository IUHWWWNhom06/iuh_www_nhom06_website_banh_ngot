<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/resources/user/images" var="img" />
	<br>
	<div class="container">
		<div class="row"
			style="background-color: #f2f885; margin-bottom: 20px">
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<div class="welcomelogin fs14">
					<div>
						<img alt="" src="${img}/logo.png">
					</div>
					<div style="font-size: 25px">
						<b>Welcome to login</b>
					</div>
					<div>Bạn chưa có tài khoản?</div>
					<div>
						<a href="${pageContext.request.contextPath}/user/formDangKy"><button
								class="btn btn-outline-warning text-uppercase mt-2 fs14"
								style="color: black">Đăng ký</button></a>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<div class="login fs14">
					<div style="text-align: center;">
						<b>ĐĂNG NHẬP</b>
					</div>
					<form action="${pageContext.request.contextPath}/dangNhap"
						method="post">
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4"
								for="tenDangNhap"><b>Tên đăng nhập</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<input type="text" placeholder="Nhập tên đăng nhập"
									class="form-control fs14" name="tenDangNhap" id="tenDangNhap">
								<span style="color: red"><form:errors path="tenDangNhap"></form:errors>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4" for="matKhau"><b>Mật
									khẩu</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<input type="password" placeholder="Nhập mật khẩu"
									class="form-control fs14" name="matKhau" id="matKhau">
								<span style="color: red"><form:errors path="matKhau"></form:errors>
								</span>
							</div>
						</div>
						<c:if test="${param.error != null}">
							<div class="col-xs-offset-1 col-xs-10" style="color: red; padding-left: 20px;">
								Tên đăng nhập hoặc mật khẩu không hợp lệ.</div>
						</c:if>
						<div style="margin-top: 30px">
							<button class="btn" type="submit">
								<b class="text-uppercase fs14">Đăng nhập</b>
							</button>
							</a>
						</div>
					</form>
					<div class="quenmatkhau">
						<a
							href="${pageContext.request.contextPath}/user/formTimTenDangNhap">Quên
							mật khẩu</a>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>

