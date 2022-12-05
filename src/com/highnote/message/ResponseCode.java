package com.highnote.message;

public class ResponseCode {
	
	public final static String OK = "OK";
	public final static String DENY = "DE";
	public final static String ERROR = "ER";
	
	public final int length = 2;
	private String responseCode;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
}
