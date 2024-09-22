package prepinsta;

public class Geeks_String1 {
	//static int i=0;
	public static void main(String[] args) {
		String s1="testing123";
		String s2="123";
		subString(s1, s2);
	}
	
	public static void subString(String s1,String s2)
	{
		int length=s1.length(),value=0;
		boolean t=true;
		String temp="";
		for (int i = 0; i < length; i++) {
			char c=s1.charAt(i);
			if(Character.isDigit(c)) {
				temp=temp+Character.getNumericValue(c);
				if(t) {
					value=i;
					t=false;
				}
			}
			
		//	System.out.println(temp);	
		}
		//System.out.println(temp);
		if(temp.equals(s2))
			System.out.println(value);
		else
			System.out.println("-1");
//		if(s1.contains(s2))
//			return 15848;
//		else
//			return 10018;
//		//int i=0;
//		for ( i = 0; i < s1.length(); i++) {
//			for (int j = 0; j < s2.length(); j++) {
//				if(Character.isDigit(s1.charAt(i))) {
//					if(Character.isDigit(s1.charAt(i))==Character.isDigit(s2.charAt(j)))
//					{
//					//	int a=i;
//					    return i;
//					}
//					else if(Character.isDigit(s1.charAt(i))!=Character.isDigit(s2.charAt(j)))
//						return -1;
//				}
//			}
//		}
//		int count=0; 
//		for ( i = 0; i < s1.length(); i++) {
//			if(Character.isDigit(s1.charAt(i))) {
//				//System.out.println("Count :-"+count+"Character"+s1.charAt(i));
//				count++;
//			}
//		}
//		System.out.println("Count :"+count);
//		int [] split=new int[count];
//		
//		for ( int i = 0,j=0; i < s1.length(); i++) {
//			if(Character.isDigit(s1.charAt(i))) {
//				split[j++]=s1.charAt(i);
//			}}
//		System.out.println("Spilts");
//		for ( int i = 0; i < split.length; i++) {
//			System.out.print(split[i]);
//		}
		//System.out.println(s1[0]);
//		StringBuffer a= new StringBuffer();
//		for (int i = 0; i < s1.length(); i++) {
//			if(Character.isDigit(s1.charAt(i)))
//				a.append(s1.charAt(i));
//		}
		
		//System.out.println("S1 :-"+a);
		//return i;
		
		
	}
}
