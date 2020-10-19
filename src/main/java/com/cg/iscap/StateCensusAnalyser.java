package com.cg.iscap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Iterator;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	public static final String INDIA_STATE_CENSUS_DATA = "IndiaStateCensusData.csv";

	public int loadCsvFile(Path p) {
		try {
			BufferedReader reader=new BufferedReader(new FileReader(p.toFile())); 

			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
					.withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();

			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			int count=0;
			while (iterator.hasNext()) {
				iterator.next();
				count++;
			}
			return count;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public static void main(String[] args) {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Path p = Paths.get(INDIA_STATE_CENSUS_DATA);
		System.out.println("Total States:"+stateCensusAnalyser.loadCsvFile(p));
	}

}
