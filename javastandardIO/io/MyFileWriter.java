package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MyFileWriter {
	// UTF-8 encoding
	private static final String charsetName = "UTF-8";
	// java standard element
	private static BufferedWriter out;

	public MyFileWriter(File file) throws FileNotFoundException, UnsupportedEncodingException {
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charsetName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public MyFileWriter(String file) throws FileNotFoundException, UnsupportedEncodingException{
		this(new File(file));
	}

	public void writeContent(String content) {
		try {
			out.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void appendContent(String content){
		try {
			out.append(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeContent(char[] content) {
		try {
			out.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void appendContent(CharSequence content){
		try {
			out.append(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
