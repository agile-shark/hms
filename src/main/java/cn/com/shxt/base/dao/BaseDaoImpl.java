package cn.com.shxt.base.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
@SuppressWarnings("unchecked")
public class BaseDaoImpl  implements IBaseDao {
	protected JdbcTemplate jdbcTemplate;
	protected SessionFactory sessionFactory;
	/**
	 * 此处不能使用setSessionFactory注入，因为setSessionFactory在HibernateDaoSupport
	 * 中已经定义了而且还是final的，所以不能被覆盖
	 * @param sessionFactory
	 */
	//@Resource(name="sessionFactory")
	
	

	public void add(Object obj) {
		try {

			this.getSession().save(obj);
	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setDataSource(DataSource dataSource) {
		  this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void delete(Object obj) {
		this.getSession().delete(obj);
	}

	public void update(Object obj) {
		this.getSession().update(obj);
	}

	public Object load(Class<?> cls, int id) {
		return this.getSession().load(cls, id);
	}
	
	public Object load(String hql,Object[] args){
		Query u = this.getSession().createQuery(hql);
		if(args!=null) {
			for(int i=0;i<args.length;i++) {
				u.setParameter(i, args[i]);
			}
		}
		System.out.println(u.uniqueResult());
		return u.uniqueResult();
	}

	public List<?> list(String hql, Object[] args) {
		Query u = this.getSession().createQuery(hql);
		if(args!=null) {
			for(int i=0;i<args.length;i++) {
				u.setParameter(i, args[i]);
			}
		}
		List<?> list = u.list();
		return list;
	}

	public List<?> list(String hql) {
		return this.list(hql,null);
	}

	public List<?> list(String hql, Object arg) {
		return this.list(hql,new Object[]{arg});
	}

	
	public PageBean find(String hql, Object[] args, int pageNow,
			int pageSize) {
		List<Object> list = new ArrayList<Object>();
		PageBean pb = new PageBean();
		Query query = this.getSession().createQuery(hql);
		Query query_count = this.getSession().createQuery(getCountHql(hql));
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
				query_count.setParameter(i, args[i]);
			}
		}
		
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		list = query.list();
		
		pb.setPageNow(pageNow);
		pb.setPageSize(pageSize);
		pb.setHql(hql);
		int totalCount = Integer.parseInt(query_count.list().get(0).toString()) ;
		pb.setTotalCount(totalCount);
		pb.setList(list);
		int allPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		pb.setAllPage(allPage);
		return pb;
	}
	
	private String getCountHql(String hql) {
		//1、获取from前面的字符串
		String f = hql.substring(0, hql.indexOf("from"));
		//2、将from前面的字符串替换为select count(*) 
		if(f.equals("")) {
			hql = "select count(*) "+hql;
		} else {
			hql = hql.replace(f, "select count(*) ");
		}
		//3、将fetch替换为""，因为抓取查询不能使用count(*)
		hql = hql.replace("fetch"," ");
		return hql;
	}

	
}
