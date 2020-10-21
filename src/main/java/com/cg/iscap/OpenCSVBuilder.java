package com.cg.iscap;

import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@SuppressWarnings("rawtypes")
public class OpenCSVBuilder<E> implements ICSVBuilder<E> {

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> getCsvFileIterator(Reader reader, Class csvPojo) throws CSVStateCensusException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
			csvToBeanBuilder.withType(csvPojo);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<E> csvToBean = csvToBeanBuilder.build();
			return csvToBean.iterator();

		} catch (IllegalStateException e) {
			throw new CSVStateCensusException(CSVStateCensusException.ExceptionType.UNABLE_TO_PARSE,
					"NOT GETTING PARSED");
		}
	}

}
