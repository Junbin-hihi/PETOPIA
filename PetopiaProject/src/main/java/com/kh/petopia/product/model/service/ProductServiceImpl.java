package com.kh.petopia.product.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.petopia.product.model.dao.ProductDao;
import com.kh.petopia.product.model.vo.Ask;
import com.kh.petopia.product.model.vo.Cart;
import com.kh.petopia.product.model.vo.Product;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Product> selectProductList() {
		return productDao.selectProductList(sqlSession);
	}

	@Override
	public ArrayList<Product> searchProductList(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectDetailProduct(int productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ask> selectAskList(int productNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertProductSize(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int productNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertProductAsk(int askNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProductAsk(int askNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertCart(int productNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCart(int productNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Cart> selectCart(int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
