package com.nitrohub.converter.bhavtojson;

public class Instrument {
	private Futures futures = new Futures();
	private Options options = new Options();
	public Futures getFutures() {
		return futures;
	}
	public void setFutures(Futures futures) {
		this.futures = futures;
	}
	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}
}
