package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomResideRecord;
import cn.com.shxt.rooms.domain.Rooms;

public interface IRoomResideRecordService {

	public void add(RoomResideRecord resideRecord);
	public void delete(RoomResideRecord obj);
	public void update(RoomResideRecord obj);
	public RoomResideRecord load(Class<?> cls, int id);
	public float countPrice(RoomResideRecord resideRecord, int residedate);
	public Rooms getRoomsName(RoomResideRecord resideRecord);
	public List<RoomResideRecord>list();
	public PageBean getResideRecordPage(PageBean pb,RoomResideRecord roomResideRecord);
	public PageBean getResideRecordAllPage(PageBean pb);

}
