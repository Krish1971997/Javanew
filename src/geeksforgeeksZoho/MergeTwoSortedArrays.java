package geeksforgeeksZoho;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int ar1[] = {1, 5, 9, 10, 15, 20};
	     int ar2[] = {2, 3, 8, 13};
	     
	     int merge[]=new int[ar1.length+ar2.length];
	     int i=0,j=0,k=0;
	     while(i<ar1.length && j<ar2.length) {
	    	 if(ar1[i]<ar2[j]) 
	    		 merge[k++]=ar1[i++];
	    	 else
	    		 merge[k++]=ar2[j++];
	     }
	     
	     while(i<ar1.length)
	    	 merge[k++]=ar1[i++];
	     while(j<ar2.length)
	    	 merge[k++]=ar2[j++];
	     
	     System.out.println(Arrays.toString(merge));
	}
}
