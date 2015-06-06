package com.testing.danawara.responses;

public class CheckResponse {
	private String msg1;
	private String msg2;
	private String msg3;
	
	public CheckResponse () {
		
	}
	
	public CheckResponse(String msg1, String msg2, String msg3) {
		this.msg1 = msg1;
		this.msg2 = msg2;
		this.msg3 = msg3;
	}
	
	public void setMsg1(String msg1){
		this.msg1 = msg1;
	}
	
	public String getMsg1(){
		return this.msg1;
	}
	
	public void setMsg2(String msg2){
		this.msg2 = msg2;
	}
	
	public String getMsg2(){
		return this.msg2;
	}
	
	public void setMsg3(String msg3){
		this.msg3 = msg3;
	}
	
	public String getMsg3(){
		return this.msg3;
	}
	
}
