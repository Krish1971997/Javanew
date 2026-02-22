package leetcodeZoho2;

public class Z13_RemoveFragmentBuiltIn {

    public static void main(String[] args) {

        String s1 = "Every morning I want to do exercise regularly";
        String s2 = "Every morning I want to do meditation without fail";
        String s3 = "It is important that I want to be happy always";

        String fragment = findCommonFragment(s1, s2, s3);

        if (fragment != null) {
            System.out.println(removeFragment(s1, fragment));
            System.out.println(removeFragment(s2, fragment));
            System.out.println(removeFragment(s3, fragment));
        } else {
            System.out.println("No common 3-word fragment found");
        }
    }

    // Find common 3-word fragment
    private static String findCommonFragment(String s1, String s2, String s3) {

        String[] words = s1.split(" ");

        for (int i = 0; i <= words.length - 3; i++) {

            String fragment = words[i] + " " + words[i+1] + " " + words[i+2];

            if (s2.contains(fragment) && s3.contains(fragment)) {
                return fragment;
            }
        }

        return null;
    }

    // Remove fragment from sentence
    private static String removeFragment(String sentence, String fragment) {
        return sentence.replace(fragment, "").replaceAll("\\s+", " ").trim();
    }
}
