package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.dao.IRoomsDao;
import cn.com.shxt.rooms.domain.RoomQuery;
import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.domain.Rooms;

public class RoomsServiceImpl implements IRoomsService {

	private IRoomsDao roomsDao;

	public void add(Rooms rooms) {

		roomsDao.add(rooms);

	}

	public void delete(Rooms obj) {
		roomsDao.delete(obj);

	}

	public Rooms load(Class<?> cls, int id) {

		return (Rooms) this.roomsDao.load(Rooms.class, id);
	}

	public void update(Rooms obj) {
		roomsDao.update(obj);

	}

	@Override
	public List<Rooms> list() {
		String hql = "from Rooms";
		return (List<Rooms>) roomsDao.list(hql);
	}

	@Override
	public PageBean getAllPages(PageBean pb) {

		if (pb == null) {
			pb = new PageBean();
		}

		String hql = "from Rooms as r order by room_id asc";
		return roomsDao.find(hql, null, pb.getPageNow(), pb.getPageSize());

	}

	public PageBean getRoomPageList(PageBean pb, RoomQuery query) {

		String hql = "from Rooms as ri where 1=1 ";

		if (pb == null) {
			pb = new PageBean();
		}

		if (query != null) {
			if (query.getRoomNum() != null
					&& query.getRoomNum().trim().length() > 0) {
				hql += "and ri.roomNum like '%" + query.getRoomNum() + "%'";
			}
			if (query.getRoomState_id() > 0) {
				hql += "and ri.roomState.roomState_id="
						+ query.getRoomState_id();
			}
			if (query.getRoomType_id() > 0) {
				hql += "and ri.roomType.roomType_id=" + query.getRoomType_id();
			}
		}

		// System.out.println("---------"+roomTypeDao.find(hql, null,
		// pb.getPageNow(), pb.getPageSize()).getList()+"=-=-=-==-=-=-=");
		return roomsDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}

	public PageBean getfreeRoomList(PageBean pb, RoomQuery query) {

		String hql = "from Rooms as ri where 1=1 and ri.roomState.roomState_id = 1 ";

		if (pb == null) {
			pb = new PageBean();
		}

		if (query != null) {
			if (query.getRoomNum() != null
					&& query.getRoomNum().trim().length() > 0) {
				hql += "and ri.roomNum like '%" + query.getRoomNum() + "%'";
			}
			if (query.getRtPrice() > 0) {
				hql += "and ri.roomType.rtPrice =" + query.getRtPrice();
			}
			if (query.getRoomType_id() > 0) {
				hql += "and ri.roomType.roomType_id=" + query.getRoomType_id();
			}
		}
		System.out.println(hql + "-----------===========------");
		// System.out.println("---------"+roomTypeDao.find(hql, null,
		// pb.getPageNow(), pb.getPageSize()).getList()+"=-=-=-==-=-=-=");
		return roomsDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}

	public PageBean getfreeScheduleRoomList(PageBean pb, RoomQuery query) {

		String hql = "from Rooms as ri where 1=1 and ri.roomState.roomState_id in (1,2)";

		if (pb == null) {
			pb = new PageBean();
		}

		if (query != null) {
			if (query.getRoomNum() != null
					&& query.getRoomNum().trim().length() > 0) {
				hql += "and ri.roomNum like '%" + query.getRoomNum() + "%'";
			}
			if (query.getRtPrice() > 0) {
				hql += "and ri.roomType.rtPrice =" + query.getRtPrice();
			}
			if (query.getRoomType_id() > 0) {
				hql += "and ri.roomType.roomType_id=" + query.getRoomType_id();
			}
		}
		System.out.println(hql + "-----------===========------");
		// System.out.println("---------"+roomTypeDao.find(hql, null,
		// pb.getPageNow(), pb.getPageSize()).getList()+"=-=-=-==-=-=-=");
		return roomsDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}

	public IRoomsDao getRoomsDao() {
		return roomsDao;
	}

	public void setRoomsDao(IRoomsDao roomsDao) {
		this.roomsDao = roomsDao;
	}

}
