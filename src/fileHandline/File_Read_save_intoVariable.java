package fileHandline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File_Read_save_intoVariable {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader f=new FileReader("C:/Users/Admin/Documents/j_test.txt");
		BufferedReader br=new BufferedReader(f);
		String data="";
		String line="";
		
		try {
			while(data!=null) {
			data+=line;
			line=br.readLine();
			}
			System.out.println(data);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
