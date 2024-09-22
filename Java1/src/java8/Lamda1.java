package java8;

public class Lamda1 {

	public static void main(String[] args) {
		Contract ci=(n1,n2)->(n1+n2);
		int n=ci.add(10, 20);
		System.out.println(n);
	}
}
