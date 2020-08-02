package com.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.mybatis.entity.TbStudent;

@Controller
@RequestMapping("test")
public class TestController {
	@RequestMapping("jdk")
	@ResponseBody
	public Map<String, String> testJDKChar() {
		Map<String, String> hashMap = new HashMap<String, String>();
		System.out.println("Default Charset=" + Charset.defaultCharset());
		hashMap.put("Default Charset=1", Charset.defaultCharset().toString());
		System.out.println("file.encoding=" + System.getProperty("file.encoding"));
		hashMap.put("file.encoding=2", System.getProperty("file.encoding").toString());
		System.out.println("Default Charset=" + Charset.defaultCharset());
		hashMap.put("Default Charset=3", Charset.defaultCharset().toString());
		System.out.println("Default Charset in Use=" + getDefaultCharSet());
		hashMap.put("Default Charset in Use=4", getDefaultCharSet().toString());
		return hashMap;
	}

	private static String getDefaultCharSet() {
		OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
		String enc = writer.getEncoding();
		return enc;
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	@ResponseBody
	public String getUser(Integer id){
		System.out.println("get"+id);
		return "";
	}
	
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	@ResponseBody
	public String postUsers(TbStudent student){
		System.out.println("postObject---id"+student.getId());
		System.out.println("postObject---username"+student.getUsername());
		return "";
	}
	

	@RequestMapping(value="/users/object",method=RequestMethod.POST)
	@ResponseBody
	public String postUser(@RequestBody TbStudent student){
		System.out.println("postObject---id"+student.getId());
		System.out.println("postObject---username"+student.getUsername());
		return "";
	}
	


}
