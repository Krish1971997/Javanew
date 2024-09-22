package qspiders;

public class FinalVariable {

	final static int A;
	static {
		A=10;
	}
	final int b;

	/*
	 * { b=20; }
	 */
	FinalVariable() {
		b=20;
	}
	
	public static void main(String[] args) {
		FinalVariable f=new FinalVariable();
		final int value;
		value=5;
		System.out.println(A);
		System.out.println(f.b);
		System.out.println(value);
	}
}
