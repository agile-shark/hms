package cn.com.shxt.rooms.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.rooms.dao.IRoomResideRecordDao;
import cn.com.shxt.rooms.domain.RoomResideRecord;
import cn.com.shxt.rooms.domain.RoomType;
import cn.com.shxt.rooms.domain.Rooms;

public class RoomResideRecordService implements IRoomResideRecordService {

	private IRoomResideRecordDao roomResideRecordDao;

	public IRoomResideRecordDao getRoomResideRecordDao() {
		return roomResideRecordDao;
	}

	public void setRoomResideRecordDao(IRoomResideRecordDao roomResideRecordDao) {
		this.roomResideRecordDao = roomResideRecordDao;
	}

	@Override
	public void add(RoomResideRecord resideRecord) {
		this.roomResideRecordDao.add(resideRecord);
	}

	@Override
	public PageBean getResideRecordPage(PageBean pb,
			RoomResideRecord rrr) {

		if (pb == null) {
			pb = new PageBean();
		}
		String hql="from RoomResideRecord as rr where 1=1 and rrRealityTime is null";
		
		if(rrr!=null){
			if(rrr.getRrNum()!=null&&rrr.getRrNum().trim().length()>0){
				hql +=" and rr.rrNum ="+rrr.getRrNum();
			}/*if(rrr.getRrIdcard()!=null&rrr.getRrIdcard().trim().length()>0){
				hql +=" and rr.rrIdcard = "+rrr.getRrIdcard();
			}*/
			
		}
		
		//System.out.println(hql+"-0-0-0-0-0-0-0-0-0-0-");
		
		return roomResideRecordDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}

	@Override
	public PageBean getResideRecordAllPage(PageBean pb) {

		if (pb == null) {
			pb = new PageBean();
		}
		String hql="from RoomResideRecord rr order by rr_id asc";
		
		return roomResideRecordDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}

	public void delete(RoomResideRecord obj) {
		roomResideRecordDao.delete(obj);

	}

	public RoomResideRecord load(Class<?> cls, int id) {
		
		return (RoomResideRecord) this.roomResideRecordDao.load(RoomResideRecord.class, id);
	}

	
	public void update(RoomResideRecord obj) {
	roomResideRecordDao.update(obj);

	}

	
	public List<RoomResideRecord> list() {
	String hql="from RoomResideRecord";
		return (List<RoomResideRecord>) roomResideRecordDao.list(hql);
	}

	//顾客应付金额
	public float countPrice(RoomResideRecord resideRecord,
			int residedate) {
		String hql="from RoomType as rt where rt.rtName=?";
		//System.out.println(resideRecord.getRtName()+"=========-----------11111111");
		String rr = resideRecord.getRtName();
		Object [] obj = {rr};
		//aksjdhfaksjdf
		RoomType roomType =  (RoomType) this.roomResideRecordDao.load(hql, obj);
		//System.out.println(this.roomResideRecordDao.load(hql, obj)+"-----countPrice----33333333333=======");
		float price = roomType.getRtPrice();
		//System.out.println(price+"=========-----------11111111");
		if(residedate<1){
			residedate = 1;
		}
		float totalPrice = residedate*price;
		return totalPrice;
	}
	
	public Rooms getRoomsName(RoomResideRecord resideRecord){
		
		String roomNum = resideRecord.getRrNum();
		
		String hql = "from Rooms as r where r.roomNum=?";
		Object [] rn = {roomNum};
		
		Rooms rooms = (Rooms) this.roomResideRecordDao.load(hql, rn);
		//System.out.println(rooms+"=--=-=-=-=--=3123423==-=-");
		return rooms;
	}
	
}
