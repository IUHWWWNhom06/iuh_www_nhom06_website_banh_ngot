function xemChiTiet(id) { //lấy dữ liệu từ api đưa vào jsp

	const url = `api/products/${id}`; // url api lấy dữ liệu
	console.log('url: ', url);
	
	$.get(url, function(data, status) { //lấy dữ liệu từ url 
	
		const {trongLuong,kichThuoc, mauSac, anhURL,thuongHieu, thongSo} = data; 	//dữ liệu nhận được

		if (status === 'success') {
			$("#xem-modal #anh").attr("src","/WebBanDienThoai/resources/user/images/SanPham/"+anhURL);	//lấy dữ liệu từ data đưa qua jsp
			$("#xem-modal #manHinh").html(`<label>${thongSo.manHinh}</label>`);
			$("#xem-modal #heDieuHanh").html(`<label>${thongSo.heDieuHanh}</label>`);
			$("#xem-modal #camera").html(`<label>${thongSo.camera}</label>`);
			$("#xem-modal #ram").html(`<label>${thongSo.ram}</label>`);
			$("#xem-modal #boNho").html(`<label>${thongSo.boNho}</label>`);
			$("#xem-modal #sim").html(`<label>${thongSo.sim}</label>`);
			$("#xem-modal #pin").html(`<label>${thongSo.pin}</label>`);
			$("#xem-modal #trongLuong").html(`<label>${trongLuong}</label>`);
			$("#xem-modal #kichThuoc").html(`<label>${kichThuoc}</label>`);
			$("#xem-modal #mauSac").html(`<label>${mauSac}</label>`);
			$("#xem-modal #thuongHieu").html(`<label>${thuongHieu.tenTH}</label>`);
			$("#xem-modal #xuatXu").html(`<label>${thuongHieu.xuatXu}</label>`);
		}
	});
}


//themChiTietDienThoai
$('#btnThem').click(function() { //khi nhấn btn thêm

	const manHinh = $('#them-modal #manHinh').val(); //lấy dữ liệu đã nhập từ jsp
	const heDieuHanh = $('#them-modal #heDieuHanh').val();
	const camera = $('#them-modal #camera').val();
	const ram = $('#them-modal #ram').val();
	const boNho = $('#them-modal #boNho').val();
	const sim = $('#them-modal #sim').val();
	const pin = $('#them-modal #pin').val();

	const url = "api/details";
	var thongso = { //khai báo biến
          manHinh:manHinh,
          boNho:boNho,
          camera:camera,
          heDieuHanh:heDieuHanh,
          pin:pin,
          ram:ram,
          sim:sim
       };

	$.ajax({ 
		url: url, 
		type: 'POST', // thêm 
		contentType: 'application/json',
		data: JSON.stringify(thongso), 
		success: function() {
			$('#them-modal').modal('hide');
			toastr.success("Thêm thành công")

		},
		error: function() {
			toastr.error("Thêm không thành công")			
		}
	});
	
});
$('#btnThem').click(function() {  //đồng thời khi nhấn btnThem
	$.get(`api/details`, function(data, status) {  //lấy dữ liệu từ url 
		var detail = data;
		const id=detail[detail.length-1].id; //lấy length id của arr
		if (status === 'success') {
			$("#detail_id").val((id+1));  //lấy dữ liệu từ data đưa qua jsp
		}
	});
});

