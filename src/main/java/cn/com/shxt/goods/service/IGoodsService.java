package cn.com.shxt.goods.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.goods.domain.Goods;
import cn.com.shxt.goods.domain.GoodsQuery;

public interface IGoodsService {
	
	public void add(Goods obj);
	public void delete(Goods obj);
	public void update(Goods obj);
	public Goods load(Class<?> cls, int id);
	public List<Goods>list();
	public PageBean getGoodsPageList(PageBean pb,GoodsQuery goodsQuery);
	PageBean getAllPages(PageBean pb);

}
