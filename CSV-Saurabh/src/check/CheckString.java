package check;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import Show_Option.Options;

/*
 * This class is used to check that String entered is null or not
 * */
public class CheckString {
	File file1 = null;

	/*
	 * In this Method, printing message if String entered is int It is used to check
	 * parameters like Emp_Name should not be integer
	 */
	public void isStringEmpty(String emp_name, File file) {
		file1 = file;
		boolean right = StringUtils.isNumeric(emp_name);
		if (right == true) {
			System.out.println("Data entered Cannot be integer");
			new Options(file1);
		}
	}
}