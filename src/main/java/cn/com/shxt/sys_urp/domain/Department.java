package cn.com.shxt.sys_urp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable {
	
	/**主键*/
	private int dept_id;
	/**部门名称*/
	private String dept_name;
	/**描述*/
	private String note;
	/**创建日期*/
	private Date createtime;
	/**创建者帐号*/
	private String createaccount;
	
	/**自身一对多*/
	private Set<Department> deptSets ;
	
	private int dept_type;
	
	public Department() {
		this.deptSets = new HashSet<Department>();
	}
	
	public void add(Department dept){
		this.deptSets.add(dept);
	}

	private int parent_id;
	

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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


	public Set<Department> getDeptSets() {
		return deptSets;
	}

	public void setDeptSets(Set<Department> deptSets) {
		this.deptSets = deptSets;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getDept_type() {
		return dept_type;
	}

	public void setDept_type(int dept_type) {
		this.dept_type = dept_type;
	}
}
