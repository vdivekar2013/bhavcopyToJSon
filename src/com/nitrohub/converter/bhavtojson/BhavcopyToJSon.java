package com.nitrohub.converter.bhavtojson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BhavcopyToJSon {

	public static void main(String[] args) {
		System.out.println("Reading file from current directory fo_bhav.csv");
		String csvFile = "./fo_bhav.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			Instruments instruments = new Instruments();
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] instrumentArray = line.split(cvsSplitBy);
				if(instrumentArray.length != 15) {
					System.out.println("Wrongly formatted file " + csvFile);
					return;
				}
				Instrument instrument = instruments.getValue().get(instrumentArray[1]);
				if(instrument == null) {
					instrument = new Instrument();
					instruments.getValue().put(instrumentArray[1], instrument);
				}
				if(instrumentArray[0].equalsIgnoreCase("FUTIDX") || instrumentArray[0].equalsIgnoreCase("FUTSTK")) {
					FutureValue futureValue = new FutureValue(instrumentArray[1],instrumentArray[2],Double.parseDouble(instrumentArray[5]),
							Double.parseDouble(instrumentArray[6]),Double.parseDouble(instrumentArray[7]),Double.parseDouble(instrumentArray[8]),
							Double.parseDouble(instrumentArray[9]),instrumentArray[14]);
					instrument.getFutures().getValue().add(futureValue);
				}
				if(instrumentArray[0].equalsIgnoreCase("OPTIDX") || instrumentArray[0].equalsIgnoreCase("OPTSTK")) {
					OptionValue optionValue = new OptionValue(instrumentArray[1],instrumentArray[2],Float.parseFloat(instrumentArray[3]),instrumentArray[4],Double.parseDouble(instrumentArray[5]),
							Double.parseDouble(instrumentArray[6]),Double.parseDouble(instrumentArray[7]),Double.parseDouble(instrumentArray[8]),
							Double.parseDouble(instrumentArray[9]),instrumentArray[14]);
					Map<String,List<OptionValue>> strikeMap = instrument.getOptions().getValue().get(instrumentArray[2]);
					if(strikeMap == null) {
						strikeMap = new HashMap<String,List<OptionValue>>();
						instrument.getOptions().getValue().put(instrumentArray[2], strikeMap);
					}
					List<OptionValue> optionList = strikeMap.get(instrumentArray[4]);
					if(optionList == null) {
						optionList = new ArrayList<OptionValue>();
						strikeMap.put(instrumentArray[4], optionList);
					}
					optionList.add(optionValue);
				}
			}
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(instruments);
			PrintWriter out = new PrintWriter("./fo_bhav.json");
			out.println( jsonInString );
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
