package com.highnote.message;

import java.math.BigInteger;

public class BitMap {
	public final int length = 2;
	private String hex;
	
	public String getHex() {
		return hex;
	}
	public void setHex(String bitMap) {
		this.hex = bitMap;
	}
	
	public String toBinaryString() {
		String binaryString = new BigInteger(this.hex, 16).toString(2);
		String leftPaddingZero = "";
		for ( int i = 0; i < (8-binaryString.length()); i++) {
			leftPaddingZero += "0";
		}
		return leftPaddingZero + binaryString;
	}
	
	public void setBinaryString(String binaryString) {
		this.hex = new BigInteger(binaryString, 2).toString(16);		
	}
	
}
