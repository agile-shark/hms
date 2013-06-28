package cn.com.shxt.rooms.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomQuery;
import cn.com.shxt.rooms.domain.RoomState;
import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.domain.Rooms;
import cn.com.shxt.rooms.service.IRoomStateService;
import cn.com.shxt.rooms.service.IRoomTypeService;
import cn.com.shxt.rooms.service.IRoomsService;


public class RoomsAction extends BaseAction {

	/**Log4J代替System输出*/
	private Logger logger = Logger.getLogger(RoomsAction.class);
	
	private IRoomsService roomsService;
	private IRoomStateService roomStateService;
	private IRoomTypeService roomTypeService;
	
	/**使用模型驱动--生成setter getter方法*/
	private Rooms rooms;
	
	private RoomType roomType;
	private RoomState roomState;
	
	private List<Rooms> rList = new ArrayList<Rooms>();
	private List<RoomType> roomTypeList = new ArrayList<RoomType>();
	private List<RoomState> roomStateList = new ArrayList<RoomState>();
	private RoomQuery query;

	/**使用模型驱动获取PageBean对象*/
	private PageBean pb = new PageBean();
	
	
	// 分页查询
		public String RoomAllPage() {
			if (pb == null) {
				pb = new PageBean();
			}
			roomTypeList=roomTypeService.list();
			roomStateList=roomStateService.list();
			pb = roomsService.getAllPages(pb);
			System.out.println(pb.getList() + "pb------------");
			this.folder = "scan";
			this.toJsp = "roomsInformation";
			return SUCCESS;
		}

		// 分页条件查询
		public String RoomPage() {
			if (pb == null) {
				pb = new PageBean();
			}
			roomTypeList=roomTypeService.list();
			roomStateList=roomStateService.list();
			pb = roomsService.getRoomPageList(pb, query);
			// System.out.println("=========="+pb.getList()+"--------------");
			this.folder = "scan";
			this.toJsp = "roomsInformation";
			return SUCCESS;
		}
		
		//查询空闲的房间信息
		public String Roomsfree(){
			
			if (pb == null) {
				pb = new PageBean();
			}
			
			roomTypeList=roomTypeService.list();
			roomStateList=roomStateService.list();
			
			pb = roomsService.getfreeRoomList(pb, query);
			
			this.folder = "reserve";
			this.toJsp = "freeRoomsInformation";
			
			return SUCCESS;
		}
		
		//查询空闲和预订的房间信息
				public String RoomsfreeSchedule(){
					
					if (pb == null) {
						pb = new PageBean();
					}
					
					roomTypeList=roomTypeService.list();
					roomStateList=roomStateService.list();
					
					pb = roomsService.getfreeScheduleRoomList(pb, query);
					
					this.folder = "reserve";
					this.toJsp = "freeRoomsInformation";
					
					return SUCCESS;
				}

		//查询空闲的房间信息
		public String Roomsregister(){
			this.RoomsfreeSchedule();
			this.folder = "register";
			return SUCCESS;
		}
		
		// 添加
		public String toAddRoomsJsp() {
			logger.info("add start.");
			roomTypeList=roomTypeService.list();
			roomStateList=roomStateService.list();
			
			this.folder = "scan";
			this.toJsp = "addRooms";
			return SUCCESS;
		}

		public String add() {
			logger.info("adding...");
			logger.info(roomState.getRoomState_id());
			logger.info(roomType.getRoomType_id());
 			rooms.setRoomState(roomState);
			rooms.setRoomType(roomType);
			logger.info(rooms.getRoomState().getRoomState_id());
			logger.info(rooms.getRoomType().getRoomType_id()); 
			roomsService.add(rooms);
			RoomAllPage();
			return SUCCESS;
		}

		// 删除
		public String del() {

			rooms = roomsService.load(Rooms.class, rooms.getRoom_id());
			roomsService.delete(rooms);

			RoomAllPage();

			return SUCCESS;
		}

		// 修改信息界面
		public String getroomsToUpdate() {
			
			rooms = roomsService.load(Rooms.class, rooms.getRoom_id());
			
			roomTypeList=roomTypeService.list();
			roomStateList=roomStateService.list();
			
			this.folder = "scan";
			this.toJsp = "updateRooms";
			return SUCCESS;
		}

		// 更新
		public String update() {
			roomsService.update(rooms);
			RoomPage();
			return SUCCESS;
		}

		// 普通查询
		public String sel() {

			rList = roomsService.list();
			this.folder = "scan";
			this.toJsp = "roomsInformation";
			return SUCCESS;
		}
	

	public IRoomsService getRoomsService() {
		return roomsService;
	}

	public void setRoomsService(IRoomsService roomsService) {
		this.roomsService = roomsService;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
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

	public List<Rooms> getrList() {
		return rList;
	}

	public void setrList(List<Rooms> rList) {
		this.rList = rList;
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
}
