package qspiders;

class Fruit{
	String origin;
	String price;
	
	
	
	public Fruit(String origin, String price) {
		this.origin = origin;
		this.price = price;
	}
	
}

class Mango extends Fruit{

	String name;
	String taste;
	public Mango(String name, String taste) {
		super("India", "150");
		this.name = name;
		this.taste = taste;
	}
	public void test() {
		System.out.println("From test");
	}
	public static void main(String[] args) {
		Fruit f=new Mango("Mango", "Sweet");
		//f=new Fruit("india", "200");
		System.out.println(f.origin);
		System.out.println(f.price);
		
	}
	
}

public class Upcasting {

	public static void main(String[] args) {
		Fruit f=new Mango("Mango", "Sweet");
		//f=new Fruit("india", "200");
		System.out.println(f.origin);
		System.out.println(f.price);
		Mango m=(Mango)f;

		
	}
}
