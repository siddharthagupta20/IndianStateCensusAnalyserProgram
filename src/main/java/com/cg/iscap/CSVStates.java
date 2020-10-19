package com.cg.iscap;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {

	@CsvBindByName
	private Integer srNo;
	@CsvBindByName(column = "State Name")
	private String stateName;
	@CsvBindByName
	private String tin;
	@CsvBindByName
	private String stateCode;

	public CSVStates() {
		this.srNo = 0;
		this.stateName = "";
		this.tin = "";
		this.stateCode = "";
	}

	public CSVStates(Integer srNo, String stateName, String tin, String stateCode) {
		this.srNo = srNo;
		this.stateName = stateName;
		this.tin = tin;
		this.stateCode = stateCode;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public Integer getSrNo() {
		return srNo;
	}

	public String getStateCode() {
		return stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public String getTin() {
		return tin;
	}

}
