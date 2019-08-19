package check;

import java.io.File;
import java.io.IOException;
import java.util.List;

import Show_Option.Options;
import fetchfile.Rewrite;

/*
 * This class is used to check that Id is unique or not
 * */
public class CheckUniqueId {
	File file1 = null;
	List<String[]> getAllData;
	Rewrite re = new Rewrite();
	String[] nextRecord;
	int flag = 0;

	/*
	 * In this Method, printing message if entered Id is unique or not, If it is not
	 * unique it will not enter the values of the data
	 */
	public void checkid(File file, int id) {
		try {
			file1 = file;
			getAllData = re.rename(file1);
			for (int i = 0; i < getAllData.size(); i++) {
				nextRecord = getAllData.get(i);
				if (nextRecord[0].equals(Integer.toString(id))) {
					System.out.println("Sorry! Emp id already Exist");
					new Options(file1);
				}
			}
		} catch (IOException e) {
			System.out.println("System error occur");
			System.exit(0);
		}
	}
}
