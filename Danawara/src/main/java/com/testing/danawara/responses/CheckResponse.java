package com.testing.danawara.responses;

public class CheckResponse {
	
	private boolean check;
	
	public CheckResponse () {
		
	}
	
	public CheckResponse(boolean check) {
		this.check = check;
	}
	
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public boolean getCheck() {
		return this.check;
	}
}
