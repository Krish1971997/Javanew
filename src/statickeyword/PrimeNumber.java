package statickeyword;

public class PrimeNumber {
	public static void main(String[] args) {
		int num=100,sum=0;
		if(num<=1)
			System.out.println("Not prime number");
		for (int i = 2; i < num/2; i++) {
			if(num%i==0)
				sum+=i;
			System.out.println("Sum : "+sum);
		}
	}
}
