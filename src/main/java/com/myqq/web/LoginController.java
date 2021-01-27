package com.myqq.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.myqq.entity.PageNumber;
import com.myqq.entity.numbergame.Odds;
import com.myqq.entity.numbergame.Person;
import com.myqq.entity.numbergame.PersonHistroy;
import com.myqq.service.JiSuSanXing;


@Controller
@RequestMapping("qq")
public class LoginController {
	private static int i ;
	private static String name = "赌狗";
	{
		JiSuSanXing.getTime();
	}
	/**
	 * 获取 本次信息 根据userId
	 * @return
	 */
	@RequestMapping("getData")
	@ResponseBody
	public Object getData(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Map<String,Object> map = new HashMap<>();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("userId")){
				String value = cookie.getValue();
				Person person = JiSuSanXing.getDugous().get(Integer.parseInt(value));
				if(person != null) {
					map.put("person", person.getMap());
				}
			}
		}
		Collection<Person> values = JiSuSanXing.getDugous().values();
		List<Person> list = new ArrayList<>(values);
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				long a = o2.getUserTodayMoney()-o1.getUserTodayMoney();
				if( a > 0 ) return 1;
				else if (a < 0)return -1;
				return 0;
			}
		});
		map.put("dugous",list);
		map.put("result",JiSuSanXing.getNumbers());
		JSON.DEFFAULT_DATE_FORMAT = "MM-dd HH:mm:ss";
		return JSON.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteDateUseDateFormat);
	}
	@RequestMapping("pourMoney")
	@ResponseBody
	public String pourMoney(@RequestBody PersonHistroy pen) {
		int fastNO = pen.getFastNO();
		PageNumber number = JiSuSanXing.getNumbers().get(String.valueOf(fastNO));
		if(number!= null&&number.isStatus()) return "已经开奖了";
		boolean pour = Odds.pour(pen);
		if(pour)return "下注成功";
		else return "赌狗已经没钱啦!";
	}
	@RequestMapping("login")
	@ResponseBody
	public Person login(HttpServletResponse response,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("userId")) {
				String value = cookie.getValue();
				return JiSuSanXing.getDugous().get(Integer.parseInt(value));
			}
		}
		Cookie userCookie=new Cookie("userId",String.valueOf(i)); 
        userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
        userCookie.setPath("/");
        response.addCookie(userCookie);
        Person pen = new Person();
        userCookie=new Cookie("userName",name+i); 
        pen.setUserName(name+i);
        pen.setUserId(i);
        userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
        userCookie.setPath("/");
        response.addCookie(userCookie);
        JiSuSanXing.getDugous().put(i++,pen);
		return pen;
	}
	@RequestMapping("quit")
	@ResponseBody
	public String quit(HttpServletResponse response,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie: cookies) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return "已退出登录";
	}
	@RequestMapping("getTime")
	@ResponseBody
	public int getTime() {
		return JiSuSanXing.getTime();
	}
	/**
	 * 
	 * @param email
	 * @param password  俩个密码是否一致由前端判断
	 * @return
	 */
	@RequestMapping("getUser")
	@ResponseBody
	public Person getUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Map<String,Object> map = new HashMap<>();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("userId")){
				String value = cookie.getValue();
				Person person = JiSuSanXing.getDugous().get(Integer.parseInt(value));
				return person;
			}
		}
		return null;
	}
}
