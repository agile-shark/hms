package cn.com.shxt.base.utils.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author 金旭生
 * @日期 2012 2012-11-26 上午11:26:09
 * @描述 用于的使浏览器不缓存页面的过滤器
 *
 */
public class ValidateUserFilter implements Filter {

	public void destroy() {

	}

	

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("进来了");
	}



	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;              
		httpResponse.setHeader("Cache-Control", "no-cache");                
		httpResponse.setHeader("Pragma", "no-cache");                 
		httpResponse.setDateHeader("Expires", -1);                
		filterChain.doFilter(request, response); 
	}

	

}