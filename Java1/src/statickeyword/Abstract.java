package statickeyword;

public  abstract class Abstract {
	
	Abstract(){
		System.out.println("Abstract method is running");
	}
	abstract void run();
	
	public static void main(String[] args) {
		Abstract ab=new Bike();
		ab.run();
	}
}

class Bike extends Abstract
{
	@Override
	void run() {
		System.out.println("Run method");
	}
	
}
