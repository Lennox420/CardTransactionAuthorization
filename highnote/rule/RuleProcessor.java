package com.highnote.rule;

import java.util.*;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;

public class RuleProcessor {
	List<ProcessingRule> rules = new ArrayList<>();
	
	public RuleProcessor() {
		rules.add(new MessageValidityRule());
		rules.add(new ZipCodeProvidedAmountLessThan200Rule());
		rules.add(new ZipCodeNotProvidedAmountLessThan100Rule());
		rules.add(new ExpirationDateValidityRule());
	}
	
	public String process(Message msg) {
		for (ProcessingRule rule : rules) {
			String responseCode = rule.process(msg);
			if (!responseCode.equals(ResponseCode.OK)) {
				return responseCode;
			}
		}
		
		return ResponseCode.OK;
	}
}
