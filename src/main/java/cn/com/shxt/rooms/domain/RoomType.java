package cn.com.shxt.rooms.domain;

import java.io.Serializable;
import java.util.Set;

public class RoomType implements Serializable {
	
	/**主键*/
	private int roomType_id;
	/**类型名称*/
	private String rtName;
	/**类型编号*/
	private String rtNum;
	/**房间价格*/
	private float rtPrice;
	/**是否特价*/
	private String rtBargain;
	/**特价价格*/
	private float rtBPrice;
	/**标准面积*/
	private String rtArea;
	/**折扣*/
	private float rtDiscount;
	/**是否有电脑*/
	private String rtComputer;
	/**是否有空调*/
	private String rtCondition;
	/**是否有窗户*/
	private String rtWindow;
	/**位置*/
	private String rtLocation;
	/**床位数*/
	private String rtBNum;
	/**一对多房间*/
	private Set<Rooms> rooms;
	
	
	
	public int getRoomType_id() {
		return roomType_id;
	}
	public void setRoomType_id(int roomType_id) {
		this.roomType_id = roomType_id;
	}
	public String getRtName() {
		return rtName;
	}
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}
	public String getRtNum() {
		return rtNum;
	}
	public void setRtNum(String rtNum) {
		this.rtNum = rtNum;
	}
	public float getRtPrice() {
		return rtPrice;
	}
	public void setRtPrice(float rtPrice) {
		this.rtPrice = rtPrice;
	}
	public String getRtBargain() {
		return rtBargain;
	}
	public void setRtBargain(String rtBargain) {
		this.rtBargain = rtBargain;
	}

	public float getRtBPrice() {
		return rtBPrice;
	}
	public void setRtBPrice(float rtBPrice) {
		this.rtBPrice = rtBPrice;
	}
	public String getRtArea() {
		return rtArea;
	}
	public void setRtArea(String rtArea) {
		this.rtArea = rtArea;
	}
	
	public float getRtDiscount() {
		return rtDiscount;
	}
	public void setRtDiscount(float rtDiscount) {
		this.rtDiscount = rtDiscount;
	}
	public String getRtComputer() {
		return rtComputer;
	}
	public void setRtComputer(String rtComputer) {
		this.rtComputer = rtComputer;
	}
	public String getRtCondition() {
		return rtCondition;
	}
	public void setRtCondition(String rtCondition) {
		this.rtCondition = rtCondition;
	}
	public String getRtWindow() {
		return rtWindow;
	}
	public void setRtWindow(String rtWindow) {
		this.rtWindow = rtWindow;
	}
	public String getRtLocation() {
		return rtLocation;
	}
	public void setRtLocation(String rtLocation) {
		this.rtLocation = rtLocation;
	}
	public String getRtBNum() {
		return rtBNum;
	}
	public void setRtBNum(String rtBNum) {
		this.rtBNum = rtBNum;
	}
	public Set<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Rooms> rooms) {
		this.rooms = rooms;
	}
	
	
	
	
	
	

}
