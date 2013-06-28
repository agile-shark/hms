package cn.com.shxt.goods.service;

import java.util.List;

import cn.com.shxt.goods.domain.ConsumeRecord;

public interface IConsumeRecordService {

	public void add(ConsumeRecord consumeRecord);
	
	public List<ConsumeRecord> list();
}
