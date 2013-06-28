package cn.com.shxt.goods.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.goods.domain.Goods;
import cn.com.shxt.goods.domain.GoodsQuery;
import cn.com.shxt.goods.domain.GoodsType;
import cn.com.shxt.goods.service.IGoodsService;
import cn.com.shxt.goods.service.IGoodsTypeService;
import cn.com.shxt.rooms.domain.RoomResideRecord;
import cn.com.shxt.rooms.domain.Rooms;
import cn.com.shxt.rooms.service.IRoomResideRecordService;
import cn.com.shxt.rooms.service.IRoomsService;
import cn.com.shxt.sys_urp.action.AccountAction;

public class GoodsAction extends BaseAction {

	/**Log4J代替System输出*/
	private Logger logger = Logger.getLogger(GoodsAction.class);
	
	private IGoodsService goodsService;
	private IGoodsTypeService goodsTypeService;
	
	/**使用模型驱动--生成setter getter方法*/
	private Goods goods;
	private GoodsType goodsType;
	private IRoomResideRecordService resideService;
	private List<RoomResideRecord> resideRecords;
	private List<Goods> goodsList = new ArrayList<Goods>();
	private List<GoodsType> goodsTypesList = new ArrayList<GoodsType>(); 
	
	private GoodsQuery query;
	
	/**使用模型驱动获取PageBean对象*/
	private PageBean pb;
	
	
	// 分页查询
	public String GoodsAllPage() {
		if (pb == null) {
			pb = new PageBean();
		}
		goodsTypesList=goodsTypeService.list();
		pb = goodsService.getAllPages(pb);
		System.out.println(pb.getList() + "pb------------");
		this.folder = "scan";
		this.toJsp = "GoodsInformation";
		return SUCCESS;
	}

	// 分页条件查询
	public String GoodsPage() {
		if (pb == null) {
			pb = new PageBean();
		}
		if(null != query && "0".equals(query.getGoodsType())){
			query = new GoodsQuery();
		}
		goodsTypesList=goodsTypeService.list();
		pb = goodsService.getGoodsPageList(pb, query);
		// System.out.println("=========="+pb.getList()+"--------------");
		this.folder = "scan";
		this.toJsp = "GoodsInformation";
		return SUCCESS;
	}
	
	// 分页条件查询
	public String GoodsPageForConsume() {
		if (pb == null) {
			pb = new PageBean();
		}
		if(null != query && "0".equals(query.getGoodsType())){
			query = new GoodsQuery();
		}
		goodsTypesList=goodsTypeService.list();
		pb = goodsService.getGoodsPageList(pb, query);
		// System.out.println("=========="+pb.getList()+"--------------");
		this.folder = "consume";
		this.toJsp = "GoodsInformation";
		return SUCCESS;
	} 

	public String toAddGoodsJsp() {
		logger.info("add start.");
		this.folder = "scan";
		this.toJsp = "addGoods";
		return SUCCESS;
	}

	public String toConsumeGoodsJsp() {
		logger.info("Consume start.");
		
		goods = goodsService.load(Goods.class, goods.getCd_id());
		resideRecords = resideService.list();
		for (RoomResideRecord r : resideRecords) {
			logger.info(r.getRrNum());
		}
		this.folder = "consume";
		this.toJsp = "goodsConsume";
		return SUCCESS;
	}
	
	public String add() {
		logger.info("adding...");

		goods.setGoodsType(goodsType);
		goodsService.add(goods);
		GoodsAllPage();
		return SUCCESS;
	}

	// 删除
	public String del() {

		goods = goodsService.load(Goods.class, goods.getCd_id());
		goodsService.delete(goods);

		GoodsAllPage();

		return SUCCESS;
	}

	// 修改信息界面
	public String getGoodsToUpdate() {
		
		goods = goodsService.load(Goods.class, goods.getCd_id());
		
		goodsTypesList=goodsTypeService.list();
		
		this.folder = "scan";
		this.toJsp = "updateGoods";
		return SUCCESS;
	}

	// 更新
	public String update() {
		goodsService.update(goods);
		GoodsPage();
		return SUCCESS;
	}

	// 普通查询
	public String sel() {

		goodsTypesList = goodsTypeService.list();
		this.folder = "scan";
		this.toJsp = "goodsTypeInformation";
		return SUCCESS;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public IGoodsTypeService getGoodsTypeService() {
		return goodsTypeService;
	}

	public void setGoodsTypeService(IGoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public List<GoodsType> getGoodsTypesList() {
		return goodsTypesList;
	}

	public void setGoodsTypesList(List<GoodsType> goodsTypesList) {
		this.goodsTypesList = goodsTypesList;
	}

	public GoodsQuery getQuery() {
		return query;
	}

	public void setQuery(GoodsQuery query) {
		this.query = query;
	}

	public IRoomResideRecordService getResideService() {
		return resideService;
	}

	public void setResideService(IRoomResideRecordService resideService) {
		this.resideService = resideService;
	}

	public List<RoomResideRecord> getResideRecords() {
		return resideRecords;
	}

	public void setResideRecords(List<RoomResideRecord> resideRecords) {
		this.resideRecords = resideRecords;
	}
}
