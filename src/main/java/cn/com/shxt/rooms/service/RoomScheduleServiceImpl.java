package cn.com.shxt.rooms.service;

import cn.com.shxt.rooms.dao.IRoomScheduleDao;
import cn.com.shxt.rooms.domain.RoomSchedule;

public class RoomScheduleServiceImpl implements IRoomScheduleService {

	private IRoomScheduleDao roomScheduleDao;

	public IRoomScheduleDao getRoomScheduleDao() {
		return roomScheduleDao;
	}

	public void setRoomScheduleDao(IRoomScheduleDao roomScheduleDao) {
		this.roomScheduleDao = roomScheduleDao;
	}

	public void add(RoomSchedule roomSchedule) {
		// TODO Auto-generated method stub
		 roomScheduleDao.add(roomSchedule);
	}
	
	
}
