package designPattern;

public class Shop {
	public static void main(String[] args) {
		Phone p=new Phone.PhoneBuilder("Windows").setBattery(5000).getPhone(); 
		System.out.println(p);
	}
}
