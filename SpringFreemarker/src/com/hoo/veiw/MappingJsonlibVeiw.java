package com.hoo.veiw;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;

import com.alibaba.fastjson.JSON;
/**
 * 
 * function:扩展AbstractView 实现JSON-lib视图
 * @author hoojo
 * @createDate 2011-4-28 下午05:26:43
 * @file MappingJsonlibVeiw.java
 * @package com.hoo.veiw.xml
 * @project SpringMVC4View
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class MappingJsonlibVeiw extends AbstractView {
	public static final String DEFAULT_CONTENT_TYPE = "application/json";
	public static final String DEFAULT_CHAR_ENCODING = "UTF-8";
	private String encodeing = DEFAULT_CHAR_ENCODING;
	public void setEncodeing(String encodeing) {
		this.encodeing = encodeing;
	}
	private Set renderedAttributes;

	public MappingJsonlibVeiw() {
		setContentType(DEFAULT_CONTENT_TYPE);
	}

	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding(encodeing);

		response.setContentType(DEFAULT_CONTENT_TYPE);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		PrintWriter out = response.getWriter();
		
		String jsonString = JSON.toJSONString(model.get("map"), true);
		
		out.print(jsonString);
	}
}