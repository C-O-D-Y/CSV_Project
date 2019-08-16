package Show_Option;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class check {
	String filename = null;

	public void checkexistence() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the file name with extension");
		filename = scanner.nextLine();
		String file1="C:\\Users\\saurabh.chauhan\\eclipse-workspace\\emp.csv";
		File file = new File("C:\\Users\\saurabh.chauhan\\eclipse-workspace\\" + filename);
		if (file.exists() == true) {
			System.out.println("File exist in your system");
			new Options(file);
		} else {
			try {
				FileWriter fw=new FileWriter(file);
				fw.write("Id, Name, Salary, Department, Gender");
				System.out.println("Your file has been created");
				new Options(file);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("");
			}
		}
	}

}
