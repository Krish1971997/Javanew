package prepinsta;

import java.util.Scanner;

public class Protech_date {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the date:- (dd/mm/yyyy) :");
		String d=s.next();
		
		String []date=d.split("/");
		try {
			int dd=Integer.parseInt(date[0]);
			int mm=Integer.parseInt(date[1]);
			int yyyy=Integer.parseInt(date[2]);
			
			if((dd>=01&&dd<=31)&&(mm==01)&&(yyyy>=1900&&yyyy<=2100))
			{
				System.out.println("Valid");
			}
			//else if((dd>=01&&dd<=29)&&(mm==02)&&(yyyy>=1900&&yyyy<=2100))
			else if((mm==02)&&(yyyy%4!=0)&&(dd>=01&&dd<=29))
			{
				System.out.println("INValid");
			}
			else if((dd>=01&&dd<=29)&&(mm==02)&&(yyyy>=1900&&yyyy<=2100))
			{
				System.out.println("Valid");
			}
			
			else if((dd>=01&&dd<=31)&&(mm>=03&&mm<=12)&&(yyyy>=1900&&yyyy<=2100))
			{
				System.out.println("Valid");
			}
			else
				System.out.println("Invalid");
			
			}catch(Exception e) {
				System.out.println("INvalid");
			}
		
	}

}
