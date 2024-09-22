package leetcodeZoho;

public class StringLastWord {

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(lengthOfLastWord(s));
		String s1 = "   fly me   to   the moon  ";
		System.out.println(lengthOfLastWord(s1));
		String s2 = "luffy is still joyboy";
		System.out.println(lengthOfLastWord(s2));
	}
    public static int lengthOfLastWord(String s) {
        String[] str=s.split("\\s+");
        String lastWord=str[str.length-1].trim();
        return lastWord.length();
    }
}
