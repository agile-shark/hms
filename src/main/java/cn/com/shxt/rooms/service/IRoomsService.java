package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.domain.Rooms;
import cn.com.shxt.rooms.domain.RoomQuery;

import cn.com.shxt.base.dao.PageBean;

public interface IRoomsService {

	public void add(Rooms obj);
	public void delete(Rooms obj);
	public void update(Rooms obj);
	public Rooms load(Class<?> cls, int id);
	public List<Rooms>list();
	public PageBean getRoomPageList(PageBean pb,RoomQuery query);
	public PageBean getfreeRoomList(PageBean pb,RoomQuery query);
	public PageBean getfreeScheduleRoomList(PageBean pb,RoomQuery query);
	PageBean getAllPages(PageBean pb);
	

}
