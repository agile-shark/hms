package cn.com.shxt.sys_urp.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.com.shxt.base.dao.BaseDaoImpl;
import cn.com.shxt.sys_urp.domain.Module;

public class AccountDaoImpl extends BaseDaoImpl implements IAccountDao {

	public Set<Module> listNav(int account_id) {

		/*
		 * String hql = "from Account as a where  a.account_id="+account_id;
		 * 
		 * List<Account> accountList =
		 * this.getSession().createQuery(hql).list();
		 * 
		 * Set<Module> navSet = new HashSet<Module>();
		 * 
		 * for(Account account : accountList){ for(Role role :
		 * account.getRoleSet()){ navSet.addAll(role.getModuleSet()); } }
		 */

		String sql = "select distinct m.module_id from sys_account a ,account_link_role b , sys_role c, role_link_module d ,sys_moduledef m where a.account_id = b.account_id and c.role_id = b.role_id and b.role_id = d.role_id and d.mudule_id=m.module_id and a.account_id="
				+ account_id;
		List<Object> ids = this.getSession().createSQLQuery(sql).list();
		Set<Module> navSet = new HashSet<Module>();
		for (Object module_id : ids) {
			navSet.add((Module) this.getSession().load(Module.class,
					Integer.parseInt(module_id.toString())));

		}

		return navSet;

	}

	public List<Module> listParent() {
		String sql = "select * from sys_moduledef where parent_id is null";
		List<Module> parentList = this.getSession().createSQLQuery(sql)
				.addEntity(Module.class).list();

		return parentList;
	}

}
