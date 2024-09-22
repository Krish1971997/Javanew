package statickeyword;

public class Program3 {
	public static void main(String[] args) {
		//String s="2.5";
		String s="6.25";
		System.out.println(findFractionNumber(s));
	}

	private static String findFractionNumber(String s) {
		if(s.indexOf(".")!=-1) {
			String[] str=s.split("\\.");
			return str[0]+" "+fraction(str[1]);
		}
		return s;
	}

	private static String fraction(String string) {
		int digit=Integer.parseInt(string);
		if(digit>0 && digit<26) {
			return "1/4";
		}else if(digit>25 && digit<51) {
			return "1/2";
		}else if(digit>50 && digit<76)
				return "3/4";
		return "";
	}
	

	
	

}
