package connect.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import connect.reservation.domain.Category;
import connect.reservation.dto.ProductInfo;
import connect.reservation.service.CategoryService;
import connect.reservation.service.ProductInfoService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductInfoService productInfoService;
	
	@GetMapping("/category")
	public String index() {
		return "index";
	}
	
	@GetMapping("/")
	public String mvMain(Model model) {		
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = categoryService.getAll();
		
		model.addAttribute("category", categoryList);
		
		return "mainpage";
	}
	
	@GetMapping("/mvMyPage")
	public String mvMyPage() {
		// 로그인을 하지 않은 유저는 로그인 페이지로
		// 로그인 한 후라면 "나의 예약 메인"페이지로 이동한다
		
		return "myreservation";
	}
	
	@ResponseBody
	@PostMapping("/changeCategory/{categoryId}")
	public int changeCategory(@PathVariable int categoryId) {
		if(categoryId == 0)
			return productInfoService.getProductCount();
		
		int productNum = productInfoService.getCategoryProductCount(categoryId);
		
		return productNum;
	}

}
