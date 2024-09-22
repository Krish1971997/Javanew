package fileHandline;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class FileCreate {
	static FileOutputStream f;
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the path");
		//String path="C:/Users/Admin/Documents/j_test.txt";
		String path=s.next();
		try {
			f=new FileOutputStream(path);
			System.err.println("File is created...");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
