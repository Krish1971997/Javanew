package statickeyword;

class A {
	A(){
		System.out.println("A is printing....");
	}
}
class B extends A{
	B(){
		System.out.println("B is printing..........");
	}
	public void run(){
		System.out.println("Run method is running...");
	}
}

public class ObjectCreation {
	public static void main(String[] args) {
		B b=new B();
		b.run();
	}
}
