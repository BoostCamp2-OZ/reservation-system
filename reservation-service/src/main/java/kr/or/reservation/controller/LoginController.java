package kr.or.reservation.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import kr.or.common.StringToJsonParser;
import kr.or.reservation.api.NaverLogin;

@Controller
public class LoginController {
	// 로그 선언
	Logger log = Logger.getLogger(this.getClass());

	@GetMapping(path = "/callback")
	public String enrollSession(Model model, HttpSession session, @RequestParam String code,
			@RequestParam String state) {
		NaverLogin login = new NaverLogin();
		JSONObject json = null, loginInfo = null;
		if(state.equals(session.getAttribute("state"))) {
			json = login.CallBack(code, state);
		}
		if(json != null) {
			loginInfo = login.getCustomInfo(json);
			session.setAttribute("id", loginInfo.get("id"));
			session.setAttribute("name", loginInfo.get("name"));
			session.setAttribute("email", loginInfo.get("email"));
			session.setAttribute("nickname", loginInfo.get("nickname"));
			session.setAttribute("profile_image", loginInfo.get("profile_image"));
		}
		return "redirect:/";
	}
	
	

	
}