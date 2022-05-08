<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<div class="login fs14">
					<h2>Cám ơn bạn đã mua sản phẩm tại shop của chúng tôi!</h2>
					<hr>
					<h3>Click vào đây để tiếp tục mua hàng 
					<a href="${pageContext.request.contextPath}/banhngot/danhsach"><button
								class="btn btn-outline-warning text-uppercase mt-2 fs14" style="color: black">Mua hàng</button></a>
					</h3>
				</div>
			</div>
		</div>
	</div>
</body>
</html>