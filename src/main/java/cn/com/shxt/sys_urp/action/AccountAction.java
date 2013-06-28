package cn.com.shxt.sys_urp.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.sys_urp.domain.Account;
import cn.com.shxt.sys_urp.domain.AccountQuery;
import cn.com.shxt.sys_urp.domain.Department;
import cn.com.shxt.sys_urp.domain.Role;
import cn.com.shxt.sys_urp.service.IAccountService;
import cn.com.shxt.sys_urp.service.IDeptService;
import cn.com.shxt.sys_urp.service.IRoleService;

import com.opensymphony.xwork2.ActionContext;

public class AccountAction extends BaseAction {
	
	private Logger logger = Logger.getLogger(AccountAction.class);
	
	private IAccountService accountService;
	
	private IDeptService deptService;
	
	private IRoleService roleService;
	
	/**使用模型驱动--生成setter getter方法*/
	private Account account;
	
	/**验证码使用属性驱动*/
	private String validateCode;
	
	private List<Department> depts;
	
	private List<Role> roles;
	
	private int[] ids;
	
	/**使用模型驱动获取查询对象*/
	private AccountQuery query;
	
	/**使用模型驱动获取PageBean对象*/
	private PageBean pb;
	/**
	 * 用户登录验证
	 * @return
	 */
	public String login(){
		//1.服务端比较验证是否输入正确--注意因为验证码使用的是原始的session
		String rand = this.request.getSession().getAttribute("rand").toString();
		if(!validateCode.trim().equalsIgnoreCase(rand)){
			//返回提示信息
			this.message = "<span class='message'>验证码输入不正确!</span>";
			
			this.toJsp = "index";
			
			return INPUT;
		}
		
		account = this.accountService.load(account);
		if(account==null){
			//返回提示信息
			this.message = "<span class='message'>帐号或密码不正确!</span>";
			
			this.toJsp = "index";
			
			return INPUT;
		}else{
			this.session.put("user_session", account);
			
			this.toJsp = "index";
			return "index";
		}
		
	}
	/**
	 * 获取导航栏
	 * @return
	 */
	public String toNavJSP(){
		
		account = (Account) this.session.get("user_session");
		
		ActionContext.getContext().put("navList", this.accountService.listNav(account.getAccount_id()));
		
		//System.out.println(this.accountService.listNav(account.getAccount_id()));
		
		ActionContext.getContext().put("parentList", this.accountService.listParent());
		
		//System.out.println("--"+this.accountService.listParent());
		
		
		this.folder="admin";
		this.toJsp = "nav";
		
		return SUCCESS;
	}
	/**
	 * 显示用户列表信息
	 * @return
	 */
	public String toShowUser(){
		
		pb = this.accountService.queryAccountList(pb, query);
		
		this.folder="account";
		this.toJsp="list";
		
		return SUCCESS;
	}
	
	public String toLoadAccountJsp(){
		account = this.accountService.load(account.getAccount_id());
		this.folder="account";
		this.toJsp="show";
		return SUCCESS;
	}
	
	/**
	 * 跳转到添加用户页面
	 * @return
	 */
	public String toAddAccountJsp(){
 
		depts = this.deptService.queryDeptList();
		roles = this.roleService.queryRoleList();
		this.folder="account";
		this.toJsp="add";
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改用户信息
	 * @return
	 */
	public String toUpdateAccountJsp(){
		depts = this.deptService.queryDeptList();
		account = this.accountService.load(account.getAccount_id());
		this.folder="account";
		this.toJsp="update";
		return SUCCESS;
	}
	
	public String add(){
		account.setCreatetime(new Date());
		for (int i = ids.length - 1; i >= 0; i--) {
			Role role = new Role();
			role.setRole_id(ids[i]);
			account.getRoleSet().add(role);
		}
		for (Role role : account.getRoleSet()) {
			logger.info(role.getRole_id());
		}
		this.accountService.add(account);
		this.folder="account";
		this.toJsp="add";
		return SUCCESS;
	}

	public String update(){
		
		this.accountService.update(account);
		return SUCCESS;
	}
	
	public String delete(){
		
		logger.info(account.getAccount_id());
		this.accountService.delete(account.getAccount_id());
		this.folder="account";
		this.toJsp="list";
		return SUCCESS;
	}
	
	public IAccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public AccountQuery getQuery() {
		return query;
	}
	public void setQuery(AccountQuery query) {
		this.query = query;
	}
	public PageBean getPb() {
		return pb;
	}
	public void setPb(PageBean pb) {
		this.pb = pb;
	}
	public List<Department> getDepts() {
		return depts;
	}
	public void setDepts(List<Department> depts) {
		this.depts = depts;
	}
	public IDeptService getDeptService() {
		return deptService;
	}
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	public IRoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
}
