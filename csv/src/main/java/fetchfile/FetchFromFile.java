package fetchfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVReader;

/*
 * In this class we load file to get our data from the file
 *  and, manipulate the data
 *  */

public class FetchFromFile {
	public CSVReader loadFile(File file) throws IOException {

	try { 
		  
        // Create an object of filereader 
        // class with CSV file as a parameter. 
        FileReader filereader = new FileReader(file); 
  
        // create csvReader object passing 
        // file reader as a parameter 
        CSVReader csvReader = new CSVReader(filereader); 
        return csvReader;
    } 
    catch (FileNotFoundException e) { 
      System.out.println("File not found");
    }
	return null;
}}
