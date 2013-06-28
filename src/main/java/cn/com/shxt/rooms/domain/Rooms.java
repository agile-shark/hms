package cn.com.shxt.rooms.domain;

import java.io.Serializable;

public class Rooms implements Serializable{
	
	/**主键*/
	private int room_id;
	/**多对一类型*/
	private RoomType roomType;
	/**多对一状态*/
	private RoomState roomState;
	/**房间号*/
	private String roomNum;
	/**客房系统编号*/
	private String roomSNum;
	/**备注*/
	private String roomRemark;
	
	
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public RoomState getRoomState() {
		return roomState;
	}
	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomSNum() {
		return roomSNum;
	}
	public void setRoomSNum(String roomSNum) {
		this.roomSNum = roomSNum;
	}
	public String getRoomRemark() {
		return roomRemark;
	}
	public void setRoomRemark(String roomRemark) {
		this.roomRemark = roomRemark;
	}
	

}
