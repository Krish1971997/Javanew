package geeksforgeeksZoho;

public class GuessWordChecker {
    public static String checkGuess(String secret, String guess) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < secret.length(); i++) {
            char secretChar = secret.charAt(i);
            char guessChar = (i < guess.length()) ? guess.charAt(i) : '-';

            if (secretChar == guessChar) {
                result.append('g');
            } else if (guess.indexOf(secretChar) != -1) {
                result.append('y');
            } else {
                result.append('-');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String secretWord = "BRICK";
        String guessWord = "BLORCK";

        String result = checkGuess(secretWord, guessWord);
        System.out.println(result); // Output: g--gg
    }
}
