package prepinsta;

public class Test {
	public static void main(String[] args) {
		A1 a=new B1();
		a.draw();
	}

}

abstract class A1 {
	A1() {
		System.out.println("From A1 constructor");
	}

	{
		System.out.println("From A1 NSIB");
	}

	public abstract void draw();

	public void cat() {
		System.out.println("From A1 cat method");
	}
}

class B1 extends A1 {

	B1() {
		System.out.println("From B1 constructor");
	}

	{
		System.out.println("From B1 NSIB");
	}

	@Override
	public void draw() {
		System.out.println("From B1 draw method");
	}

}