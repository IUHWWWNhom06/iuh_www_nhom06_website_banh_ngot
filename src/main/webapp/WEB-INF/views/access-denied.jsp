<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#error .area {
  display: inline;
  float: left;
  text-align: center;
  width: 100%;
}
#error .area h2 {

  display: inline-block;
  font-size: 150px;
  line-height: 150px;
  margin-bottom: 30px;
  text-shadow: 0 2px 2px #ddd;
}
#error .area span {
  color: #000;
  display: block;
  font-size: 30px;
  font-weight: bold;
  margin-bottom: 20px;
  text-shadow: 1px 1px 3px #ddd;
}

#error .area a {
  border: 1px solid #ccc;
  display: inline-block;
  font-size: 16px;
  font-weight: bold;
  letter-spacing: 0.5px;
  margin-top: 30px;
  padding: 10px 15px;

}
</style>
</head>
<body>

	<section id="error">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="area">
            <h2>403</h2>
            <span>Bạn không có quyền truy cập!</span>
            <a href="${pageContext.request.contextPath}/product/danhsach"> Trở về trang chủ</a>
          </div>
        </div>
      </div>
    </div>
  </section>
</body>
</html>