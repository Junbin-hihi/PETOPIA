<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
	.myPage_navi{
		padding-top: 20px;
	}

	.myPage_navi_category{
		list-style-type: none;
	    margin: 0;
	    padding: 0;
	    padding-top: 20px;
	}
	
	.myPage_navi_category a{
		display: block;
		color: #000;
		padding: 8px 16px;
		text-decoration: none;
	}
	
	/* 마이페이지 div규격 */
	#main_center_left{
		width:20%; 
		height:100%;
		border: 1px solid black;
		box-sizing: border-box;
		float: left;
	}
	#main_center_right{
		width:80%; 
		height:100%;
		border: 1px solid black;
		box-sizing: border-box;
		float: left;
	}
	#main_center_right_1{
		border: 1px solid black;
		box-sizing: border-box;
		width:100%;
		height:250px;
	}
	
</style>
</head>
<body>

	<!-- 마이페이지 메뉴바 -->
    <div class="myPage_navi">
        <ul class="myPage_navi_category">
        	<li><a><h4><b>관리자 페이지</b></h4></a></li>
        </ul>
        <ul class="myPage_navi_category">
        	<li><a href="memberList.ad"><h5><b>회원조회</b></h5></a></li>
        	<li><a href="adminSales.ad"><h5><b>매출관리</b></h5></a></li>
        	<li><a href="adminShipping.ad"><h5><b>주문/배송 조회</b></h5></a></li>
        </ul>
        <ul class="myPage_navi_category">
        	<li><a href="couponList.ad"><h5><b>관리자 쿠폰 발급</b></h5></a></li>
        </ul>
            
    </div> 
   

</body>
</html>