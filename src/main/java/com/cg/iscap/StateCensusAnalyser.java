package com.cg.iscap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import java.util.Iterator;

import com.cg.iscap.CSVStateCensusException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

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
			reader.close();
			BufferedReader reader1 = new BufferedReader(new FileReader(p.toFile()));
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader1)
					.withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
			
			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			int count = 0;
			while (iterator.hasNext()) {
				iterator.next();
				count++;
				
				
			}
			
			reader1.close();
			
			
			return count;
		} catch (IOException e) {
			throw new CSVStateCensusException(ExceptionType.INCORRECT_PATH, "Invalid File");

		}
	}

}
