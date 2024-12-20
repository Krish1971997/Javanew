package qspiders;

public class Zoho_1 {
	
	public static void main(String[] args) {
	
		int []a= {13,2, 4,15,12,10,5};
	
		int odd[]=new int[100];
		int even[]=new int[100];
	
		int oddit=0, evenit=0;
		for(int i=0;i<a.length;i++) {
			if(i%2==0)
				odd[oddit++]=a[i];
			else
				even[evenit++]=a[i];
		}
		
		for (int i = 0; i <oddit-1; i++) {
			for (int j = i+1; j <oddit-1; j++)
			if(odd[i]>odd[j])
			{
				int temp=odd[i];
				odd[i]=odd[j];
				odd[j]=temp;
			}
		}
		
		for (int i = 0; i <evenit-1; i++) {
			for (int j = i+1; j <evenit-1; j++)
			if(even[i]>even[j])
			{
				int temp=even[i];
				even[i]=even[j];
				even[j]=temp;
			}
		}
		oddit=0;
		evenit=0;
		for (int j = 0; j < a.length; j++) {
			if(j%2==0)
				System.out.print(odd[oddit++]);
			else
				System.out.print(even[evenit++]);
		}
			
	}
}
