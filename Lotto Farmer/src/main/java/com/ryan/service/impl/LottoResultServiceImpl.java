package com.ryan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.ryan.dao.LottoResultDao;
import com.ryan.model.LottoResult;
import com.ryan.service.LottoResultService;
import com.ryan.service.security.LottoResultSecurityService;
import com.ryan.service.security.ServiceLogger;

public class LottoResultServiceImpl implements LottoResultService {

	private LottoResultDao lrDao;
	private Logger slogger = (Logger) ServiceLogger.getInstance(LottoResultServiceImpl.class.getName());

	@Override
	public void insertRecord(LottoResult result) {
		try {
			LottoResultSecurityService.isValidLottoResult(result);
			
			if(lrDao.retrieveByDrawDateAndDrawType(result.getDraw_date(), result.getDraw_type(), false) == null) {
				lrDao.create(result);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void insertRecords(List<LottoResult> results) {
		if(results.size() > 0) {
			for(LottoResult result : results) {				
				this.insertRecord(result);
			}

		}
	}

	@Override
	public void updateRecord(LottoResult result) {	

	}

	public LottoResultDao getLrDao() {
		return lrDao;
	}

	public void setLrDao(LottoResultDao lrDao) {
		this.lrDao = lrDao;
	}
}
