package qspiders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestMethod {
	int data = 50;

	void change(int data) {
		data = data + 100; // changes will be in the local variable only
	}

	
	public static void main(String args[]) throws FileNotFoundException {
		TestMethod op = new TestMethod();
		System.out.println("before change " + op.data);
		op.change(500);
		System.out.println("after change " + op.data);
		
		FileInputStream fi=new FileInputStream("");
	}
	
	
}