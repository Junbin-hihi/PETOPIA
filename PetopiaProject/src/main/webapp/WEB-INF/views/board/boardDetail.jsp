<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style> 
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

        table * {margin:5px;}
        table {width:100%;}
    </style>
</head>
<body>
        
    <jsp:include page="../common/header.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>게시글 상세보기</h2>
            <br>

            <a class="btn btn-secondary" style="float:right;" href="board.bo?category=ALL">목록으로</a>
            <br><br>

            <table id="contentArea" algin="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">${ b.boardTitle }</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${b.nickName }</td>
                    <th>작성일</th>
                    <td>${b.createDate }</td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
	                    <c:choose>
		                    <c:when test="${ empty b.originName }">
		                    <img id="preview" width="100px" height="100px">
		                    	<a>파일없음</a>
		                    </c:when>
		                    <c:otherwise>
		                        <a href="${b.filePath }${b.changeName}" download="${b.originName }">${b.originName }</a>
		                        <img src="${b.filePath }${b.changeName}" width="100px" height="100px">
		                    </c:otherwise>
	                    </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4"><p style="height:150px;">${b.boardContent }</p></td>
                </tr>
            </table>
            <br>

            <!-- 수정하기, 삭제하기 버튼은 이 글이 본인이 작성한 글일 경우에만 보여져야 함 -->
            <c:if test="${ loginMember.nickname eq b.nickName }">
	            <div align="center">
		                <a class="btn btn-primary" onclick="postFormSubmit(1);">수정하기</a>
		                <a class="btn btn-danger" onclick="postFormSubmit(2);">삭제하기</a>
	            </div>
            </c:if>
            
            <form action="" method="post" id="postForm">
            	<input type="hidden" name="bno" value="${ b.boardNo }">
            	<input type="hidden" name="file" value="${ b.changeName }">
            </form>
            
            <script>
            	function postFormSubmit(num){
            		if(num == 1){
            			$('#postForm').attr('action', 'updateForm.bo').submit();
            		} else{
            			$('#postForm').attr('action', 'delete.bo').submit();
            		}
            	}
            </script>
            
            <br><br>

            <!-- 댓글 기능은 나중에 ajax 배우고 나서 구현할 예정! 우선은 화면구현만 해놓음 -->
            <table id="replyArea" class="table" align="center">
                <thead>
                	<c:choose>
	                	<c:when test="${ empty loginMember }">
		                    <tr>
		                        <th colspan="2">
		                            <textarea class="form-control" cols="55" rows="2" readonly style="resize:none; width:100%;">로그인 후 이용 바랍니다.</textarea>
		                        </th>
		                        <th style="vertical-align:middle"><button class="btn btn-secondary" id="replyButton">등록하기</button></th>
		                    </tr>
	                    </c:when>
	                    <c:otherwise>
		                    <tr>
		                        <th colspan="2">
		                            <textarea class="form-control" id="content" cols="55" rows="2" style="resize:none; width:100%;"></textarea>
		                        </th>
		                        <th style="vertical-align:middle"><button class="btn btn-secondary" onclick="addReply();">등록하기</button></th>
		                    </tr>
	                    </c:otherwise>
                    </c:choose>
                    
                    <tr>
                        <td colspan="3">댓글(<span id="rcount">0</span>)</td>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
        <br><br>

    </div>
    
    <jsp:include page="../common/footer.jsp" />
    
    <script>
    
    	$(function(){
    		selectReplyList();
    	})
    
    	
    	function selectReplyList(){
    		$.ajax({
    			url : 'rlist.bo',
    			data : { bno : ${b.boardNo}},
    			success : result => {
    				// console.log(result);
    				let value = "";
    				
    				for(let i in result){
    					value += '<tr>'
    						   + '<td>' + result[i].nickname + '</td>'
    						   + '<td>' + result[i].replyContent + '</td>'
    						   + '<td>' + result[i].createDate + '</td>'
    						   + '<td><button onclick="deleteReply(this);">삭제</button></td>'
    						   + '</tr>'
    				}
    				$('#replyArea > tbody').html(value);
    				$('#rcount').text(result.length);
    			},
    			error : () => {
    				console.log('ajax통신 실패 ~');
    			}
    		})
    	}
    	
    	function addReply(){
    		
    		if($('#content').val().trim() != ''){
    			$.ajax({
    				url : 'replyInsert.bo',
    				data : {
    					boardNo : ${b.boardNo},
    					replyContent : $('#content').val(),
    					nickname : '${loginMember.nickname}'
    				},
    				success : result => {
    					selectReplyList();
    					$('#content').val('');
    				},
    				error : () => {
    					console.log('ajax통신 실패');
    				}
    				
    			});
    		} else {
    			alertify.alert('댓글 작성시 빈공백은 작성이 불가능 합니다.');
    		}
    		
    	}
    </script>
    
</body>
</html>