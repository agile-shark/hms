package cn.com.shxt.rooms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomResideRecord;
import cn.com.shxt.rooms.domain.RoomState;
import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.domain.Rooms;
import cn.com.shxt.rooms.service.IRoomResideRecordService;
import cn.com.shxt.rooms.service.IRoomStateService;
import cn.com.shxt.rooms.service.IRoomTypeService;
import cn.com.shxt.rooms.service.IRoomsService;

public class RoomResideRecordAction extends BaseAction {

	/** Log4J代替System输出 */
	private Logger logger = Logger.getLogger(RoomResideRecordAction.class);

	private IRoomResideRecordService roomResideRecordService;
	private IRoomsService roomsService;
	private IRoomStateService roomStateService;
	private IRoomTypeService roomTypeService;
	private List<RoomType> roomTypeList = new ArrayList<RoomType>();
	/** 使用模型驱动--生成setter getter方法 */
	private RoomResideRecord roomRes;
	private RoomState roomState;
	private Rooms rooms;

	private List<RoomResideRecord> roomReList = new ArrayList<RoomResideRecord>();
	/** 使用模型驱动获取PageBean对象 */
	private PageBean pb;

	// 入住信息添加
	public String toRegisterJsp() {
		logger.info("add start.");
		logger.info(rooms.getRoom_id());
		rooms = roomsService.load(Rooms.class, rooms.getRoom_id());
		this.folder = "register";
		this.toJsp = "registerRooms";
		return SUCCESS;
	}

	public String add() {
		logger.info("adding...");
		rooms = roomsService.load(Rooms.class, rooms.getRoom_id());
		roomState = roomStateService.load(RoomState.class, 3);
		rooms.setRoomState(roomState);
		logger.info("Exception start!!!");
		roomsService.update(rooms);
		this.roomResideRecordService.add(roomRes);
		this.folder = "register";
		this.toJsp = "registerRooms";
		return SUCCESS;
	}

	// 分页查询
	public String getResideRecordAllPage() {

		pb = roomResideRecordService.getResideRecordAllPage(pb);
		this.folder = "register";
		this.toJsp = "roomResideRecordInformation";
		return SUCCESS;
	}

	// 分页条件查询
	public String getResidePage() {

		if (roomRes != null && "0".equals(roomRes.getRrNum())) {
			if ("0".equals(roomRes.getRrIdcard())) {
				roomRes = new RoomResideRecord();
			}

		}

		roomReList = roomResideRecordService.list();
		pb = roomResideRecordService.getResideRecordPage(pb, roomRes);

		this.folder = "register";
		this.toJsp = "roomResideRecordInformation";
		return SUCCESS;
	}

	// 修改信息界面
	public String toUpdateroomResideRecordJsp() {
		if (roomRes == null) {
			roomRes = new RoomResideRecord();
		}
		roomRes = roomResideRecordService.load(RoomResideRecord.class,
				roomRes.getRr_id());
		this.folder = "register";
		this.toJsp = "updateroomResideRecord";
		return SUCCESS;
	}

	// 退宿，房间状态改为空闲
	public String update() {
		String room2 = roomRes.getRrBilling();
		roomRes = roomResideRecordService.load(RoomResideRecord.class,
				roomRes.getRr_id());
		// System.out.println(roomRes.getRrNum()+"---------33333------====");
		Rooms rooms1 = roomResideRecordService.getRoomsName(roomRes);
		int roomsId = rooms1.getRoom_id();
		rooms = roomsService.load(Rooms.class, roomsId);
		roomState = roomStateService.load(RoomState.class, 1);
		rooms.setRoomState(roomState);
		roomsService.update(rooms);
		Date date = new Date();
		roomRes.setRrRealityTime(date);
		roomRes.setRrBilling(room2);
		roomResideRecordService.update(roomRes);

		this.folder = "register";
		this.toJsp = "quitroomReside";
		return SUCCESS;
	}

