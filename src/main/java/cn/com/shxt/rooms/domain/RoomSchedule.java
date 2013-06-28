package cn.com.shxt.rooms.domain;

import java.io.Serializable;
import java.util.Date;

public class RoomSchedule implements Serializable {

	/**主键*/
	private int sche_id;
	/**预订人姓名*/
	private String rrPName;
	/**预住日期*/
	private Date scheTime;
	/**预住天数*/
	private int scheDay;
	/**押金*/
	private int scheDeposit;
	/**预订房间编号*/
	private int scheNum;
	/**开单人*/
	private String scheBilling;
	public int getSche_id() {
		return sche_id;
	}
	public void setSche_id(int sche_id) {
		this.sche_id = sche_id;
	}
	public String getRrPName() {
		return rrPName;
	}
	public void setRrPName(String rrPName) {
		this.rrPName = rrPName;
	}
	public Date getScheTime() {
		return scheTime;
	}
	public void setScheTime(Date scheTime) {
		this.scheTime = scheTime;
	}
	public int getScheDay() {
		return scheDay;
	}
	public void setScheDay(int scheDay) {
		this.scheDay = scheDay;
	}
	public int getScheDeposit() {
		return scheDeposit;
	}
	public void setScheDeposit(int scheDeposit) {
		this.scheDeposit = scheDeposit;
	}
	public int getScheNum() {
		return scheNum;
	}
	public void setScheNum(int scheNum) {
		this.scheNum = scheNum;
	}
	public String getScheBilling() {
		return scheBilling;
	}
	public void setScheBilling(String scheBilling) {
		this.scheBilling = scheBilling;
	}
	@Override
	public String toString() {
		return "RoomSchedule [sche_id=" + sche_id + ", rrPName=" + rrPName
				+ ", scheTime=" + scheTime + ", scheDay=" + scheDay
				+ ", scheDeposit=" + scheDeposit + ", scheNum=" + scheNum
				+ ", scheBilling=" + scheBilling + "]";
	}
	
	
}
