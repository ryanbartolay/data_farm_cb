package com.ryan.model;

public enum DrawType {
	PHLPCSOUL("Ultra Lotto 6/58"),
	PHLPCSOGL("Grand Lotto 6/55"),
	PHLPCSOSL("Super Lotto 6/49"),
	PHLPCSOML("Mega Lotto 6/45"),
	PHLPCSOL("Lotto 6/42");
	
	
	private String draw_name;
	
	DrawType(String draw_name) {
		this.draw_name = draw_name;
	}

	public String getDraw_name() {
		return draw_name;
	}

}
