<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-12">
						<form:form action="search" method="GET">
							<div class="input-group">
								<input type="text" class="form-control" name="search"
									placeholder="Nhập từ khóa cần tìm kiếm..." />
								<button class="btn btn-light" type="submit">
									<i class="zmdi zmdi-search zmdi-hc-lg"></i>
								</button>
							</div>
						</form:form>
					</div>
				</div>
				<br>
				<div class="card" style="background: transparent">
					<c:if test="${not empty datHang}">
						<div class="card-body">
							<h5 class="card-title">Danh sách người dùng đã đặt hàng</h5>
							<div class="table-responsive">
								<table class="table table-striped">
									<thead>
										<tr class="text-white">
											<th scope="col">#</th>
											<th scope="col">Tên đăng nhập</th>
											<th scope="col">SĐT</th>
											<th scope="col">Ngày tạo</th>
											<th scope="col">Hành động</th>

										</tr>
									</thead>
									<tbody class="text-white">
										<c:forEach items="${datHang}" var="user">
											<c:if test="${user.vaiTro=='ROLE_USER'}">
												<c:url value="/admin/user/showFormEdit" var="edit">
													<c:param name="userId" value="${user.id}"></c:param>
												</c:url>
												<c:url value="/admin/user/delete" var="delete">
													<c:param name="userId" value="${user.id}"></c:param>
												</c:url>
												<tr>
													<td scope="row">${user.id}</td>
													<td>${user.tenDangNhap}</td>
													<td>${user.soDienThoai}</td>
													<td>${user.ngayTao}</td>
													<td>&nbsp;<a onClick="xemChiTiet('${user.id}')"
														data-toggle="modal" data-target="#xem-modal"><i
															class="zmdi zmdi-eye zmdi-hc-lg"></i> </a>&nbsp;&emsp; <a
														href="${edit}"><i
															class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a>


													</td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty chuaDatHang}">
						<div class="card-body">
							<h5 class="card-title">Danh sách người dùng chưa đặt hàng</h5>
							<div class="table-responsive">
								<table class="table table-striped">
									<thead>
										<tr class="text-white">
											<th scope="col">#</th>
											<th scope="col">Tên đăng nhập</th>
											<th scope="col">SĐT</th>
											<th scope="col">Ngày tạo</th>
											<th scope="col">Hành động</th>

										</tr>
									</thead>
									<tbody class="text-white">
										<c:forEach items="${chuaDatHang}" var="user">
											<c:if test="${user.vaiTro=='ROLE_USER'}">
												<c:url value="/admin/user/showFormEdit" var="edit">
													<c:param name="userId" value="${user.id}"></c:param>
												</c:url>
												<c:url value="/admin/user/delete" var="delete">
													<c:param name="userId" value="${user.id}"></c:param>
												</c:url>
												<tr>
													<td scope="row">${user.id}</td>
													<td>${user.tenDangNhap}</td>
													<td>${user.soDienThoai}</td>
													<td>${user.ngayTao}</td>
													<td><a onClick="xemChiTiet('${user.id}')"
														data-toggle="modal" data-target="#xem-modal"><i
															class="zmdi zmdi-eye zmdi-hc-lg"></i> </a>&nbsp; <a
														href="${edit}"><i
															class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a> &nbsp; <a
														onclick="return confirm('Bạn có chắn chắn xóa không?')"
														href="${delete}"><i
															class="zmdi zmdi-delete zmdi-hc-lg"></i></a></td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>


<div class="modal fade" id="xem-modal" style="display: none;"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="background-color: #0d5b80;">
			<div class="modal-body"
				style="background-color: #0d5b80; opacity: 0.9;">
				<div class="scroll">
					<h4 class="text-center">
						<label style="color: white; font-size: 20px;"> Chi tiết
							người dùng</label>
					</h4>
					<form>
						<div class="row mt-3">
							<div class="col-6">
								<div class="form-group">
									<span class="col-sm-12 col-form-label">ID:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="id"
											readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Họ tên:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="ten"
											readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Tên đăng nhập:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="tenDangNhap"
											readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
							</div>

							<div class="col-6">
								<div class="form-group">
									<span class="col-sm-12 col-form-label">Email:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="email"
											readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Số điện thoại:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="sdt"
											readonly="readonly" style="font-size: 14px;">
									</div>
								</div>

								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Ngày lập:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="ngayLap"
											readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
							</div>

							<div class="col-12" style="margin-top: -15px;">
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Địa chỉ:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="diaChi"
											readonly="readonly" style="font-size: 14px;">
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
<script type="text/javascript"
	src="${resources}/admin/js/account/account.js"></script>
