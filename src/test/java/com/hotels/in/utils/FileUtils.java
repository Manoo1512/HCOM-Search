package com.hotels.in.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class FileUtils {

	private static final String NEW_LINE_SEPARATOR = "\n";


	public static void writeListToCsvFile(String fileName , List<String> data){

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			int i=0;
			while (i<data.size()){
				fileWriter.append(data.get(i));
				fileWriter.append(NEW_LINE_SEPARATOR);
				i++;
			}

		}catch (Exception e){
			e.printStackTrace();
		}

		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}


		}

	}
}