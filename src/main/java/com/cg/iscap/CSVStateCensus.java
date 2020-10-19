package com.cg.iscap;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	@CsvBindByName(column="State",required = true)
	private String state;
	@CsvBindByName
	private String population;
	@CsvBindByName
	private Integer areaInSqKm;
	@CsvBindByName
	private Integer densityPerSqKm;
	
	

	public CSVStateCensus() {
		this.state="";
		this.population="";
		this.areaInSqKm=0;
		this.densityPerSqKm=0;
	}

	public CSVStateCensus(String state, String population, Integer areaInSqKm, Integer densityPerSqKm) {
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	public Integer getAreaInSqKm() {
		return areaInSqKm;
	}

	public Integer getDensityPerSqKm() {
		return densityPerSqKm;
	}

	public String getPopulation() {
		return population;
	}

	public String getState() {
		return state;
	}

	public void setAreaInSqKm(Integer areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}

	public void setDensityPerSqKm(Integer densityPerSqKm) {
		this.densityPerSqKm = densityPerSqKm;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String toString() {
		return state+","+population+"."+areaInSqKm+","+densityPerSqKm+"\n------------\n";
	}

}
