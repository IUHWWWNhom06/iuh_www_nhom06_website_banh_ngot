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
	<c:url value="/resources" var="resources" />
	<br>
	<div class="container">
		<div class="row">
			<table class="table" style="width: 60%">
				<c:forEach var="cake" items="${sessionScope.cart}">
					<tr class="fs16">
						<td><img alt="" src="${resources}/user/images/SanPham/${cake.product.anhURL}"
							style="width: 100p; height: 100px"></td>
						<td><b>Bánh: ${cake.product.name}<br>
								Thành phần: ${cake.product.ingredient} <br>Đơn giá: <fmt:formatNumber
									type="number" pattern="#,###,###.##₫"
									value="${cake.product.price}" /> <br> Số lượng:
								${cake.soLuong}	
								
						</b></td>
					</tr>
				</c:forEach>
				
				<tr>
					<td><b style="color: red; font-size: 20px">Tổng tiền</b>
					<td><b style="color: red; font-size: 20px; float: right;"><fmt:formatNumber
								type="number" pattern="#,###,###.##₫" value="${tongtien}" /></b>
					<td>
				</tr>
			</table>
		</div>

		<div class="row">
			<div class="thongtinkhachhang">
				<div style="text-align: center;">
					<h4>THÔNG TIN KHÁCH HÀNG</h4>
				</div>

				<form:form
					action="${pageContext.request.contextPath}/user/thanhtoan"
					method="POST" modelAttribute="nguoiNhan" class="fs16">
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Họ và
							tên</label>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<form:input class="form-control form-control-lg fs13" path="nameCustomer"
								placeholder="Nhập họ và tên người nhận" />
							<span style="color: red"><form:errors
									path="nameCustomer" cssClass="error"></form:errors></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Số điện
							thoại</label>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<form:input cssClass="form-control form-control-lg fs13" path="phoneCustomer"
								placeholder="Nhập số điện thoại người nhận" />
							<span style="color: red;"><form:errors
									path="phoneCustomer" cssClass="error"></form:errors></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Địa chỉ
						</label>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<form:input class="form-control form-control-lg fs13" path="addressCustomer"
								placeholder="Nhập số địa chỉ người nhận" />
							<span style="color: red"><form:errors
									path="addressCustomer" cssClass="error"></form:errors></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Email </label>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<form:input class="form-control form-control-lg fs13" path="email"
								placeholder="Nhập email người nhận" />
							<span style="color: red"><form:errors path="email"
									cssClass="error"></form:errors></span>
						</div>
					</div>


					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3">PT thanh toán</label>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<select class="form-control form-control-lg fs13" name="idPT" aria-invalid="false">
								<c:forEach var="pm" items="${getAllPaymentMethod}">
									<option value="${pm.id}" selected>${pm.method}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></label>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<a><button type="submit" class="btn btn-success btn-block fs16">
									Thanh toán</button></a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>

