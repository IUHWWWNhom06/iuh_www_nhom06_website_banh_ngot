<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<c:url value="/resources" var="resources" />
	<div class="container-fluid">
		<br>
		<div class="container-fluid ">
			<div class="container-fluid ">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 border-danger">
						<div class="carousel slide" id="carouselExampleControl"
							data-ride="carousel">
							<ol class="carousel-indicators ">
								<li class="active" data-target="#carouselExampleControl"
									data-slide-to="0"></li>
								<li data-target="#carouselExampleControl" data-slide-to="1"></li>
								<li data-target="#carouselExampleControl" data-slide-to="2"></li>
								<li data-target="#carouselExampleControl" data-slide-to="3"></li>
								<li data-target="#carouselExampleControl" data-slide-to="4"></li>
								<li data-target="#carouselExampleControl" data-slide-to="5"></li>

							</ol>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="${resources}/user/images/apple.png" alt="First"
										class="d-block w-100">
								</div>
								<div class="carousel-item ">
									<img src="${resources}/user/images/galaxy1.png" alt="Second"
										class="d-block w-100">
								</div>
								<div class="carousel-item ">
									<img src="${resources}/user/images/iphone.png" alt="Third"
										class="d-block w-100">
								</div>
								<div class="carousel-item ">
									<img src="${resources}/user/images/phukien.png" alt="Fourth"
										class="d-block w-100">
								</div>
								<div class="carousel-item ">
									<img src="${resources}/user/images/samsung.png" alt="Fifth"
										class="d-block w-100">
								</div>
								<div class="carousel-item ">
									<img src="${resources}/user/images/vivo.png" alt="Fifth"
										class="d-block w-100">
								</div>

							</div>
							<a href="#carouselExampleControl" class="carousel-control-prev"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"> </span> <span
								class="sr-only">Previous</span>
							</a> <a href="#carouselExampleControl" class="carousel-control-next"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"> </span> <span
								class="sr-only">Next</span>
							</a>

						</div>

					</div>
				</div>

			</div>
		</div>

		<div class="container-fluid ">
			<div class="container-fluid "
				style="overflow: hidden; margin-top: 1%">
				<h3 style="float: left;">${countGiamGia} ĐIỆNTHOẠIĐANGGIẢMGIÁ</h3>
				<a class="btn btn-light" href="${pageContext.request.contextPath}/dienthoai/danhmuc" style="float: right;">
					<h3>Xem tất cả ></h3>
				</a>
			</div>
			<div class="container-fluid mt-3 mb-3 col1_2 ">
				<div class="row">
					<c:forEach var="dt" items="${dts}">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ">
							<div class="card text-center">
								<div class="dt">
									<div class="tragop">
										<label class="installment">Trả góp <b>0%</b></label>
									</div>
										<a class="btn" href="${pageContext.request.contextPath}/dienthoai/laychitiet/${dt.id}"
											style="text-decoration: none; color: black;">
											<img class="card-img-top"
												src="${resources}/user/images/SanPham/${dt.anhURL}"
												alt="Card image" style="width: 50%">
											<div class="card-body">
												<h4 class="card-title">
													<c:out value="${dt.tenDT} ${dt.thongSo.boNho}" />
												</h4>
												<p class="card-text">
													<span style="color: red;"> <b><fmt:formatNumber
																type="number" pattern="#,###,###.##"
																value="${(dt.giaDT*(100-dt.giamGia))/100}" /> đ </b> &nbsp;
														<strike><i> <fmt:formatNumber type="number"
																	pattern="#,###,###.##" value="${dt.giaDT}" /> đ
														</i></strike>
													</span><br>
												</p>
											</div>
											<div class="card-footer"
												style="bottom: 0; position: absolute; width: 90%; float: center; background-color: white;">
												<a class="btn btn-success btn-block fs14"
													href="${pageContext.request.contextPath}/user/themvaogiohang/${dt.id}">
													Thêm vào giỏ hàng </a>
											</div>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="container-fluid ">
			<div class="container-fluid "
				style="overflow: hidden; margin-top: 1%">
				<h3 style="float: left;">${countBanChay} ĐIỆNTHOẠIBÁNCHẠYNHẤT</h3>
				<a class="btn btn-light" href="${pageContext.request.contextPath}/dienthoai/danhmuc" style="float: right;">
					<h3>Xem tất cả ></h3>
				</a>
			</div>
			<div class="container-fluid mt-3 mb-3 col1_2 ">
				<div class="row">
					<c:forEach var="dt" items="${dtsbc}">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ">
							<div class="card text-center">
								<div class="dt">
									<div class="tragop">
										<label class="installment">Trả góp <b>0%</b></label>
									</div>
										<a class="btn" href="${pageContext.request.contextPath}/dienthoai/laychitiet/${dt.id}"
											style="text-decoration: none; color: black;">
											<img class="card-img-top"
												src="${resources}/user/images/SanPham/${dt.anhURL}"
												alt="Card image" style="width: 50%">
											<div class="card-body">
												<h4 class="card-title">
													<c:out value="${dt.tenDT} ${dt.thongSo.boNho}" />
												</h4>
												<p class="card-text">
													<span style="color: red;"> <b><fmt:formatNumber
																type="number" pattern="#,###,###.##"
																value="${(dt.giaDT*(100-dt.giamGia))/100}" /> đ </b> &nbsp;
														<strike><i> <fmt:formatNumber type="number"
																	pattern="#,###,###.##" value="${dt.giaDT}" /> đ
														</i></strike>
													</span><br>
												</p>
											</div>
											<div class="card-footer"
												style="bottom: 0; position: absolute; width: 90%; float: center; background-color: white;">
												<a class="btn btn-success btn-block"
													href="${pageContext.request.contextPath}/user/themvaogiohang/${dt.id}">
													Thêm vào gỏi hàng </a>
											</div>
										</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="container-fluid ">
			<div class="container-fluid "
				style="overflow: hidden; margin-top: 1%">
				<!-- Nav tabs -->
				<ul class="nav nav-pills" role="tablist">
					<c:forEach var="th" items="${ths}">
						<c:if test="${th.id == 1}">
							<li class="btn nav-item"><a
								class="nav-link active btn btn-outline-info" data-toggle="pill"
								href="#${th.tenTH}">${th.tenTH}</a></li>
						</c:if>
						<c:if test="${th.id != 1}">
							<li class="btn nav-item"><a
								class="nav-link btn btn-outline-info" data-toggle="pill"
								href="#${th.tenTH}">${th.tenTH}</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="container-fluid">
				<div class="row">
					<!-- Tab panes -->
					<div class="tab-content col-12 ">
						<c:forEach var="th" items="${ths}">
							<c:if test="${th.id == 1}">
								<div id="${th.tenTH}" class="tab-pane active">
									<c:forEach var="dt" items="${dienthoais}">
										<c:if test="${dt.thuongHieu.id == th.id}">
											<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 float-left">
												<div class="card text-center">
													<div class="dt">
														<div class="tragop">
															<label class="installment">Trả góp <b>0%</b></label>
														</div>
														<a class="btn" href="${pageContext.request.contextPath}/dienthoai/laychitiet/${dt.id}"
																style="text-decoration: none; color: black;">
																<img class="card-img-top"
																	src="${resources}/user/images/SanPham/${dt.anhURL}"
																	alt="Card image" style="width: 50%">
																<div class="card-body">
																	<h4 class="card-title">
																		<c:out value="${dt.tenDT} ${dt.thongSo.boNho}" />
																	</h4>
																	<p class="card-text">
																		<span style="color: red;"> <b><fmt:formatNumber
																					type="number" pattern="#,###,###.##"
																					value="${(dt.giaDT*(100-dt.giamGia))/100}" /> đ </b> &nbsp;
																			<strike><i> <fmt:formatNumber type="number"
																						pattern="#,###,###.##" value="${dt.giaDT}" /> đ
																			</i></strike>
																		</span><br>
																	</p>
																</div>
																<div class="card-footer"
																	style="bottom: 0; position: absolute; width: 90%; float: center; background-color: white;">
																	<a class="btn btn-success btn-block"
																		href="${pageContext.request.contextPath}/user/themvaogiohang/${dt.id}">
																		Thêm vào gỏi hàng </a>
																</div>
														</a>
													</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
							<c:if test="${th.id != 1}">
								<div id="${th.tenTH}" class="tab-pane fade">
									<c:forEach var="dt" items="${dienthoais}">
										<c:if test="${dt.thuongHieu.id == th.id}">
											<c:if test="${dt.soLuongTon>0 }">
											<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 float-left">
												<div class="card text-center">
													<div class="dt">
														<div class="tragop">
															<label class="installment">Trả góp <b>0%</b></label>
														</div>
														<a class="btn" href="${pageContext.request.contextPath}/dienthoai/laychitiet/${dt.id}"
																style="text-decoration: none; color: black;">
																<img class="card-img-top"
																	src="${resources}/user/images/SanPham/${dt.anhURL}"
																	alt="Card image" style="width: 50%">
																<div class="card-body">
																	<h4 class="card-title">
																		<c:out value="${dt.tenDT} ${dt.thongSo.boNho}" />
																	</h4>
																	<p class="card-text">
																		<span style="color: red;"> <b><fmt:formatNumber
																					type="number" pattern="#,###,###.##"
																					value="${(dt.giaDT*(100-dt.giamGia))/100}" /> đ </b> &nbsp;
																			<strike><i> <fmt:formatNumber type="number"
																						pattern="#,###,###.##" value="${dt.giaDT}" /> đ
																			</i></strike>
																		</span><br>
																	</p>
																</div>
																<div class="card-footer"
																	style="bottom: 0; position: absolute; width: 90%; float: center; background-color: white;">
																	<a class="btn btn-success btn-block"
																		href="${pageContext.request.contextPath}/user/themvaogiohang/${dt.id}">
																		Thêm vào gỏi hàng </a>
																</div>
														</a>
													</div>
												</div>
											</div>
											</c:if>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<!--------------------------------------------------FOOOTER----------------------------------------------------------------->
	</div>
</body>

</html>