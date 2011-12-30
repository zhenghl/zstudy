package com.hoo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hoo.entity.User;

@Controller

@RequestMapping("/jsonlib/view")

public class JsonlibMappingViewController {

	@RequestMapping("/doMapJsonView")
	public ModelAndView doMapJsonView() {
	    ModelAndView mav = new ModelAndView("jsonlibView");
	    
	    User user = new User();
	    user.setAddress("china GuangZhou");
	    user.setAge(23);
	    user.setBrithday(new Date());
	    user.setName("jack");
	    user.setSex(true);
	    Map map = new HashMap();
	    map.put("user", user);
	    map.put("success", true);
	    
	    mav.addObject("map", map);
	    
	    mav.addObject("title", "ViewController doBeanJsonView");
	    
	    return mav;
	}
}