function xemChiTiet(id) {

	const url = `api/orderdetails/${id}`;
	console.log('url: ', url);
	
	const numberFormat = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND',});
	
	$.get(url, function(data, status) {
	
		const {hoaDon} = data;	
		var currentTime = new Date(data[0].hoaDon.ngayLap);
		var month = currentTime.getMonth() + 1;
		var day = currentTime.getDate();
		var year = currentTime.getFullYear();
		var date = year + "-" + month + "-" + day;
		
		if (status === 'success') {
			$("#xem-modal #idHoaDon").val(data[0].hoaDon.id);
			$("#xem-modal #ngayLap").val(date);
			$("#xem-modal #tenKH").val(data[0].hoaDon.hoTenKhachHang);		
			$("#xem-modal #sdt").val(data[0].hoaDon.soDienThoaiGiaoHang);
			$("#xem-modal #diaChi").val(data[0].hoaDon.diaChiGiaoHang);
			$("#xem-modal #email").val(data[0].hoaDon.email);
		}
		$("#tableBody").html("");
		$.each(data, (i, detail) => {
		const {dienThoai,soLuong} = detail;
		console.log(JSON.stringify(detail));
		
		var giaDT=dienThoai.giaDT*soLuong;
		var thue=(giaDT*dienThoai.thue)/100;
		var giamGia=(giaDT*dienThoai.giamGia)/100;		
		var thanhTien=giaDT + thue - giamGia;
						
		var tt=numberFormat.format(thanhTien);
		var gia=numberFormat.format(dienThoai.giaDT);
		
		$("<tr>").appendTo($("#tableBody"))	
			.append($("<td>").text(dienThoai.id))
			.append($("<td>").text(dienThoai.tenDT+' ('+dienThoai.thongSo.boNho+')'))
			.append($("<td>").text(soLuong))
			.append($("<td>").text(gia))
			.append($("<td>").text(dienThoai.thue))
			.append($("<td>").text(dienThoai.giamGia))
			.append($("<td>").text(tt))
						
		});
		
		var tongTien=0;
				
			for(var i in data) { 
				tongTien += (data[i].dienThoai.giaDT*data[i].soLuong) + 
					((data[i].dienThoai.giaDT*data[i].soLuong)*data[i].dienThoai.thue)/100 - 
					((data[i].dienThoai.giaDT*data[i].soLuong)*data[i].dienThoai.giamGia)/100; 
			}
		var sub=numberFormat.format(tongTien);
			$("#xem-modal #tongTien").val(sub);
	});
}
