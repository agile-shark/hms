package cn.com.shxt.rooms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.service.IRoomTypeService;
import cn.com.shxt.sys_urp.action.AccountAction;

public class RoomTypeAction extends BaseAction {

	/** Log4J代替System输出 */
	private Logger logger = Logger.getLogger(AccountAction.class);

	private IRoomTypeService roomTypeService;

	/** 使用模型驱动--生成setter getter方法 */
	private RoomType roomType;

	/** 使用模型驱动获取PageBean对象 */
	private PageBean pb;

	private List<RoomType> rtList = new ArrayList<RoomType>();

	// 分页查询
	public String RoomTypeAllPage() {
		pb = roomTypeService.getAllPages(pb);
		//System.out.println(pb.getList() + "pb------------");
		this.folder = "scan";
		this.toJsp = "roomTypeInformation";
		return SUCCESS;
	}

	// 分页条件查询
	public String RoomTypePage() {
		
		rtList=roomTypeService.list();
		
		pb = roomTypeService.getRoomPageList(pb, roomType);
		System.out.println("=========="+pb.getList()+"--------------");
		
		
		this.folder = "scan";
		this.toJsp = "roomTypeInformation";
		return SUCCESS;

	}

	// 添加
	public String toAddRoomTypeJsp() {

		logger.info("toaddRoomTypejsp--------------");
		this.folder = "scan";
		this.toJsp = "addRoomType";
		return SUCCESS;
	}

	public String add() {
		roomTypeService.add(roomType);
		this.folder = "scan";
		this.toJsp = "addRoomType";
		return SUCCESS;
	}

	// 删除
	public String del() {

		roomType = roomTypeService.load(RoomType.class, roomType.getRoomType_id());
		roomTypeService.delete(roomType);
		/*if(pb==null){
			pb = new PageBean();
		}
		if(roomType==null){
			roomType = new RoomType();
		}
		if(rtList==null){
			rtList = new ArrayList<RoomType>();
		}
		RoomTypeAllPage();
		*/
		this.folder = "scan";
		this.toJsp = "roomTypeInformation";
		return SUCCESS;
	}

	public String toLoadRoomTypeJsp() {
		roomType = roomTypeService.load(RoomType.class, roomType.getRoomType_id());
		this.folder = "scan";
		this.toJsp = "showRoomType";
		return SUCCESS;
	}
	
	// 修改信息界面
	public String toUpdateRoomTypeJsp() {
		roomType = roomTypeService.load(RoomType.class, roomType.getRoomType_id());
		this.folder = "scan";
		this.toJsp = "updateRoomType";
		return SUCCESS;
	}

	// 更新
	public String update() {
		roomTypeService.update(roomType);
		rtList = roomTypeService.list();
		if (pb == null) {
			pb = new PageBean();
		}
		pb = roomTypeService.getRoomPageList(pb, roomType);
		this.folder = "scan";
		this.toJsp = "roomTypeInformation";
		return SUCCESS;
	}

	// 普通查询
	public String sel() {

		rtList = roomTypeService.list();
		this.folder = "scan";
		this.toJsp = "roomTypeInformation";
		return SUCCESS;
	}
	
	public void checkType() throws IOException{
		
		logger.info("check start!");
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		if(this.roomTypeService.isExistType(roomType.getRtNum())){
			out.print("false");
			
		}else{
			out.print("true");
		}
		out.flush();
		out.close();
	}

	public IRoomTypeService getRoomTypeService() {
		return roomTypeService;
	}

	public void setRoomTypeService(IRoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public List<RoomType> getRtList() {
		return rtList;
	}

	public void setRtList(List<RoomType> rtList) {
		this.rtList = rtList;
	}

}
