package com.hoo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
 * 执行时间过滤器
 * 
 * @author liufang
 * 
 */
public class ProcessTimeFilter implements Filter {
	protected final Logger log = Logger.getLogger(ProcessTimeFilter.class);
	/**
	 * 请求执行开始时间
	 */
	public static final String START_TIME = "_start_time";

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		long time = System.currentTimeMillis();
		request.setAttribute(START_TIME, time);
		chain.doFilter(request, response);
		time = System.currentTimeMillis() - time;
		
		log.info(String.format("process ms: %d URL: %s", time, request.getRequestURI()));
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
