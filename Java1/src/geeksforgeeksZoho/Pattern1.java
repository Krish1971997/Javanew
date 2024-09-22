package geeksforgeeksZoho;

public class Pattern1 {

	/*
	 * 1 
	 * b2 
	 * 3c3 
	 * d4d4 
	 * 5e5e5 
	 * f6f6f6
	 */
	 public static void main(String[] args) {
        int a = 6;
            for (int i=1;i<=a;i++){
                boolean isEven = i%2 == 0 ? true : false;
                char c =(char) (96 + i);
                for (int j=1;j<=i;j++){
                    if (isEven){
                        System.out.print(c);
                        isEven=false;
                    }else {
                        System.out.print(i);
                        isEven=true;
                    }
                }
                System.out.println();
            }
        }
	
	/*public static void main(String[] args) {
		int n = 6, m = 1, loop = 0;
		char ch = 'b';
		for (int i = 0; i < n; i++) {
			if (i % 2 != 0)
				loop = loop + 1;
			if (i == 0) {
				System.out.print(m++);
			} else if (i % 2 != 0) {
				for (int j = 0; j < loop; j++) {
					System.out.print(ch + "" + m);
				}
				ch++;
				m++;
			} else {
				for (int j = 0; j < loop; j++) {
					System.out.print(m + "" + ch);
				}
				System.out.print(m);
				ch++;
				m++;
			}

			System.out.println();
		}
	}
*/	
}
