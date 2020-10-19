package com.cg.iscap;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class StateCensusAnalyseTest {

	public static final String INDIA_STATE_CENSUS_DATA = "IndiaStateCensusData.csv";
	public static final String INVALID_PATH = "IndiaStateCensus.csv";
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
	@Test(expected =CSVStateCensusException.class)
	public void givenFilePath_WhenInvalid_ShouldReturnTrue() throws CSVStateCensusException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INVALID_PATH);
		stateCensusAnalyser.loadCsvFile(p);
	}

}
