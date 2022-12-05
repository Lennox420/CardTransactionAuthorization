package com.highnote.message;

public class Message {
	private String message;
	
	private MessageType messageType;
	private BitMap bitMap;
	
	private CardNumber cardNumber;
	private ExpirationDate expirationDate;
	private TransactionAmount transactionAmount;
	private ResponseCode responseCode;
	private CardholderName cardholderName;
	private ZipCode zipCode;
	
	private int processIndex = 0;
	
	public Message(String message) {
		this.message = message;
		this.parse();
	}
	
	public void parse() {
		parseMessageType();
		parseBitmap();
		String bitMapBinaryString = bitMap.toBinaryString();
		
		if ( '1' == bitMapBinaryString.charAt(0)) {
			parseCardNumber();
		}
		
		if ( '1' == bitMapBinaryString.charAt(1)) {
			parseExpirationDate();
		}
		
		if ( '1' == bitMapBinaryString.charAt(2)) {
			parseTransactionAmount();
		}
		
		if ( '1' == bitMapBinaryString.charAt(3)) {
			parseResponseCode();
		}
		
		if ( '1' == bitMapBinaryString.charAt(4)) {
			parseCardholderName();
		}
		
		if ( '1' == bitMapBinaryString.charAt(5)) {
			parseZipCode();
		}
		
	}
	
	public void parseMessageType() {
		String type = this.message.substring(processIndex, processIndex+4);
		processIndex += 4;
		
		this.messageType = MessageType.getTypeFromString(type);
	}
	
	public void parseBitmap() {
		BitMap bitMap = new BitMap();
		String hex = this.message.substring(processIndex, processIndex+bitMap.length);
		bitMap.setHex(hex);
		processIndex += bitMap.length;
		
		this.bitMap = bitMap;
	}
	
	public void parseCardNumber() {
		CardNumber cardNumber = new CardNumber(); 
		int lengthOfCardNumber = Integer.parseInt(message.substring(processIndex, processIndex+cardNumber.length));
		processIndex += cardNumber.length;
		
		String cardNumberStr = message.substring(processIndex, processIndex + lengthOfCardNumber);
		cardNumber.setCardNumber(cardNumberStr);
		processIndex += lengthOfCardNumber;
		
		this.cardNumber = cardNumber;
	}
	
	public void parseExpirationDate() {
		if (processIndex >= message.length()) {
			return;
		}
		ExpirationDate expDate = new ExpirationDate();
		String expDateStr = message.substring(processIndex, processIndex + expDate.length);
		expDate.setExpirationDate(expDateStr);
		processIndex += expDate.length;
		
		this.expirationDate = expDate;
	}
	
	public void parseTransactionAmount() {
		if (processIndex >= message.length()) {
			return;
		}
		TransactionAmount transactionAmount = new TransactionAmount();
		String amountStr = message.substring(processIndex, processIndex + transactionAmount.length);
		transactionAmount.setTransactionAmount(amountStr);
		processIndex += transactionAmount.length;
		
		this.transactionAmount = transactionAmount;
	}
	
	public void parseResponseCode() {
		if (processIndex >= message.length()) {
			return;
		}
		ResponseCode responseCode = new ResponseCode();
		String code = message.substring(processIndex, processIndex + responseCode.length);
		responseCode.setResponseCode(code);
		processIndex += responseCode.length;
		
		this.responseCode = responseCode;
	}
	
	public void parseCardholderName() {
		if (processIndex >= message.length()) {
			return;
		}
		CardholderName cardholderName = new CardholderName();
		int nameLen = Integer.parseInt(message.substring(processIndex, processIndex + cardholderName.length));
		processIndex += cardholderName.length;
		
		String name = message.substring(processIndex, processIndex + nameLen);
		cardholderName.setCardholderName(name);
		processIndex += nameLen;
		
		this.cardholderName = cardholderName;
	}
	
	public void parseZipCode() {
		if (processIndex >= message.length()) {
			return;
		}
		ZipCode zipCode = new ZipCode();
		String zipCodeStr = message.substring(processIndex, processIndex + zipCode.length);
		zipCode.setZipCode(zipCodeStr);
		processIndex += zipCode.length;
		this.zipCode = zipCode;	
	}

	public CardNumber getCardNumber() {
		return cardNumber;
	}

	public ExpirationDate getExpirationDate() {
		return expirationDate;
	}

	public TransactionAmount getTransactionAmount() {
		return transactionAmount;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(ResponseCode rc) {
		String binaryString = this.getBitMap().toBinaryString();
		binaryString = binaryString.substring(0,3) + "1" + binaryString.substring(4);
		this.getBitMap().setBinaryString(binaryString);
		
		this.responseCode = rc;
	}

	public CardholderName getCardholderName() {
		return cardholderName;
	}

	public ZipCode getZipCode() {
		return zipCode;
	}

	public MessageType getMessageType() {
		return messageType;
	}
	
	public BitMap getBitMap() {
		return bitMap;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(MessageType.RESPONSE_MESSAGE.type);
		sb.append(this.getBitMap().getHex());
		if (null != this.getCardNumber()) {
			sb.append(this.getCardNumber().getCardNumber().length() + this.getCardNumber().getCardNumber());
		}
		
		if (null != this.getExpirationDate()) {
			sb.append(this.getExpirationDate().getExpirationDate());
		}
		
		if (null != this.getTransactionAmount()) {
			sb.append(this.getTransactionAmount().getTransactionAmount());
		}
		
		if (null != this.getResponseCode()) {
			sb.append(this.getResponseCode().getResponseCode());
		}
		
		if (null != this.getCardholderName()) {
			sb.append(this.getCardholderName().getCardholderName().length() + this.getCardholderName().getCardholderName());
		}
		
		if (null != this.getZipCode()) {
			sb.append(this.getZipCode().getZipCode());
		}
		
		return sb.toString();
		
	}
	
}
