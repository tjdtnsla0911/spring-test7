$(document).ready(function(){
	console.log('시작 = ',$('input:radio[name="radioSale"]:checked').val());
    // 라디오버튼 클릭시 이벤트 발생
    $("input:radio[name=radioSale]").click(function(){
        if($("input:radio[name=radioSale]:checked").val() == 'true'){
            $(".radioSale").attr("disabled",false);
            // radio 버튼의 value 값이 1이라면 활성화
        	console.log($('input:radio[name="radioSale"]:checked').val());
        }else if($("input:radio[name=radioSale]:checked").val() == 'false'){
              $(".radioSale").attr("disabled",true);
          	console.log($('input:radio[name="radioSale"]:checked').val());
            // radio 버튼의 value 값이 0이라면 비활성화
        }
    });
});

	var sel_file;

	$(document).ready(function() {
		$("#input_img").on("change", handleImgFileSelect);
	});
	console.log($("#input_img").val());

	function handleImgFileSelect(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);

		filesArr.forEach(function(f) {
			if (!f.type.match("image.*")) {
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}

			sel_file = f;

			var reader = new FileReader();
			reader.onload = function(e) {
				$("#img").attr("src", e.target.result);
			}
			reader.readAsDataURL(f);
		});
	}


let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를
												// 바인딩하기 위해서!!
				this.save();
			});
			$(".btn-update").on("click", (e)=>{ // function(){} , ()=>{} this를
												// 바인딩하기 위해서!!
				console.log('안왔음');
				this.update(e);
			});
			$(".btn-delete").on("click", (e)=>{ // function(){} , ()=>{} this를
												// 바인딩하기 위해서!!
				this.userDelete(e);
			});
			$("#start").on("click",()=>{
				this.start();
			});
			$(".btn-ViewDetails").on("click", (e)=>{ // function(){} , ()=>{} this를

this.ViewDetails(e);
});

		},




		save: function(){


			// alert('user의 save함수 호출됨');
			let data = {
					parentProductId:$("#parentProductId").val(),
					relateProductId:$("#relateProductId").val(),
					title: $("#title").val(),
					thumb: $("#thumb").val(),
					price: $("#price").val(),
					disc: $("#disc").val(),
					discounted: $("#discounted").val(),
					content: $("#content").val(),
					radioSale : $('input:radio[name="radioSale"]:checked').val(),
					radioAd : $('input:radio[name="radioAd"]:checked').val(),
					radioParentTypeId : $('input:radio[name="radioParentTypeId"]:checked').val(),
					radioBest : $('input:radio[name="radioBest"]:checked').val(),
					radioNew : $('input:radio[name="radioNew"]:checked').val(),
			};
			console.log('data = ',data);
			if(data.bgImg.length < 444){
				alert('사진미리보기를 누르지 않으셨습니다.');

					return;

			}

			if(fuck=="null"){
				alert('사진을 등록하시지않으셨습니다.');
					return;
			}
			console.log(data);


			// console.log(data);

			// ajax호출시 default가 비동기 호출
			// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
			$.ajax({
				type: "POST",
				url: "/crud",
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",
			       // enctype: 'multipart/form-data',// body데이터가 어떤 타입인지(MIME)
				dataType: "text" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
									// json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
				console.log(resp);
				alert('성공');
//
					// location.href = "/list";


			}).fail(function(error){
				alert(JSON.stringify(error));
			});

		},







		start: function(){


			// alert('user의 save함수 호출됨');
			let data = {
					changebgImg : $("#imgs").val(),

			};


			$.ajax({
				 url : '/instar',
			        type : 'POST',
			        data : data,
			        contentType : false,
			        processData : false

			}).done(function(resp){
				console.log(resp);
				alert('성공');
//
					// location.href = "/list";


			}).fail(function(error){
				alert(JSON.stringify(error));
			});

		},





		// delete 하는곳
		userDelete: function(e){
			// alert('user의 save함수 호출됨');
			let temp = (e.target.id).replace("bt-delete-","");
			let data = {
					id: temp
			};
			console.log('최종 = ',data.id);
			$.ajax({
				type: "delete",
				url: "/listDelete/"+data.id,
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",// body데이터가 어떤
																// 타입인지(MIME)
				dataType: "text" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
									// json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
				alert("회원삭제가 완료되었습니다.");
				console.log(resp);
				location.href = "/list";

			}).fail(function(error){
				alert(JSON.stringify(error));
			});



		},

		update: function(){
			console.log(event.target);
//			console.log('update에왔음');
//			console.log('e =',e);
//			let temp = (e.target.id).replace("bt-update-","");
//
//			$("#bt-update-1").

			let data2 = {
					id: temp
			};
			console.log('ajax안의 또다른 ajax의 id =',data2.id);

			$.ajax({
			type: "PUT",
			url: "/changeadsfasdf/"+data2.id,
			contentType: 'multipart/form-data',
			data: formData, // http body데이터
			 processData: false,
			 contentType: false,
			}).done(function(resp){
				alert("물품변경이 완료되었습니다.");
				// console.log(resp);
				// location.href = "/list";
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},

		ViewDetails: function(e){

			console.log('e =',e);
			let temp = (e.target.id).replace("bt-ViewDetails-","");

			let data2 = {
					id: temp
			};
			console.log('data2 = ',data2);

			let data = {
					id:$("#id"+data2.id).val(),
					userId:$("#id"+data2.id).val(),
					orderDate:$("#orderDate"+data2.id).val(),
					totalPrice:$("#totalPrice"+data2.id).val(),
					username:$("#username"+data2.id).val(),
					createDate:$("#createDate"+data2.id).val(),
					address:$("#address"+data2.id).val(),
					detail_address:$("#detail_address"+data2.id).val(),
					howToPay:$("#howToPay"+data2.id).val(),

			};
			console.log('data = ',data);



			// console.log(data);

			// ajax호출시 default가 비동기 호출
			// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
			$.ajax({
				type: "PUT",
				url: "/ordersDetail/"+data2.id,
				data: JSON.stringify(data2), // http body데이터
				contentType: "application/json; charset=utf-8",
			       // enctype: 'multipart/form-data',// body데이터가 어떤 타입인지(MIME)
				dataType: "JSON" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
									// json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
				console.log(resp);

				$("#detail").empty(); //여기서 지우고

				for(var data of resp){ //for(var data(변수명) if resp(성공한거의 끝까지나오게해라))

					var input_html =
						" <tr class=\"warning\">\r\n" +
						"\r\n" +
						"        <td>"+data.id+"</td>\r\n" +
						"        <td>"+data.orderDate+"</td>\r\n" +
						"        <td>"+data.type+"</td>\r\n" +
						"        <td>"+data.howToPay+"</td>\r\n" +
						"        <td>"+data.price+"</td>\r\n" +
						"        <td>"+data.stats+"</td>\r\n" +
						"        <td>"+data.fee+"</td>\r\n" +
						"        <td>"+data.title+"</td>\r\n" +
						"        <td>"+data.address+"</td>\r\n" +
						"        <td>"+data.detail_address+"</td>\r\n" +
						"        <td>"+data.quantity+"</td>\r\n" +
						"        <td>"+data.orders_detailId+"</td>\r\n" +
						"		<td>\r\n" +

						"				<button type=\"button\" data-toggle=\"modal\" data-target=\"#myModal"+data.orders_detailId+"\" style=\"WIDTH: 60pt; HEIGHT: 20pt\">상세보기</button> <br />\r\n" +
						"						<form>\r\n" +
						"							<div class=\"modal fade\" id=\"myModal"+data.orders_detailId+"\" class=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n" +
						"								<div class=\"modal-dialog\" role=\"document\">\r\n" +
						"									<div class=\"modal-content\">\r\n" +
						"										<div class=\"modal-header\">\r\n" +
						"											<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n" +
						"												<span aria-hidden=\"true\">&times;</span>\r\n" +
						"											</button>\r\n" +
						"											<h4 class=\"modal-title\" id=\"myModalLabel\">회원 정보 수정을 합시다~</h4>\r\n" +
						"											상태변경 : <input type=\"text\" id=\"stats"+data.orders_detailId+"\" name=\"stats\" value=\""+data.stats+"\">\r\n" +
						"\r\n" +
						"\r\n" +
						"										</div>\r\n" +
						"										<div class=\"modal-body\"></div>\r\n" +
						"										<div class=\"modal-footer\">\r\n" +
						"											<input class=\"btn-update\" type=\"button\" id=\"bt-update-"+data.orders_detailId+"\" style=\"WIDTH: 60pt; HEIGHT: 20pt\" value=\"수정하기\" />\r\n" +
						"											<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">닫기</button>\r\n" +
						"										</div>\r\n" +
						"									</div>\r\n" +
						"								</div>\r\n" +
						"							</div>\r\n" +
						"						</form>"
						"</td>"+
						"\r\n" +
						"\r\n" +
						"\r\n" +
						"\r\n" +
						"\r\n" +
						"<br/>\r\n" +
						"\r\n" +
						"		</td>\r\n" +
						"\r\n" +
						"      </tr>\r\n" +
						"\r\n" +
						"      </div>";

					console.log(input_html);
					$("#detail").append(input_html);


//				$('#ajaxtest').val(resp[0].totalPrice);

				}

				$(".btn-update").on("click", (e)=>{
					console.log('e =',e)
				console.log('왔음');
				test1(e);
				});


			}).fail(function(error){
				alert(JSON.stringify(error));
			});

		},
}

function test1(e){
	console.log(e);
	let temp = (e.target.id).replace("bt-update-","");//"bt-update-"+data.orders_detailId+"
	let data = {
			id: temp
	};
console.log("받아온 id값 = ",data.id)
let data2={
	stats : $("#stats"+data.id).val(),
	orders_detailId : data.id,
}
console.log("data2= ",data2);

$.ajax({
	type: "PUT",
	url: "/chaneStats/"+data.id,
	data: JSON.stringify(data2), // http body데이터
	contentType: "application/json; charset=utf-8",// body데이터가 어떤
	dataType: "text" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
						// json이라면) => javascript오브젝트로 변경
}).done(function(resp){

	console.log(resp);
	location.href="/orders"

}).fail(function(error){
	alert(JSON.stringify(error));
});


}




index.init();