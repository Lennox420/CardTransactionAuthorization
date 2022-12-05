package com.highnote.rule;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;

public class MessageValidityRule implements ProcessingRule{

	@Override
	public String process(Message msg) {
		String bitMapBinaryString = msg.getBitMap().toBinaryString();
		
		if (null == msg.getCardNumber()) {
			return ResponseCode.ERROR;
		}
		
		if (null == msg.getExpirationDate()) {
			return ResponseCode.ERROR;
		}
		
		if (null == msg.getTransactionAmount()) {
			return ResponseCode.ERROR;
		}
		
		if ( '1' == bitMapBinaryString.charAt(3)) {
			if (null == msg.getResponseCode()) {
				return ResponseCode.ERROR;
			}
		}
		
		if ( '1' == bitMapBinaryString.charAt(4)) {
			if (null == msg.getCardholderName()) {
				return ResponseCode.ERROR;
			}
		}
		
		if ( '1' == bitMapBinaryString.charAt(5)) {
			if (null == msg.getZipCode()) {
				return ResponseCode.ERROR;
			}
		}
		return ResponseCode.OK;
	}

}
