package com.nitrohub.converter.bhavtojson;

public class OptionValue {
	private String name;
	private String expiryDate;
	private float strikePrice;
	private String optionType;
	private double open;
	private double high;
	private double low;
	private double close;
	private double settlement;
	private String timestamp;
	
	public OptionValue(String name,String expiryDate,float strikePrice,String optionType,double open,double high,double low,double close,double settlement,String timestamp) {
		this.name = name;
		this.expiryDate = expiryDate;
		this.setStrikePrice(strikePrice);
		this.setOptionType(optionType);
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.settlement = settlement;
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getSettlement() {
		return settlement;
	}
	public void setSettlement(double settlement) {
		this.settlement = settlement;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public float getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(float strikePrice) {
		this.strikePrice = strikePrice;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
}
