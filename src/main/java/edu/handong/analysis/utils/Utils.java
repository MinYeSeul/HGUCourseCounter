package edu.handong.analysis.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class Utils {

	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(targetFileName);
		} catch(IOException e) {
			System.out.println("Error opening output file " + targetFileName);
			System.exit(0);
		}
		
		for(String line: lines) {
			outputStream.println(line);
		}
		outputStream.close();
	}

	public static ArrayList<CSVRecord> getLines(String file, boolean removeHeader) {
		ArrayList<CSVRecord> lines = new ArrayList<CSVRecord>();
				
		try
		{
			File readFile = new File(file);
			if (!readFile.exists())
				try {
					throw new NotEnoughArgumentException("The file path does not exist. Please check your CLI argument!");
				} catch (NotEnoughArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Reader reader = Files.newBufferedReader(Paths.get(file));
			CSVParser csvParser = CSVParser.parse(reader, CSVFormat.EXCEL.withIgnoreSurroundingSpaces().withTrim());
		
			Iterator<CSVRecord> temp = csvParser.iterator();
			while(temp.hasNext()) {
				lines.add(temp.next());
			}
			if(removeHeader) {
				lines.remove(0);
			}
			reader.close();
		}
		catch(FileNotFoundException e) { //if there is a wrong file path
			System.out.println("The file path does not exist. Please check your CLI argument!");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("The file path does not exist. Please check your CLI argument!");
			System.exit(0);
		}
				
		return lines;
	}
}