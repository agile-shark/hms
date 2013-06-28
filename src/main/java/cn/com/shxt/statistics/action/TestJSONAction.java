package cn.com.shxt.statistics.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.com.shxt.base.action.BaseAction;
import cn.com.shxt.goods.domain.ConsumeRecord;
import cn.com.shxt.goods.service.IConsumeRecordService;
import cn.com.shxt.rooms.service.IRoomResideRecordService;


public class TestJSONAction extends BaseAction {
	
	private Logger logger = Logger.getLogger(TestJSONAction.class);
	private IRoomResideRecordService resideRecordService;
	private IConsumeRecordService consumeRecordService;
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");
	
	 //当日类型统计 
	public String day(){
		//this.toData(String caption, );
		List<ConsumeRecord> consumes = new ArrayList<ConsumeRecord>();
		Map<String, Float> dayMap = new HashMap<String, Float>();
		for (ConsumeRecord consumeRecord : consumes) {
			if(FORMAT.format(new Date()) == FORMAT.format(consumeRecord.getCsTime())){
				String type = consumeRecord.getGoodsType().getGoodsType();
				if(!dayMap.containsKey(type)){
					dayMap.put(type, consumeRecord.getCsPrice() * consumeRecord.getCsNum());
				}else{
					dayMap.put(type, dayMap.get(type) + consumeRecord.getCsPrice() * consumeRecord.getCsNum());
				}
			}
		}
		
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "当日类型统计");
		map_top.put("showpercentvalues", 1);
		
		List list_data  = new ArrayList();
		for (Map.Entry<String, Float> entry : dayMap.entrySet()) {
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
		
		
		return SUCCESS;
	}
	 //月销售统计 
	public String year(){
		
		
		return SUCCESS;
	}
	
	
	public String toData() throws IOException{
		Map<String, Object> map_top = new HashMap<String, Object>();
		map_top.put("caption", "Company Revenue");
		map_top.put("showpercentvalues", 1);
	
		Map map_data_1  = new HashMap<String, Object>();
		map_data_1.put("label", "移动2G投资");
		map_data_1.put("value", 10);
		Map map_data_2  = new HashMap<String, String>();
		map_data_2.put("label", "移动3G投资");
		map_data_2.put("value", 20);
		Map map_data_3  = new HashMap<String, String>();
		map_data_3.put("label", "3G通信收入");
		map_data_3.put("value", 10);
		Map map_data_4  = new HashMap<String, String>();
		map_data_4.put("label", "3G用户出账用户");
		map_data_4.put("value", 20);
		Map map_data_5  = new HashMap<String, String>();
		map_data_5.put("label", "2G出账用户");
		map_data_5.put("value", 40);
		
		
		List list_data  = new ArrayList();
		list_data.add(map_data_1);
		list_data.add(map_data_2);
		list_data.add(map_data_3);
		list_data.add(map_data_4);
		list_data.add(map_data_5);
		
		map_top.put("data", list_data);
		
		
		this.jsonResult = map_top;
		
		return JSON;
		/**
		 * 
		 * {
	 "chart":{ "caption":"Company Revenue","showpercentvalues":"1" },

	 "data":[
		{ "label":"移动2G投资", "value":"10" },
		{ "label":"移动3G投资", "value":"20"  },
		{ "label":"3G通信收入", "value":"10" } ,
		{ "label":"3G用户出账用户", "value":"20" } ,
		 { "label":"2G出账用户", "value":"40" } ,
	  ] 
	}
		 */
		
	}

	

	
	public String show(){
		return SUCCESS;
	}

	public IRoomResideRecordService getResideRecordService() {
		return resideRecordService;
	}

	public void setResideRecordService(IRoomResideRecordService resideRecordService) {
		this.resideRecordService = resideRecordService;
	}

	public IConsumeRecordService getConsumeRecordService() {
		return consumeRecordService;
	}

	public void setConsumeRecordService(IConsumeRecordService consumeRecordService) {
		this.consumeRecordService = consumeRecordService;
	}
}
