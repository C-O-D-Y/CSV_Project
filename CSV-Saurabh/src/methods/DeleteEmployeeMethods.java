package methods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import fetchfile.ReInsert;
import fetchfile.Rewrite;

public class DeleteEmployeeMethods extends FetchEmployeeMethods {
	File file = null;
	List<String[]> getAllData;
	Rewrite re = new Rewrite();
	ReInsert reinsert = new ReInsert();
	String[] nextRecord;
	int flag = 0;

	public DeleteEmployeeMethods(File file) throws IOException {

		// FetchEmployeeMethods constructor is been called to load the txt file from the
		// class
		super(file);
		this.file = file;

		/*
		 * Calling rewriteFile() method to rewrite into the file
		 */
	}

	/*
	 * In all below present methods, when if condition is true if true, then that
	 * line is not printed in the file.
	 */

	public void delete() throws IOException {
		getAllData = re.rename(file);
		getAllData.removeAll(getAllData);
		System.out.println("All Records deleted");
	}

	public void delete(String name) throws IOException {
		try {
			getAllData = re.rename(file);
			for (int i = 0; i < getAllData.size(); i++) {
				nextRecord = getAllData.get(i);
				if (nextRecord[1].equalsIgnoreCase(name)) {
					flag = 1;
					getAllData.remove(i);
					System.out.println("Record deleted");
				}
			}
			reinsert.reInsertInFile(file, getAllData);
			if (flag == 0) {
				System.out.println("No Records Found");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			reinsert.reInsertInFile(file, getAllData);
		}
	}

	public void delete1(String department) throws IOException {
		try {
			getAllData = re.rename(file);
			for (int i = 0; i < getAllData.size(); i++) {
				// size=getAllData.size();
				nextRecord = getAllData.get(i);
				if (nextRecord[3].equalsIgnoreCase(department)) {
					flag = 1;
					i = 0;
					getAllData.remove(nextRecord);
					System.out.println("Record deleted");
				}
			}
			reinsert.reInsertInFile(file, getAllData);
			if (flag == 0) {
				System.out.println("No Records Found");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			reinsert.reInsertInFile(file, getAllData);
		}
	}

	public void delete(int id) throws IOException {
		try {
			getAllData = re.rename(file);
			for (int i = 0; i < getAllData.size(); i++) {
				nextRecord = getAllData.get(i);
				if (nextRecord[0].equals(Integer.toString(id))) {
					flag = 1;
					getAllData.remove(i);
					System.out.println("Record deleted");
				}
			}
			reinsert.reInsertInFile(file, getAllData);
			if (flag == 0) {
				System.out.println("No Records Found");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			reinsert.reInsertInFile(file, getAllData);
		}
	}
}
