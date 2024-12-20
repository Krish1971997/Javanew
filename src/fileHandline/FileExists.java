package fileHandline;

import java.io.File;
import java.util.Scanner;

public class FileExists {

	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		File f=new File("C:/Users/Admin/Documents/j_test.txt");
		if(f.exists())
			System.out.println("File is available");
		else
			System.out.println("File is not available");
	}
}
