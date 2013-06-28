package cn.com.shxt.sys_urp.action;

import com.opensymphony.xwork2.ActionContext;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.sys_urp.domain.Module;
import cn.com.shxt.sys_urp.service.IModuleService;

public class ModuleAction extends BaseAction {
	
	private Module module;
	
	private IModuleService moduleService;
	
	public IModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(IModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public String showAllList(){
		ActionContext.getContext().put("allModuleList", this.moduleService.listAll());
		this.folder="module";
		this.toJsp="list";
		return SUCCESS;
	}
	/**
	 * 跳转到添加ROOT页面页面
	 * @return
	 */
	public String toAddRootJsp(){
		this.folder="module";
		this.toJsp="root_add";
		return SUCCESS;
	}
	/**
	 * 跳转到更新ROOT页面页面
	 * @return
	 */
	public String toUpdateRootJsp(){
		try {
			module = this.moduleService.load(module.getModule_id());
			
		} catch (Exception e) {
			this.message = e.getMessage();
		}
		
		
		this.folder="module";
		this.toJsp="root_update";
		return SUCCESS;
	}
	/**
	 * 业务--保存Root节点
	 * @return
	 */
	public String addRoot(){
		try {
			this.message = "添加ROOT节点成功";
			
			this.moduleService.add(module);
		} catch (Exception e) {
			this.message=e.getMessage();
		}
		
		this.folder="module";
		this.toJsp="message_info";
		return SUCCESS;
	}
	/**
	 * 业务--更新Root节点
	 * @return
	 */
	public String updateRoot(){
		try {
			this.message = "更新ROOT节点成功";
			this.moduleService.update(module);
		} catch (Exception e) {
			this.message=e.getMessage();
		}
		
		this.folder="module";
		this.toJsp="message_info";
		return SUCCESS;
	}
	
	public String deleteRoot(){
		
		try {
			
		} catch (Exception e) {
			this.message = e.getMessage();
		}
		
		return SUCCESS;
	}
	
	
	

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	

}
