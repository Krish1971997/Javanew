package fileHandline;

import java.io.File;
import java.util.Date;

public class File_Lastmodified {

	public static void main(String[] args) {
		File f = new File("C:/Users/Admin/Documents/j_test.txt");
		
		Date date=new Date(f.lastModified());
		System.out.println("Date :"+date);
	}
}
