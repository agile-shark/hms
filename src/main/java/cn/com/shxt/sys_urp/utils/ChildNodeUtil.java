package cn.com.shxt.sys_urp.utils;

import java.util.List;

import cn.com.shxt.sys_urp.dao.IModuleDao;
import cn.com.shxt.sys_urp.dao.MoudleDaoImpl;
import cn.com.shxt.sys_urp.domain.Module;

public class ChildNodeUtil {


	public static List<Module> getNode(int parent_id){
		String hql = "from Module as m where m.parent_id=? ";
		IModuleDao moduleDao = new MoudleDaoImpl();
		System.out.println(moduleDao.list(hql, parent_id));
		return (List<Module>) moduleDao.list(hql, parent_id);
	}
	
	public static int getNodeCount(int parent_id){
		String hql = "from Module as m where m.parent_id=? ";
		IModuleDao moduleDao = new MoudleDaoImpl();
		System.out.println("----------------------"+ moduleDao.list(hql, parent_id).size());
		System.out.println(moduleDao.list(hql, parent_id));
		return  moduleDao.list(hql, parent_id).size();
	}
	
	

}
