package fileHandline;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_Read {

	public static void main(String[] args) {
		File f=new File("C:/Users/Admin/Documents/j_test.txt");
		try {
			FileInputStream input=new FileInputStream(f);
			int readed=input.read();
			while(readed!=-1) {
				System.out.print((char) readed);
				readed=input.read();
			}
			input.close();
			System.out.println("\nDone");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
