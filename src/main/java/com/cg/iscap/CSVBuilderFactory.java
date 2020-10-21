package com.cg.iscap;

public class CSVBuilderFactory {
	
	@SuppressWarnings("rawtypes")
	public static ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuilder();
	}

}
