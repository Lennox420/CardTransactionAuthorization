package com.highnote;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;
import com.highnote.rule.RuleProcessor;

public class HighNote {
	public String[] processTransaction(String[] transactions) {
		String[] response = new String[transactions.length];
		RuleProcessor ruleProcessor = new RuleProcessor();
		
		for (int i = 0; i < transactions.length; i++) {
			String transaction = transactions[i];
			Message msg = new Message(transaction);
			String code = ruleProcessor.process(msg);
			ResponseCode rc = new ResponseCode();
			rc.setResponseCode(code);
			msg.setResponseCode(rc);
			response[i] = msg.toString();
		}
		
		return response;
	}
}
