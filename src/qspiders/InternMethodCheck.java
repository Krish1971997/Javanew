package qspiders;

public class InternMethodCheck {
	public static void main(String[] args) {
		String s1=new String("Test");
		String s2="Test";
		String s3=s1.intern();
		s1.intern();
		s2.intern();
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(s2==s3);
	}
}
