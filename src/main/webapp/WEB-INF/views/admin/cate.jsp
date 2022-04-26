<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="content-wrapper">
	<div class="container-fluid">
		<!--End Row-->


		<div class="row">
			<div class="col-lg-12">
				<button class="add-catalog">
					<a href="${pageContext.request.contextPath}/admin/cate/showFormAdd">Thêm
						danh mục</a>
				</button>
			</div>
			<label for="tenDanhMuc" class="col-lg-12 col-form-label">Tên danh mục</label>
			<div class="col-lg-12">	
				<input type="text" class="form-control" id="timKiemTenDanhMuc" placeholder="Nhập tên danh mục" />
			</div>	
			<div class="col-lg-12">
				<div class="card" style="background: transparent">
					<div class="card-body">
						<h5 class="card-title">Danh sách danh mục</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="text-white">
										<th scope="col">#</th>
										<th colspan="2"></th>
										<th scope="col">Tên danh mục</th>
										<th scope="col">Hành động</th>

									</tr>
								</thead>
								<tbody class="text-white" id="tableBody">
									<c:forEach items="${cates}" var="cate">
										<c:url value="/admin/cate/showFormEdit" var="edit">
											<c:param name="cateId" value="${cate.id}"></c:param>
										</c:url>
										<c:url value="/admin/cate/delete" var="delete">
											<c:param name="cateId" value="${cate.id}"></c:param>
										</c:url>
										<tr>
											<td scope="row">${cate.id}</td>
											<td></td>
											<td></td>
											<td>${cate.tenDanhMuc}</td>
											<td>	
											&nbsp;
												<a href="${edit}"><i class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a>	
													&emsp;&nbsp;																																	
												<a onClick="xoa(${cate.id})" class="text-white"><i class="zmdi zmdi-delete zmdi-hc-lg"></i></a>
											</td>
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
</div>

<c:url value="/resources" var="resources"></c:url>
<script src="${resources}/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${resources}/admin/js/cate/category.js"></script>
