<%@page import="com.banhngot.entity.ProductCart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<c:url value="/resources" var="resources" />
<header class="header" style="background: #ffe6e6">
	<div class="container-fluid">
		<nav class="header__navbar hide-on-mobile-tablet">
			<ul class="header__navbar-list">
				<li class="header__navbar-item"><i class="fas fa-store fs-150"></i>&nbsp;
					<span class=" text-dark font-weight-bold" >Cửa hàng</span></li>
				<li class="header__navbar-item"><span
					class="header__navbar-title--no-pointer text-dark font-weight-bold">Liên
						hệ</span> <a href="#" class="header__navbar_icon-link"> <i
						class="header_navbar-icon fab fa-facebook text-dark"></i>
				</a> <a href="#" class="header__navbar_icon-link"> <i
						class="header_navbar-icon fas fa-phone text-dark font-weight-bold"></i>
				</a></li>

			</ul>
			<ul class="header__navbar-list">
				<li class="header__navbar-item"><div
						class="header__logo hide-on-tablet">
						<a href="${pageContext.request.contextPath}/banhngot/danhsach"
							class="head_logo-link"> <img
							src="${resources}/user1/img/logocake.png"
							class="header__logo-img ml-24" alt="logo cake">
						</a>
					</div></li>
			</ul>
			<ul class="header__navbar-list">
				<c:if test="${pageContext.request.userPrincipal.name==null}">
					<li class="header__navbar-item header__navbar-item-bold"><a
						class="text-deco"
						href="${pageContext.request.contextPath}/user/formDangKy">Đăng
							ký<a></li>
					<li class="header__navbar-item header__navbar-item-bold"><a
						class="text-deco"
						href="${pageContext.request.contextPath}/user/formDangNhap">Đăng
							nhập</a></li>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name!=null}">
					<li class="header__navbar-item header__navbar-user"><span
						class="header__navbar-user-name">Xin chào: <b>${pageContext.request.userPrincipal.name}</b></span>
						<ul class="header__navbar-user-menu ">
							<li class="header__navbar-user-item text-deco"><a href="#">Tài
									khoản của tôi</a></li>
							<li class="header__navbar-user-item text-deco"><a href="#">Đơn
									mua</a></li>
							<li class="header__navbar-user-item text-deco"><a
								href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
						</ul></li>
				</c:if>
			</ul>


		</nav>

		<div class="header-with-search " style="padding-bottom: 50px">
			<div class="list-inline-item">
				<a
					class="text-decoration-none fs14 mr-3 text-deco text-dark text-uppercase opacity05 px-3 py-2 font-weight-bold"
					href="${pageContext.request.contextPath}/banhngot/danhsach">Trang
					chủ</a>
			</div>
			<label for="mobile-search-checkbox" class="header__mobile-search">
				<i class="fas fa-search" sstyle="color: black;"></i>
			</label> <input type="checkbox" hidden name="" id="mobile-search-checkbox"
				class="mobile__check-header">
			<form:form class="header__search form-inline"
				action="${pageContext.request.contextPath}/banhngot/search"
				method="GET">
				<div class="header__search-input-wrap">
					<input type="hidden" value="${sort}" name="sort" /> <input
						type="text" class="header__search-input" name="searchName"
						placeholder="Tìm tên bánh" value="${param.search }">
				</div>

				<button class="header__search-btn" value="Search">
					<i class="header__search-btn-icon fas fa-search"></i>
				</button>
			</form:form>
			<!-- Cart Layout -->
			<div class="header__cart">
				<div class="header__cart-wrap">
					<a href="${pageContext.request.contextPath}/user/cart"> <i
						class="header__cart-icon fas fa-shopping-cart"
						style="color: black;"></i></a>

					<%
						List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
					int count = 0;
					try {
						count = cart.size();
					} catch (Exception e) {
					}
					%>
					<c:if test="${pageContext.request.userPrincipal.name!=null}">
						<span class="header__cart-notice"><%=count%></span>
					</c:if>

				</div>
			</div>

		</div>

	</div>
</header>

<!--   <div class="text-center" style="background: #99ff99; padding-top: 30px">
	<ul class="list-inline pb-3">
		<li class="list-inline-item"><a
			class="text-decoration-none fs14 mr-3 text-deco text-dark text-uppercase opacity05 px-3 py-2 font-weight-bold"
			href="${pageContext.request.contextPath}/product/danhsach">Trang
				chủ</a></li>
		<li class="list-inline-item"><a
			class="text-decoration-none fs14 mr-3 text-deco text-dark text-uppercase opacity05 px-3 py-2 font-weight-bold"
			href="${pageContext.request.contextPath}/user/cart">Giỏ hàng</a></li>

	</ul>
</div>-->