	// 删除
	public String del() {

		roomRes = roomResideRecordService.load(RoomResideRecord.class,
				roomRes.getRr_id());
		roomResideRecordService.delete(roomRes);

		this.folder = "register";
		this.toJsp = "roomResideRecordInformation";
		return SUCCESS;
	}

	// 查看详情
	public String toLoadResideRecordJsp() {
		logger.info("toLoadResideRecordJsp--------------");
		if (roomRes == null) {
			roomRes = new RoomResideRecord();
		}
		roomRes = roomResideRecordService.load(RoomResideRecord.class,
				roomRes.getRr_id());
		this.folder = "register";
		this.toJsp = "showRoomResideRecordType";
		return SUCCESS;
	}

	// 退房结算
	public String toCountResideRecordJsp() throws ParseException {
		logger.info("toLoadResideRecordJsp--------------");
		if (roomRes == null) {
			roomRes = new RoomResideRecord();
		}
		roomRes = roomResideRecordService.load(RoomResideRecord.class,
				roomRes.getRr_id());
		// System.out.println(roomRes.getRrPName()+"======----3333444333222222");
		/*
		 * Date date = new Date(); int date1 =
		 * date.getDate()-roomRes.getRrTime().getDate(); if(date.getHours()<12){
		 * date1 = date1+1; }
		 */
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date date1 = myFormatter.parse((myFormatter.format(date)));
		Date date2 = myFormatter.parse(roomRes.getRrTime().toString());
		int day = (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));
		if (date.getHours() > 12) {
			day = day + 1;
		}
		System.out.println(day + "----------date===============");
		roomRes.setRrPreMoney(roomResideRecordService.countPrice(roomRes, day));
		roomRes.setRrDate(day);
		// roomRes.setRrRealityTime(date);
		// System.out.println(roomRes.getRrPreMoney()+"======----3333355533222222");
		// System.out.println(roomRes.getRrPName()+"======----333333666222222");
		// 计算顾客商品消费多少钱,再加到实际金额中
		if (roomRes.getRrMember().equals("是")) {
			float rMoney = (float) (roomRes.getRrPreMoney() * 0.8);
			roomRes.setRrRealityMoney(rMoney);
		} else {
			roomRes.setRrRealityMoney(roomRes.getRrPreMoney());
		}
		roomResideRecordService.update(roomRes);
		// System.out.println(roomRes.getRrPreMoney()+"======----333337773222222");
		// System.out.println(roomRes.getRrPName()+"======----33333388822222");

		this.folder = "register";
		this.toJsp = "updateroomResideRecord";
		return SUCCESS;
	}

	// 添加
	public String toAddRoomResideRecordJsp() {

		logger.info("toAddRoomResideRecordJsp--------------");
		this.folder = "register";
		this.toJsp = "addRoomResideRecord";
		return SUCCESS;
	}

	public String addResideRecord() {
		roomResideRecordService.add(roomRes);
		this.folder = "register";
		this.toJsp = "roomResideRecordInformation";
		return SUCCESS;
	}

	public IRoomResideRecordService getRoomResideRecordService() {
		return roomResideRecordService;
	}

	public void setRoomResideRecordService(
			IRoomResideRecordService roomResideRecordService) {
		this.roomResideRecordService = roomResideRecordService;
	}

	public RoomResideRecord getRoomRes() {
		return roomRes;
	}

	public void setRoomRes(RoomResideRecord roomRes) {
		this.roomRes = roomRes;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
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

	public RoomState getRoomState() {
		return roomState;
	}

	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}

	public IRoomTypeService getRoomTypeService() {
		return roomTypeService;
	}

	public void setRoomTypeService(IRoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

	public List<RoomResideRecord> getRoomReList() {
		return roomReList;
	}

	public void setRoomReList(List<RoomResideRecord> roomReList) {
		this.roomReList = roomReList;
	}
}
