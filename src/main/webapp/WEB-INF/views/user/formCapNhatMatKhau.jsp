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
					<h1>Nhập mật khẩu mới.</h1>
										<hr>
					<form action="capNhatMatKhau" method="post">
						<div class="form-group">
							<label>Tạo mật khẩu mới có tối thiểu 6 ký tự.</label> <br>
							<div>								
							<br>
								<input name="matKhau" type="password"
									Class="form-control fs14" placeholder="Nhập mật khẩu mới" />
							</div>
							<c:if test="${error!=null}">
								<div class="col-xs-offset-1 col-xs-10"
									style="color: red; padding-left: 20px;">${error}</div>
							</c:if>
						</div>
						<br>
						<div>
							<input type="submit" value="Tiếp tục" class="form-control fs14">
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>