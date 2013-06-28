package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.dao.IRoomStateDao;
import cn.com.shxt.rooms.dao.IRoomTypeDao;

public class RoomTypeServiceImpl implements IRoomTypeService {

	private IRoomTypeDao roomTypeDao;
	
	
	public void add(RoomType type) {
		
		
		roomTypeDao.add(type);

	}


	public void delete(RoomType obj) {
		roomTypeDao.delete(obj);
		
	
	}

	
	public RoomType load(Class<?> cls, int id) {
		
		return (RoomType) this.roomTypeDao.load(RoomType.class, id);
	}

	
	public void update(RoomType obj) {
	roomTypeDao.update(obj);

	}

	
	@Override
	public List<RoomType> list() {
	String hql="from RoomType";
		return (List<RoomType>) roomTypeDao.list(hql);
	}


	@Override
	public PageBean getAllPages(PageBean pb) {
	  
		if (pb == null) {
			pb = new PageBean();
		}
		String hql="from RoomType rt order by roomType_id asc";
		return roomTypeDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
		
	}



	public PageBean getRoomPageList(PageBean pb, RoomType rt) {
	
		String hql  = "from RoomType as rt where 1=1 ";
		if(pb==null){
			pb=new PageBean();
			
		}
		
		if(rt!=null){
			if(rt.getRoomType_id()!=0){
				hql += " and rt.roomType_id ="+rt.getRoomType_id();
			}if(rt.getRtPrice()!=0){
				hql += " and rt.rtPrice = "+rt.getRtPrice();
			}
		}
		//System.out.println(hql+"--------------===============");
		
		
		//System.out.println("---------"+roomTypeDao.find(hql, null, pb.getPageNow(), pb.getPageSize()).getList()+"=-=-=-==-=-=-=");
		return this.roomTypeDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}
	
	

	
	
	

	public IRoomTypeDao getRoomTypeDao() {
		return roomTypeDao;
	}

	public void setRoomTypeDao(IRoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}


	@Override
	public boolean isExistType(String num) {
		// TODO Auto-generated method stub
		
		if(null != this.roomTypeDao.load("from RoomType where rt_num = ?", new Object[]{num})){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	
}
