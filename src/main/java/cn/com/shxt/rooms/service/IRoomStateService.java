package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomState;
import cn.com.shxt.rooms.domain.RoomType;

public interface IRoomStateService {

	public void add(RoomState roomState);
	public void delete(RoomState obj);
	public void update(RoomState obj);
	public RoomState load(Class<?> cls, int id);
	public List<RoomState>list();
	public PageBean getAllPages(PageBean pb);
	public PageBean getRoomPageList(PageBean pb,RoomState rs);
	
}
