package cn.com.shxt.sys_urp.service;

import java.util.List;
import java.util.Set;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.base.exception.AppException;
import cn.com.shxt.sys_urp.domain.Account;
import cn.com.shxt.sys_urp.domain.AccountQuery;
import cn.com.shxt.sys_urp.domain.Module;

public interface IAccountService {
	/**
	 * 登录的时候通过用户和密码获取用户信息
	 * @param account
	 * @return 返回用户对象  没有则返回null
	 * @throws AppException
	 */
	public Account load(Account account)throws AppException;
	
	public void update(Account account)throws AppException;
	
	public Account load(int id) throws AppException;
	/**
	 * 通过用户ID,获取角色，在获取菜单集合
	 * @param account_id
	 * @return
	 * @throws AppException
	 */
	public Set<Module> listNav(int account_id)throws AppException;
	/**
	 * 获取第一个导航
	 * @return
	 * @throws AppException
	 */
	public List<Module> listParent()throws AppException ;
	
	public void add(Account account)throws AppException;
	
	public void delete(int id)throws AppException;
	
	public PageBean queryAccountList(PageBean pb , AccountQuery query)throws AppException;
	
	

}
