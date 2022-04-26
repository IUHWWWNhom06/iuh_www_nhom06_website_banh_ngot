<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Start header section -->
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-12">
				<div class="card" style="background: transparent">
					<div class="card-body">
						<div class="card-title">Sửa User</div>
						<hr>
						<form:form
							action="${pageContext.request.contextPath}/admin/user/save"
							method="post" modelAttribute="user">
							<form:hidden path="matKhau"/>
							<form:hidden path="vaiTro"/>
							<caption>
								<div class="form-group">
									<c:if test="${user.id != null}">
										<label>ID</label>
										<form:input path="id" cssClass="form-control" readonly="true"/>
									</c:if>
									<c:if test="${user.id == null}">
										<form:hidden path="id"/>
									</c:if>	
								</div>
							</caption>
							<div class="form-group">
								<label>Họ tên</label>
								<form:input path="tenNguoiDung" cssClass="form-control" />
								<span style="color: red"><form:errors path="tenNguoiDung" ></form:errors> </span>
							</div>
							<div class="form-group">
								<label>Tên đăng nhập</label>
								<form:input path="tenDangNhap" cssClass="form-control" />
								<span style="color: red"><form:errors path="tenDangNhap" ></form:errors> </span>
							</div>
							<div class="form-group">
								<label>Email</label>
								<form:input path="email" cssClass="form-control" />
								<span style="color: red"><form:errors path="email" ></form:errors> </span>
							</div>
							<div class="form-group">
								<label>Số điện thoại</label>
								<form:input path="soDienThoai" cssClass="form-control" />
								<span style="color: red"><form:errors path="soDienThoai" ></form:errors> </span>
							</div>
							<div class="form-group">
								<label>Địa chỉ</label>
								<form:input path="diaChi" cssClass="form-control" />
								<span style="color: red"><form:errors path="diaChi" ></form:errors> </span>
							</div>

							<div class="form-group">
								<label>Ngày tạo</label>
								<form:input path="ngayTao" cssClass="form-control"  readonly="true"/>
							</div>
							
							<div class="form-group">
								<button class="btn btn-danger">
									<a href="${pageContext.request.contextPath}/admin/user/list">Hủy</a>
								</button>

								<button type="submit" class="btn btn-success">Cập nhật</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>
