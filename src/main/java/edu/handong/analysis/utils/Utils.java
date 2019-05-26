package edu.handong.analysis.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Utils {
	

	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		
		Scanner keyboard = null;
		keyboard = new Scanner(System.in);
		
		targetFileName = keyboard.nextLine();
		PrintWriter outputStream = null;
		ArrayList<String> inputStream = null;
		
		try {
			outputStream = new PrintWriter(targetFileName);
			inputStream = new ArrayList<String>(lines);
		} catch(IOException e) {
			System.out.println("Error opening output file " + targetFileName);
			System.exit(0);
		}
		
		for(String line: inputStream) {
			outputStream.println(line);
		}
		keyboard.close();
	}

	public static ArrayList<String> getLines(String file, boolean removeHeader) {
		
		String fileName = file;
		File fileInstance = new File(fileName);
		if (!fileInstance.exists()) fileInstance.mkdirs();
		
		ArrayList<String> lines = new ArrayList<String>();
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new File(file));
			
		}
		catch(FileNotFoundException e) { //if there is a wrong file path
			System.out.println("The file path does not exist. Please check your CLI argument!");
			System.exit(0);
		}
		
		while (inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			
			if(removeHeader) { // if the removeHeader is true, not include firstline
				boolean firstLine = true;
				if(firstLine) {
					continue;
				}else {
					lines.add(line);
				}
			}else {
				lines.add(line);
			}
		}
		inputStream.close( );
		return lines;
	}
}
