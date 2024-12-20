package qspiders;

public class Test2 {
	public static void main(String[] args) {
		int n=5;
		int res=fact(5);
		System.out.println(res);
	}
	static int fact(int n) {
		if(n==1)
			return 1;
		return n*fact(n-1);
	}

}
