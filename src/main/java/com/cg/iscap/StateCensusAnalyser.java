package com.cg.iscap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.cg.iscap.CSVStateCensusException.ExceptionType;


public class StateCensusAnalyser {

	public enum Code {
		STATE_CENSUS, STATE_CODE
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public int loadCsvFile(Path p) throws CSVStateCensusException {

		if (!p.toString().contains(".csv"))
			throw new CSVStateCensusException(ExceptionType.INCORRECT_TYPE, "INVALID TYPE");
		try {

			BufferedReader reader = new BufferedReader(new FileReader(p.toFile()));
			String empty="";
			String[] header=reader.readLine().split(",");
			
			while ((empty = reader.readLine()) != null) {
				if(!(("STATE").equalsIgnoreCase(header[0])&&("POPULATION").equalsIgnoreCase(header[1])&&("AREAINSQKM").equalsIgnoreCase(header[2])&&("DensityperSQKM").equalsIgnoreCase(header[3])))
					throw new CSVStateCensusException(ExceptionType.INCORRECT_HEADER, "INVALID HEADER");
				if (!empty.contains(","))
					throw new CSVStateCensusException(ExceptionType.INCORRECT_DELIMITER, "INVALID DELIMITER");
			}
			
			reader = new BufferedReader(new FileReader(p.toFile()));
			
			Iterator<CSVStateCensus> iterator = ((OpenCSVBuilder<CSVStateCensus>)CSVBuilderFactory.createCSVBuilder()).getCsvFileIterator(reader, CSVStateCensus.class);
			
			Iterable<CSVStateCensus> csvIterable=()->iterator;
			int count=(int)StreamSupport.stream(csvIterable.spliterator(), false).count();

			reader.close();
			return count;
		} catch (IOException e) {
			throw new CSVStateCensusException(ExceptionType.INCORRECT_PATH, "Invalid File");

		}
	}
@SuppressWarnings({ "resource", "unchecked" })
public int loadStateCodeCsvFile(Path p) throws CSVStateCensusException {
		
		if(!p.toString().contains(".csv"))
			throw new CSVStateCensusException(ExceptionType.INCORRECT_TYPE,"INVALID TYPE");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(p.toFile()));
			String empty="";
			String[] header=reader.readLine().split(",");
			
			while ((empty = reader.readLine()) != null) {
				if(!(("STATE").equalsIgnoreCase(header[0])&&("POPULATION").equalsIgnoreCase(header[1])&&("AREAINSQKM").equalsIgnoreCase(header[2])&&("DensityperSQKM").equalsIgnoreCase(header[3])))
					throw new CSVStateCensusException(ExceptionType.INCORRECT_HEADER, "INVALID HEADER");
				if (!empty.contains(","))
					throw new CSVStateCensusException(ExceptionType.INCORRECT_DELIMITER, "INVALID DELIMITER");
			}
			reader = new BufferedReader(new FileReader(p.toFile()));
			
			Iterator<CSVStates> iterator =  ((OpenCSVBuilder<CSVStates>)CSVBuilderFactory.createCSVBuilder()).getCsvFileIterator(reader, CSVStates.class);
			
			Iterable<CSVStates> csvIterable=()->iterator;
			int count=(int)StreamSupport.stream(csvIterable.spliterator(), false).count();
			reader.close();
			return count;
			
		} catch (IOException e) {
			throw new CSVStateCensusException(ExceptionType.INCORRECT_PATH, "Invalid File");

		}
	}

	
	

}
