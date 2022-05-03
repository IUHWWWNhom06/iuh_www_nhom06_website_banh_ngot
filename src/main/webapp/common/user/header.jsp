<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<nav
	class="navbar navbar-expand-md navbar-fixed-top navbar-default bg-light navbar-light"
	style="background-color: rgb(233, 220, 38) !important;">
	<a class="navbar-brand border " href="index_1.html" style="width: 7%;">
		<img src="${img}/logo.png" alt="" class="src"
		style="width: 100%; height: 10%;">
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav position-relative m-auto"
			style="width: 80%; letter-spacing: 2px;">
			<li class="nav-item position-relative pr-10"><a
				class="nav-link position-relative ml-20"
				href="${pageContext.request.contextPath}/dienthoai/danhsach"><i
					class="iconmenu fas fa-home"></i><b>TRANG CHỦ</b></a></li>
			<li class="nav-item position-relative"><a
				class="nav-link position-relative dropdown-toggle"
				data-toggle="dropdown" href="#"><i
					class="iconmenu fab fa-product-hunt"></i><b>SẢN PHẨM</b></a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="iPhone.html">Iphone</a> <a
						class="dropdown-item" href="SAMSUNG.html">SAMSUNG</a> <a
						class="dropdown-item" href="iPad.html">Ipad</a>
				</div></li>
			<li class="nav-item position-relative"><a
				class="nav-link position-relative" href="lienhe.html"><i
					class="iconmenu fas fa-address-card"></i><b>LIÊN HỆ</b></a></li>
			<li class="nav-item position-relative"><a
				class="nav-link position-relative" href="gioithieu.html"><i
					class="iconmenu fas fa-book"></i><b> GIỚI THIỆU </b></a></li>


		

			
				<li class="nav-item position-relative"><a
					class="nav-link position-relative"
					href="${pageContext.request.contextPath}/user/formDangNhap"><i
						class="fa fa-user"></i> <!--  aria-hidden="true" data-toggle="modal"
							data-target="#myModal" style="font-size: 20px;"></i>--> </a></li>

			
			<li class="nav-item position-relative"><a
				class="nav-link position-relative"
				href="${pageContext.request.contextPath}/user/cart"><i
					class="fa fa-shopping-cart"></i></a></li>
			<li class="nav-item position-relative"><a
				class="nav-link position-relative" href="#"> <i
					class="fa fa-fw fa-search" data-toggle=" modal "
					data-target="#myModal_Search " aria-hidden="true"
					style="font-size: 20px;"> </i>
			</a></li>
		</ul>
	</div>
</nav>
