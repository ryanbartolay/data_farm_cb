package com.ryan.dao.impl;

import java.util.Date;
import java.util.List;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import com.ryan.dao.LottoResultDao;
import com.ryan.model.Constants;
import com.ryan.model.DrawType;
import com.ryan.model.LottoResult;

public class LottoResultDaoImpl implements LottoResultDao {
	private CouchDbClient couchDBClient;
    
    public Response create(LottoResult result) {
        return couchDBClient.save(result);
    }
    public List<LottoResult> retrieveAll() {
        return couchDBClient.view(Constants.NOSQL_ALL_DOCS).includeDocs(true).query(LottoResult.class);
    }	
	public List<LottoResult> retrieveAllByDrawType(DrawType draw_type) {
		return couchDBClient.view(Constants.NOSQL_DESIGN_DOCUMENT_ALL+ "/" + Constants.NOSQL_VIEW_BY_DRAW_TYPE).includeDocs(true).key(draw_type).query(LottoResult.class);
	}
	public LottoResult retrieveByDrawDateAndDrawType(Date draw_date, DrawType draw_type) {		
		return this.retrieveByDrawDateAndDrawType(draw_date, draw_type, true);
	}
	public LottoResult retrieveByDrawDateAndDrawType(Date draw_date, DrawType draw_type, boolean include_docs) {
		try {
			return couchDBClient.view(Constants.NOSQL_DESIGN_DOCUMENT_ALL+ "/" + Constants.NOSQL_VIEW_BY_DRAW_DATE_DRAW_TYPE).includeDocs(include_docs).key(new Object[] {draw_date , draw_type}).query(LottoResult.class).get(0);
		} catch(IndexOutOfBoundsException ex) {
			return null;
		}
	}
	public List<LottoResult> retrieveByDrawDateAndDrawType(Date from_draw_date, Date to_draw_date, DrawType draw_type) {		
		return couchDBClient.view(Constants.NOSQL_DESIGN_DOCUMENT_ALL+ "/" + Constants.NOSQL_VIEW_BY_DRAW_DATE_DRAW_TYPE).includeDocs(true).startKey(new Object[] {from_draw_date , draw_type}).endKey(new Object[] {to_draw_date , draw_type}).query(LottoResult.class);
	}
    public LottoResult retrieveById(String id) {
        return couchDBClient.find(LottoResult.class, id);
    }
    public void update(LottoResult result) {    
        couchDBClient.update(result);
    }
    public void delete(LottoResult result) {
        couchDBClient.remove(result);
    }    
    public CouchDbClient getCouchDBClient() {
        return couchDBClient;
    }
    public void setCouchDBClient(CouchDbClient couchDbClient) {
        this.couchDBClient = couchDbClient;
    }
}
