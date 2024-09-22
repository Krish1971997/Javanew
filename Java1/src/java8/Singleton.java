package java8;

public class Singleton {
	
	private static Singleton instance;
	
	String value="";
	private Singleton(String value) {
		this.value=value;
	}
	
	public static Singleton getInstance(String value) {
		if(instance==null) {
			instance=new Singleton(value);
		}
		return instance;
		
	}
	
	public static void main(String[] args) {
		Singleton singleton=Singleton.getInstance("Zoho");
		Singleton singleton1=Singleton.getInstance("Java");
		
		System.out.println(instance.value+" "+singleton.hashCode());
		System.out.println(instance.value+" "+singleton1.hashCode());
		
	}

}
