package com.cg.iscap;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class StateCodesTest {

	public static final String INDIA_STATE_CODE_DATA = "IndiaStateCode.csv";
	public static final String INVALID_PATH = "IndiaStateCodes.csv";
	public static final String INVALID_TYPE = "IndiaStateCensusData.txt";
	public static final String INVALID_DELIMITER = "IndiaStateCode1.csv";
	public static final String INVALID_HEADER = "IndiaStateCensusData.csv";

	@Test
	public void givenStatesCensusData_whenRead_shouldReturnCount() throws CSVBeanBuilderException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INDIA_STATE_CODE_DATA);
		try {
			assertEquals(37, stateCensusAnalyser.loadStateCodeCsvFile(p));
		} catch (CSVStateCensusException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenFilePath_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException, CSVBeanBuilderException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_PATH);
		try {
			stateCensusAnalyser.loadStateCodeCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INCORRECT_PATH, e.type);
		}
	}

	@Test
	public void givenFileType_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException, CSVBeanBuilderException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_TYPE);
		try {
			stateCensusAnalyser.loadStateCodeCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INCORRECT_TYPE, e.type);
		}
	}

	@Test
	public void givenFileDelimiter_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException, CSVBeanBuilderException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_DELIMITER);
		try {
			stateCensusAnalyser.loadStateCodeCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INCORRECT_DELIMITER, e.type);

		}
	}
	@Test
	public void givenFileWithInvalidHeader_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException, CSVBeanBuilderException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_HEADER);
		try {
			stateCensusAnalyser.loadStateCodeCsvFile(p);
		} catch (CSVStateCensusException e) {
			assertEquals(CSVStateCensusException.ExceptionType.INCORRECT_HEADER, e.type);

		}
	}
}
