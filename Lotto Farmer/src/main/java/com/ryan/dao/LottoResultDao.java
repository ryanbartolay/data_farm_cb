package com.ryan.dao;

import java.util.Date;
import java.util.List;

import org.lightcouch.Response;

import com.ryan.model.DrawType;
import com.ryan.model.LottoResult;

public interface LottoResultDao {
	public Response create(LottoResult result);
    public List<LottoResult> retrieveAll();
    public List<LottoResult> retrieveAllByDrawType(DrawType draw_type);
    public LottoResult retrieveById(String id);
    public LottoResult retrieveByDrawDateAndDrawType(Date draw_date, DrawType draw_type);
    public LottoResult retrieveByDrawDateAndDrawType(Date draw_date, DrawType draw_type, boolean include_docs);
    public List<LottoResult> retrieveByDrawDateAndDrawType(Date from_draw_date, Date to_draw_date, DrawType draw_type);
    public void update(LottoResult result);
    public void delete(LottoResult result);
}
