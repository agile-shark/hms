package cn.com.shxt.sys_urp.domain;
/**
 * 方式的是查询条件的
 * @author Administrator
 *
 */
public class AccountQuery {

	private String user_name;
	
	private String account;
	
	private String dept_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

}
