package com.cg.iscap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.cg.iscap.CSVStateCensusException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	public enum Code {
		STATE_CENSUS, STATE_CODE
	}

	public int loadCsvFile(Path p) throws CSVStateCensusException {
		
		if(!p.toString().contains(".csv"))
			throw new CSVStateCensusException(ExceptionType.INCORRECT_TYPE,"INVALID TYPE");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(p.toFile()));

			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
					.withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();

			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			Iterable<CSVStateCensus> csvIterable=()->iterator;
			int count=(int)StreamSupport.stream(csvIterable.spliterator(), false).count();
			return count;
		} catch (IOException e) {
			throw new CSVStateCensusException(ExceptionType.INCORRECT_PATH, "Invalid File");

		}catch(RuntimeException e) {
			throw new CSVStateCensusException(ExceptionType.INVALID_CONTENT,"Invalid Content");
		}
	}
public int loadStateCodeCsvFile(Path p) throws CSVStateCensusException {
		
		if(!p.toString().contains(".csv"))
			throw new CSVStateCensusException(ExceptionType.INCORRECT_TYPE,"INVALID TYPE");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(p.toFile()));

			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
					.withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();

			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			Iterable<CSVStateCensus> csvIterable=()->iterator;
			int count=(int)StreamSupport.stream(csvIterable.spliterator(), false).count();
			return count;
		} catch (IOException e) {
			throw new CSVStateCensusException(ExceptionType.INCORRECT_PATH, "Invalid File");

		}catch(RuntimeException e) {
			throw new CSVStateCensusException(ExceptionType.INVALID_CONTENT,"Invalid Content");
		}
	}

	
	

}
