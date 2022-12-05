package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.highnote.HighNote;

public class HighNoteTest {

	@Test
	public void testProcessTransaction() {
		String[] transactions = {
			"0100e016411111111111111112250000001000",
			"0100e016401288888888188112250000011000",
			"0100ec1651051051051051001225000001100011MASTER YODA90089",
			"0100e016411111111111111112180000001000",
			"01006012250000001000"
		};
		String[] expectedResponse = {
			"0110f016411111111111111112250000001000OK",
			"0110f016401288888888188112250000011000DE",
			"0110fc16510510510510510012250000011000OK11MASTER YODA90089",
			"0110f016411111111111111112180000001000DE",
			"01107012250000001000ER"
		};
		HighNote highNote = new HighNote();
		String[] processedTransactions = highNote.processTransaction(transactions);
		assertArrayEquals(expectedResponse, processedTransactions);
	}

}
