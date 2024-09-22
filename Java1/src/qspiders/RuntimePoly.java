package qspiders;

class BabyDog1 {
	// Output: Dog is eating
	// Since, BabyDog is not overriding the eat() method, so eat() method of Dog
	// class is invoked.
	void eat() {
		System.out.println("animal is eating...");
	}
}

class Dog1 extends BabyDog1 {
	@Override
	void eat() {
		System.out.println("dog is eating...");
	}
}

public class RuntimePoly extends Dog1 {
	public static void main(String args[]) {
		BabyDog1 a = new Dog1();
		a.eat();
	}

}
