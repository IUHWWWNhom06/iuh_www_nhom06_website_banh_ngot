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
				<div class="welcomelogin">
					<div>
						<img alt="" src="${img}/logo.png">
					</div>
					<div style="font-size: 25px">
						<b>Welcome to login</b>
					</div>
					<p class="fs14">
						Bạn đã có tài khoản?
					</p>
					<div>
						<a href="${pageContext.request.contextPath}/user/formDangNhap"><button
								class="btn btn-outline-warning fs14" style="color: black">Đăng nhập</button></a>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<div class="login">
					<div style="text-align: center;">
						<b class="fs16">ĐĂNG KÝ</b>
					</div>
					<form:form action="${pageContext.request.contextPath}/user/dangky"
						method="post" modelAttribute="nguoiDung">
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><b>Tên
									đăng nhập</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<form:input path="tenDangNhap" cssClass="form-control fs14"
									placeholder="Nhập tên đăng nhập" />
								<span style="color: red"><form:errors path="tenDangNhap" ></form:errors> </span>
								
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><b>Họ và
									tên</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<form:input placeholder="Nhập họ tên" cssClass="form-control fs14"
									path="tenNguoiDung" />
								<span style="color: red"><form:errors path="tenNguoiDung" ></form:errors> </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><b>Email</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<form:input placeholder="Nhập email" cssClass="form-control fs14"
									path="email" />
								<span style="color: red"><form:errors cssClass="error" path="email" ></form:errors> </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><b>Số
									điện thoại</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<form:input placeholder="Nhập số điện thoại"
									cssClass="form-control fs14" path="soDienThoai" />
									<span style="color: red"><form:errors path="soDienThoai" ></form:errors> </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><b>Địa
									chỉ</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<form:input placeholder="Nhập số địa chỉ"
									cssClass="form-control fs14" path="diaChi" />
								<span style="color: red"><form:errors path="diaChi" ></form:errors> </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><b>Mật
									khẩu</b></label>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<form:password placeholder="Nhập mật khẩu"
									cssClass="form-control fs14" path="matKhau" />
								<span style="color: red"><form:errors path="matKhau" ></form:errors> </span>
							</div>
						</div>
						<div style="color: red;padding-left: 15px;">
							<b class="fs14">${loi}</b>
						</div>
						<div style="margin-top: 30px">
							<button class="btn" type="submit">
								<b>Đăng ký</b>
							</button>
							</a>
						</div>
					</form:form>
					<div class="quenmatkhau">
						<a href="">Quên mật khẩu</a>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>

