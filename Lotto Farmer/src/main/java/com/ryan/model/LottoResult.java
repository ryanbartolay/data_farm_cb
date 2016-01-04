package com.ryan.model;

import java.util.Date;

import com.ryan.service.ScrapeData;

public class LottoResult {
	private long draw_id;
	private String _id; // for couchDB
	private String _rev; // for couchDB
	private Date draw_date;
	private DrawType draw_type;
		
	private transient ScrapeData raw_data;
	private int draw_1;
	private int draw_2;
	private int draw_3;
	private int draw_4;
	private int draw_5;
	private int draw_6;
	
	public LottoResult() {
		
	}
	public LottoResult(String _id) {
		this._id = _id;
	}
	public long getDraw_id() {
		return draw_id;
	}
	public void setDraw_id(long draw_id) {
		this.draw_id = draw_id;
	}		
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Date getDraw_date() {
		return draw_date;
	}
	public void setDraw_date(Date draw_date) {
		this.draw_date = draw_date;
	}
	public DrawType getDraw_type() {
		return draw_type;
	}
	public void setDraw_type(DrawType draw_type) {
		this.draw_type = draw_type;
	}
	public int getDraw_1() {
		return draw_1;
	}
	public void setDraw_1(int draw_1) {
		this.draw_1 = draw_1;
	}
	public int getDraw_2() {
		return draw_2;
	}
	public void setDraw_2(int draw_2) {
		this.draw_2 = draw_2;
	}
	public int getDraw_3() {
		return draw_3;
	}
	public void setDraw_3(int draw_3) {
		this.draw_3 = draw_3;
	}
	public int getDraw_4() {
		return draw_4;
	}
	public void setDraw_4(int draw_4) {
		this.draw_4 = draw_4;
	}
	public int getDraw_5() {
		return draw_5;
	}
	public void setDraw_5(int draw_5) {
		this.draw_5 = draw_5;
	}
	public int getDraw_6() {
		return draw_6;
	}
	public void setDraw_6(int draw_6) {
		this.draw_6 = draw_6;
	}
	public ScrapeData getRaw_data() {
		return raw_data;
	}
	public void setRaw_data(ScrapeData raw_data) {
		this.raw_data = raw_data;
		this.draw_date = raw_data.getDraw_date();
		this.draw_type = raw_data.getDraw_type();
		this.draw_1 = raw_data.getDraw1();
		this.draw_2 = raw_data.getDraw2();
		this.draw_3 = raw_data.getDraw3();
		this.draw_4 = raw_data.getDraw4();
		this.draw_5 = raw_data.getDraw5();
		this.draw_6 = raw_data.getDraw6();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (draw_id ^ (draw_id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LottoResult other = (LottoResult) obj;
		if (draw_id != other.draw_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LottoResult [draw_id=" + draw_id + ", _id=" + _id + ", _rev="
				+ _rev + ", draw_date=" + draw_date + ", draw_type="
				+ draw_type + ", draw_1=" + draw_1 + ", draw_2=" + draw_2
				+ ", draw_3=" + draw_3 + ", draw_4=" + draw_4 + ", draw_5="
				+ draw_5 + ", draw_6=" + draw_6 + "]";
	}
	
}
