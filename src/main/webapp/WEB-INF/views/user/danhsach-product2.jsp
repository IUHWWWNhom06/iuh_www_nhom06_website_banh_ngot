<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="resources" />
<!-- Để lấy link có đuôi -->
<c:url var="linkgia_asc" value="/product/danhsach">
	<c:param name="sort" value="gia_asc" />
	<c:param name="search" value="${search}" />
</c:url>
<c:url var="linkgia_desc" value="/product/danhsach">
	<c:param name="sort" value="gia_desc" />
	<c:param name="search" value="${search}" />
</c:url>
<c:url var="linkgiamgia" value="/product/danhsach">
	<c:param name="sort" value="giamgia" />
	<c:param name="search" value="${search}" />
</c:url>


<div class="mt-3">
	<div class="app-body">
		<div class="container-fluid">
			<div class="row">
				<div class="col-2">
					<nav class="category">
						<h3 class="category__heading">
							<i class="category__heading-icon fas fa-list"></i> Loại bánh
						</h3>
						<ul class="category-list">
							<c:forEach var="dm" items="${dms}">
								<form:form
									action="${pageContext.request.contextPath}/product/danhmuc"
									method="get">
									<input type="hidden" value="${sort}" name="sort" />
									<input type="hidden" value="${dm.tenDanhMuc}" name="search" />
									<li class="category-item">
										<div class="list-group">
											<button type="submit"
												class="list-group-item list-group-item-action fs16"
												style="width: 200; border-bottom: 1px solid #c3c3c3;">${dm.tenDanhMuc}</button>
										</div>
									</li>
								</form:form>

							</c:forEach>
						</ul>
					</nav>
				</div>
				<div class="col-10">
					<div class="row">
						<div class="col-12">
							<div class="home-filter hide-on-mobile-tablet">
								<span class="home-filter__label fs14">Sắp xếp theo</span>
								<c:if test="${param.sort=='giamgia' }">
									<a class="text-dark" href="${linkgiamgia}"><button
											class="home-filter-btn btn btn-warning fs14">Giảm
											giá</button></a>
								</c:if>
								<c:if test="${param.sort!='giamgia' }">
									<a class="text-dark" href="${linkgiamgia}"><button
											class="home-filter-btn btn fs14">Giảm giá</button></a>
								</c:if>
							
								<div class="select-input">
									<span class="select-input-price"> <c:if
											test="${param.sort =='gia_asc'}"> Giá: Thấp đến cao</c:if> <c:if
											test="${param.sort =='gia_desc'}"> Giá: Cao đến thấp</c:if> <c:if
											test="${!param.sort}"> Giá </c:if>
									</span> <i class="select-input-icon fas fa-angle-down"></i>
									<ul class="select-input-list">
										<li class="select-input-item"><a href="${linkgia_asc}"
											class="select-input-link text-decoration-none">Giá: Thấp
												đến cao <i class="select-input-item-icon fas fa-arrow-up"></i>
										</a></li>
										<li class="select-input-item"><a href="${linkgia_desc}"
											class="select-input-link">Giá: Cao đến thấp <i
												class="select-input-item-icon fas fa-arrow-down"></i></a></li>
									</ul>
								</div>
								
							</div>
						</div>
					</div>
					<div class="home_product">
						<div class="row">
							<c:forEach var="item" items="${products}">
								<div class="col-3 home-product-item-wrapper">

									<a class="home-product-item pb-3 text-deco 	"
										style="padding-top: 15px;"
										href="${pageContext.request.contextPath}/product/danhsach">
										<div class="home-product-item-img"
											style="background-image: url(${resources}/user/images/SanPham/${item.anhURL}); width: 90%;"></div>
										<h4 class="home-product-item__name">${item.name}
											</h4> <c:if test="${item.giamGia>0}">
											<div class="home-product-item__price">
												<span class="home-product-item__price-old"><fmt:formatNumber
														type="number" pattern="#,###,###.##" value="${item.giaDT}" />
													đ</span> <span class="home-product-item__price-current"
													style="color: red;"><fmt:formatNumber type="number"
														pattern="#,###,###.##"
														value="${(item.giaDT*(100-item.giamGia))/100}" /> đ </span>
											</div>
										</c:if> <c:if test="${item.giamGia<=0}">
											<div class="home-product-item__price">
												<span class="home-product-item__price-current float-right"><fmt:formatNumber
														type="number" pattern="#,###,###.##" value="${item.giaDT}" />
													đ </span>
											</div>
										</c:if>
								
										 <c:if test="${item.giamGia>0}">
											<div class="home-product-item__sale-off">
												<span class="home-product-item__percent">${item.giamGia}</span>
												<span class="home-product-item__label">GIẢM</span>
											</div>
										</c:if>
									</a> <a class="btn btn-success btn-block fs14"
										href="${pageContext.request.contextPath}/user/themvaogiohang/${item.id}">
										Thêm vào giỏ hàng </a>
								</div>
							</c:forEach>

						</div>
						<br>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="${resources}/user/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${resources}/user/js/pagination.min.js"></script>
