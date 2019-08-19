package methods;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVWriter;

import check.CheckString;
import check.CheckUniqueId;

/*
 *In this Class, We are inserting the data of the employee in the file
 **/
public class Insert {
	File file_path;
	int emp_id;
	String emp_name;
	double emp_salary;
	String emp_department;
	String emp_gender;
	CheckUniqueId cui = new CheckUniqueId();
	CheckString cs = new CheckString();
	Scanner input = new Scanner(System.in);

//Constructor called to give object of file to the Instance variable(file)

	public Insert(File file_path) {
		this.file_path = file_path;
	}

	/*
	 * In this Method, We are inserting the data that has been given by the user
	 */
	public void insert() {
		try {
			System.out.print("Please enter the Employee id:");
			emp_id = input.nextInt();
			// calling unique id method to check id is unique present or not
			cui.checkid(file_path, emp_id);
			System.out.print("Please enter Employee Name:");
			input.nextLine();
			emp_name = input.nextLine();
			// calling the String empty method to check file entered path is null or not
			cs.isStringEmpty(emp_name, file_path);
			System.out.print("Please enter the Employee Salary:");
			emp_salary = input.nextDouble();
			System.out.print("Please enter your Employee Department:");
			input.nextLine();
			emp_department = input.nextLine();
			System.out.print("Please enter Gender of the Employee:");
			emp_gender = input.nextLine();
			FileWriter outputfile = new FileWriter(file_path, true);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] data = { Integer.toString(emp_id), emp_name, Double.toString(emp_salary), emp_department,
					emp_gender };
			writer.writeNext(data);
			writer.close();
			System.out.println("Employee Data Inserted");
		} catch (Exception e) {
			System.out.println("Wrong Input! Please Enter Correct Data");
			new Insert(file_path).insert();
		}
	}
}
