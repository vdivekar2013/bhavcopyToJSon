package com.nitrohub.converter.bhavtojson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Options {
	private Map<String,Map<String,List<OptionValue>>> value = new HashMap<String,Map<String,List<OptionValue>>>();

	public Map<String,Map<String,List<OptionValue>>> getValue() {
		return value;
	}

	public void setValue(Map<String,Map<String,List<OptionValue>>> value) {
		this.value = value;
	}
}
