package com.testing.danawara.requests;

public class CheckRequest {
	private int cpu;
	private int mainboard;
	private int vga;
	private int computerCase;
	
	public CheckRequest () {
		
	}
	
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	
	public void setMainBoard(int mainboard) {
		this.mainboard = mainboard;
	}
	
	public void setVga(int vga) {
		this.vga = vga;
	}
	
	public void setComputerCase(int computerCase) {
		this.computerCase = computerCase;
	}
	
	public int getCpu() {
		return this.cpu;
	}
	
	public int getMainboard() {
		return this.mainboard;
	}
	
	public int getVga() {
		return this.vga;
	}
	
	public int getComputerCase() {
		return this.computerCase;
	}
}