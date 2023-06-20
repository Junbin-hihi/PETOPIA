package com.kh.petopia.myPage.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.petopia.common.template.MyFileRename;
import com.kh.petopia.myPage.model.service.MyPageService;
import com.kh.petopia.myPage.model.vo.AllReviews;
import com.kh.petopia.myPage.model.vo.Petpay;
import com.kh.petopia.product.model.vo.ProductReceipt;

@Controller
public class MyPageController {

	private String filePath = "resources/uploadFiles/";
	
	@Autowired
	private MyPageService myPageService;
	
	
	// 헤더 마이페이지 클릭
	@RequestMapping("myPage.me")
	public String myPage(int mno) {
		//MyPage myPage = new MyPage();
		//회원 등급 조회
		//myPage.setRating(myPageService.getMemberRating(mno));
		
		return "myPage/myPage";
	}
	
	// 마이페이지 게시글 조회
	@RequestMapping("myBoard.me")
	public String myBoardList() {
		//model.addAttribute("list", myPageService.myBoardList(mno));
		return "myPage/myBoardList";
	}
	
	// 알람 iframe페이지
	@RequestMapping("alram.me")
	public String alramList(int mno, Model model) {
		model.addAttribute("list", myPageService.alramList(mno));
		return "myPage/alramList";
	}
	
	// 헤더 마이페이지 클릭
	@RequestMapping("myPetpayPoint.me")
	public String myPetpayPoint(int mno, Model model) {
		// 전체금액, 총 n건, 날짜, 사용, 충전
		
		// 전체금액, 총 n건 int 타입으로 받아오기
		model.addAttribute("petpayAmount", myPageService.selectMemberPetPay(mno));
		model.addAttribute("pointAmount", myPageService.selectMemberPoint(mno));
		
		model.addAttribute("petpayCount", myPageService.selectPetPayCount(mno));
		model.addAttribute("pointCount", myPageService.selectPointCount(mno));
		
		// 금액, 날짜, 사용M, 충전P ArrayList
		model.addAttribute("petpayList", myPageService.myPetpayList(mno));
		model.addAttribute("pointList", myPageService.myPointList(mno));

		return "myPage/myPetpayPoint";
	}
	
	
	@RequestMapping("memberCouponList.me")
	public String memberCouponListView() {
		return "myPage/memberCouponList";
	}
	
	// 마이페이지 펫페이 충전
	@RequestMapping("insertChargePetpay.me")
	public String insertChargePetpay(int memberNo, int petpayAmount, HttpSession session, Model model) {
		Petpay p = new Petpay();
		p.setMemberNo(memberNo);
		p.setPetpayAmount(petpayAmount);
		
		if(myPageService.insertChargePetpay(p) > 0) {
			session.setAttribute("alertMsg", "펫페이 충전 완료!");
			return "redirect:myPetpayPoint.me?mno=" + memberNo;
		} else {
			model.addAttribute("errorMsg", "펫페이 충전 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("insertWithdrawPetpay.me")
	public String insertWithdrawPetpay(int memberNo, int petpayAmount, HttpSession session, Model model) {
		Petpay p = new Petpay();
		p.setMemberNo(memberNo);
		p.setPetpayAmount(petpayAmount);
		
		if(myPageService.insertWithdrawPetpay(p) > 0) {
			session.setAttribute("alertMsg", "펫페이 인출 완료!");
			return "redirect:myPetpayPoint.me?mno=" + memberNo;
		} else {
			model.addAttribute("errorMsg", "펫페이 충전 실패");
			return "common/errorPage";
		}
	}
	
	// 리뷰 조회 페이지
	@RequestMapping("myReview.me")
	public String myReviewList() {
		//System.out.println(mno);
		//model.addAttribute("list", myPageService.myReviewList(mno));
		return "myPage/myReviewList";
	}
	
	// 상품 리뷰 작성 페이지
	@RequestMapping("productReviewForm.me")
	public String productReviewForm(AllReviews r, Model model) {
		System.out.println("상품 :  " + r);
		model.addAttribute("review", myPageService.productReviewForm(r));
		return "myPage/myReviewInsert";
	}
	
	// 예약 리뷰 작성 페이지
	@RequestMapping("reservationReviewForm.me")
	public String reservationReviewForm(AllReviews r, Model model) {
		System.out.println("예약 : " +r);
		model.addAttribute("list", myPageService.reservationReviewForm(r));
		return "myPage/myReviewInsert";
	}
	
	// 리뷰 작성 INSERT
	@RequestMapping("insertReview.me")
	public String insertReview(AllReviews r,
				               MultipartFile upfile,
							   HttpSession session,
							   Model model ) {
		
		System.out.println("작성 : " + r);
		
		if(!upfile.getOriginalFilename().equals("")) {
			r.setOriginName(upfile.getOriginalFilename());
			r.setChangeName(MyFileRename.saveFile(session, upfile));
			r.setFilePath(filePath);
		}
		
		if(myPageService.insertReview(r) > 0) {
			session.setAttribute("alertMsg", "리뷰 등록 성공!!");
			return "redirect:myReview.me";
		} else {
			model.addAttribute("errorMsg", "게시글 등록 실패 ㅠ");
			return "common/errorPage";
		}
		
	}
	



	
//------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("orderList.me")
	public String selectOrderList() {
		return "myPage/myOrderList";
	}
	
	//회원 배송, 주문 내역 디테일 조회
	@GetMapping("detailOrderList.me")
	public ModelAndView selectDetailOrderList(int receiptNo, ModelAndView mv) {
		ArrayList<ProductReceipt> orderList = myPageService.selectDetailOrderList(receiptNo);
		System.out.println(orderList);
		return mv;
	}

	
}
