function xoa(id) {

	if (confirm("Bạn có chắc chắn xóa không ?")) {

		$.ajax({
			url: `api/brands/${id}`,
			type: 'DELETE',
			contentType: 'application/json',
			success: function() {
				toastr.success('Xóa thành công')	
				$("#xoa").attr("href","list");
			},
			error: function() {
				toastr.error('Đã có sản phẩm, không xóa được')
				$("#xoa").attr("href","#");
			},

		});

	}
}
