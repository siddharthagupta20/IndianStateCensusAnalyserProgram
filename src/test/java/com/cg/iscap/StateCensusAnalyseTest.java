package com.cg.iscap;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class StateCensusAnalyseTest {

	public static final String INDIA_STATE_CENSUS_DATA = "IndiaStateCensusData.csv";
	public static final String INVALID_PATH = "IndiaStateCensus.csv";
	public static final String INVALID_TYPE = "IndiaStateCensusData.txt";
	public static final String INVALID_DELIMITER = "IndiaStateCensusData1.csv";
	public static final String INVALID_HEADER = "IndiaStateCode.csv";

	@Test
	public void givenStatesCensusData_whenRead_shouldReturnCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INDIA_STATE_CENSUS_DATA);
		try {
			assertEquals(29, stateCensusAnalyser.loadCsvFile(p));
		} catch (CSVStateCensusException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenFilePath_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_PATH);
		try {
			stateCensusAnalyser.loadCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INCORRECT_PATH, e.type);
		}
	}

	@Test
	public void givenFileType_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_TYPE);
		try {
			stateCensusAnalyser.loadCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INCORRECT_TYPE, e.type);
		}
	}

	@Test
	public void givenFileDelimiter_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_DELIMITER);
		try {
			stateCensusAnalyser.loadCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INVALID_CONTENT, e.type);

		}
	}
	@Test
	public void givenFileWithInvalidHeader_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_HEADER);
		try {
			stateCensusAnalyser.loadCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INVALID_CONTENT, e.type);

		}
	}
}
