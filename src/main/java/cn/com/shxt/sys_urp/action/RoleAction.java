package cn.com.shxt.sys_urp.action;

import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.sys_urp.domain.Role;
import cn.com.shxt.sys_urp.service.IRoleService;

public class RoleAction extends BaseAction {
	
	private Logger logger = Logger.getLogger(AccountAction.class);
	
	private IRoleService roleService;
	
	private PageBean pb;

	/**使用模型驱动--生成setter getter方法*/
	private Role role;
	

	public String toShowUser(){
		
		return SUCCESS;
	}
	
	public String addRole(){

		return SUCCESS;
	}
	
	/**
	 * 显示角色列表信息
	 * @return
	 */
	public String showAllList(){
		
		pb = this.roleService.queryRoleList(pb, new Role());
		this.folder = "role";
		this.toJsp = "list";
		return SUCCESS;
	}
	
	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}
}
