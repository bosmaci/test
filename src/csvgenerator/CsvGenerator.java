package csvgenerator;

import io.MyFileWriter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;

public class CsvGenerator {

	private static final String dateFormatPattern = "ddMMyyyyHHmmssSSS";
	
	private static final String defaultFilePath = "C:/Users/L938182/Documents/test/";
	private static final String defaultExtension = ".csv";
	private static final char singleElementSeparator = ',';
	private static final char newLineSeparator = '\n';
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);
	



	private static void createCsvFile(String fileName, String fileContent) throws IOException {
		String now = sdf.format(new Date());
		MyFileWriter writer = new MyFileWriter(defaultFilePath + fileName.trim() + "_" +  now + defaultExtension);
		writer.writeContent(fileContent);
	}

	private static String generateSingleElement(Object element) {
		return "\"" + element + "\"";
	}
	
	@Deprecated
	public static void generateCsvFromMap(String fileName, LinkedHashMap<Object, Object> data) {
		StringBuffer buffer = new StringBuffer();
	}

	public static void generateCsvFromList(String fileName, List<Object> elems, Integer rowElems)
			throws IOException {
		StringBuffer buffer = new StringBuffer();
		if (elems.isEmpty()) {
			createCsvFile(fileName, buffer.toString());
		} else {
			rowElems = rowElems == null ? 1 : rowElems < 1 ? 1 : rowElems;
			int elemIndex = 1;
			ListIterator<Object> it = elems.listIterator();
			while (it.hasNext()) {
				buffer.append(generateSingleElement(it.next()));
				if (elemIndex < rowElems && it.hasNext()) {
					buffer.append(singleElementSeparator);
					elemIndex++;
				} else if(it.hasNext()){
					buffer.append(newLineSeparator);
					elemIndex = 1;
				}
			}
		}
		
		createCsvFile(fileName, buffer.toString());
	}
}
