package cn.com.shxt.sys_urp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {
	
	/**主键*/
	private int role_id;
	/**角色名称*/
	private String role_name;
	/**角色描述*/
	private String role_desc;
	
	/**自身一对多查询*/
	private Set<Module> moduleSet ;
	
	
	public Role() {
		moduleSet = new HashSet<Module>();
	}
	
	public void addModules(Module module){
		this.moduleSet.add(module);
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

	public Set<Module> getModuleSet() {
		return moduleSet;
	}

	public void setModuleSet(Set<Module> moduleSet) {
		this.moduleSet = moduleSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((moduleSet == null) ? 0 : moduleSet.hashCode());
		result = prime * result
				+ ((role_desc == null) ? 0 : role_desc.hashCode());
		result = prime * result + role_id;
		result = prime * result
				+ ((role_name == null) ? 0 : role_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (moduleSet == null) {
			if (other.moduleSet != null)
				return false;
		} else if (!moduleSet.equals(other.moduleSet))
			return false;
		if (role_desc == null) {
			if (other.role_desc != null)
				return false;
		} else if (!role_desc.equals(other.role_desc))
			return false;
		if (role_id != other.role_id)
			return false;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name
				+ ", role_desc=" + role_desc + ", moduleSet=" + moduleSet + "]";
	}


	
	
	
	
	

}
