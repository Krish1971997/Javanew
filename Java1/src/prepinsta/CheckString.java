package prepinsta;

import stringinBuiltMethods.StringCustom;

public class CheckString {

	public static void main(String[] args) {
		
		String s="Zoho corporation";
		StringCustom str=new StringCustom(s);
		System.out.println(str.subString(5,8));
		System.out.println(str.indexOf("zoho"));
		
		System.out.println(StringCustom.abs(10));
	}
}
