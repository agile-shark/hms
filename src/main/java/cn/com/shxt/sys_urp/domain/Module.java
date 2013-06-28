package cn.com.shxt.sys_urp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Module implements Serializable {
	
	/**主键*/
	private int module_id;
	/**模块名称*/
	private String name;
	/**访问路径*/
	private String url;
	/**排序*/
	private int sortno;
	/**菜单图标*/
	private String icon;
	/**描述*/
	private String note;
	
	
	private Integer parent_id;
	
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSortno() {
		return sortno;
	}
	public void setSortno(int sortno) {
		this.sortno = sortno;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + module_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result
				+ ((parent_id == null) ? 0 : parent_id.hashCode());
		result = prime * result + sortno;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Module other = (Module) obj;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (module_id != other.module_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (parent_id == null) {
			if (other.parent_id != null)
				return false;
		} else if (!parent_id.equals(other.parent_id))
			return false;
		if (sortno != other.sortno)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Module [module_id=" + module_id + ", name=" + name + ", url="
				+ url + ", sortno=" + sortno + ", icon=" + icon + ", note="
				+ note + ", parent_id=" + parent_id + "]";
	}
	


}
