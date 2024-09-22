package fileHandline;

import java.io.File;
import java.io.IOException;

public class FilehandlingUsingPayilagam {
	public static void main(String[] args) throws IOException {
		/*File file=new File("C:\\Users\\Admin\\Documents\\Filehandling\\1\\2\\3");
		if(!file.exists()) {
			file.mkdirs();
			System.out.println("Folder is created:");
		}
		*/
		
		//File file=new File("C:\\Users\\Admin\\Documents\\Filehandling\\1\\2\\3\\");
		File file=new File("C:\\Users\\Admin\\Documents");
		if(!file.exists()) {
			boolean created=file.createNewFile();
			System.out.println("File created "+created);
			
		}
		/*--Delete
		 * if(file.delete()) {
			System.out.println("File deleted");
			
		}*/
		/*--Rename
		File newfile=new File("C:\\Users\\Admin\\Documents\\Filehandling\\1\\2\\3\\new.txt");
		file.renameTo(newfile);
		
		*/
		
		/*System.out.println(file.getName());
		System.out.println(file.canExecute());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		*/
	
		/*
		String listOfFiles[]=file.list();
		for (String string : listOfFiles) {
			System.out.println(string);
		} */
		
		File[] files=file.listFiles();
		for (File file2 : files) {
			if(file2.isFile())
				System.out.println(file2);
		}
	}

}
