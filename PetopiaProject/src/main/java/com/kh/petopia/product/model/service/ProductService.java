package com.kh.petopia.product.model.service;

public interface ProductService {

	// ���� ��ǰ ��ȸ (select)
	// ���� ī�װ� ��ǰ ��ȸ
	ArrayList<Product> selectProductList(Category c);
	SQL => �ذ�
	if(Category.equals('��ü')) {
		where category = '��ü'
	} else if(Category.equals('�ְ߿�ǰ')) {
		where category = '�ְ߿�ǰ'
	} ...
	
	// ��ǰ ���� ��ȸ (select)
	sort() ����� JS�մܿ��� �ذ��Ҽ��ִ��� ? �ƴϸ� java������ �ͼ� �ذ��Ѳ��� �ƴϸ� SQL if�� �Ἥ �Ҳ��� 
	
	// ��ǰ �˻� ��ȸ (select)
	ArrayList<Product> searchProductList(String keyword);
	SQL => �ذ�
	where productTitle like '%' + keyword + '%';
			
	// ��ǰ �� ��ȸ (select)
	Product selectDetailProduct(int productNo);
	
	// ��ǰ ���� ��ȸ (select) board
	ArrayList<Ask> selectAskList(int productNo);
	
	// ��ǰ ���� ��� (insert)
	int insertAsk(ȸ����ȣ, ��ǰ��ȣ, ���ǳ���)
	hashMap 3�� �ְ� 
	SQL => �ذ�
	insert
	  into
	  	   Ask
	  	   (
	  		njdanjd
	  		..�ְ�.
	  		)
	values
			(
			seq
			#(��ǰ��ȣ)
			#(ȸ����ȣ)
			#(���ǳ���)
			sysdate
			);
	// ---------- ������ ��� --------------------
	
	// ��ǰ �߰� (insert)
	// �������̺� �⺻���� insert ���� 
	�ѹ��� �ΰ��� ���̺� ���� �־�ߵǴϱ� insert All �׸��� 
	�Ѱ��� ���̺� �������� insert�� ��쿡�� forEach�±� ���
	int insertProduct(Product p); 
	
	// ���������̺� ������ ������ ������ŭ insert	
	int insertProductSize(Product p);
	controller�ܿ��� for��? insert <c:choose>
	<c:forEach item="product" index="">
	// ��ǰ ���� (update)
	
	sqlSession.insert("dsadsamapper", list)
	insert all
		into A���̺�
		<choose test=" empty list.siez()">
		into B���̺�
		</if test=" not empty list.size()">
		<forEach item="Arraylist<Product>" collection="list" index="list.siez()">
		into B���̺�
		...
		
		<>
	
	// ��ǰ ���� (update)
	
	// ��ǰ ���� �亯 ��� (insert)
	
	// ----------- ���� ---------------
	
	// ��ٱ��� (insert)(delete)(select)
	
	// ��ǰ ���� (insert)
	
	// ------------- ���������� ���� ��� ---------------
	
	// ��ǰ ��� (update)

	
	
	
	
	
	
	
	
	
}
