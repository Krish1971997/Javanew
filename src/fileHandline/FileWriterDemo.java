package fileHandline;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\Admin\\Documents\\Filehandling\\1\\2\\3\\new.txt");
		if(file.exists()) {
			FileWriter write=new FileWriter(file,true);
			write.write("Krishnakumar");
			write.write("\n123123");
			write.flush();
			write.close();
			System.out.println("Passed input");
		}
		
		FileReader reader=new FileReader(file);
		System.out.println(reader.read());
		reader.read();
	}

}
