package com.kh.petopia.board.model.service;

public interface BoardService {

	// �Խñ� ��ȸ (select)
	// �Խñ� ī�װ� ��ȸ (select)
	ArrayList<Board> selectBoard();
	if(Category.equals('��ü')) {
		//�̰ſ� ���� ��
	} else if(Category.equals('�Ҹ���')) {
		
	} else {
		// �ڶ��ϱ�~ ī�װ� ����Ʈ �̾��ֱ�
	}

	// �Խñ� ����ȸ(select)
	Board selectDetailBoard(int boardNo);
	
	// �Խñ� �߰� (insert)
	int insertBoard(int memberNo);
	
	// �Խñ� ���� (update)
	int updateBoard(Board b);
	
	// �Խñ� ���� (update)
	int deleteBoard(int boardNo);
	
	/* �Խñ� �˻� (select)
	ArrayList<Board> selectSearchBoard(Search s)
	VO�� ���
	�˻�����
	������ ī�װ� option
	sql 
	*/
	
	// �Խñ� ���� (select)
	// sort�Լ� ����� �����غ��� 
	// ���� db�� ���� ��ȸ�� �ؾ��ұ� ? �̹� �ִ� �����͸� ������ �ͼ� java���̳� JS�ܿ��� �ذ��� �������� ������~?
	
	
	// -------------- ����¡ ----------------------
	
	// �Խñ� ī�װ� �� ��ȸ (select)
	// �Խñ� ����Ʈ �� ��ȸ (select)
	select count(*)
	  from board
	 where stauts = 'Y'
	if(category)
	
	// �Խñ� �˻� �� ��ȸ (select)
	int searchBoardCount(Search s);
	select count(*)
	  from board
	  where status = 'Y'
	   and boardTitle keywoard;
	   and boardWriter like '%' + keyword + '%'
	// ------------------------------------------

	// �Խñ� ��ȸ�� ���� (update)
	int increaseCount(int boardNo);
	
	// ------------------------------------------
	  
	// ����ۼ� (insert)
	int insertReply(Reply r);
	   
	// �����ȸ (select)
	ArrayList<Reply> selectReply(int boardNo);
	
	// ��ۼ��� (update)
	int updateReply(int replyNo);
	
	// ��ۻ��� (update)
	int deleteReply(int replyNo);
	
	// ��� ���ƿ� �� ���� (update)
	int increasReplyLike(int replyNo);
	
	// --------------------------------------------
	
	// ÷������ �̹��� 

	
}
