package cn.com.shxt.rooms.domain;

import java.io.Serializable;
import java.util.Set;

public class RoomState implements Serializable {
	
	/**主键*/
	private int roomState_id;
	/**客房状态名*/
	private String rsName;
	/**备注*/
	private String rsRemark;
	/**一对多房间*/
	private Set<Rooms> rooms;
	
	
	public int getRoomState_id() {
		return roomState_id;
	}
	public void setRoomState_id(int roomState_id) {
		this.roomState_id = roomState_id;
	}
	public String getRsName() {
		return rsName;
	}
	public void setRsName(String rsName) {
		this.rsName = rsName;
	}
	public String getRsRemark() {
		return rsRemark;
	}
	public void setRsRemark(String rsRemark) {
		this.rsRemark = rsRemark;
	}
	public Set<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Rooms> rooms) {
		this.rooms = rooms;
	}
	

}
