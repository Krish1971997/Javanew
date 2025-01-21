package qspiders;

class Parent1{
	public void methodOne() {
		System.out.println("Method one From Parent");
	}
}

class Child1 extends Parent1{
	public void methodOne() {
		System.out.println("Method one From Child");
	}
	public void methodTwo() {
		System.out.println("Method Two From Child");
	}
}

public class OOPSMain {
	public static void main(String[] args) {
		//Parent1 parent=new Parent1();
		//Parent1 parent=new Child1();
		Child1 parent=new Child1();
		parent.methodOne();
	}

}
