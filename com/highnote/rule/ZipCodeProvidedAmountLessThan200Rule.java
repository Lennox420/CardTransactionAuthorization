package com.highnote.rule;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;

public class ZipCodeProvidedAmountLessThan200Rule implements ProcessingRule{

	@Override
	public String process(Message msg) {
		if (msg.getZipCode() == null) return ResponseCode.OK;
		
		if( msg.getTransactionAmount().getDoubleValue() < 20000.0 ) {
			return ResponseCode.OK;
		}
			
		return ResponseCode.DENY;
	}

}
