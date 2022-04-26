<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="resources"></c:url>
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row ">			
			<div class="col-lg-12">
				<button class="add-catalog">
					<a href="${pageContext.request.contextPath}/admin/product/showFormAdd">Thêm sản phẩm</a>
				</button>
			</div>
			<label for="tenDienThoai" class="col-lg-12 col-form-label">Tên điện thoại</label>
			<div class="col-lg-12">	
				<input type="text" class="form-control" id="timKiemTendienThoai" placeholder="Nhập tên điện thoại" />
			</div>			
			<div class="col-lg-12 mt-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Danh sách sản phẩm</h5>
						<div class="table-responsive">
							<table class="table" style="opacity: 1">
								<thead>
									<tr class="text-white">
										<th scope="col">#</th>
										<th scope="col">Hình ảnh</th>
										<th scope="col">Tên điện thoại</th>									  
										<th scope="col">Giá</th>
										<th scope="col">Số lượng</th>
										<th scope="col">Giảm giá</th>
										<th scope="col">Xem</th>
										<th scope="col">Hành động</th>
									</tr>
								</thead>
								<tbody class="text-white" id="tableBody">
									<c:forEach items="${productList}" var="product">
										<c:url value="/admin/product/showFormEdit" var="edit">
											<c:param name="productId" value="${product.id}"></c:param>
										</c:url>
										<c:url value="/admin/product/delete" var="delete">
											<c:param name="productId" value="${product.id}"></c:param>
											<c:param name="productDetailId" value="${product.thongSo.id}"></c:param>
										</c:url>
										<c:url value="/admin/product/list" var="detail">
										</c:url>
										<tr>
											<th scope="row">${product.id}</th>
											<td><img style="width: 110px; height: 67px; border: 1px solid #fff;"
												src="${resources}/user/images/SanPham/${product.anhURL}"></td>
											<td>${product.tenDT} ${product.thongSo.boNho } </td>
											 
											<td><fmt:formatNumber type="number" pattern="#,###,###.##"
												value="${product.giaDT}" />  đ</td>
											<td>${product.soLuongTon}</td>
											<td>${product.giamGia }%</td>

											<td><a onClick="xemChiTiet('${product.id}')"
												data-toggle="modal" data-target="#xem-modal"><i class="zmdi zmdi-eye zmdi-hc-lg"></i> </a></td>
											<td>											
													<a href="${edit}"><i class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a>	
													&emsp;&nbsp;																																	
													<a onClick="xoa(${product.id})" class="text-white"><i class="zmdi zmdi-delete zmdi-hc-lg"></i>
													</a>				
											</td>
										</tr>

									</c:forEach>

								</tbody>
							</table>
						</div>
						<br />	
						    <div class="col-md-12">
						    <form action="${pageContext.request.contextPath}/admin/product/list" id="formSubmit" method="get">
							    <ul id="pagination" class="pagination"></ul>
							  	 <input type="hidden" value="" id="page" name="page"/>
								</form>
							</div>
											    
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="xem-modal" style="display: none;"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="background-color: #0d5b80;">
			<div class="modal-body" >
				<div class="scroll">
					<h4 class="text-center ">
						Thông số kỹ thuật chi tiết<br>${product.tenDT}
					</h4>
					
					<ul class="parameterfull">
						<li>
							<div style="text-align: center;">										
								<img id="anh" src=""  width="300" height="250">
							</div>
						</li>
						<li><span>Màn hình</span>
							<div><label id="manHinh"> </label></div>
						</li>
						
						<li><span>Hệ điều hành</span>
							<div>
								<label id="heDieuHanh"> </label>
							</div>
						</li>
						<li><span>Độ phân giải Camera</span>
							<div>
								<label id="camera"></label>
							</div>
						</li>
						<li><span>Ram</span>
							<div>
								<label id="ram"></label>
							</div>
						</li>
						<li><span>Bộ nhớ trong</span>
							<div>
								<label id="boNho"></label>
							</div>
						</li>
						<li><span>Sim</span>
							<div>
								<label id="sim"></label>
							</div>
						</li>
						<li><span>Pin</span>
							<div>
								<label id="pin"></label>
							</div>
						</li>
						<li><span>Trọng lượng</span>
							<div>
								<label id="trongLuong"></label>
							</div>
						</li>
						<li><span>Kích thước</span>
							<div>
								<label id="kichThuoc"></label>
							</div>
						</li>
						<li><span>Màu sắc</span>
							<div>
								<label id="mauSac"></label>
							</div>
						</li>
						<li><span>Thương hiệu</span>
							<div>
								<label id="thuongHieu"></label>
							</div>
						</li>
						<li><span>Xuất xứ</span>
							<div>
								<label id="xuatXu"></label>
							</div>
						</li>
						
					</ul>
					<button type="button" class="btn btn-danger" data-dismiss="modal" style="float: right">Đóng</button>
				</div>
			</div>

		</div>
	</div>
</div>

<script src="${resources}/admin/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${resources}/admin/js/product/productt.js"></script>
<script type="text/javascript" src="${resources}/admin/js/pagination.min.js"></script>
<script type="text/javascript">
$('#pagination').pagination({
    total: ${total},
    current: ${page},
    length: 7,
    size: 1, 
    click: function(options,$target) {
    	$target.next("#page").val(options.current);
    	$('#formSubmit').submit();
    }
});
</script>