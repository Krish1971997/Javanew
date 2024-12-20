package qspiders;

public class Method_override {
	void car()
	{
		System.out.println("Car is running");
	}

}

class Bike extends Method_override
{
	@Override
	void car()
	{
		System.out.println("Bike is running");
	}	
}