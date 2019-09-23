package kr.co.itcen.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		String data = "Hello world";
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", data);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
	}

	@RequestMapping("/hello3")
	public String hello3(Model model) {
		String data = "Hello world";
		model.addAttribute("data", data);
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello4")
	public String hello4(@RequestParam(value = "email", required = true, defaultValue = "") String email,
			// 파라미터에 붙는 annotation-> e를 email에 세팅해라
			// required = false -> 반드시 필요하지 않다
			// required = true -> 반드시 필요하다
			@RequestParam(value = "age", required = true, defaultValue = "0") int age, Model model) {
		model.addAttribute("email", email);
		model.addAttribute("age", age);

		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello5")
	public String hello5(@ModelAttribute User user, Model model) {

		System.out.println(user);
		model.addAttribute("email", user.getEmail());
		model.addAttribute("age", user.getAge());

		return "/WEB-INF/views/hello.jsp";
	}

}