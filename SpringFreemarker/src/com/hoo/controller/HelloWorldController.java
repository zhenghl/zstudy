package com.hoo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UrlPathHelper;

import com.hoo.bean.Book;

import servlet.LogInitServlet;

/**
 * <b>function:</b> FreeMarker示例控制器
 * 
 * @author hoojo
 * @createDate 2011-3-3 下午04:50:10
 * @file HelloWorldController.java
 * @package com.hoo.controller
 * @project SpringFreemarker
 * @version 1.0
 */
@Controller
@RequestMapping("/freeMarker")
public class HelloWorldController {
	private static Logger logger = null;
	
	private static int count = 0;
	
	public HelloWorldController() {
		logger = Logger.getLogger(HelloWorldController.class);
	}

	@RequestMapping("/hello")
	public String sayHello(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		/*
		UrlPathHelper helper = new UrlPathHelper();
		logger.info(helper.getContextPath(request));
		logger.info(helper.getLookupPathForRequest(request));
		logger.info(helper.getOriginatingContextPath(request));
		logger.info(helper.getOriginatingQueryString(request));
		logger.info(helper.getOriginatingRequestUri(request));
		logger.info(helper.getPathWithinApplication(request));
		logger.info(helper.getPathWithinServletMapping(request));
		logger.info(helper.getRequestUri(request));
		logger.info(helper.getServletPath(request));
//		logger.info(helper.);
//		logger.info(helper.);
		
		System.out.println("1 : " + Thread.currentThread().getContextClassLoader().getResource(""));    
		System.out.println("2 : " + HelloWorldController.class.getClassLoader().getResource(""));       
		System.out.println("3 : " + ClassLoader.getSystemResource(""));       
		System.out.println("4 : " + HelloWorldController.class.getResource(""));       
		System.out.println("5 : " + HelloWorldController.class.getResource("/")); //Class文件所在路径 
		System.out.println("6 : " + new java.io.File("/").getAbsolutePath());       
		System.out.println("7 : " + System.getProperty("user.dir"));   
		*/
		System.out.println("say Hello ……");
		map.addAttribute("name", " World!");
		return "/hello.ftl";
	}

	@RequestMapping("/hi")
	public String sayHi(Book book, String id, ModelMap map) {
		System.out.println("say hi ……");
		logger.info("id=" + id);
		logger.info("book=" + book);
		map.put("name", "jojo");
		return "/hi.ftl";
	}

	@RequestMapping("/jsp")
	public String jspRequest(ModelMap map) {
		System.out.println("jspRequest ……");
		map.put("name", "jsp");
		return "/temp.jsp";
	}
	
	public void testBean() {
		count++;
		logger.info("HelloWorldController.count (static) =" + count);
	}
}
