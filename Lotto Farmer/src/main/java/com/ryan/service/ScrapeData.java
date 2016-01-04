package com.ryan.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ryan.exception.InvalidLottoResultException;
import com.ryan.model.DrawType;

/**
 * @author Ryan Bartolay
 *
 */
public abstract class ScrapeData {
	protected Date draw_date;
	protected Map<Integer, Integer> draws = new HashMap<Integer, Integer>();
	private DrawType draw_type;	
	
	public Date getDraw_date() {
		return draw_date;
	}
	public void setDraw_date(Date draw_date) {
		this.draw_date = draw_date;
	}
	public int getDraw1() {
		return draws.get(1);
	}
	public int getDraw2() {
		return draws.get(2);
	}
	public int getDraw3() {
		return draws.get(3);
	}
	public int getDraw4() {
		return draws.get(4);
	}
	public int getDraw5() {
		return draws.get(5);
	}
	public int getDraw6() {
		return draws.get(6);
	}
	public DrawType getDraw_type() {
		return draw_type;
	}
	public void setDraw_type(DrawType draw_type) {
		this.draw_type = draw_type;
	}
}
