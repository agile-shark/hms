package cn.com.shxt.sys_urp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import cn.com.shxt.base.exception.AppException;
import cn.com.shxt.sys_urp.dao.IModuleDao;
import cn.com.shxt.sys_urp.dao.IRoleDao;
import cn.com.shxt.sys_urp.domain.Module;
import cn.com.shxt.sys_urp.domain.Role;

public class ModuleServiceImpl implements IModuleService {

	private Logger logger = Logger.getLogger(ModuleServiceImpl.class);

	private IModuleDao moduleDao;

	public IModuleDao getModuleDao() {
		return moduleDao;
	}

	public void setModuleDao(IModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	@Override
	public List<Module> listAll() throws AppException {
		String hql = "from Module where parent_id is null ";

		return (List<Module>) this.moduleDao.list(hql);
	}

	@Override
	public void add(Module module) throws AppException {
		// 先查询输入的Root节点名称是否存在
		String hql = "from Module as m where m.name=?";

		List list = this.moduleDao.list(hql, module.getName().trim());

		if (list != null && list.size() > 0) {
			throw new AppException("该Root节点重名，请重新输入!");
		} else {
			this.moduleDao.add(module);
		}

	}

	@Override
	public Module load(int module_id) throws AppException {
		Module module = (Module) this.moduleDao.load(Module.class, module_id);
		if (module == null) {
			throw new AppException("抱歉你所查询的数据不存在!");
		}
		return module;
	}

	@Override
	public void update(Module module) throws AppException {
		// 先查询输入的Root节点名称是否存在
		String hql = "from Module as m where m.name=?";

		List list = this.moduleDao.list(hql, module.getName().trim());
		if (list != null && list.size() > 0) {
			throw new AppException("该Root节点重名，请重新输入!");
		} else {
			this.moduleDao.update(module);
		}

	}

	@Override
	public void delete(int module_id) throws AppException {
		
		Module module = (Module) this.moduleDao.load(Module.class, module_id);
		
		
	}
	
	

}
