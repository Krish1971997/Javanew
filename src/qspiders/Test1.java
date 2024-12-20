package qspiders;

class Parent{
	static int a=1;
}
class Child extends Parent{
	static int a=4;
}
public class Test1 {
	public static void main(String[] args) {
		System.out.println(Parent.a);
		System.out.println(Child.a);
	}
}
