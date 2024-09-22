package zoho1;

import java.util.Arrays;

public class ZohoEmailQuestion {

	public static void main(String[] args) {
		String[] s= {"3 alice alice@gmail.com","1 bob bob@gmail.com",
				"2 david david@gmail.com"};
		Person[] persons=new Person[s.length];
		for (int i = 0; i < s.length; i++) {
			String []parts=s[i].split(" ");
			int id=Integer.parseInt(parts[0]);
			String name=parts[1];
			String email=parts[2];
			persons[i]=new Person(id,name,email);
		}
		Arrays.sort(persons);
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}

class Person implements Comparable<Person>{
	int id;
	String name;
	String email;
	
	public Person(int id, String name, String email) {
		//super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
		
	@Override
	public String toString() {
		return "Person ==> [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int compareTo(Person o) {
		int value=Integer.compare(this.email.length(), o.email.length());
		if(value!=0)
			return value;
		else
			return Integer.compare(this.id, o.id);
	}
}