<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="clearfix"></div>
<div class="content-wrapper">
	<div class="container-fluid">
		<div class="card mt-3" style="background: transparent">
			<div class="card-content">
				<div class="row row-group m-0">
				<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">			
												
								<fmt:formatNumber type="number" pattern="#,###,###.##" value="${doanhThu}" />
								<span class="float-right">VNĐ</span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 0%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Doanh thu (theo tháng)
							</p>
						</div>
					</div>
							
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">			
												
								<fmt:formatNumber type="number" pattern="#,###,###.##" value="${loiNhuan}" />
								<span class="float-right">VNĐ</span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 0%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Lợi nhuận (theo tháng)							
								<c:if test="${phanTram > 0 }">
									<span class="float-right"> +<fmt:formatNumber type="number" pattern="#,###,###.##" value="${phanTram}"/>%
										<i class="zmdi zmdi-long-arrow-up"></i>								
									</span>
								</c:if>
								<c:if test="${phanTram < 0 }">
									<span class="float-right"><fmt:formatNumber type="number" pattern="#,###,###.##" value="${phanTram}"/>%
										<i class="zmdi zmdi-long-arrow-down"></i>								
									</span>
								</c:if>											
							</p>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								${sl} <span class="float-right"><i
									class="fa fa-shopping-cart"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 0%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Đơn hàng (theo tháng)<span class="float-right">+4.2% <i
									class="zmdi zmdi-long-arrow-up"></i></span>
							</p>
						</div>
					</div>		
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								${soLuongBan } <span class="float-right"><i class="fa fa-envira"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 0%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Bán ra (theo tháng)<span class="float-right"></span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12 col-lg-5 col-xl-5">
				<div class="card">
					<div class="card-header">Danh mục bán chạy</div>
					<div class="card-body">
						<div class="chart-container-2">
							<canvas id="chart2"></canvas>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table align-items-center">
						<thead>
									<tr class="text-white">
										<th scope="col">Tên</th>
										<th scope="col">Số lượng bán</th>
									</tr>
						</thead>
							<tbody>
								<tr>
									<td><i class="fa fa-circle text-white mr-2"></i>
										<span id="top1"></span>
									</td>
									<td>
										<span id="gia1"></span>
									</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-1 mr-2" ></i>
										<span id="top2"></span>
									</td>
									<td>
										<span id="gia2"></span>
									</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-2 mr-2" ></i>
										<span id="top3"></span>
									</td>
									<td>
										<span id="gia3"></span>
									</td>
								</tr>
								<tr>
									<td><i class="fa fa-circle text-light-3 mr-2"></i>
										<span id="top4"></span>
									</td>
									<td>
										<span id="gia4"></span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<c:url value="/resources" var="resources"></c:url>
<script src="${resources}/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${resources}/admin/js/index.js"></script>