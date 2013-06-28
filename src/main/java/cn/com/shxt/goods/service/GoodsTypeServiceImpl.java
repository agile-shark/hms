package cn.com.shxt.goods.service;

import java.util.List;

import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.goods.dao.IGoodsTypeDao;
import cn.com.shxt.goods.domain.GoodsType;

public class GoodsTypeServiceImpl implements IGoodsTypeService {

	private IGoodsTypeDao goodsTypeDao;

	
public void add(GoodsType type) {
		
		
		goodsTypeDao.add(type);

	}


	public void delete(GoodsType obj) {
		goodsTypeDao.delete(obj);
		
	
	}

	
	public GoodsType load(Class<?> cls, int id) {
		
		return (GoodsType) this.goodsTypeDao.load(GoodsType.class, id);
	}

	
	public void update(GoodsType obj) {
	goodsTypeDao.update(obj);

	}

	
	@Override
	public List<GoodsType> list() {
	String hql="from GoodsType";
		return (List<GoodsType>) goodsTypeDao.list(hql);
	}


	@Override
	public PageBean getAllPages(PageBean pb) {
	  
		if (pb == null) {
			pb = new PageBean();
		}
		String hql="from GoodsType rt order by cdt_id asc";
		return goodsTypeDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
		
	}



	public PageBean getRoomPageList(PageBean pb, GoodsType gt) {
	
		String hql  = "from GoodsType as gt where 1=1 ";
		if(pb==null){
			pb=new PageBean();
			
		}
		
		if(gt!=null){
			if(gt.getGoodsType()!=null&&gt.getGoodsType().trim()!=null){
				hql += " and gt.goodsType like'%"+gt.getGoodsType()+"%'";
			}
		}
		
		System.out.println(hql+"--------------===============");
		
		
		//System.out.println("---------"+GoodsTypeDao.find(hql, null, pb.getPageNow(), pb.getPageSize()).getList()+"=-=-=-==-=-=-=");
		return this.goodsTypeDao.find(hql, null, pb.getPageNow(), pb.getPageSize());
	}
	
	
	
	public IGoodsTypeDao getGoodsTypeDao() {
		return goodsTypeDao;
	}

	public void setGoodsTypeDao(IGoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}
	
	
}
