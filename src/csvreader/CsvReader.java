package csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvReader {
	
	private static final String csvValueSeparator = ",";
	
	public static void read(URI uri) {
		BufferedReader br = null;
		String line = "";
		try {
			FileReader csvFile = new FileReader(uri.toString());
			br = new BufferedReader(csvFile);
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] country = line.split(csvValueSeparator);
//				System.out.println("Country [code= " + country[4] + " , name="
//						+ country[5] + "]");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void read(String uriString) {
		URI uri = null;
		try {
			uri = new URI(uriString);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		read(uri);
	}

}
