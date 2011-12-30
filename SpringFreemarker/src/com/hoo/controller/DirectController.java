package com.hoo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hoo.entity.User;

@Controller

@RequestMapping("/direct")

public class DirectController {
	private static Logger logger = null;
	
	public DirectController() {
		logger = Logger.getLogger(HelloWorldController.class);
	}
	@RequestMapping("/hi")
	public void hi(HttpServletRequest request, HttpServletResponse response, String id) {
		try {
			response.getWriter().write("render directly:" + id);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	@RequestMapping("/hi2")
	public void hi2(HttpServletRequest request, HttpServletResponse response, String id) {
		try {
			response.getWriter().write("render directly:" + id);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}