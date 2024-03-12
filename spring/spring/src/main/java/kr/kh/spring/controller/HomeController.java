package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//value : url, method : 전송방식 GET 또는 POST
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
}
