<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#main_center_right_top{
		height: 10%;
		padding-top: 30px;
		
	}
	#main_center_right_top>div{
		margin: auto;
		text-align: center;
		
	}
	#main_center_right_bottom{
		height:90%;
		margin: auto;
	}
	#myBoardList{
		border: 1px solid black;
		height: 100px;
		width: 400px;
		margin: auto;
		text-align: center;
	}
	#main_center_right{
		margin: auto;
	}
	#pagingArea {
		width: fit-content;
		margin: auto;
			
    }
	#orderList{
		padding-left: 100px;
	}
	.myOrderList{
		text-align: center
	}
	.list{
		width: 300px;
		float: left;
		border: 1px solid black;
		overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
	}
	.status > h3{
		display: inline;
	}
	.status > button{
		width: 100px;
		background-color:#FAC264 ;
	}
	.page-link{
		background-color: #FAC264;
	}



</style>
</head>
<body>

	<jsp:include page="../common/header.jsp" />

    <div id="main">
		<div id="main_left">
		
		</div>
		<div id="main_center">
			<div id="main_center_left">
				<jsp:include page="myPageNavi.jsp" />
			</div>
			<div id="main_center_right">
				<div id="main_center_right_top">
					<h2 align="center">주문/배송목록 조회</h2>
				</div>
				<div id="main_center_right_bottom">
					<div id="orderList">

					</div>
					<div id="pagingArea" >
						<ul class="pagination">
			
						</ul>
					</div>		
				</div>
			</div>
			
		</div>
		<div id="main_right">
			
		</div>
		
	</div>
	
	<script>
		let cpage = 1;
		$(document).ready(() =>{
			selectOrderList(cpage);
			
			$(document).on('click', '.myOrderList button', e =>{
				var receiptNo = $(e.target).attr('class');
				$.ajax({
					url: 'updateShippingStatus.me',
					data : {
						receiptNo : receiptNo,
					},
					type : 'post',
					success : result =>{
						$(e.target).remove();
						selectOrderList(cpage);
					},
					error: () =>{
						console.log('실패');
					}
				})
			})
			
			
		})

		$(()=>{
			$('#orderList').on('click', '.myOrderList > .list', function() {
				var rno = $(this).find('.receiptNo1').val();
				location.href = 'orderDetail.me?receiptNo=' +rno ;
			})
		})

		
		
		
		function selectOrderList(cpage){
			$.ajax({
				url: 'selectOrderList.me',
				data: {
					memberNo :${sessionScope.loginMember.memberNo},
					currentPage: cpage
				},
				success : list =>{
					if(Object.keys(list).length == 0 ){
						value ='<h2 align="center"> 주문/ 배송 내역이 없습니다</h1>';
							$('#orderList').html(value);
					}else{
						let item = list.list;
						let pi = list.pi;
						let value = '';

						let paging = '';
							
						let cPage = pi.currentPage;
						let startPage = pi.startPage;
						let endPage = pi.endPage;
						let prev = cPage - 1;
						let next = cPage + 1;
						let max = pi.maxPage;
						for(var i in item) {
							value += '<div class="myOrderList">'	
									+ 	'<div class="list" style="font-weight: 900px;">' 
									+ 	'<input type="hidden" class="receiptNo1" name="receiptNo" value="' + item[i].receiptNo + '">'
									+ 		'<b>상품명 : ' + item[i].productTitle + '</b><br>'
									+ 		'<b>결제 금액 : ' + item[i].resultPrice + '</b><br>'
									+	'</div>' ;
									if(item[i].shippingStatus =='배송중'){
										value += 	'<div class="status" >' 
												+		'<h3>'+item[i].shippingStatus +'</h3><br>'
												+ 		'<button class="'+ item[i].receiptNo +'">구매확정</button>'
												+ 	'</div>' 
												+ '</div><br>';
									}else{
										value += 	'<div class="status" >' 
												+		'<h3>'+item[i].shippingStatus +'</h3>'
												+ 	'</div>' 
												+ '</div><br>';
									}
						};
					
						$('#orderList').html(value);						
						if(cPage == 1){
							paging += '<li class="page-item disabled"><a class="page-link" href="#">&lt;-</a></li>';                		
						} else {
							paging += '<li class="page-item"><a class="page-link" href="javascript:selectOrderList(' + prev + ');">&lt;-</a></li>';
						}
						
						for(let i = startPage; i <= endPage; i++){
							if(i != cPage){
								paging += '<li class="page-item"><a class="page-link" href="javascript:selectOrderList(' + i + ');">' + i + '</a></li>';
							} else {
								paging += '<li class="page-item"><a class="page-link" style="background-color:#FAC264;" href="javascript:selectOrderList(' + i + ');">' + i + '</a></li>';
							}
						}
						if(cPage == max){
							paging += '<li class="page-item disabled"><a class="page-link" href="#">-&gt;</a></li>';                		
						} else {
							paging += '<li class="page-item"><a class="page-link" href="javascript:selectOrderList(' + next + ');">-&gt;</a></li>';
						}
						$('.pagination').html(paging);
					}
				},
				error: () =>{
					console.log('실패');
				}
			})
		}
	
	
	</script>

   
    <jsp:include page="../common/footer.jsp" />

</body>
</html>