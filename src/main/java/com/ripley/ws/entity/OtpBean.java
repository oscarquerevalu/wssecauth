package com.ripley.ws.entity;

public class OtpBean {
	
	private int otpnum;
	private String id;
	
	public OtpBean(int otpnum, String id) {
		super();
		this.otpnum = otpnum;
		this.id = id;
	}
	public int getOtpnum() {
		return otpnum;
	}
	public void setOtpnum(int otpnum) {
		this.otpnum = otpnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "OtpBean [otpnum=" + otpnum + ", id=" + id + "]";
	}
	
	

}
