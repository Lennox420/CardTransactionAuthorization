package com.highnote.rule;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;

public class ExpirationDateValidityRule implements ProcessingRule{

	@Override
	public String process(Message msg) {
		if(msg.getExpirationDate().isGreatThanCurrentDate()) {
			return ResponseCode.OK;
		}
			
		return ResponseCode.Auth;
	}

}
