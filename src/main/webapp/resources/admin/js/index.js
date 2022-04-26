$(function() {

		var ctx = document.getElementById("chart2").getContext('2d');//lấy id của biểu đồ từ html
		const url = `api/products`;
		$.get(url, function(data, status) {
		
			if (status === 'success') {
			$("#top1").html(`<span>${data[0][1]+" "+data[0][3]}</span>`); //gán giá trị cho thẻ span data[0][1], [1] tên ĐT, [3] bộ nhớ
			$("#top2").html(`<span>${data[1][1]+" "+data[1][3]}</span>`);
			$("#top3").html(`<spand>${data[2][1]+" "+data[2][3]}</span>`);
			$("#top4").html(`<tspand>${data[3][1]+" "+data[3][3]}</span>`);
			
			
			$("#gia1").html(`<span>${data[0][0]}</span>`); //data[0][0], [0] số lượng bán
			$("#gia2").html(`<span>${data[1][0]}</span>`);
			$("#gia3").html(`<span>${data[2][0]}</span>`);
			$("#gia4").html(`<span>${data[3][0]}</span>`);
			
			}
						
			var myChart = new Chart(ctx, {
				type: 'doughnut',
				data: {
					labels: [data[0][1]+" "+data[0][3], data[1][1]+" "+data[1][3], data[2][1]+" "+data[2][3], data[3][1]+" "+data[3][3]],
					datasets: [{
						backgroundColor: [
							"#ffffff",
							"rgba(255, 255, 255, 0.70)",
							"rgba(255, 255, 255, 0.50)",
							"rgba(255, 255, 255, 0.20)"
						],
						data: [data[0][0], data[1][0], data[2][0], data[3][0]],
						borderWidth: [0, 0, 0, 0]
					}]
				},
			options: {
				maintainAspectRatio: false,
			   legend: {
				 position :"bottom",	
				 display: false,
				    labels: {
					  fontColor: '#ddd',  
					  boxWidth:15
				   }
				}
				,
				tooltips: {
				  displayColors:false
				}
			   }
			   });
			});
   });	 
   