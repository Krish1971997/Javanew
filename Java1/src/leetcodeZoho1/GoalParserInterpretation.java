package leetcodeZoho1;

public class GoalParserInterpretation {
	public static void main(String[] args) {
		String str = "G()(al)";
		// String str="G()()()()(al)";
		// String str="(al)G(al)()()G";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i)))
				sb.append(str.charAt(i));
			if (str.charAt(i) == ')') {
				if (i>0 && str.charAt(i - 1) == '(')
					sb.append('o');
			}
		}
		System.out.println(sb.toString());
	}
}
