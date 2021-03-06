package Atmecs.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.CSVReader;

import fetchfile.FetchFromFile;

public class FetchEmployeeMethods {
	CSVReader csv;

	public FetchEmployeeMethods(File file) throws IOException {
		// In this constructor i'm loading the file into our java context code from
		// FetchFromFile class
		try {
			csv = new FetchFromFile().loadFile(file);
		} catch (FileNotFoundException e) {

			System.out.println("File Path Not Found! Please give correct path.");
		}
	}

	public void fetch() throws IOException {
		String[] nextRecord;
		csv.readNext();
		// we are going to read data line by line
		while ((nextRecord = csv.readNext()) != null) {
			for (String cell : nextRecord) {
				System.out.print(cell + ", ");
			}
			System.out.println();
		}
	}

	public void fetch(int id) throws IOException {
		String[] nextRecord;
		while ((nextRecord = csv.readNext()) != null) {
			if (nextRecord[0].equals(Integer.toString(id))) {
				for (String cell1 : nextRecord) {
					System.out.print(cell1 + ", ");
				}
				System.out.println();
			}
		}
	}

	public void fetch(String name) throws IOException {
		String[] nextRecord;
		while ((nextRecord = csv.readNext()) != null) {
			if (nextRecord[1].equalsIgnoreCase(name) || nextRecord[3].equalsIgnoreCase(name)) {
				for (String cell : nextRecord) {
					System.out.print(cell + ", ");

				}
				System.out.println();
			}
		}
	}
}
