package fileHandline;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization {

	public static void main(String args[]) {
		File file=new File("C:\\Users\\Admin\\Documents\\Zoho\\New Text Document.txt");
		//Serialization
		try {
			// Creating the object
			Student s1 = new Student(211, "ravi");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s1);
			out.flush();
			out.close();
			System.out.println("success");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//DeSerialization
		try {
			FileInputStream fin=new FileInputStream(file);
			ObjectInputStream obj=new ObjectInputStream(fin);
			Student s=(Student)obj.readObject();
			System.out.println(s);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int rollno;
	String name;
	
	public Student(int i, String string) {
		this.rollno = i;
		this.name = string;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}
	
}