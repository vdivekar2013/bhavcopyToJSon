package com.nitrohub.converter.bhavtojson;

import java.util.HashMap;
import java.util.Map;

public class Instruments {
	private Map<String,Instrument> value = new HashMap<String,Instrument>();

	public Map<String,Instrument> getValue() {
		return value;
	}

	public void setValue(Map<String,Instrument> value) {
		this.value = value;
	}
}
