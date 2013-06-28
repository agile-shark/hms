package cn.com.shxt.goods.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.goods.dao.IGoodsDao;
import cn.com.shxt.goods.domain.Goods;
import cn.com.shxt.goods.domain.GoodsQuery;

public class GoodsServiceImpl implements IGoodsService {

	private IGoodsDao goodsDao;

	
	
public void add(Goods goods) {
		
		
	goodsDao.add(goods);

	}


	public void delete(Goods obj) {
		goodsDao.delete(obj);
		
	
	}

	
	public Goods load(Class<?> cls, int id) {
		//System.out.println(id+"============____________");
		return (Goods) this.goodsDao.load(Goods.class, id);
	}

	
	public void update(Goods obj) {
	goodsDao.update(obj);

	}

	
	@Override
	public List<Goods> list() {
	String hql="from Goods";
		return (List<Goods>) goodsDao.list(hql);
	}


	@Override
	public PageBean getAllPages(PageBean pb) {
	  
		if(pb==null){
			pb = new PageBean();
		}
		
		String hql="from Goods as r order by Goods_id asc";
		return goodsDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
		
	}



	public PageBean getGoodsPageList(PageBean pb, GoodsQuery goodsQuery) {
	
		String hql  = "from Goods as ri where 1=1 ";
		
		
		if(pb==null){
			pb = new PageBean();
		}
		
		if(goodsQuery!=null){
			if(goodsQuery.getGoodsName()!=null&&goodsQuery.getGoodsName().trim().length()>0){
				hql += "and ri.goodsName like '%"+goodsQuery.getGoodsName()+"%'";
			}
			if(goodsQuery.getGoodsPrice()>0){
				hql += "and ri.goodsPrice="+goodsQuery.getGoodsPrice();
			}
			if(goodsQuery.getGoodsSNum()!=null&&goodsQuery.getGoodsSNum().trim().length()>0){
				hql += "and ri.goodsSNum like '%"+goodsQuery.getGoodsSNum()+"%'";
			}
			if(goodsQuery.getGoodsType()!=null&&goodsQuery.getGoodsType().trim().length()>0){
				hql += "and ri.goodsType.goodsType like '%"+goodsQuery.getGoodsType()+"%'";
			}
		}
		
		//System.out.println("---------"+GoodsTypeDao.find(hql, null, pb.getPageNow(), pb.getPageSize()).getList()+"=-=-=-==-=-=-=");
		return goodsDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}
	
	
	
	
	public IGoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	
	
}
