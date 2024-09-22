package prepinsta;

import java.util.Scanner;

public class IP4_address_validator {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the IP address");
		//String ip=s.next();
		String ip="192.168.150.150";
		
		String []ip_add=ip.split("\\.");
		//try {
			if(ip_add.length==4)
			{
				int a=Integer.parseInt(ip_add[0]);
				int b=Integer.parseInt(ip_add[1]);
				int c=Integer.parseInt(ip_add[2]);
				int d=Integer.parseInt(ip_add[3]);
				
				if(isVerified(a, b, c, d))
					System.out.println("Is valid");
				else
					System.out.println("Is not valid");
			}
			
//		}catch (Exception e) {
//			System.out.println("Incorrect format");
//		}
	}
	public static boolean isVerified(int a, int b, int c, int d)
	{
		if((a>=0&&a<=255)&&(b>=0&&b<=255)&&(c>=0&&c<=255)&&(d>=0&&d<=255))
			return true;
		else 
			return false;
	}

}
