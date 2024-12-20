package qspiders;

abstract public class Abstract1 {
	abstract void main1();
}

class dog extends Abstract1
{
	void main1()
	{
		System.out.println("From dog class");
	}
}

class Driver{
	public static void main(String[] args) {
		Abstract1 a=new dog();
		a.main1();
	}
}