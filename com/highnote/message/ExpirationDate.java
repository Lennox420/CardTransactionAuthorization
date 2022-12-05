package com.highnote.message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpirationDate {
	public final int length = 4;
	private String expirationDate;
	
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public boolean isGreatThanCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMYY");
        try {
			Date exp = sdf.parse(this.expirationDate);
			Date today = new Date();
			return exp.after(today);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return false;
	}
	
}
