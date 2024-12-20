package qspiders;

public class GarbageCollection1 {
	public static void main(String[] args) {
		GarbageCollection1 g=new GarbageCollection1();
		g=null;
		System.gc();
		System.out.println("Call from main method");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Calling finalize method");
		// TODO Auto-generated method stub
		super.finalize();
	}
}
