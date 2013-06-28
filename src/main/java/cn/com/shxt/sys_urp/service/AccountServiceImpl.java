package cn.com.shxt.sys_urp.service;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.base.exception.AppException;
import cn.com.shxt.sys_urp.dao.IAccountDao;
import cn.com.shxt.sys_urp.domain.Account;
import cn.com.shxt.sys_urp.domain.AccountQuery;
import cn.com.shxt.sys_urp.domain.Module;

public class AccountServiceImpl implements IAccountService{
	
	private Logger logger = Logger.getLogger(AccountServiceImpl.class);
	
	private IAccountDao accountDao;


	@Override
	public Account load(Account account) throws AppException {
		logger.info("用户信息为--"+account.getAccount()+"--"+account.getPassword());
		
		String hql = "from Account as ac where ac.account=? and ac.password=?";
		
		account = (Account)this.accountDao.load(hql, new Object[]{account.getAccount(),account.getPassword()});
		
		logger.info("用户信息为--"+account);
		/*if(account==null){
			throw new AppException("该用户不存在");
		}*/
		return account;
	}
	
	
	public IAccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}



	public Set<Module> listNav(int account_id) throws AppException {
		
		return this.accountDao.listNav(account_id);
	}
	
	public List<Module> listParent()throws AppException {
		
		return this.accountDao.listParent();
	}


	@Override
	public void add(Account account) throws AppException {
		this.accountDao.add(account);
		
	}

	@Override
	public void delete(int id) throws AppException {
		// TODO Auto-generated method stub
		this.accountDao.delete(this.load(id));
	}

	@Override
	public PageBean queryAccountList(PageBean pb, AccountQuery query)
			throws AppException {
		String hql  = "from Account as a where 1=1 ";
		if(query!=null){
			if(query.getUser_name().trim().length()>0){
				hql += " and a.user_name like '%"+query.getUser_name()+"%'";
			}
			if(query.getAccount().trim().length()>0){
				hql += " and a.account like '%"+query.getAccount()+"%'";
			}
			if(query.getDept_name().trim().length()>0){
				//导航查询
				hql += " and a.deptDepartment.dept_name like '%"+query.getDept_name()+"%'";
			}
		}
		
		if(pb==null){
			pb=new PageBean();
			pb.setPageNow(1);
			pb.setPageSize(2);
		}
			
		pb = this.accountDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
		
		//System.out.println(pb.getList()+"-=-=-09-79898097---");
		
		return pb;
	}


	@Override
	public Account load(int id) throws AppException {
		// TODO Auto-generated method stub
		Account account = (Account) this.accountDao.load(Account.class, id);
		return account;
	}


	@Override
	public void update(Account account) throws AppException {
		// TODO Auto-generated method stub
		this.accountDao.update(account);
	}

}
