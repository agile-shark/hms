package cn.com.shxt.sys_urp.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.base.exception.AppException;
import cn.com.shxt.sys_urp.domain.Role;

public interface IRoleService {
	
	public void add(Role role)throws AppException;
	
	public List<Role> queryRoleList();
	
	public PageBean queryRoleList(PageBean pb , Role role)throws AppException;
}
