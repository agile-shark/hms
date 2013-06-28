package cn.com.shxt.rooms.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomState;
import cn.com.shxt.rooms.service.IRoomStateService;
import cn.com.shxt.sys_urp.action.AccountAction;

public class RoomStateAction extends BaseAction {
	
	/**Log4J代替System输出*/
	private Logger logger = Logger.getLogger(AccountAction.class);
	
	private IRoomStateService roomStateService;
	
	/**使用模型驱动--生成setter getter方法*/
	private RoomState roomState;
	
	/**使用模型驱动获取PageBean对象*/
	private PageBean pb;

	private List<RoomState> rsList = new ArrayList<RoomState>();
	
	// 分页查询
	public String RoomStateAllPage() {
		pb = roomStateService.getAllPages(pb);
		System.out.println(pb.getList() + "pb------------");
		this.folder = "scan";
		this.toJsp = "roomStateInformation";
		return SUCCESS;
	}

	// 分页条件查询
	public String RoomStatePage() {
		rsList = roomStateService.list();
		if (pb == null) {
			pb = new PageBean();
		}
		if(null != roomState && "0".equals(roomState.getRsName())){
			 roomState = new RoomState();
		}
		pb = roomStateService.getRoomPageList(pb, roomState);
		// System.out.println("=========="+pb.getList()+"--------------");
		this.folder = "scan";
		this.toJsp = "roomStateInformation";
		return SUCCESS;

	}

	// 添加
	public String toaddRoomStatejsp() {

		this.folder = "scan";
		this.toJsp = "addRoomState";
		return SUCCESS;
	}

	public String add() {
		roomStateService.add(roomState);
		if (pb == null) {
			pb = new PageBean();
		}
		pb = roomStateService.getRoomPageList(pb, roomState);
		this.folder = "scan";
		this.toJsp = "roomStateInformation";
		return SUCCESS;
	}

	// 删除
	public String del() {

		roomState = roomStateService.load(RoomState.class, roomState.getRoomState_id());
		roomStateService.delete(roomState);

		if (pb == null) {
			pb = new PageBean();
		}
		pb = roomStateService.getRoomPageList(pb, roomState);
		this.folder = "scan";
		this.toJsp = "roomStateInformation";

		return SUCCESS;
	}

	// 修改信息界面
	public String getRoomStateToUpdate() {
		roomState = roomStateService.load(RoomState.class, roomState.getRoomState_id());
		this.folder = "scan";
		this.toJsp = "updateRoomState";
		return SUCCESS;
	}

	// 更新
	public String update() {
		roomStateService.update(roomState);
		rsList = roomStateService.list();
		if (pb == null) {
			pb = new PageBean();
		}
		pb = roomStateService.getRoomPageList(pb, roomState);
		this.folder = "scan";
		this.toJsp = "roomStateInformation";
		return SUCCESS;
	}

	// 普通查询
	public String sel() {

		rsList = roomStateService.list();
		this.folder = "scan";
		this.toJsp = "roomStateInformation";
		return SUCCESS;
	}

	
	public IRoomStateService getRoomStateService() {
		return roomStateService;
	}

	public void setRoomStateService(IRoomStateService roomStateService) {
		this.roomStateService = roomStateService;
	}

	public RoomState getRoomState() {
		return roomState;
	}

	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public List<RoomState> getRsList() {
		return rsList;
	}

	public void setRsList(List<RoomState> rsList) {
		this.rsList = rsList;
	}
	
	

}
