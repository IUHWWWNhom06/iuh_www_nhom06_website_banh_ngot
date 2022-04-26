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
							<c:if test="${cate.id != null}">
								Cập nhật danh mục
							</c:if>
							<c:if test="${cate.id == null}">
								Thêm danh mục
							</c:if>	
							</div>
						</caption>
						
						<hr>
						<form:form action="${pageContext.request.contextPath}/admin/cate/save"
							method="post" modelAttribute="cate">
							<caption>
								<div class="form-group">
									<c:if test="${cate.id != null}">
										<label>ID</label>
										<form:input path="id" cssClass="form-control" readonly="true"/>
									</c:if>
									<c:if test="${cate.id == null}">
										<form:hidden path="id"/>
									</c:if>	
								</div>
							</caption>						
							<div class="form-group">
								<label>Danh mục</label>
								<form:input path="tenDanhMuc" cssClass="form-control" />
								<span style="color: red"><b><form:errors path="tenDanhMuc" ></form:errors> </b></span>
							</div>
							<div class="form-group">
								<button class="btn btn-danger">
									<a href="${pageContext.request.contextPath}/admin/cate/list">Hủy</a>
								</button>

								<caption>
							<button type="submit" class="btn btn-success">
							<c:if test="${cate.id != null}">
								Cập nhật
							</c:if>
							<c:if test="${cate.id == null}">
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
