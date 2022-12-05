package com.highnote.rule;

import com.highnote.message.Message;

public interface ProcessingRule {

	public String process(Message msg);
}
