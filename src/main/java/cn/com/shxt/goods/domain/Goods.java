package cn.com.shxt.goods.domain;

import java.io.Serializable;

public class Goods implements Serializable {
	
	/**主键*/
	private int cd_id;
	/**多对一商品类型*/
	private GoodsType goodsType;
	/**商品系统编号*/
	private String goodsSNum;
	/**商品名*/
	private String goodsName;
	/**商品库存*/
	private int goodsCode;
	/**商品价格*/
	private float goodsPrice;
	/**商品描述*/
	private String goodsDes;
	public int getCd_id() {
		return cd_id;
	}
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsSNum() {
		return goodsSNum;
	}
	public void setGoodsSNum(String goodsSNum) {
		this.goodsSNum = goodsSNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public int getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsDes() {
		return goodsDes;
	}
	public void setGoodsDes(String goodsDes) {
		this.goodsDes = goodsDes;
	}
	@Override
	public String toString() {
		return "Goods [cd_id=" + cd_id + ", goodsType=" + goodsType
				+ ", goodsSNum=" + goodsSNum + ", goodsName=" + goodsName
				+ ", goodsCode=" + goodsCode + ", goodsPrice=" + goodsPrice
				+ ", goodsDes=" + goodsDes + "]";
	}
	
	
	

}
