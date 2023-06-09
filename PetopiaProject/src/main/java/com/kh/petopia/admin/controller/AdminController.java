package com.kh.petopia.admin.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.petopia.admin.model.service.AdminService;
import com.kh.petopia.admin.model.vo.Coupon;
import com.kh.petopia.common.model.vo.PageInfo;
import com.kh.petopia.common.template.Pagination;
import com.kh.petopia.myPage.model.service.MyPageService;
import com.kh.petopia.product.model.vo.ProductReceipt;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MyPageService mypageService;

	
	@RequestMapping("adminPage.ad")
	public String adminPage() {
		return "admin/adminPage";
	}
	
	@RequestMapping("memberList.ad")
	public String memberList(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		return "admin/adminMemberList"; 
	}
	
	@RequestMapping("adminSales.ad")
	public String adminSales(Model model) {
		Date now = new Date();
		int month = now.getMonth()+1;
		
		int store = adminService.salesCheck();
		int reservation = adminService.salesCheck2();
		model.addAttribute("month", month);
		model.addAttribute("store",store);
		model.addAttribute("reservation",reservation);
		
		return "admin/adminSales";
	}
	
	@RequestMapping("adminShipping.ad")
	public String adminShipping() {
		return "admin/adminShipping"; 
	}
	
	@RequestMapping("shippingDetail.ad")
	public ModelAndView adminShippingDetail(int receiptNo, ModelAndView mv) {
		ArrayList<ProductReceipt> orderList = mypageService.selectDetailOrderList(receiptNo);
		mv.addObject("order", orderList)
		.setViewName("admin/adminShippingDetail");
		return mv;
	}
	
	@RequestMapping("chatBot.ct")
	public String adminChat() {
		return "admin/chatBot";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//----------------------하은--------------------
	
	
	

	
	//관리자 쿠폰 발급
	@RequestMapping("insertCoupon.ad")
	public String insertCouponToAdmin(Coupon c, HttpSession session) {
		System.out.println(c);
		
		if(adminService.insertCoupon(c)> 0) {
			session.setAttribute("alertMsg", "쿠폰이 발급되었습니다");
			
		}else {
			session.setAttribute("alertMsg", "쿠폰발급이 실패했습니다");
		}
		return "redirect:couponList.ad";
		
	}
	
	/**
	 * 관리자 관점 쿠폰 리스트 조회
	 * @param currentPage : 페이징 처리를 위한 현재 페이지 번호
	 * @return
	 */
	@RequestMapping("couponList.ad")
	public ModelAndView coponListShow(@RequestParam(value="cpage", defaultValue="1") int currentPage,
								ModelAndView mv) {
		PageInfo pi = Pagination.getPageInfo(adminService.adminCouponListCount(), currentPage, 10, 10);
		ArrayList<Coupon> couponList = adminService.adminCouponList(pi);
		if(!couponList.isEmpty()) {
			mv.addObject("pi", pi)
			.addObject("couponList",couponList )
			.setViewName("admin/adminCouponList");
		}
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
}
