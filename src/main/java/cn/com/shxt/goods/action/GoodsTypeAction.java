package cn.com.shxt.goods.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.goods.domain.GoodsType;
import cn.com.shxt.goods.service.IGoodsTypeService;

public class GoodsTypeAction extends BaseAction {
	
	/**Log4J代替System输出*/
	private Logger logger = Logger.getLogger(GoodsTypeAction.class);
	
	private IGoodsTypeService goodsTypeService;
	
	/**使用模型驱动--生成setter getter方法*/
	private GoodsType goodsType;
	
	/**使用模型驱动获取PageBean对象*/
	private PageBean pb;
	
	private List<GoodsType> gtList = new ArrayList<GoodsType>();
	
	// 分页查询
	public String goodsTypeAllPage() {
		logger.info("goodsType start");
		pb = goodsTypeService.getAllPages(pb);
		logger.info(pb.getList().size());
		//System.out.println(pb.getList() + "pb------------");
		this.folder = "scan";
		this.toJsp = "goodsTypeInformation";
		return SUCCESS;
	}

	// 分页条件查询
	public String goodsTypePage() {

		logger.info("goodsType start");
		if (pb == null) {
			pb = new PageBean();
		} 
		if(null != goodsType && goodsType.getCdt_id()!= 0){
			goodsType = this.goodsTypeService.load(GoodsType.class, goodsType.getCdt_id());
			logger.info(goodsType.getCdt_id() + goodsType.getGoodsType());
		}
		gtList=goodsTypeService.list();
		//System.out.println(goodsType.getGoodsType()+"----=======-------=======");
		pb = goodsTypeService.getRoomPageList(pb, goodsType);
		logger.info(pb.getList().size());
		System.out.println("=========="+pb.getList()+"--------------");
		this.folder = "scan";
		this.toJsp = "goodsTypeInformation";
		return SUCCESS;

	}

	// 添加
	public String toAddGoodsTypeJsp() {

		logger.info("toaddgoodsTypejsp--------------");
		this.folder = "scan";
		this.toJsp = "addgoodsType";
		return SUCCESS;
	}

	public String add() {
		goodsTypeService.add(goodsType);
		this.folder = "scan";
		this.toJsp = "addgoodsType";
		return SUCCESS;
	}

	// 删除
	public String del() {

		goodsType = goodsTypeService.load(GoodsType.class, goodsType.getCdt_id());
		goodsTypeService.delete(goodsType);
		
		this.folder = "scan";
		this.toJsp = "goodsTypeInformation";
		return SUCCESS;
	}

	public String toLoadgoodsTypeJsp() {
		goodsType = goodsTypeService.load(GoodsType.class, goodsType.getCdt_id());
		this.folder = "scan";
		this.toJsp = "showgoodsType";
		return SUCCESS;
	}
	
	// 修改信息界面
	public String toUpdategoodsTypeJsp() {
		goodsType = goodsTypeService.load(GoodsType.class, goodsType.getCdt_id());
		this.folder = "scan";
		this.toJsp = "updategoodsType";
		return SUCCESS;
	}

	// 更新
	public String update() {
		goodsTypeService.update(goodsType);
		gtList = goodsTypeService.list();
		if (pb == null) {
			pb = new PageBean();
		}
		pb = goodsTypeService.getRoomPageList(pb, goodsType);
		this.folder = "scan";
		this.toJsp = "goodsTypeInformation";
		return SUCCESS;
	}

	// 普通查询
	public String sel() {

		gtList = goodsTypeService.list();
		this.folder = "scan";
		this.toJsp = "goodsTypeInformation";
		return SUCCESS;
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

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}

	public List<GoodsType> getGtList() {
		return gtList;
	}

	public void setGtList(List<GoodsType> gtList) {
		this.gtList = gtList;
	}
	
	

}
