package cn.com.shxt.rooms.domain;

import java.io.Serializable;
import java.util.Date;

public class RoomResideRecord implements Serializable {
	
	/**主键*/
	private int rr_id;
	/**客房号*/
	private String rrNum;
	/**客房类型*/
	private String rtName;
	/**订房日期*/
	private Date rrTime;
	/**房客姓名*/
	private String rrPName;
	/**房客身份证号*/
	private String rrIdcard;
	/**房客人数*/
	private int rrPNum;
	/**预计退房日期*/
	private Date rrPreTime;
	/**实际退房日期*/
	private Date rrRealityTime;
	/**押金*/
	private float rrDeposit;
	/**应付金额*/
	private float rrPreMoney;
	/**实际金额*/
	private float rrRealityMoney;
	/**入住天数*/
	private int rrDate;
	/**是否是会员*/
	private String rrMember;
	/**开单人*/
	private String rrBilling;
	public int getRr_id() {
		return rr_id;
	}
	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}

	public String getRrNum() {
		return rrNum;
	}
	public void setRrNum(String rrNum) {
		this.rrNum = rrNum;
	}
	public String getRtName() {
		return rtName;
	}
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}
	public Date getRrTime() {
		return rrTime;
	}
	public void setRrTime(Date rrTime) {
		this.rrTime = rrTime;
	}
	public String getRrPName() {
		return rrPName;
	}
	public void setRrPName(String rrPName) {
		this.rrPName = rrPName;
	}
	public String getRrIdcard() {
		return rrIdcard;
	}
	public void setRrIdcard(String rrIdcard) {
		this.rrIdcard = rrIdcard;
	}
	public int getRrPNum() {
		return rrPNum;
	}
	public void setRrPNum(int rrPNum) {
		this.rrPNum = rrPNum;
	}
	public Date getRrPreTime() {
		return rrPreTime;
	}
	public void setRrPreTime(Date rrPreTime) {
		this.rrPreTime = rrPreTime;
	}
	public Date getRrRealityTime() {
		return rrRealityTime;
	}
	public void setRrRealityTime(Date rrRealityTime) {
		this.rrRealityTime = rrRealityTime;
	}
	public float getRrDeposit() {
		return rrDeposit;
	}
	public void setRrDeposit(float rrDeposit) {
		this.rrDeposit = rrDeposit;
	}
	public float getRrPreMoney() {
		return rrPreMoney;
	}
	public void setRrPreMoney(float rrPreMoney) {
		this.rrPreMoney = rrPreMoney;
	}
	public float getRrRealityMoney() {
		return rrRealityMoney;
	}
	public void setRrRealityMoney(float rrRealityMoney) {
		this.rrRealityMoney = rrRealityMoney;
	}
	public int getRrDate() {
		return rrDate;
	}
	public void setRrDate(int rrDate) {
		this.rrDate = rrDate;
	}
	public String getRrMember() {
		return rrMember;
	}
	public void setRrMember(String rrMember) {
		this.rrMember = rrMember;
	}
	public String getRrBilling() {
		return rrBilling;
	}
	public void setRrBilling(String rrBilling) {
		this.rrBilling = rrBilling;
	}

}
