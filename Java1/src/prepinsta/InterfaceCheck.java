package prepinsta;

import java.util.StringJoiner;

public class InterfaceCheck {
public static void main(String[] args) {
	A a=new C();
	a.a();
}
}

interface A{  
void a();  
void b();  
}  

class C implements A{

	C() {
		super();
		System.out.println("From C constructor");
	}

	{
		System.out.println("From C NSIB");
	}

	@Override
	public void a() {
		System.out.println("From C A() method");
	}

	@Override
	public void b() {
		System.out.println("From C B() method");
		StringJoiner s=new StringJoiner(",");
		s.add("add");
	}
	
}
