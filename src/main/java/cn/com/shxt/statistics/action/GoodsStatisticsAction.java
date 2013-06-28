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
import cn.com.shxt.goods.domain.ConsumeRecord;
import cn.com.shxt.goods.service.IConsumeRecordService;

public class GoodsStatisticsAction extends BaseAction {
	
	private Logger logger = Logger.getLogger(GoodsStatisticsAction.class);
	private IConsumeRecordService consumeRecordService;
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat FORMATD = new SimpleDateFormat("yyyyMM");
	private static final SimpleDateFormat FORMATY = new SimpleDateFormat("MM");
	 //当日类型统计 
	public String day(){

		List<ConsumeRecord> consumes = this.consumeRecordService.list();
		Map<String, Float> dayMap = new LinkedHashMap<String, Float>();
		dayMap.put("今日销售总额", 0f);
		for (ConsumeRecord consumeRecord : consumes) {
			
			if(FORMAT.format(new Date()).equals(FORMAT.format(consumeRecord.getCsTime()))){
				String type = consumeRecord.getGoodsType().getGoodsType();	
				float sum = consumeRecord.getCsPrice() * consumeRecord.getCsNum();
				dayMap.put("今日销售总额", dayMap.get("今日销售总额") + sum);
				if(!dayMap.containsKey(type)){
					dayMap.put(type, sum);
				}else{
					dayMap.put(type, dayMap.get(type) + sum);
				}
			}
		}
		
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "今日销售统计(单位：元)");
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
		List<ConsumeRecord> consumes = this.consumeRecordService.list();
		Map<String, Float> dayMap = new LinkedHashMap<String, Float>();
		dayMap.put("本月销售总额", 0f);
		for (ConsumeRecord consumeRecord : consumes) {
			
			if(FORMATD.format(new Date()).equals(FORMATD.format(consumeRecord.getCsTime()))){
				String type = consumeRecord.getGoodsType().getGoodsType();	
				float sum = consumeRecord.getCsPrice() * consumeRecord.getCsNum();
				dayMap.put("本月销售总额", dayMap.get("本月销售总额") + sum);
				if(!dayMap.containsKey(type)){
					dayMap.put(type, sum);
				}else{
					dayMap.put(type, dayMap.get(type) + sum);
				}
			}
		}
		
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "本月销售统计(单位：元)");
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
		List<ConsumeRecord> consumes = this.consumeRecordService.list();
		Map<String, Float> dayMap = new HashMap<String, Float>();
		dayMap.put("今年销售总额", 0f);
		for (ConsumeRecord consumeRecord : consumes) {
			String mon = FORMATY.format(consumeRecord.getCsTime());
			float sum = consumeRecord.getCsPrice() * consumeRecord.getCsNum();
			dayMap.put("今年销售总额", dayMap.get("今年销售总额") + sum);
			if(!dayMap.containsKey(mon)){
				dayMap.put(mon, sum);
			}else{
				dayMap.put(mon, dayMap.get(mon) + sum);
			}
		}
		
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "今年销售总额(单位：元)");
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

	public IConsumeRecordService getConsumeRecordService() {
		return consumeRecordService;
	}

	public void setConsumeRecordService(IConsumeRecordService consumeRecordService) {
		this.consumeRecordService = consumeRecordService;
	}
	
	public static void main(String[] args) {
		
	}
}
