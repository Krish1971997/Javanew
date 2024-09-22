package fileHandline;

import java.io.*;

class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
}

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee("John Doe", 101);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\Admin\\Documents\\Zoho\\New Text Document.txt"))) {
			oos.writeObject(emp); // Employee object can be serialized because it implements Serializable
			System.out.println("Employee object has been serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
