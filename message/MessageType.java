package com.highnote.message;

import java.util.*;

public enum MessageType {
	REQUEST_MESSAGE("0100"),
	RESPONSE_MESSAGE("0110");
	
	public final String type;

    private MessageType(String type) {
        this.type = type;
    }
    
    private static final Map<String, MessageType> stringToTypeMap = new HashMap<>();
    
    static {
    	for (MessageType type : MessageType.values()) {
    		stringToTypeMap.put(type.type, type);
    	}
    	
    }
    
    public static MessageType getTypeFromString(String type) {
    	return stringToTypeMap.get(type);
    }
}