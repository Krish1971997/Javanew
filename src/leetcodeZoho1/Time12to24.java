package leetcodeZoho1;

public class Time12to24 {
	public static void main(String[] args) {
		String Time="11.55PM";
		int hours=Integer.parseInt(Time.substring(0, 2));
		int minutes=Integer.parseInt(Time.substring(3,5));
		boolean isAm = Time.substring(5).equals("AM");
		
		if(!isAm) {
			minutes+=720;
			hours+=minutes/60;
			minutes=minutes%60;
		}
		System.out.println(hours+":"+minutes);	
	}
}
