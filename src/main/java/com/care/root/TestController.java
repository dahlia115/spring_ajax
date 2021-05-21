package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller와 ResponseBody를 합친 것과 같다
public class TestController {
	@GetMapping(value = "rest", produces = "application/json; charset=utf-8")
	//@ResponseBody
	public String get() {
		return "{\"execute\" : \"get(데이터 요청할 때 사용(select))\"}";
	}
	
	@PostMapping(value = "rest", produces = "application/json; charset=utf-8")
	public String post() {
		return "{\"execute\" : \"post(데이터 추가(insert))\"}";
	}
	
	@PutMapping(value = "rest", produces = "application/json; charset=utf-8")
	public String put() {
		return "{\"execute\" : \"put(데이터 수정(update))\"}";
	}
	
	@DeleteMapping(value = "rest", produces = "application/json; charset=utf-8")
	public String delete() {
		return "{\"execute\" : \"delete(데이터 삭제(delete))\"}";
	}
}
