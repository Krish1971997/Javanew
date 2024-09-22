package stringinBuiltMethods;

public class StringCustom {
	
	String string;
	public StringCustom(String string){
		this.string=string;
	}
	
	public String subString(int start) {
		return subString(start,string.length());
	}
	
	public String subString(int start, int end) {
		StringBuilder sb=new StringBuilder();
		for(int i=start;i<end;i++) {
			sb.append(string.charAt(i));
		}
		return sb.toString();
	}
	
	public int indexOf(String str) {
		for(int i=0;i<string.length();i++) {
			int j=0;
			for(j=0;j<str.length();j++) {
				if(string.charAt(i+j)!=str.charAt(j))
					break;
			}
			
			if(j==str.length())
				return i;
		}
		return -1;
	}
	
	public static int abs(int value) {
		return value<0?value*-1:value;
	} 
}
