<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="resources"></c:url>
<c:url var="ngay_desc" value="/admin/order/list">
	<c:param name="sort" value="ngay_desc" />
	<c:param name="search" value="${search}" />
</c:url>
<c:url var="ngay_asc" value="/admin/order/list">
	<c:param name="sort" value="ngay_asc" />
	<c:param name="search" value="${search}" />
</c:url>

<div class="content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
			<div class="row">
				<label class="col-lg-8 col-form-label">Tìm kiếm hóa đơn: </label>
				<label class="col-lg-4 col-form-label">Xắp xếp theo: </label>
			</div>
			<div class="row">
				<div class="col-lg-8">	
				<form:form action="list" method="GET"> 						
					<div class="input-group">						
						<input type="hidden" value="${sort}" name="sort"/>
						<input type="text" class="form-control" name="search" placeholder="Nhập từ khóa cần tìm kiếm..." />
						<button class="btn btn-light" type="submit"><i class="zmdi zmdi-search zmdi-hc-lg"></i></button>									
					</div>
				</form:form>
				</div>	
				<div class="col-lg-4">
					<select class="form-control valid" onchange="location = this.options[this.selectedIndex].value;">
						<option>Ngày</i></option>
						<option value="${ngay_asc}">Ngày: Từ thấp đến cao</option>
						<option value="${ngay_desc}">Ngày: Từ cao đến thấp</option>
					</select>
				</div>	
			</div>
			<br>
				<div class="card" style="background: transparent">
					<div class="card-body">
						<h5 class="card-title">Danh sách đơn hàng</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="text-white">
										<th scope="col">#</th>
										<th scope="col">Họ Tên</th>
										<th scope="col">SĐT</th>										
										<th scope="col">Phương thức thanh toán</th>
										<th scope="col">Ngày lập</th>
										<th scope="col">Xem chi tiết</th>

									</tr>
								</thead>
								<tbody class="text-white">
									<c:forEach items="${order}" var="order">
										<tr>
											<td scope="row">${order.id}</td>											
											<td>${order.hoTenKhachHang}</td>
											<td>${order.soDienThoaiGiaoHang}</td>
											<td><c:choose>
													<c:when
														test="${order.thanhToan.phuongThuc == 'COD'}">
														<c:out value="COD" />
													</c:when>
													<c:otherwise>
														<c:out value="Thẻ nội địa ATM" />
													</c:otherwise>
												</c:choose></td>
											<td>${order.ngayLap}</td>
											<td><a onClick="xemChiTiet('${order.id}')"
												data-toggle="modal" data-target="#xem-modal"><i
													class="zmdi zmdi-eye zmdi-hc-lg"></i> </a></td>
											<td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>		
						<br>
						 <div class="col-md-12">
						    <form action="${pageContext.request.contextPath}/admin/order/list" id="formSubmit" method="get">
							    <ul id="pagination" class="pagination"></ul>
							  	 <input type="hidden" value="" id="page" name="page"/>
							  	  <input type="hidden" value="${sort}" name="sort"/>
							  	  <input type="hidden" value="${search}" name="search"/>
								</form>
							</div>				
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade bd-example-modal-lg" id="xem-modal"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content" style="background-color: #0d5b80;">
			<div class="modal-body"
				style="background-color: #0d5b80; opacity: 0.9;">
				<div class="scroll">
					<h4 class="text-center">
						<label style="color: white; font-size: 20px;"> Chi tiết đơn hàng</label>
					</h4>
					<form>
					<h6>
						<label style="color: white;">Thông tin khách hàng</label>
					</h6>
						<div class="row mt-3">
							<div class="col-6">
								<div class="form-group row">
									<span class="col-sm-4 col-form-label">ID hóa đơn:</span>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="idHoaDon" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group row mt-3">
									<span class="col-sm-4 col-form-label">Số điện thoại:</span>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="sdt" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group row mt-3">
									<span class="col-sm-4 col-form-label">Ngày lập:</span>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="ngayLap" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
							</div>

							<div class="col-6">
								<div class="form-group row">
									<span class="col-sm-4 col-form-label">Email:</span>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="email" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group row mt-3">
									<span class="col-sm-4 col-form-label">Họ tên:</span>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="tenKH" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
							</div>

							<div class="col-12" style="margin-top: -15px;">
								<div class="form-group row mt-3">
									<span class="col-sm-2 col-form-label">Địa chỉ:</span>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="diaChi" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
							</div>
							<h6 style="margin-top: 15px; padding-left: 10px;">
								<label style="color: white;">Thông tin sản phẩm</label>
							</h6>
							<div class="table-responsive">
								<table class="table" style="opacity: 1">
									<thead>
										<tr>
											<th scope="col">ID</th>
											<th scope="col">Tên sản phẩm</th>											
											<th scope="col">Số lượng</th>
											<th scope="col">Giá</th>
											<th scope="col">Thuế(%)</th>
											<th scope="col">Giảm giá(%)</th>
											<th scope="col">Thành tiền</th>
										</tr>
									</thead>
									<tbody class="text-white" id="tableBody">
										<tr>
											<th scope="row">1</th>
											<td>iphone</td>
											<td><fmt:formatNumber type="number" pattern="#,###,###.##"
												value="" /></td>
											<td>1</td>
											<td>10%</td>
											<td>5%</td>
											<td>110000</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="col-12" style="margin-top: -15px;">
								<div class="form-group row mt-3">
									<span class="col-sm-2 col-form-label" style="color: white;font-size: 15px;">Tổng tiền:</span>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="tongTien" readonly="readonly" style="font-size: 14px;background-color: #0d5b80;padding-left: 0px;">
									</div>
								</div>
							</div>
						</div>

					</form>
					<button type="button" class="btn btn-danger" data-dismiss="modal"
						style="float: right">Đóng</button>
				</div>
			</div>

		</div>
	</div>
</div>

<c:url value="/resources" var="resources"></c:url>
<script src="${resources}/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${resources}/admin/js/order/order.js"></script>
<script type="text/javascript" src="${resources}/admin/js/pagination.min.js"></script>
<script type="text/javascript">
$('#pagination').pagination({
    total: ${total},
    current: ${page},
    length: 9,
    size: 1, 
    click: function(options,$target) {
    	$target.next("#page").val(options.current);
    	$('#formSubmit').submit();
    }
});
</script>