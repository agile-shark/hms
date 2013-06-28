package cn.com.shxt.goods.domain;

import java.io.Serializable;
import java.util.Date;

import cn.com.shxt.rooms.domain.RoomResideRecord;

public class ConsumeRecord implements Serializable {
	
	/**主键*/
	private int cs_id;

	/**多对一商品类型*/
	private GoodsType goodsType;
	/**多对一入住信息*/
	private RoomResideRecord roomResideRecord;
	/**房客身份证号*/
	private String rrIdcard;
	/**商品名称*/
	private String csName;
	/**商品单价*/
	private float csPrice;
	/**商品数量*/
	private int csNum;
	/**消费时间*/
	private Date csTime;
	/**开单人*/
	private String csBilling;
	/**备注*/
	private String csDes;
	public int getCs_id() {
		return cs_id;
	}

	public void setCs_id(int cs_id) {
		this.cs_id = cs_id;
	}
	
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public RoomResideRecord getRoomResideRecord() {
		return roomResideRecord;
	}
	public void setRoomResideRecord(RoomResideRecord roomResideRecord) {
		this.roomResideRecord = roomResideRecord;
	}
	public String getRrIdcard() {
		return rrIdcard;
	}
	public void setRrIdcard(String rrIdcard) {
		this.rrIdcard = rrIdcard;
	}
	public String getCsName() {
		return csName;
	}
	public void setCsName(String csName) {
		this.csName = csName;
	}
	public float getCsPrice() {
		return csPrice;
	}
	public void setCsPrice(float csPrice) {
		this.csPrice = csPrice;
	}
	public int getCsNum() {
		return csNum;
	}
	public void setCsNum(int csNum) {
		this.csNum = csNum;
	}
	public Date getCsTime() {
		return csTime;
	}
	public void setCsTime(Date csTime) {
		this.csTime = csTime;
	}
	public String getCsBilling() {
		return csBilling;
	}
	public void setCsBilling(String csBilling) {
		this.csBilling = csBilling;
	}
	public String getCsDes() {
		return csDes;
	}
	public void setCsDes(String csDes) {
		this.csDes = csDes;
	}

}
