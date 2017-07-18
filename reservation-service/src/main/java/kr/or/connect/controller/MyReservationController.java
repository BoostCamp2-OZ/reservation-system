package kr.or.connect.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.domain.*;
import kr.or.connect.service.*;

@Controller
@RequestMapping("/my-reservation")
public class MyReservationController {

	LoginService loginService;

	@Autowired
	public MyReservationController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	@GetMapping
	public String check(HttpServletRequest request, HttpServletResponse response, Model model) {
		String returnPath = null;
		User checkingUser = loginService.check(request, response);
		if (checkingUser != null) {
			model.addAttribute("user", checkingUser);
			returnPath = "myreservation";
		} else {
			model.addAttribute("requestURI", request.getRequestURI());
			returnPath = "loginForm";
		}
		return returnPath;
	}

	@GetMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("loginOK", "jungtaejoon");
		return "redirect:/my-reservation";
	}
}
