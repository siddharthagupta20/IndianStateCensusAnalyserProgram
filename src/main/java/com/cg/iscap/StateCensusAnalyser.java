package com.cg.iscap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;

import com.cg.iscap.CSVStateCensusException.ExceptionType;

public class StateCensusAnalyser {

	public enum Code {
		STATE_CENSUS, STATE_CODE
	}

	@SuppressWarnings({ "resource" })
	public int loadCsvFile(Path p) throws CSVStateCensusException {
		String ext = FilenameUtils.getExtension(p.toString());
		if (!ext.equals("csv"))
			throw new CSVStateCensusException(ExceptionType.INCORRECT_TYPE, "INVALID TYPE");
		try {

			BufferedReader reader = new BufferedReader(new FileReader(p.toFile()));
	
			String empty = "";
			String[] header = reader.readLine().split(",");
	
			while ((empty = reader.readLine()) != null) {
				if (!(("STATE").equalsIgnoreCase(header[0]) && ("POPULATION").equalsIgnoreCase(header[1])
						&& ("AREAINSQKM").equalsIgnoreCase(header[2])
						&& ("DensityperSQKM").equalsIgnoreCase(header[3])))
					throw new CSVStateCensusException(ExceptionType.INCORRECT_HEADER, "INVALID HEADER");
				if (!empty.contains(","))
					throw new CSVStateCensusException(ExceptionType.INCORRECT_DELIMITER, "INVALID DELIMITER");
			}

			reader = new BufferedReader(new FileReader(p.toFile()));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
					.withHeaderComments(CSVStateCensus.class));
			
			int count=-1;
			for(CSVRecord record:csvParser) {
				count++;
			}

			reader.close();
			return count;
		} catch (IOException e) {
			throw new CSVStateCensusException(ExceptionType.INCORRECT_PATH, "Invalid File");

		}
	}

	@SuppressWarnings({ "resource" })
	public int loadStateCodeCsvFile(Path p) throws CSVStateCensusException {

		String ext = FilenameUtils.getExtension(p.toString());
		if (!ext.equals("csv"))
			throw new CSVStateCensusException(ExceptionType.INCORRECT_TYPE, "INVALID TYPE");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(p.toFile()));
			String empty = "";
			String[] header = reader.readLine().split(",");

			while ((empty = reader.readLine()) != null) {
				if (!(("SRNO").equalsIgnoreCase(header[0]) && ("STATE NAME").equalsIgnoreCase(header[1])
						&& ("TIN").equalsIgnoreCase(header[2]) && ("STATECODE").equalsIgnoreCase(header[3]))) {
					throw new CSVStateCensusException(ExceptionType.INCORRECT_HEADER, "INVALID HEADER");
				}
				if (!empty.contains(","))
					throw new CSVStateCensusException(ExceptionType.INCORRECT_DELIMITER, "INVALID DELIMITER");
			}
			reader = new BufferedReader(new FileReader(p.toFile()));

			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
					.withHeaderComments(CSVStateCensus.class));
			
			int count=0-1;
			for(CSVRecord record:csvParser) {
				count++;
			}
			reader.close();
			return count;

		} catch (IOException e) {
			throw new CSVStateCensusException(ExceptionType.INCORRECT_PATH, "Invalid File");

		}
	}

}
