<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<%-- <div class="col-lg-12">
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/user/showFormAdd">Thêm User</a></button>
          </div> --%>
			<div class="col-lg-12">
				<div class="card" style="background: transparent">
					<div class="card-body">
						<h5 class="card-title">Danh sách Admin</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="text-white">
										<th scope="col">#</th>
										<th scope="col">Tên đăng nhập</th>
										<th scope="col">Số điện thoại</th>										
										<th scope="col">Ngày tạo</th>
										<th scope="col">Hành động</th>

									</tr>
								</thead>
								<tbody class="text-white">
									<c:forEach items="${admin}" var="admin">
									<c:if test="${admin.vaiTro=='ROLE_ADMIN'}">
											<c:url value="/admin/admin/showFormEdit" var="edit">
												<c:param name="adminId" value="${admin.id}"></c:param>
											</c:url>
											<tr>
												<td scope="row">${admin.id}</td>
												<td>${admin.tenDangNhap}</td>												
												<td>${admin.soDienThoai}</td>											
												<td>${admin.ngayTao}</td>
												<td>											
														&nbsp;<a onClick="xemChiTiet('${admin.id}')"
												data-toggle="modal" data-target="#xem-modal"><i
													class="zmdi zmdi-eye zmdi-hc-lg"></i> </a>&nbsp;&emsp;	
														<a href="${edit}"><i class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a>
												</td>
											</tr>
									</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>

<div class="modal fade" id="xem-modal"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="background-color: #0d5b80;">
			<div class="modal-body"
				style="background-color: #0d5b80; opacity: 0.9;">
				<div class="scroll">
					<h4 class="text-center">
						<label style="color: white; font-size: 20px;"> Chi tiết người dùng</label>
					</h4>
					<form>					
						<div class="row mt-3">
							<div class="col-6">
								<div class="form-group">
									<span class="col-sm-12 col-form-label">ID:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="id" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Họ tên:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="ten" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Tên đăng nhập:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="tenDangNhap" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
							</div>

							<div class="col-6">
								<div class="form-group">
									<span class="col-sm-12 col-form-label">Email:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="email" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Số điện thoại:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="sdt" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
								
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Ngày lập:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="ngayLap" readonly="readonly" style="font-size: 14px;">
									</div>
								</div>
							</div>

							<div class="col-12" style="margin-top: -15px;">
								<div class="form-group mt-3">
									<span class="col-sm-12 col-form-label">Địa chỉ:</span>
									<div class="col-sm-12">
										<input type="text" class="form-control" id="diaChi" readonly="readonly" style="font-size: 14px;">
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
<script type="text/javascript" src="${resources}/admin/js/account/account.js"></script>

