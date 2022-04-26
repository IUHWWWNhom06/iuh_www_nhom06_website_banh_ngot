function xemChiTiet(id) {

	const url = `api/users/${id}`;
	console.log('url: ', url);
	

	$.get(url, function(data, status) {
	
		const {id,tenNguoiDung,soDienThoai,diaChi,email,tenDangNhap,ngayTao} = data;	
		var currentTime = new Date(ngayTao);
		var month = currentTime.getMonth() + 1;
		var day = currentTime.getDate();
		var year = currentTime.getFullYear();
		var date = year + "-" + month + "-" + day;
		
		if (status === 'success') {
			$("#xem-modal #id").val(id);
			$("#xem-modal #ngayLap").val(date);
			$("#xem-modal #ten").val(tenNguoiDung);		
			$("#xem-modal #tenDangNhap").val(tenDangNhap);	
			$("#xem-modal #sdt").val(soDienThoai);
			$("#xem-modal #diaChi").val(diaChi);
			$("#xem-modal #email").val(email);
		}
	});
}
