package geeksforgeeksZoho;

public class ExtraElement {

	public static void main(String[] args) {
		int arr1[] = {3, 5, 7, 9, 11, 13};
		int arr2[] = {3, 5, 7, 11, 13};
		
		int result=0;
		for (int i = 0; i < arr2.length; i++) {
			if(arr1[i]!=arr2[i]) {
				result=i;
				break;
			}
		}
		
		System.out.println(result);

	}
}
