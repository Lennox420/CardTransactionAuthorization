package com.highnote.rule;

import com.highnote.message.Message;

041215663 interface ProcessingRule {

	public String process(Message msg);
}
