package cn.com.shxt.goods.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GoodsType implements Serializable {
	
	/**主键*/
	private int cdt_id;
	/**类型名称*/
	private String goodsType;
	/**商品类型描述*/
	private String goodsTypeDes;
	/**一对多商品*/
	private Set<Goods> goods;
	
	public int getCdt_id() {
		return cdt_id;
	}
	public void setCdt_id(int cdt_id) {
		this.cdt_id = cdt_id;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsTypeDes() {
		return goodsTypeDes;
	}
	public void setGoodsTypeDes(String goodsTypeDes) {
		this.goodsTypeDes = goodsTypeDes;
	}
	public Set<Goods> getGoods() {
		return goods;
	}
	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
	
}
