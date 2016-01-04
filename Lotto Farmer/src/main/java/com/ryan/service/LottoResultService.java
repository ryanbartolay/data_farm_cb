package com.ryan.service;

import java.util.List;

import com.ryan.model.LottoResult;

public interface LottoResultService {
	public void insertRecord(LottoResult result);
	public void insertRecords(List<LottoResult> results);
	public void updateRecord(LottoResult result);
}
