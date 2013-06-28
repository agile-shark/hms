package cn.com.shxt.base.dao;

import java.util.List;

public interface IBaseDao {
	public void add(Object obj);
	public void delete(Object obj);
	public void update(Object obj);
	public Object load(Class<?> cls, int id);
	public Object load(String hql,Object[] args);
	public List<?> list(String hql,Object[] args);
	public List<?> list(String hql);
	public List<?> list(String hql,Object arg);
	
	public PageBean find(String hql, Object[] args, int pageNow,int pageSize);
	
}
