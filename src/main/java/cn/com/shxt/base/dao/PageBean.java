package cn.com.shxt.base.dao;

import java.util.List;

/**
 *  数据处理类
 *
 */
public class PageBean {
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	//结果集
	private List<Object> list;
	//总记录数
	private int totalCount;
	//总页数
	private int allPage;
	//当前页数
	private int pageNow=1;
	//每页显示记录数
	private int pageSize=5;
	
	private String hql;
	
	
	
	
	
}
