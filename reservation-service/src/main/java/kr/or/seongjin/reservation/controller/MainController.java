package kr.or.seongjin.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	

	
    @GetMapping(path = "/")
    public String index(Model model){
    	
        return "forward:/resources/html/mainpage.html";
    }
    
  
    
}
