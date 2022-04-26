<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="content-wrapper">
	<div class="container-fluid">
		<!--End Row-->


		<div class="row">
			<div class="col-lg-12">
				<button class="add-catalog">
					<a href="${pageContext.request.contextPath}/admin/brand/showFormAdd">Thêm
						thương hiệu</a>
				</button>
			</div>
			<label class="col-lg-12 col-form-label">Tên danh mục</label>
			<div class="col-lg-12">
				<div class="card" style="background: transparent">
					<div class="card-body">
						<h5 class="card-title">Danh sách thương hiệu</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr class="text-white">
										<th scope="col">#</th>
										<th colspan="2"></th>
										<th scope="col">Tên thương hiệu</th>
										<th scope="col">Xuất xứ</th>
										<th scope="col">Hành động</th>

									</tr>
								</thead>
								<tbody class="text-white" id="tableBody">
									<c:forEach items="${brands}" var="brand">
										<c:url value="/admin/brand/showFormEdit" var="edit">
											<c:param name="brandId" value="${brand.id}"></c:param>
										</c:url>
										<c:url value="/admin/brand/delete" var="delete">
											<c:param name="brandId" value="${brand.id}"></c:param>
										</c:url>
										<tr>
											<td scope="row">${brand.id}</td>
											<td></td>
											<td></td>
											<td>${brand.tenTH}</td>
											<td>${brand.xuatXu }</td>											
											<td>	
											&nbsp;
												<a href="${edit}"><i class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a>	
													&emsp;&nbsp;																																	
												<a onClick="xoa(${brand.id})" class="text-white" id="xoa">	<i class="zmdi zmdi-delete zmdi-hc-lg"></i></a>
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
<script type="text/javascript" src="${resources}/admin/js/brand/brand.js"></script>
