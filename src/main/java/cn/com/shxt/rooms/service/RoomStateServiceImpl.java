package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.dao.IRoomStateDao;
import cn.com.shxt.rooms.domain.RoomState;
import cn.com.shxt.rooms.domain.RoomType;

public class RoomStateServiceImpl implements IRoomStateService {

	private IRoomStateDao roomStateDao;

	public void add(RoomState state) {

		roomStateDao.add(state);

	}

	public void delete(RoomState obj) {
		roomStateDao.delete(obj);

	}

	public RoomState load(Class<?> cls, int id) {

		return (RoomState) this.roomStateDao.load(RoomState.class, id);
	}

	public void update(RoomState obj) {
		roomStateDao.update(obj);

	}

	@Override
	public List<RoomState> list() {
		String hql = "from RoomState";
		return (List<RoomState>) roomStateDao.list(hql);
	}

	@Override
	public PageBean getAllPages(PageBean pb) {

		String hql = "from RoomState as rs order by roomState_id asc";
		return roomStateDao.find(hql, null, pb.getPageNow(), pb.getPageSize());

	}

	public PageBean getRoomPageList(PageBean pb, RoomState roomState) {

		String hql = "from RoomState as rs where 1=1 ";

		if (pb == null) {
			pb = new PageBean();

		}

		if (roomState != null) {
			if (roomState.getRsName() != null
					&& roomState.getRsName().trim().length() > 0) {
				hql += " and rs.rsName like '%" + roomState.getRsName() + "%'";
			}
		}
		System.out.println(hql + "---------------------");

		// System.out.println("---------"+roomTypeDao.find(hql, null,
		// pb.getPageNow(), pb.getPageSize()).getList()+"=-=-=-==-=-=-=");
		return roomStateDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}

	

	public IRoomStateDao getRoomStateDao() {
		return roomStateDao;
	}

	public void setRoomStateDao(IRoomStateDao roomStateDao) {
		this.roomStateDao = roomStateDao;
	}

}
