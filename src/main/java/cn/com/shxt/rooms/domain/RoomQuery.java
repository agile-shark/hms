package cn.com.shxt.rooms.domain;

public class RoomQuery {
	
	/**房间号*/
	private String roomNum;
	/**房间类型*/
	private int roomType_id;
	/**房间状态*/
	private int roomState_id;
	/**状态名*/
	private String rsName;
	/**房间价格*/
	private float rtPrice;
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public int getRoomType_id() {
		return roomType_id;
	}
	public void setRoomType_id(int roomType_id) {
		this.roomType_id = roomType_id;
	}
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
	public float getRtPrice() {
		return rtPrice;
	}
	public void setRtPrice(float rtPrice) {
		this.rtPrice = rtPrice;
	}
	
	

}
