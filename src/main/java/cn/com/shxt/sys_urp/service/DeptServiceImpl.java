package cn.com.shxt.sys_urp.service;

import java.util.List;

import cn.com.shxt.sys_urp.dao.IDeptDao;
import cn.com.shxt.sys_urp.domain.Department;


public class DeptServiceImpl implements IDeptService {

	private IDeptDao deptDao;
	
	public List<Department> queryDeptList(){
		String hql = "from Department";
		
		return (List<Department>) this.deptDao.list(hql);
	}

	public IDeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	};
}
