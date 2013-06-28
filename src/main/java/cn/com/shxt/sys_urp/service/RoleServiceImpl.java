package cn.com.shxt.sys_urp.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.base.exception.AppException;
import cn.com.shxt.sys_urp.dao.IRoleDao;
import cn.com.shxt.sys_urp.domain.Role;

public class RoleServiceImpl implements IRoleService {
	
	private IRoleDao roleDao;

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void add(Role role) throws AppException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageBean queryRoleList(PageBean pb, Role role) throws AppException {
		// TODO Auto-generated method stub
		String hql  = "from Role as r where 1=1 ";
/*		if(null != role){
			if(role.getRole_name().trim().length()>0){
				hql += " and r.role_name like '%"+role.getRole_name()+"%'";
			}
			if(role.getRole_desc().trim().length()>0){
				hql += " and r.role_desc like '%"+role.getRole_desc()+"%'";
			}
		}*/
		
		if(pb==null){
			pb=new PageBean();
			pb.setPageNow(1);
			pb.setPageSize(2);
		}
			
		pb = this.roleDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
		
		System.out.println(pb.getList().size());
		
		return pb;
	}

	@Override
	public List<Role> queryRoleList() {
		// TODO Auto-generated method stub
		String hql = "from Role";
		
		return (List<Role>) this.roleDao.list(hql);
	}
	

}