//sửa thông số
function sua(id) { 

	const url = `api/details/${id}`; 			 // url api lấy dữ liệu
	console.log('url: ', url);

	$.get(url, function(data, status) { 		//lấy dữ liệu từ url 

		const {id,manHinh, heDieuHanh,camera,ram ,boNho, sim, pin} = data;   //dữ liệu nhận được

		if (status === 'success') {
			$("#detail_id").val(id);   					//lấy dữ liệu từ data đưa qua jsp
			$("#sua-modal #idSua").val(id);
			$("#sua-modal #manHinhSua").val(manHinh);
			$("#sua-modal #heDieuHanhSua").val(heDieuHanh);
			$("#sua-modal #cameraSua").val(camera);
			$("#sua-modal #ramSua").val(ram);
			$("#sua-modal #boNhoSua").val(boNho);
			$("#sua-modal #simSua").val(sim);
			$("#sua-modal #pinSua").val(pin);
			$("#sua-modal #linkImage").val(pin);
		}
	});
}
$('#btnSua').click(function() {  		//khi nhấn btnSua
	
	
	const id = $('#sua-modal #idSua').val();			//lấy dữ liệu từ jsp
	const manHinh = $('#sua-modal #manHinhSua').val();
	const heDieuHanh = $('#sua-modal #heDieuHanhSua').val();
	const camera = $('#sua-modal #cameraSua').val();
	const ram= $('#sua-modal #ramSua').val();
	const boNho = $('#sua-modal #boNhoSua').val();
	const sim= $('#sua-modal #simSua').val();
	const pin= $('#sua-modal #pinSua').val();
	
	const url = "api/details";						//url api lấy dữ liệu


	$.ajax({
		url: url,
		type: 'PUT',				//cập nhật
		data: JSON.stringify({id, manHinh,heDieuHanh,camera,ram,boNho,sim,pin}),
		contentType: 'application/json',
		success: function() {

			$('#sua-modal').modal('hide');
			toastr.success('Cập nhật thành công')

		},
		error: function() {
			toastr.error('Cập nhật không thành công')
		},

	});
	
});

// tìm kiếm tên điện thoại
$("#timKiemTendienThoai").on("keyup", function() {  		//khi nhập 1 từ khóa vào 
	capNhat(this.value);

});



// thay đổi dữ liệu trong table của jsp
function render(data) {
	$("#tableBody").html("");												//lấy table từ jsp set null
	$.each(data, (i, data) => {												//chạy vòng lặp, lặp qua dữ liệu 
		const { id, tenDT, giaDT,soLuongTon,giamGia, anhURL,thongSo} = data;			//dữ liệu nhận được
		console.log(JSON.stringify(data));
		$("<tr>").appendTo($("#tableBody"))									// tạo thẻ tr của table
			.append($("<td>").text(id))										// thêm thẻ td vào thẻ tr
			.append($("<td>").html(` 
				<img style="width: 110px; height: 67px; border: 1px solid #fff;" 
				src="/WebBanDienThoai/resources/user/images/SanPham/${anhURL}">
				`))			
			.append($("<td>").text(tenDT +" ("+ thongSo.boNho+")"))
			.append($("<td>").text(giaDT))
			.append($("<td>").text(soLuongTon))
			.append($("<td>").text(giamGia))
			.append($("<td>").html(` 
				<a onClick="xemChiTiet('${id}')" data-toggle="modal" data-target="#xem-modal"><i class="zmdi zmdi-eye zmdi-hc-lg"></i> </a>
				`))
			.append($("<td>").html(` 
				<a href="showFormEdit?productId=${id}"><i class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a>	
				&emsp;&nbsp;																																	
				<a onClick="xoa(${id})" class="text-white"><i class="zmdi zmdi-delete zmdi-hc-lg"></i></a>
				`))	;
			
	});
}


function xoats(id) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {
		$.ajax({
			url: `api/details/${id}`,
			type: 'DELETE',
			contentType: 'application/json',
			success: function() {
				toastr.success('Xóa thành công')	
				capNhat("");	
			},
			error: function() {
				toastr.error('Đã có sản phẩm, không xóa được')
			},

		});

	}
}


// xóa điện thoại
function xoa(id) {
	if (confirm("Bạn có chắc chắn xóa không ?")) {
		$.ajax({
			url: `api/products/${id}`,		//url api
			type: 'DELETE',					// xóa 
			contentType: 'application/json',
			success: function() {
				toastr.success('Xóa thành công')	
				capNhat("");		//cập nhập lại dữ liệu 
			},
			error: function() {
				toastr.error('Đã có sản phẩm, không xóa được')
			},

		});

	}
}



//cập nhật dữ liệu khi tìm kiếm theo tên điện thoại 
function capNhat(tenDT) {

	const url = `api/products?tenDT=${tenDT}`;   //url api
	$.get(url, function(data, status) {
		if (status === 'success') {
			render(data);		//thay đổi dữ liệu trong table của jsp
		}
	})
}