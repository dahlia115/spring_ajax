package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@GetMapping("non_ajax")
	public String nonAjax() {
		return "non_ajax";
	}
	
	@GetMapping("ajax")
	public String ajax() {
		System.out.println("ajax연결");
		return "ajax";
	}
	static int cnt=0;
	@GetMapping("ajax_result")
	@ResponseBody
	public String ajax_result() {
		return ++cnt + "";
	}
	
	@GetMapping("ajax01")
	public String ajax01() {
		return "ajax01";
		
	}
	@PostMapping(value = "ajax_result01",
			produces = "application/json; charset=utf-8")//요청받았을 때 처리해줄 타입
	@ResponseBody //리턴으로 돌려주는 값이 문자형태
	public InfoDTO ajax_result01(@RequestBody InfoDTO dto) {//@RequestBody(json타입으로 받을 때 무조건 쓴다) jsp페이지 에서 넘어오는 데이터를 처리할 때
		System.out.println(dto.getName());
		System.out.println(dto.getAge());	
		dto.setName("변경된 이름");
		dto.setAge("200");
		
		return dto;
	}
}













