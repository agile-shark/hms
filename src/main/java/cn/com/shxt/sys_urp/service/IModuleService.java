package cn.com.shxt.sys_urp.service;

import java.util.List;
import java.util.Set;

import cn.com.shxt.base.exception.AppException;
import cn.com.shxt.sys_urp.domain.Module;


public interface IModuleService {
	public List<Module> listAll()throws AppException;
	
	public void add(Module module)throws AppException;
	
	public void update(Module module)throws AppException;
	
	public Module load(int module_id)throws AppException;
	
	public void delete(int module_id)throws AppException;
}
