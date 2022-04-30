<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="resources" />
<div class="container-fluid">
	<!-- Page Content-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 col-md-12">
				<nav class="category">

					<h3 class="category__heading">
						<i class="category__heading-icon fas fa-list"></i> Danh Mục
					</h3>
					<ul class="category-list">
						<c:forEach var="dm" items="${dms}">
							<c:if test="${iddanhmuc != dm.id}">
								<li class="category-item"><a
									href="${pageContext.request.contextPath}/dienthoai/danhmuc/${dm.id}"
									class="category-item__link text-decoration-none">${dm.tenDanhMuc}</a>
								</li>
							</c:if>
							<c:if test="${iddanhmuc == dm.id}">
								<li class="category-item"><a
									href="${pageContext.request.contextPath}/dienthoai/danhmuc/${dm.id}"
									class="category-item__link text-decoration-none bg-warning text-white">${dm.tenDanhMuc}</a>
								</li>
							</c:if>

						</c:forEach>
					</ul>
				</nav>
			</div>
			<div class="col-lg-9 col-md-12">
				<div class="col-12">
					<c:forEach items="${dts}" var="dt">
						<div class="col-3 home-product-item-wrapper float-left">

							<a class="home-product-item pb-3 text-deco 	"
								style="padding-top: 15px;"
								href="${pageContext.request.contextPath}/dienthoai/laychitiet/${dt.id}">
								<div class="home-product-item-img"
									style="background-image: url(${resources}/user/images/SanPham/${dt.anhURL}); width: 90%;"></div>
								<h4 class="home-product-item__name">${dt.tenDT}
									</h4> <c:if test="${dt.giamGia>0}">
									<div class="home-product-item__price">
										<span class="home-product-item__price-old"><fmt:formatNumber
												type="number" pattern="#,###,###.##" value="${dt.giaDT}" />
											đ</span> <span class="home-product-item__price-current"
											style="color: red;"><fmt:formatNumber type="number"
												pattern="#,###,###.##"
												value="${(dt.giaDT*(100-dt.giamGia))/100}" /> đ </span>
									</div>
								</c:if> <c:if test="${dt.giamGia<=0}">
									<div class="home-product-item__price">
										<span class="home-product-item__price-current float-right"><fmt:formatNumber
												type="number" pattern="#,###,###.##" value="${dt.giaDT}" />
											đ </span>
									</div>
								</c:if>
							
								<div class="home-product-item__favorite">
									<i class="fas fa-check"></i> <span>Yêu thích</span>
								</div> <c:if test="${dt.giamGia>0}">
									<div class="home-product-item__sale-off">
										<span class="home-product-item__percent">${dt.giamGia}</span>
										<span class="home-product-item__label">GIẢM</span>
									</div>
								</c:if>
							</a> <a class="btn btn-success btn-block fs14"
								href="${pageContext.request.contextPath}/user/themvaogiohang/${dt.id}">
								Thêm vào giỏ hàng </a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
