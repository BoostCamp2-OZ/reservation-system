package connect.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import connect.reservation.domain.Category;
import connect.reservation.domain.ReservationInfo;
import connect.reservation.domain.User;
import connect.reservation.dto.Product;
import connect.reservation.dto.ReservationCount;
import connect.reservation.service.CategoryService;
import connect.reservation.service.CommentService;
import connect.reservation.service.ProductService;
import connect.reservation.service.ReservationService;
import connect.reservation.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	private final CommentService commentService;
	private final UserService userService;
	private final ReservationService reservationService;
	
	
	@Autowired
	public MainController(
			CategoryService categoryService, 
			ProductService productService,
			CommentService commentService,
			UserService userService,
			ReservationService reservationService) {
		this.categoryService = categoryService;
		this.productService = productService;
		this.commentService = commentService;
		this.userService = userService;
		this.reservationService = reservationService;
	}
	
	@GetMapping("/category")
	public String index() {
		return "index";
	}
	
	@GetMapping("/")
	public String mvMain(Model model) {		
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = categoryService.getAll();
		
		model.addAttribute("category", categoryList);
		
		//return "mainpage";
		return "files";
	}
	
	@GetMapping("/mvMyPage")
	public String mvMyPage(Model model, HttpSession session) {
		User currentUser = (User)session.getAttribute("currentUser");
		if(null != currentUser) {
			int userId = currentUser.getId();
			model.addAttribute("reservation", reservationService.get(userId));
			model.addAttribute("reservationStatus", reservationService.getCount(userId));
			return "myreservation";
		}
		else 
			return "redirect:/login?type=myPage";

	}

	@GetMapping("/mvDetail")
	public String mvDetail(Model model, @RequestParam("productId") Integer productId) {
		if(productId < 1)
			return null;
		
		model.addAttribute("productId", productId);
		model.addAttribute("productImage", productService.getImage(productId));
		model.addAttribute("detailInfo", productService.getDetail(productId));
		model.addAttribute("commentMap", commentService.getList(productId));
		model.addAttribute("NoticeImage", productService.getNoticeImage(productId));
		model.addAttribute("InfoImage", productService.getInfoImage(productId));
		
		return "detail";
	}
	
	@GetMapping("/reserve")
	public String mvReserve(HttpSession session, Model model, @RequestParam("productId") Integer productId) {
		if(productId < 1)
			return null;
		
		User currentUser = (User)session.getAttribute("currentUser");
		
		if(null == currentUser) {
			session.setAttribute("beforeUrl", "redirect:/reserve?productId="+productId);
			return "redirect:/login?type=reserve";
		}
		
		int userId = currentUser.getId();
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = productService.getReserveInfo(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> list = productService.getPriceInfo(productId);
		
		model.addAttribute("reserveInfo", map.get("info"));
		model.addAttribute("startDay", map.get("startDay"));
		model.addAttribute("endDay", map.get("endDay"));
		model.addAttribute("price", list);
		model.addAttribute("minPrice", productService.getMinimunPrice(list));
		model.addAttribute("user", userService.getUserInfo(userId));
		return "reserve";
	}
	
	@PostMapping("/reserve")
	public String addReservation(HttpSession session, @RequestBody ReservationInfo reservationInfo) {

		User currentUser = (User)session.getAttribute("currentUser");

		// getParameter, getAttribute 차이
		reservationInfo.setUserId(currentUser.getId());
		reservationInfo.setReservationDate(userService.getDate());
		reservationInfo.setCreateDate(userService.getDate());
		
		reservationService.add(reservationInfo);
		return "success";
	}
	
	@GetMapping("/review")
	public String mvReviewList(HttpSession session, Model model) {
		User currentUser = (User) session.getAttribute("currentUser");
		
		return "review";
	}
}
