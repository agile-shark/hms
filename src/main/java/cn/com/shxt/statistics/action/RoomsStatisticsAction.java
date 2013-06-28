package cn.com.shxt.statistics.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.rooms.domain.RoomResideRecord;
import cn.com.shxt.rooms.service.IRoomResideRecordService;

public class RoomsStatisticsAction extends BaseAction {
	
	private Logger logger = Logger.getLogger(RoomsStatisticsAction.class);
	private IRoomResideRecordService roomResideRecordService;
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat FORMATD = new SimpleDateFormat("yyyyMM");
	private static final SimpleDateFormat FORMATY = new SimpleDateFormat("MM");
	
	//当日类型统计 
	public String day(){
		
		logger.info("start ROOMS day");
		List<RoomResideRecord> resideRecords = this.roomResideRecordService.list();
		logger.info(resideRecords.size());
		Map<String, Float> dayMap = new LinkedHashMap<String, Float>();
		dayMap.put("今日客房总收入", 0f);
		for (RoomResideRecord resideRecord : resideRecords) {
		
			if(null != resideRecord.getRrRealityTime() && FORMAT.format(new Date()).equals(FORMAT.format(resideRecord.getRrRealityTime()))){
				String type = resideRecord.getRtName();	
				logger.info(type);
				dayMap.put("今日客房总收入", dayMap.get("今日客房总收入") + resideRecord.getRrRealityMoney());
				if(!dayMap.containsKey(type)){
					logger.info(resideRecord.getRrRealityMoney());
					dayMap.put(type, resideRecord.getRrRealityMoney());
				}else{
					logger.info(resideRecord.getRrRealityMoney());
					dayMap.put(type, dayMap.get(type) + resideRecord.getRrRealityMoney());
				}
			}
			
		}
		
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "今日客房收入(单位：元)");
		map_top.put("showpercentvalues", 1);
		
		List list_data  = new ArrayList();

		for (Map.Entry<String, Float> entry : dayMap.entrySet()) {
			logger.info(entry.getKey());
			logger.info(entry.getValue());
			Map map_data  = new HashMap<String, Object>();
			map_data.put("label", entry.getKey());
			map_data.put("value", entry.getValue());
			list_data.add(map_data);
		}
		
		
		map_top.put("data", list_data);
		this.jsonResult = map_top;
		return JSON;

	}
	 //当月类型统计
	public String month(){
		logger.info("start ROOMS day");
		List<RoomResideRecord> resideRecords = this.roomResideRecordService.list();
		logger.info(resideRecords.size());
		Map<String, Float> dayMap = new LinkedHashMap<String, Float>();
		dayMap.put("本月客房总收入", 0f);
		for (RoomResideRecord resideRecord : resideRecords) {
			
			if(null != resideRecord.getRrRealityTime() && FORMATD.format(new Date()).equals(FORMATD.format(resideRecord.getRrRealityTime()))){
				String type = resideRecord.getRtName();	
				logger.info(type);
				dayMap.put("本月客房总收入", dayMap.get("本月客房总收入") + resideRecord.getRrRealityMoney());
				if(!dayMap.containsKey(type)){
					logger.info(resideRecord.getRrRealityMoney());
					dayMap.put(type, resideRecord.getRrRealityMoney());
				}else{
					logger.info(resideRecord.getRrRealityMoney());
					dayMap.put(type, dayMap.get(type) + resideRecord.getRrRealityMoney());
				}
			}
			
		}
		
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "本月客房收入(单位：元)");
		map_top.put("showpercentvalues", 1);
		
		List list_data  = new ArrayList();

		for (Map.Entry<String, Float> entry : dayMap.entrySet()) {
			logger.info(entry.getKey());
			logger.info(entry.getValue());
			Map map_data  = new HashMap<String, Object>();
			map_data.put("label", entry.getKey());
			map_data.put("value", entry.getValue());
			list_data.add(map_data);
		}
		
		
		map_top.put("data", list_data);
		this.jsonResult = map_top;
		return JSON;

	}
	
	 //月销售统计 
	public String year(){
		logger.info("start ROOMS day");
		List<RoomResideRecord> resideRecords = this.roomResideRecordService.list();
		logger.info(resideRecords.size());
		Map<String, Float> dayMap = new LinkedHashMap<String, Float>();
		dayMap.put("今年客房总收入", 0f);
		
		for (RoomResideRecord resideRecord : resideRecords) {
			if(null != resideRecord.getRrRealityTime()){
				String mon = FORMATY.format(resideRecord.getRrRealityTime());
				
				dayMap.put("今年客房总收入", dayMap.get("今年客房总收入") + resideRecord.getRrRealityMoney());
				if(!dayMap.containsKey(mon)){
					logger.info(resideRecord.getRrRealityMoney());
					dayMap.put(mon, resideRecord.getRrRealityMoney());
				}else{
					logger.info(resideRecord.getRrRealityMoney());
					dayMap.put(mon, dayMap.get(mon) + resideRecord.getRrRealityMoney());
				}
			}
		}
			
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "今年客房收入(单位：元)");
		map_top.put("showpercentvalues", 1);
		
		List list_data  = new ArrayList();

		for (Map.Entry<String, Float> entry : dayMap.entrySet()) {
			logger.info(entry.getKey());
			logger.info(entry.getValue());
			Map map_data  = new HashMap<String, Object>();
			map_data.put("label", entry.getKey());
			map_data.put("value", entry.getValue());
			list_data.add(map_data);
		}
		
		
		map_top.put("data", list_data);
		this.jsonResult = map_top;
		return JSON;

	}
	
	public String show(){
		return SUCCESS;
	}
	
	public IRoomResideRecordService getRoomResideRecordService() {
		return roomResideRecordService;
	}
	public void setRoomResideRecordService(
			IRoomResideRecordService roomResideRecordService) {
		this.roomResideRecordService = roomResideRecordService;
	}
	public static void main(String[] args) {
		
	}
}
