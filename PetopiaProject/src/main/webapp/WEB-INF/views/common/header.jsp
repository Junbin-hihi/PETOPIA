<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- jQuery 라이브러리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <style>
        div {box-sizing:border-box;} 
        #header {
            width:1200px;
            height:180px;
            padding-top:20px;
            margin:auto;
        }
        #header>div {width:100%;}
        #header_1 {height:70%;}
        #header_2 {height:30%;}

        #header_1>div{
            height:100%;
            float:left;
        }
        #header_1_left {width:30%; position:relative;}
        #header_1_center {width:40%;}
        #header_1_right {width:30%; float: right;}

        #header_1_left>img {height:100%; position:absolute; margin:auto; top:0px; bottom:0px; right:0px; left:0px;}
        #header_1_right {text-align:right; line-height:35px; font-size:12px; text-indent:35px;}
        #header_1_right>a {margin:5px;}
        #header_1_right>a:hover {cursor:pointer;}
        #header_1_right_bottom {padding-top: 10px;}

        #header_2>ul {width:100%; height:100%; list-style-type:none; margin:auto; padding:0;}
        #header_2>ul>li {float:left; width:13%; height:100%; line-height:55px; text-align:center;}
        #header_2>ul>li a {text-decoration:none; color:black; font-size:18px; font-weight:900;}

        #header_2 {border-bottom:1px solid lightgray; padding-left: 130px;}

        #header a {text-decoration:none; color:black;}

        /* 세부페이지마다 공통적으로 유지할 style */
        .content {
            background-color:rgb(247, 245, 245);
            width:80%;
            margin:auto;
        }
        .innerOuter {
            border:1px solid lightgray;
            width:80%;
            margin:auto;
            padding:5% 10%;
            background-color:white;
        }

        /*--------------------------------------------------------------------------------*/

        /* 네비 스타일 */
        #navi{
            list-style : none;
            /* ul요소는 기본적으로 위, 아래 marign이 존재 왼쪽에는 padding도 있음 */
            margin : 0px;
            padding : 0px;
            height : 100%;
        }

        #navi > li{
            float : center;
            height : 100%;
            text-align : center;
        }

        #navi a{
            text-decoration : none;
            color : forestgreen;
            font-weight : 800;
            width : 100%;
            height : 100%; /* a태그는 인라인요소기 때문에 width, height속성이 적용 X */
            display : block; /* 인라인 요소를 블록으로 바꿔줌 */
            /*vertical-align : middle;*/
            line-height : 35px; /* 줄간격속성 px / % / em */
        }

        #navi a:hover{
            font-size : 17px;
            color : rgb(16, 85, 16);
        }

        #navi > li > ul{
            list-style : none;
            padding : 0px;
            display:none; /* 평소에는 안보이다가 마우스가 올라가는 순간 펼쳐지는 효과 1 */
        }

        #navi > li > a:hover + ul {
            display : block;  /* 평소에는 안보이다가 마우스가 올라가는 순간 펼쳐지는 효과 2 */
        }

        #navi > li > ul:hover {
            display : block; /* 평소에는 안보이다가 마우스가 올라가는 순간 펼쳐지는 효과 3 */
        }

        #navi > li > ul a{font-size : 11px;}
        #navi > li > ul a:hover{font-size : 14px;}
    </style>

<script src="https://kit.fontawesome.com/280c5da56d.js" crossorigin="anonymous"></script>
</head>
<body>


    <c:if test="${ not empty alertMsg }">
       <script>      
          alertify.alert('추카추카룽','${alertMsg}',function(){ alertify.success('어 뿅'); });
       </script>
       <c:remove var="alertMsg" scope="session"/>
    </c:if>
    

    <div id="header">
        <!-- 로그인 및 회원가입 -->
        <div id="header_1">
            <div id="header_1_left">
            </div>
            <div id="header_1_center" align="center">
                <img src="resources/images/petopiaLogo.png" alt="펫토피아로고" style="height: 60px; width: 170px;">
            </div>
            <div id="header_1_right">               
               <!-- null == loginUser // empty loginUser -->
               <!-- 빈문자열인지 아닌지도 체크  -->
               <c:choose>
                  <c:when test="${ empty requestScope.loginMember }">
                      <!-- 로그인 전 -->
                      <a href="memberEnroll.me">회원가입 </a> |
                      <a href="login">로그인</a> <!-- 모달의 원리 : 이 버튼 클릭시 data-targert에 제시되어있는 해당 아이디의 div요소를 띄워줌 -->
                  </c:when>
                  <c:otherwise>
                                    
                      <label>${ requestScpoe.loginMember.memberName }횐님 환영합니다</label> &nbsp;
                      <a href="myPage.me">마이페이지</a>
                      <a href="logout.me">로그아웃</a>
                      
                  </c:otherwise>
               </c:choose>
               <div id="header_1_right_bottom">
                <!-- 알림, 페이 아이콘-->
                <i class="fa-regular fa-credit-card fa-2x" id="payIcon"></i>
                <i class="fa-regular fa-bell fa-2x" id="alarmIcon"></i>
               </div>
            </div>
        </div>

        <div id="header_2">
            <ul id="navi">
                <li>
                    <a href="">호텔</a>
                </li>
                <li><a href="">유치원</a>
                </li>
                <li><a href="">미용</a>
                </li>
                <li><a href="">훈련</a>
                </li>
                <li><a href="">상점</a>
                    <ul>
                        <li><a href="">메뉴1</a></li>
                        <li><a href="">메뉴2</a></li>
                        <li><a href="">메뉴3</a></li>
                        <li><a href="">메뉴4</a></li>
                    </ul>
                </li>
                <li><a href="">커뮤니티</a>
                    <ul>
                        <li><a href="">메뉴1</a></li>
                        <li><a href="">메뉴2</a></li>
                        <li><a href="">메뉴3</a></li>
                        <li><a href="">메뉴4</a></li>
                    </ul>
                </li>
            </ul>
    
        </div>



    </div>
</body>
</html>