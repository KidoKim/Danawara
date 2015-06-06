package com.testing.danawara.common;

public enum EnumSize {
	M_ATX(1), ATX(2), EXTENDED_ATX(3);
	
	private int value;    

	private EnumSize(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
