package fileHandline;

import java.io.File;
import java.io.IOException;

public class File_Check_Canread_CanWrite {
	public static void main(String[] args) {
		File f = new File("C:/Users/Admin/Documents/j_tet.txt");
		
//		 boolean file=f.setReadOnly(); 
//		 System.out.println(file);
//		
//		if (f.canRead())
//			System.out.println("Can read");
//		else
//			System.out.println("Can not read");
		if(f.isDirectory())
			System.out.println(f.getAbsolutePath()+" is a Director");
		else
			System.out.println("not a directory");
		if(f.exists())
			System.out.println("File is available");
		else
			try {
				f.createNewFile();
				System.out.println("File is createtd");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
