package kr.kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "/main/home";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		
		return "/member/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model, MemberVO member) {
		if(memberService.insertMember(member)) {
			model.addAttribute("msg", "회원가입을 완료했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원가입을 실패했습니다.");
			model.addAttribute("url", "/signup");
		}
		return "message";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		
		return "/member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, LoginDTO loginDto) {
		MemberVO user = memberService.login(loginDto);
		if(user != null) {
			model.addAttribute("user", user);
			model.addAttribute("msg", "로그인을 완료했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "로그인을 실패했습니다.");
			model.addAttribute("url", "/login");
		}
		return "message";
	}
	
	@GetMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		//로그아웃 => 세션에 회원 정보를 제거
		session.removeAttribute("user");

		model.addAttribute("msg", "로그아웃 했습니다.");
		model.addAttribute("url", "/");
		return "message";
	}
	
	
//	//value : url, method : 전송방식 GET 또는 POST
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Model model) {
//		MemberVO member = memberService.getMember("admin1");
//		System.out.println(member);
//		//model.addAttribute("화면에서 사용할 이름","보낼 데이터");
//		model.addAttribute("name","홍길동");
//		return "home";
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String homePost(Model model, TestDTO testDto/*, String name, int age*/) {
//		/*
//		System.out.println("이름 : " + name);
//		System.out.println("나이 : " + age);
//		TestDTO testDto = new TestDTO(name, age);
//		*/
//		System.out.println(testDto);
//		return "home";
//	}
//	
//	@RequestMapping(value = "/test/{num}", method = RequestMethod.GET)
//	public String test(Model model, @PathVariable("num")int num) {
//		System.out.println("경로 데이터 : " + num);
//		return "redirect:/";
//	}
	
}
