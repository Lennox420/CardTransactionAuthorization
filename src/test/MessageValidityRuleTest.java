package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.highnote.message.Message;
import com.highnote.message.ResponseCode;
import com.highnote.rule.MessageValidityRule;

public class MessageValidityRuleTest {

	@Test
	public void testProcess() {
		MessageValidityRule rule = new MessageValidityRule();
		String responseCode;
		
		Message msg2 = new Message("0100ec1651051051051051001225000001100011MASTER YODA90089");
		responseCode = rule.process(msg2);
		assertEquals(ResponseCode.OK, responseCode);
		
		Message msg3 = new Message("01006012250000001000");
		responseCode = rule.process(msg3);
		assertEquals(ResponseCode.ERROR, responseCode);
	}

}
