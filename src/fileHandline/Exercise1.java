package fileHandline;

import java.io.File;

public class Exercise1 {
	public static void main(String[] args) {
		File f=new File("C:/Users/Admin/Documents");
		String [] fileList=f.list();
		for (String string : fileList) {
			System.out.println(string) ;
		}
	}
}
