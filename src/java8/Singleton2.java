package java8;

public class Singleton2 {

	private static Singleton2 instance;
	private Singleton2(){}
	
	public static Singleton2 getInstance() {
		if(instance==null) {
			instance=new Singleton2();
		}
		return instance;
		
	}
		
	public static void main(String[] args) {
		Singleton2 singeSingleton2=Singleton2.getInstance();
		System.out.println(" Hashcode "+singeSingleton2.hashCode());
		Singleton2 singeSingleton=Singleton2.getInstance();
		System.out.println(" Hashcode "+singeSingleton.hashCode());
	}	
	
}