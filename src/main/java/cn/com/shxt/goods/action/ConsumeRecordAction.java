package cn.com.shxt.goods.action;

import java.util.Date;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.base.dao.PageBean;
import cn.com.shxt.goods.domain.ConsumeRecord;
import cn.com.shxt.goods.service.IConsumeRecordService;
import cn.com.shxt.rooms.domain.RoomResideRecord;
import cn.com.shxt.rooms.domain.Rooms;
import cn.com.shxt.rooms.service.IRoomResideRecordService;

public class ConsumeRecordAction extends BaseAction {

	/**Log4J代替System输出*/
	private Logger logger = Logger.getLogger(ConsumeRecordAction.class);
	
	private IConsumeRecordService consumeRecordService;
	private IRoomResideRecordService roomResideRecordService;
	
	/**使用模型驱动--生成setter getter方法*/
	private ConsumeRecord consumeRecord;
	private RoomResideRecord roomResideRecord;
	
	/**使用模型驱动获取PageBean对象*/
	private PageBean pb;
	
	public String add(){
		logger.info("add start!!");
		consumeRecord.setCsTime(new Date());
		roomResideRecord = this.roomResideRecordService.load(Rooms.class, consumeRecord.getRoomResideRecord().getRr_id());
		consumeRecord.setRoomResideRecord(roomResideRecord);
		consumeRecordService.add(consumeRecord);
		logger.info("add end!!");
		return null;
	}

	public IConsumeRecordService getConsumeRecordService() {
		return consumeRecordService;
	}

	public void setConsumeRecordService(IConsumeRecordService consumeRecordService) {
		this.consumeRecordService = consumeRecordService;
	}

	public IRoomResideRecordService getRoomResideRecordService() {
		return roomResideRecordService;
	}

	public void setRoomResideRecordService(
			IRoomResideRecordService roomResideRecordService) {
		this.roomResideRecordService = roomResideRecordService;
	}

	public RoomResideRecord getRoomResideRecord() {
		return roomResideRecord;
	}

	public void setRoomResideRecord(RoomResideRecord roomResideRecord) {
		this.roomResideRecord = roomResideRecord;
	}

	public ConsumeRecord getConsumeRecord() {
		return consumeRecord;
	}

	public void setConsumeRecord(ConsumeRecord consumeRecord) {
		this.consumeRecord = consumeRecord;
	}

	public PageBean getPb() {
		return pb;
	}

	public void setPb(PageBean pb) {
		this.pb = pb;
	}
}
