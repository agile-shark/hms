package cn.com.shxt.sys_urp.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Account implements Serializable {
	
	/**主键*/
	private int account_id;
	/**帐号*/
	private String account;
	/**用户姓名*/
	private String user_name;
	/**密码*/
	private String password;
	/**性别*/
	private int sex;
	/**联系电话*/
	private String telephone;
	/**职务*/
	private String position;
	/**创建日期*/
	private Date createtime;
	/**创建者帐号*/
	private String createaccount;
	/**访问主页*/
	private String homepage;
	/**电子邮件*/
	private String email;
	
	/**一对一部门*/
	private Department deptDepartment;
	
	/**一对多角色*/
	private Set<Role> roleSet ;
	

	public Account() {
		this.roleSet = new HashSet<Role>();
	}
	public void add(Role role){
		this.roleSet.add(role);
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateaccount() {
		return createaccount;
	}

	public void setCreateaccount(String createaccount) {
		this.createaccount = createaccount;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDeptDepartment() {
		return deptDepartment;
	}

	public void setDeptDepartment(Department deptDepartment) {
		this.deptDepartment = deptDepartment;
	}
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account=" + account
				+ ", user_name=" + user_name + ", password=" + password
				+ ", sex=" + sex + ", telephone=" + telephone + ", position="
				+ position + ", createtime=" + createtime + ", createaccount="
				+ createaccount + ", homepage=" + homepage + ", email=" + email
				+ ", deptDepartment=" + deptDepartment + ", roleSet=" + roleSet
				+ "]";
	}

}
