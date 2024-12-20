package leetcodeZoho4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NameToKeypadNumber {

	// Map each character to the digit and its required presses
	private static final Map<Character, String> keypadMap = new HashMap<>();

	static {
		keypadMap.put('A', "21");
		keypadMap.put('B', "22");
		keypadMap.put('C', "23");
		keypadMap.put('D', "31");
		keypadMap.put('E', "32");
		keypadMap.put('F', "33");
		keypadMap.put('G', "41");
		keypadMap.put('H', "42");
		keypadMap.put('I', "43");
		keypadMap.put('J', "51");
		keypadMap.put('K', "52");
		keypadMap.put('L', "53");
		keypadMap.put('M', "61");
		keypadMap.put('N', "62");
		keypadMap.put('O', "63");
		keypadMap.put('P', "71");
		keypadMap.put('Q', "72");
		keypadMap.put('R', "73");
		keypadMap.put('S', "74");
		keypadMap.put('T', "81");
		keypadMap.put('U', "82");
		keypadMap.put('V', "83");
		keypadMap.put('W', "91");
		keypadMap.put('X', "92");
		keypadMap.put('Y', "93");
		keypadMap.put('Z', "94");
	}

	public static String convertNameToKeypad(String name) {
		StringBuilder result = new StringBuilder();
		for (char c : name.toUpperCase().toCharArray()) {
			if (keypadMap.containsKey(c)) {
				result.append(keypadMap.get(c));
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the name: ");
		String name = scanner.nextLine();

		String numericRepresentation = convertNameToKeypad(name);
		System.out.println("Keypad number combination: " + numericRepresentation);
	}
}
