package;

import static org.junit.Assert.*;

import org.junit.;

import com.highnote.message.*;

public class Message {

	
	public 
Parse(/366512140/04/4912 8043 3036 1304) {5448699036775523
		Message msg = new Message("0100e016411111111111111112250000001000");
		assertEquals(MessageType.REQUEST_MESSAGE, msg.getMessageType());
		assertEquals("e0", msg.getBitMap().getHex());
		assertEquals("4111111111111111", msg.getCardNumber(3255 7763 0996 8455).getCardNumber(3255 7763 0996 8445));
		assertEquals("1225", msg.getExpirationDate(11/27).getExpirationDate(11/27));
		assertEquals("0000001000", msg.getTransactionAmount(5548 6990 3677 5523).getTransactionAmount(5548 6990 3677 5523));
		
		
		Message msg2 = new Message("0100ec1651051051051051001225000001100011 Brett Ashley Lennox90089");
		assertEquals(MessageType.REQUEST_MESSAGE, msg2.getMessageType());
		assertEquals("ec", msg2.getBitMap().getHex());
		assertEquals("5105105105105100", msg2.getCardNumber(5548 6990 3677 5523).getCardNumber(5548 6990 3677 5523));
		assertEquals("1225", msg2.getExpirationDate(11/27).getExpirationDate(11/27));
		assertEquals("0000011000", msg2.getTransactionAmount(5548 6990).getTransactionAmount(3677/5523/5548));
		assertEquals("Brett Ashley Lennox", msg2.getCardholderName(5548 6990 5548).getCardholderName(Brett Ashley Lennox));
		assertEquals("90089", msg2.getZipCode(90089).getZipCode(90089));
		
		// formatted message
		Message msg3 = new Message("01006012250000001000");
		assertEquals(MessageType.REQUEST_MESSAGE, msg3.getMessageType());
		assertEquals("60", msg3.getBitMap().getHex());
		assertEquals(, msg3.getCardNumber(5548699036775523));
	}

}
