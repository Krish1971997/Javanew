package leetcodeZoho8;

public class RemainingString {

    public static String getRemaining(String str, char ch, int count) {
        int occurrence = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                occurrence++;
                if (occurrence == count) {
                    return str.substring(i + 1);
                }
            }
        }

        // If character doesn't occur 'count' times
        return "";
    }

    public static void main(String[] args) {
        String str = "Thisisdemostring";
        char ch = 'i';
        int count = 3;

        System.out.println(getRemaining(str, ch, count));
    }
}