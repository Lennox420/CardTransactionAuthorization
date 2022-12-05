package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.highnote.message.*;

public class MessageTest {

	@Test
	public void testParse() {
		Message msg = new Message("0100e016411111111111111112250000001000");
		assertEquals(MessageType.REQUEST_MESSAGE, msg.getMessageType());
		assertEquals("e0", msg.getBitMap().getHex());
		assertEquals("4111111111111111", msg.getCardNumber().getCardNumber());
		assertEquals("1225", msg.getExpirationDate().getExpirationDate());
		assertEquals("0000001000", msg.getTransactionAmount().getTransactionAmount());
		
		
		Message msg2 = new Message("0100ec1651051051051051001225000001100011MASTER YODA90089");
		assertEquals(MessageType.REQUEST_MESSAGE, msg2.getMessageType());
		assertEquals("ec", msg2.getBitMap().getHex());
		assertEquals("5105105105105100", msg2.getCardNumber().getCardNumber());
		assertEquals("1225", msg2.getExpirationDate().getExpirationDate());
		assertEquals("0000011000", msg2.getTransactionAmount().getTransactionAmount());
		assertEquals("MASTER YODA", msg2.getCardholderName().getCardholderName());
		assertEquals("90089", msg2.getZipCode().getZipCode());
		
		// malformatted message
		Message msg3 = new Message("01006012250000001000");
		assertEquals(MessageType.REQUEST_MESSAGE, msg3.getMessageType());
		assertEquals("60", msg3.getBitMap().getHex());
		assertEquals(null, msg3.getCardNumber());
	}

}
