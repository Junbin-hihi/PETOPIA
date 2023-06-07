package com.kh.petopia.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.petopia.admin.model.vo.Coupon;
import com.kh.petopia.common.model.vo.PageInfo;
import com.kh.petopia.member.model.vo.Member;

@Repository
public class AdminDao {
	
	public int memberListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.memberListCount");
	}
	
	public ArrayList<Member> memberList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.memberList", null, rowBounds);
	}
	
	
	public int insertCoupon(SqlSessionTemplate sqlSession, Coupon c) {
		return sqlSession.insert("adminMapper.insertCoupon", c);
	}

	public int memberSearchCount(SqlSessionTemplate sqlSession, Map params) {
		
		int a = sqlSession.selectOne("adminMapper.memberSearchCount", params);
		System.out.println(a);
		return sqlSession.selectOne("adminMapper.memberSearchCount", params);
	}
	
	public ArrayList memberSearch(SqlSessionTemplate sqlSession, Map params, PageInfo pi) {
		return (ArrayList)sqlSession.selectList("adminMapper.memberSearch", params);
	}

	
	
}
