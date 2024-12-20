package fileHandline;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialization {

	public static void main(String args[]){  
		  try{  
		  //Creating stream to read the object  
			  File file=new File("F:\\Payslip\\Payslip\\Passout_2020\\New_17_11_2022\\290623\\serialization.txt");
		  ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));  
		  Student s=(Student)in.readObject();  
		  //printing the data of the serialized object  
		  System.out.println(s.rollno+" "+s.name);  
		  //closing the stream  
		  in.close();  
		  }catch(Exception e){System.out.println(e);}  
		 }  
}
