function xoa(id) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/cates/${id}`,
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

$("#timKiemTenDanhMuc").on("keyup", function() {
	capNhat(this.value);

});



function render(data) {
	$("#tableBody").html("");
	$.each(data, (i, danhMuc) => {
		const { id, tenDanhMuc} = danhMuc;
		$("<tr>").appendTo($("#tableBody"))
			// thêm td vào tr
			.append($("<td>").text(id))
			.append($("<td>").text(null))
			.append($("<td>").text(null))
			.append($("<td>").text(tenDanhMuc))
			.append($("<td>").html(` 
				&nbsp;
				<a href="showFormEdit?cateId=${id}"><i class="zmdi zmdi-border-color zmdi-hc-lg"></i> </a>	
				&emsp;&nbsp;																																	
				<a onClick="xoa(${id})" class="text-white"><i class="zmdi zmdi-delete zmdi-hc-lg"></i></a>																													
				`));
	});
}

function capNhat(tenDanhMuc) {

	const url = `api/cates?tenDanhMuc=${tenDanhMuc}`;
	$.get(url, function(data, status) {

		if (status === 'success') {

			render(data);
		}
	})
}