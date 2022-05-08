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
	<c:url value="/resources/user/images" var="img" />
	<br>
	<div class="container">
		<table class="table table-hover table-condensed" style="width: 80%">
			<thead>
				<tr>
					<td style="text-align: left;"><a
						href="${pageContext.request.contextPath}/banhngot/danhsach">
							<button type="button" class="btn fs14" style="background: #ff8533; color: #fff;"> 
								<i class="fa fa-angle-left"></i> Tiếp tục mua hàng
							</button>
					</a></td>
					<td style="font-size: 20px"><c:if
							test="${not empty tinhtranggiohang }">
							<img src="${img}/cartnull.jpg"
								style="width: 100px; height: 100px">
							<b>Không có sản phẩm nào trong giỏ hàng</b>
						</c:if></td>
				</tr>

			</thead>
			<tbody>
				<c:forEach var="ds" items="${sessionScope.cart}">
					<tr>
						<td>
							<div class="row ">
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 ">
									<img
										src="${resources}/user/images/SanPham/${ds.product.anhURL}"
										alt="" class="" style="width: 100%">
									<div style="text-align: center; margin-top: 10%">
										<a
											href="${pageContext.request.contextPath}/user/xoaproductcart/${ds.product.id}"><button
												class="btn btn-danger btn-sm" style="background: #ff1a1a; color: #fff;">
												
												<i class="fa fa-trash"></i>
											</button> </a>
									</div>
								</div>
								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 mt-2"
									style="margin-top: 10%; font-size: 20px">
									<div>
										<b>${ds.product.name}</b>
									</div>
								</div>
							</div>
						</td>
						<td>
							<div style="text-align: center; color: red; font-size: 25px">
								<fmt:formatNumber type="number" pattern="#,###,###.##₫"
									value="${ds.product.price}" />
							</div>
							<div style="text-align: center; margin-top: 10px">												
								<c:if test="${ds.soLuong >= 2}">
									<a href="${pageContext.request.contextPath }/user/giamsoluong/${ds.product.id}">
										<button class="btn fs16" style="background: #ff8533; color: #fff;"><b>-</b></button>
									</a>
								</c:if>
								<c:if test="${ds.soLuong == 1}">
									<a href="${pageContext.request.contextPath}/user/xoaproductcart/${ds.product.id}">
										<button class="btn fs16" style="background: #ff8533; color: #fff;"><b>-</b></button>
									</a>
								</c:if>	
								&nbsp; 
									<span class="fs14">${ds.soLuong} </span>
								&nbsp;
								<c:if test="${ds.soLuong >= ds.product.quantity}">
									<a onclick="return confirm('Không đủ số lượng trong kho!');">
										<button	class="btn btn-warning fs16" style="opacity: 0.5;background: #ff8533; color: #fff;">
											<b>+</b>
										</button>
									</a>
								</c:if>
								<c:if test="${ds.soLuong < ds.product.quantity}">
								<a href="${pageContext.request.contextPath }/user/tangsoluong/${ds.product.id}"><button
											class="btn fs16" style="background: #ff8533; color: #fff;">
											<b>+</b>
										</button></a>
								</c:if>																														
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="giohangtongtien">
				<table class="table fs14">
					<tr>
						<td>Tạm tính:</td>
						<td><fmt:formatNumber type="number" pattern="#,###,###.## ₫"
								value="${tamtinh}" /></td>
					</tr>
					<tr>
						<td>Giảm:</td>
						<td><fmt:formatNumber type="number" pattern="#,###,###.## ₫"
								value="${giamgia}" /></td>
					</tr>
					<tr>
						<td><b>Tổng tiền (đã tính VAT):</b></td>
						<td style="color: red;"><b><fmt:formatNumber
									type="number" pattern="#,###,###.## ₫" value="${tongtien}" /></b></td>
					</tr>
					<tr>
						<td style="width: 100%">
						<c:if test="${tongtien==0 }">
							<a href="${pageContext.request.contextPath }/user/gioHang"
									onclick="return confirm('Không có sản phẩm nào trong giỏ hàng!');"><button
										style="width: 100%; background: #ff8533; color: #fff;" class="btn btn-success fs14">Đặt
										hàng</button></a>
						</c:if>
							<c:if test="${tenDangNhap==null && tongtien > 0}">
								<a <%-- href="${pageContext.request.contextPath }/user/showFormNguoiNhan --%>"
									onclick="return confirm('Bạn phải đăng nhập mới đặt hàng được!');"><button
										style="width: 100%; background: #ff8533; color: #fff;" class="btn btn-success fs14">Đặt
										hàng</button></a>
							</c:if>
						<c:if test="${tenDangNhap!=null && tongtien > 0}">
							<a
								<%-- href="${pageContext.request.contextPath }/user/showFormNguoiNhan" --%>>
								<button style="width: 100%; background: #ff8533; color: #fff;" type="button"
									class="btn fs14 text-uppercase">Đặt hàng</button>
							</a>
							
						</c:if>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="row">
			<div style="color: red; text-align: center; font-size: 20px">
				<b>${errorcartnull}</b>
			</div>
		</div>
		<div class="row" style="display: none">
			<div class="thongtinkhachhang">
				<div style="text-align: center;">
					<h4>THÔNG TIN KHÁCH HÀNG</h4>
				</div>
				<form:form
					action="${pageContext.request.contextPath}/user/showFormNguoiNhan"
					method="POST">
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Họ và
							tên</label>
						<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
							<input class="form-control" placeholder="Nhập họ và tên">
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3">Giới
							tính</label>
						<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
							<input type="radio" name="gioiTinh" value="Nam">Nam
							&nbsp; <input type="radio" name="gioiTinh" value="Nu">Nữ
						</div>

					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3"> Địa
							chỉ </label>
						<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
							<input class="form-control" placeholder="Nhập địa chỉ người nhận">
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3"> Ghi
							chú </label>
						<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
							<textarea class="form-control" placeholder="Ghi chú"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></label>
						<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
							<button type="submit" class="btn btn-success btn-block">
								Đặt hàng</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>

