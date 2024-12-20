package fileHandline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_Write {

	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		File f=new File("C:/Users/Admin/Documents/j_test.txt");
		System.out.println("Enter the login name:-");
		String owner=s.next();
		s.nextLine();
		if(owner.equals("Admin"))
		f.setWritable(true,true);
		try {
			FileWriter write=new FileWriter(f);
			System.out.println("Enter the data");
			String data=s.nextLine();
			write.write(data);
			write.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
