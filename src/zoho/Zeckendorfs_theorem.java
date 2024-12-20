package zoho;

public class Zeckendorfs_theorem {

		public static void main(String[] args) {
			int n=64;
			print(n);
		}

		private static void print(int n) {
			while(n>0) {
				int f=fibonacci(n);
				System.out.print(f+" ");
				n=n-f;
			}	
		}
		private static int fibonacci(int n) {
			if(n==0||n==1)
			return n;
			int a=0,b=1,c=1;
			while(c<=n) {
				a=b;
				b=c;
				c=a+b;
			}
			return b;
		}
	}


