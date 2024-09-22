package codeiozoho;

public class FormAnumberDivisible {
	public static void main(String[] args) {
		int[] num= {40,50,90};
		int divisible=3,sum=0;
		for (int i = 0; i < num.length; i++) {
			sum+=num[i]%divisible;
		}
		
		if(sum%3==0)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
