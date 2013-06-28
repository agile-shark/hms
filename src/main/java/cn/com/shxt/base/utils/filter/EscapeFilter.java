package cn.com.shxt.base.utils.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.com.shxt.base.utils.filter.wrapper.EscapeWrapper;


/**
 * @author 刘文铭
 * @日期 2012 2012-11-26 上午11:04:31
 * @描述 字符替换过滤器
 *
 */
public class EscapeFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
	        FilterChain chain) throws IOException, ServletException {
		//将原来请求对象包裹至EscaperWrapper中
		HttpServletRequest requestWrapper = new EscapeWrapper((HttpServletRequest) req);
		//将EscapeWrapper对象当做请求对象传入doFilter中
		chain.doFilter(requestWrapper, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
