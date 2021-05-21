package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	static Map<String, InfoDTO> DBMap = new HashMap();
	@GetMapping(value = "users", produces = "application/json; charset=utf-8")
	public ArrayList<InfoDTO> users(){
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i=cnt; i < (cnt+10); i++) {
			InfoDTO dto = new InfoDTO();
			dto.setName("홍길동"+i);
			dto.setAge("2"+i);
			list.add(dto);
			DBMap.put("홍길동"+i, dto);
		}
		cnt += 10;
		return list;
	}
	@GetMapping(value="user/{uId}", produces = "application/json; charset=utf-8" )//value="user/{전달 받은 값}"
	//public InfoDTO user(@RequestParam String userId) {//값 받아오기
	public InfoDTO user(@PathVariable String uId) {//값 받아오기
		System.out.println("userId : "+uId);
		return DBMap.get(uId);
	}
	@PostMapping(value="membership", produces = "application/json; charset=utf-8" )//value="user/{전달 받은 값}"
	public String membership(@RequestBody Map<String, Object> map) {
		System.out.println("id : "+map.get("uId"));
		System.out.println("name : "+map.get("uName"));
		System.out.println("age : "+map.get("uAge"));
		System.out.println("addr : "+map.get("uAddr"));
		return "{\"result\" : true}";
	}
}









