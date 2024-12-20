package prepinsta;

import java.util.Arrays;

public class Geeks_mergeArray {

	public static void main(String[] args) {
		int arr1[]= {2,4,5,6,7,9,10,13};
		int arr2[]= {2,3,4,5,6,7,8,9,11,15};
		
		int []temp=new int[arr1.length+arr2.length];
		// merge two arrays
		for (int i = 0, j=0,k=0; i < temp.length; i++) {
			if(i<arr1.length)
				temp[i]=arr1[j++];
			else 
				temp[i]=arr2[k++];
		}
		Arrays.sort(temp);
		for (int i = 0; i < temp.length-1; i++) {
			for(int j=i+1;j<temp.length;j++) {
				if(temp[i]==temp[j]) {
					temp[j]=-1;
				}
			}
		}
		int count=0;
		for (int i = 0,j=0; i < temp.length; i++) {
			if(temp[i]>=0) {
				count++;
			}
		}
		System.out.println("Count "+count);
		int res[]=new int[count];
		for (int i = 0,j=0; i < temp.length; i++) {
			if(temp[i]>=0) {
				res[j++]=temp[i];
			}
		}
		
		
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}
}
