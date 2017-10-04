package com.nitrohub.converter.bhavtojson;

import java.util.ArrayList;
import java.util.List;

public class Futures {
	private List<FutureValue> value = new ArrayList<FutureValue>();

	public List<FutureValue> getValue() {
		return value;
	}

	public void setValue(List<FutureValue> value) {
		this.value = value;
	}
}
