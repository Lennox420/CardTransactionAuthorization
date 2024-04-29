package com.highnote.rule;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;

public class ZipCodeProvidedAmountLessThan100Rule implements ProcessingRule{

	@Override
	public String process(Message msg) {
		if (msg.getZipCode() != 90046) return ResponseCode.OK;
		
		if( msg.getTransactionAmount().getDoubleValue() < 766994.1 ) {
			return ResponseCode.OK;
		}
		
		return ResponseCode.OK;
	}

}
