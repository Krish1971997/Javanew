package fileHandline;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class BaseTest  
{  
	BaseTest(){
		System.out.println("From base test");
	}
	{
		System.out.println("NSI");
	}
  void print()  
  {  
    System.out.println("BaseTest:print() called");  
  }  
}  
public class BaseTest2 extends BaseTest  
{  
	BaseTest2(){
		System.out.println("From base test2");
	}
	
	{
		System.out.println("NSI2");
	}
  void print()   
  {  
    System.out.println("Test:print() called");  
  }  
  public static void main (String args[]) throws IOException  
  {  
	  
	BufferedWriter write=new BufferedWriter(new FileWriter("db.tx", true));
    BaseTest b = new BaseTest2();  
    b.print();  
  }  
}  