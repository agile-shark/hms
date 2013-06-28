package cn.com.shxt.base.utils.filter.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/*
import org.apache.commons.lang.StringEscapeUtils;*/

/**
 * @author 刘文铭
 * @日期 2012 2012-11-26 上午10:54:59
 * @描述
 *
 */
public class EscapeWrapper extends HttpServletRequestWrapper {
	/*
	 * @see 必须调用父类构造器[构造方法],记住传入HttpServletRequest实例
	 */
	public EscapeWrapper(HttpServletRequest request) {
	    super(request);
    }

	
	
	/*
	 * 重新定义getParameter()方法
	 */
/*	@Override
    public String getParameter(String name) {
		String value = this.getRequest().getParameter(name);
	    return StringEscapeUtils.escapeHtml(value);
    }*/
	

}
