package cn.com.shxt.goods.service;

import java.util.List;

import cn.com.shxt.goods.dao.IConsumeRecordDao;
import cn.com.shxt.goods.domain.ConsumeRecord;

public class ConsumeRecordServiceImpl implements IConsumeRecordService {

	private IConsumeRecordDao consumeRecordDao;

	public IConsumeRecordDao getConsumeRecordDao() {
		return consumeRecordDao;
	}

	public void setConsumeRecordDao(IConsumeRecordDao consumeRecordDao) {
		this.consumeRecordDao = consumeRecordDao;
	}

	@Override
	public void add(ConsumeRecord consumeRecord) {
		// TODO Auto-generated method stub
		this.consumeRecordDao.add(consumeRecord);
	}

	@Override
	public List<ConsumeRecord> list() {
		// TODO Auto-generated method stub
		String hql = "from ConsumeRecord";
		return (List<ConsumeRecord>)this.consumeRecordDao.list(hql);
	}
	
	
}
