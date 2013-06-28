package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomType;

public interface IRoomTypeService {

	public void add(RoomType roomType);
	public void delete(RoomType obj);
	public void update(RoomType obj);
	public RoomType load(Class<?> cls, int id);
	public boolean isExistType(String num);
	public List<RoomType>list();
	public PageBean getAllPages(PageBean pb);
	public PageBean getRoomPageList(PageBean pb,RoomType rt);
	
}
