<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources/admin" var="url" />
<div id="sidebar-wrapper" data-simplebar=""
	data-simplebar-auto-hide="true">
	<div class="brand-logo">
		<a href="${pageContext.request.contextPath}/admin/trang-chu"> <img
			src="${url}/images/logo-icon.png" class="logo-icon" alt="logo icon">
			<h5 class="logo-text">Admin Web Điện thoại</h5>
		</a>
	</div>
	<ul class="sidebar-menu do-nicescrol">
		<li class="sidebar-header">MENU ADMIN</li>
		<li><a href="${pageContext.request.contextPath}/admin/trang-chu">
				<i class="zmdi zmdi-view-dashboard"></i> <span>Tổng quan</span>
		</a></li>

		<li><a href="${pageContext.request.contextPath}/admin/admin/list">
				<i class="zmdi zmdi-account-box"></i> <span>Quản lí Admin</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/user/list">
				<i class="zmdi zmdi-accounts"></i> <span>Quản lí User</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/cate/list">
				<i class="zmdi zmdi-grid"></i> <span>Danh Mục</span>
		</a></li>
		<li><a
			href="${pageContext.request.contextPath}/admin/product/list"> <i
				class="zmdi zmdi-widgets"></i> <span>Danh Sách Sản Phẩm</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/order/list">
				<i class="zmdi zmdi-shopping-cart"></i> <span>Đơn Hàng</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/brand/list">
				<i class="zmdi zmdi-store"></i> <span>Thương hiệu</span>
		</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/comment/list">
				<i class="zmdi zmdi-calendar-check"></i> <span>Bình luận</span>
		</a></li>

	</ul>
</div>
<header class="topbar-nav">
	<nav class="navbar navbar-expand fixed-top">
		<ul class="navbar-nav mr-auto align-items-center">
			<li class="nav-item"></li>
		</ul>

		<ul class="navbar-nav align-items-center right-nav-link">
			<li class="nav-item"><a
				class="nav-link dropdown-toggle dropdown-toggle-nocaret"
				data-toggle="dropdown" href="#"> <span class="user-profile"><img
						src="${url}/images/avatar-admin.png" class="img-circle"
						alt="user avatar"></span>
			</a>
				<ul class="dropdown-menu dropdown-menu-right">
					<li class="dropdown-item user-details"><a
						href="javaScript:void();">
							<div class="media">
								<div class="avatar">
									<img class="align-self-start mr-3"
										src="${url}/images/avatar-admin.png" alt="user avatar">
								</div>
								<div class="media-body">
									<h6 class="mt-2 user-title">Xin chào!</h6>
									
									<b> Admin: <security:authentication property="principal.username"/> </b>
									
								</div>
							</div>
					</a></li>

					<li class="dropdown-divider"></li>
					<li class="dropdown-item">
					<form:form action="${pageContext.request.contextPath}/logout" method="POST">
						<i class="icon-power mr-2"> </i> <input type="submit" value="Logout" /> 
					</form:form></li>
				</ul></li>
		</ul>
	</nav>
</header>