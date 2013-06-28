package cn.com.shxt.sys_urp.dao;

import java.util.List;
import java.util.Set;

import cn.com.shxt.base.dao.IBaseDao;
import cn.com.shxt.sys_urp.domain.Module;

public interface IAccountDao extends IBaseDao {
	public Set<Module> listNav(int account_id);
	
	public List<Module> listParent();
}
