<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="resources"></c:url>
<div class="content-wrapper">
	<div class="container-fluid">
		<!--End Row-->

		<div class="col-lg-12">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Danh sách bình luận</h5>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Email</th>
									<th scope="col">Sản Phẩm</th>
									<th style="width: 100%">Nội dung</th>
									<th scope="col">Ngày đánh giá</th>
									<th scope="col">Hành động</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${comments}" var="comment">
									<c:url value="/admin/comment/delete" var="delete">
										<c:param name="commentId" value="${comment.id }"></c:param>
									</c:url>
									<tr>
										<td scope="row">${comment.id}</td>
										<td>${comment.email}</td>
										<td>${comment.dienThoai.tenDT}<br> 
										GB: ${comment.dienThoai.thongSo.boNho}
										<br> Màu:
											${comment.dienThoai.mauSac }
										</td>
										<td>${comment.noiDung}</td>
										<td>${comment.ngay}</td>
										<td><a href="${delete}" onclick="return confirm('Bạn có chắn chắn xóa không?')"><i
												class="zmdi zmdi-delete zmdi-hc-lg"></i> </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

