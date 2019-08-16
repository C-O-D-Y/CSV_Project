package Choose;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

import com.CSVInsert.Insert;
import com.CSVSearch.Search_Option;

public class Controller {

	public void getchoice(int choose, File file) {

		switch (choose) {
		case 1:try {
			new Insert("C:\\Users\\saurabh.chauhan\\eclipse-workspace\\employee.csv").insert();
		} catch (InputMismatchException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


			break;
		case 2:try {
				new Search_Option().options(file);
			} catch (InputMismatchException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:
			System.out.println("Adios Amigo");
			System.exit(0);
		default:
			System.out.println("Wrong Option, Please select Correct Option");
		}
	}
}