package com.care.root;

import java.util.ArrayList;

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
	static int cnt = 0;
	@GetMapping(value = "users", produces = "application/json; charset=utf-8")
	public ArrayList<InfoDTO> users(){
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i=cnt; i < (cnt+10); i++) {
			InfoDTO dto = new InfoDTO();
			dto.setName("홍길동 "+i);
			dto.setAge("2"+i);
			list.add(dto);
		}
		cnt += 10;
		return list;
	}
	
}
