package com.testing.danawara.common;

public enum EnumSocket {
	INTEL(1), AMD(2);
	
	private int value;    

	private EnumSocket(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
