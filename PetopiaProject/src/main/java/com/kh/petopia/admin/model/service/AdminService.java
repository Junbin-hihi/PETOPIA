package com.kh.petopia.admin.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.kh.petopia.admin.model.vo.Coupon;
import com.kh.petopia.common.model.vo.PageInfo;
import com.kh.petopia.member.model.vo.Member;

public interface AdminService {
	
	// 총 맴버 수 조회
	int memberListCount();
	
	// 맴버 목록 조회 + 페이징처리 (SELECT)
	ArrayList<Member> memberList(PageInfo pi);
	
	// 맴버 검색 + 검색된 맴버 수 조회
	int memberSearchCount(Map params);

	// 맴버 검색 + 페이징처리
	ArrayList memberSearch(Map params, PageInfo pi);
	
	//관리자 쿠폰 발급
	int insertCoupon(Coupon c);
	
	//관리자 쿠폰 목록 조회 
	ArrayList<Coupon> cList(PageInfo pi);

	


	
	
	
}
