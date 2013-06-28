package cn.com.shxt.rooms.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomQuery;
import cn.com.shxt.rooms.domain.RoomSchedule;
import cn.com.shxt.rooms.domain.RoomState;
import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.domain.Rooms;
import cn.com.shxt.rooms.service.IRoomScheduleService;
import cn.com.shxt.rooms.service.IRoomStateService;
import cn.com.shxt.rooms.service.IRoomTypeService;
import cn.com.shxt.rooms.service.IRoomsService;
import cn.com.shxt.sys_urp.action.AccountAction;

public class RoomScheduleAction extends BaseAction {

	/**Log4J代替System输出*/
	private Logger logger = Logger.getLogger(RoomScheduleAction.class);
	
	private IRoomScheduleService roomScheduleService;
	private IRoomsService roomsService;
	private IRoomStateService roomStateService;
	private IRoomTypeService roomTypeService;
	
	/**使用模型驱动--生成setter getter方法*/
	private RoomSchedule roomSchedule;
	private Rooms rooms;
	private RoomType roomType;
	private RoomState roomState;
	private List<Rooms> rList = new ArrayList<Rooms>();
	private List<RoomType> roomTypeList = new ArrayList<RoomType>();
	private List<RoomState> roomStateList = new ArrayList<RoomState>();
	private RoomQuery query;

	/**使用模型驱动获取PageBean对象*/
	private PageBean pb = new PageBean();
	
	
	public String reserve(){
		logger.info("reserve start!");
		logger.info(rooms.getRoom_id());
		rooms = roomsService.load(Rooms.class, rooms.getRoom_id());
		System.out.println(rooms.getRoomNum()+"----------==========00000000");
		this.folder = "reserve";
		this.toJsp = "reserveRooms";
		return SUCCESS;
	}
	
	public String reserveUpdate(){
		logger.info("reserveUpdate start!");
		rooms = roomsService.load(Rooms.class, rooms.getRoom_id());
		roomState = roomStateService.load(RoomState.class, 2);
		rooms.setRoomState(roomState);
		logger.info("Exception start!!!");
		roomsService.update(rooms);
		this.roomScheduleService.add(roomSchedule);
		this.folder = "reserve";
		this.toJsp = "reserveRooms";
		return SUCCESS;
	}

	public IRoomScheduleService getRoomScheduleService() {
		return roomScheduleService;
	}

	public void setRoomScheduleService(IRoomScheduleService roomScheduleService) {
		this.roomScheduleService = roomScheduleService;
	}

	public RoomSchedule getRoomSchedule() {
		return roomSchedule;
	}

	public void setRoomSchedule(RoomSchedule roomSchedule) {
		this.roomSchedule = roomSchedule;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public IRoomsService getRoomsService() {
		return roomsService;
	}

	public void setRoomsService(IRoomsService roomsService) {
		this.roomsService = roomsService;
	}

	public IRoomStateService getRoomStateService() {
		return roomStateService;
	}

	public void setRoomStateService(IRoomStateService roomStateService) {
		this.roomStateService = roomStateService;
	}

	public IRoomTypeService getRoomTypeService() {
		return roomTypeService;
	}

	public void setRoomTypeService(IRoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomState getRoomState() {
		return roomState;
	}

	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}

	public List<Rooms> getrList() {
		return rList;
	}

	public void setrList(List<Rooms> rList) {
		this.rList = rList;
	}

	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

	public List<RoomState> getRoomStateList() {
		return roomStateList;
	}

	public void setRoomStateList(List<RoomState> roomStateList) {
		this.roomStateList = roomStateList;
	}

	public RoomQuery getQuery() {
		return query;
	}

	public void setQuery(RoomQuery query) {
		this.query = query;
	}
	
	
	
}
