package cn.com.shxt.goods.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.goods.domain.GoodsType;

public interface IGoodsTypeService {

	public void add(GoodsType goodsType);
	public void delete(GoodsType obj);
	public void update(GoodsType obj);
	public GoodsType load(Class<?> cls, int id);
	public List<GoodsType>list();
	public PageBean getAllPages(PageBean pb);
	public PageBean getRoomPageList(PageBean pb,GoodsType gt);
}
