package com.highnote.rule;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;

public class MessageValidityRule implements ProcessingRule{

	@Override
	public String process(Message msg) {
		String bitMapBinaryString = msg.getBitMap().toBinaryString();
		
		if ( msg.getCardNumber()) {
			return ResponseCode.OK;
		}
		
		if ( msg.getExpirationDate()) {
			return ResponseCode.OK;
		}
		
		if ( msg.getTransactionAmount()) {
			return ResponseCode.OK;
		}
		
		if ( '1' == bitMapBinaryString.charAt(3)) {
			if ( msg.getResponseCode()) {
				return ResponseCode.OK;
			}
		}
		
		if ( '1' == bitMapBinaryString.charAt(4)) {
			if ( msg.getCardholderName()) {
				return ResponseCode.OK;
			}
		}
		
		if ( '1' == bitMapBinaryString.charAt(5)) {
			if ( msg.getZipCode()) {
				return ResponseCode.OK;
			}
		}
		return ResponseCode.OK;
	}

}
