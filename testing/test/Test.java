package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csvgenerator.CsvGenerator;
import csvreader.CsvReader;

public class Test {

	@org.junit.Test
	public void test() {
		CsvReader.read("C:/Users/L938182/Documents/test/GeoIPCountryWhois.csv");
	}
	
	@org.junit.Test
	public void testCreate() {
		List elems = new ArrayList();
		elems.add("pippo");
		elems.add("calippo");
		try {
			CsvGenerator.generateCsvFromList("pippoCalippo", elems, 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
