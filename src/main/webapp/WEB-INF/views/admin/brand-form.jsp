<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-8">
				<div class="card" style="background: transparent">
					<div class="card-body">
					<caption>
							<div class="card-title">
							<c:if test="${brand.id != null}">
								Cập nhật thương hiệu
							</c:if>
							<c:if test="${brand.id == null}">
								Thêm thương hiệu
							</c:if>	
							</div>
						</caption>
						
						<hr>
						<form:form action="${pageContext.request.contextPath}/admin/brand/save"
							method="post" modelAttribute="brand">
							<caption>
								<div class="form-group">
									<c:if test="${brand.id != null}">
										<label>ID</label>
										<form:input path="id" cssClass="form-control" readonly="true"/>
										
									</c:if>
									<c:if test="${brand.id == null}">
										<form:hidden path="id"/>
									</c:if>	
								</div>
							</caption>						
							<div class="form-group">
								<label>Thương hiệu</label>
								<form:input path="tenTH" cssClass="form-control" />
								<span style="color: red"><form:errors path="tenTH" ></form:errors> </span>
							</div>
							<div class="form-group">
								<label>Xuất xứ</label>
								<form:input path="xuatXu" cssClass="form-control" />
									<span style="color: red"><form:errors path="xuatXu" ></form:errors> </span>
							</div>
							<div class="form-group">
								<button class="btn btn-danger">
									<a href="${pageContext.request.contextPath}/admin/brand/list">Hủy</a>
								</button>

								<caption>
							<button type="submit" class="btn btn-success">
							<c:if test="${brand.id != null}">
								Cập nhật
							</c:if>
							<c:if test="${brand.id == null}">
								Thêm
							</c:if>	
							</button>
						</caption>
							</div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
