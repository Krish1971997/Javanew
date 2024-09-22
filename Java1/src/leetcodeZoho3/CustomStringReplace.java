package leetcodeZoho3;

public class CustomStringReplace {

    public static void main(String[] args) {
        String original = "Hello World, Hello Universe";
        String target = "Hello";
        String replacement = "Hi";

        String result = customReplace(original, target, replacement);
        System.out.println(result);  // Output: Hi World, Hi Universe
    }

    public static String customReplace(String original, String target, String replacement) {
        if (target == null || target.isEmpty()) {
            return original;
        }

        StringBuilder result = new StringBuilder();

        int targetLength = target.length();
        int start = 0;

        while (start <= original.length()) {
            int index = original.indexOf(target, start);

            if (index >= 0) {
                result.append(original, start, index);
                result.append(replacement);
                start = index + targetLength;
            } else {
                result.append(original.substring(start));
                break;
            }
        }
        return result.toString();
    }
}
