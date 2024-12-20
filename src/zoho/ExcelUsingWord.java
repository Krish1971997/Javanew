package zoho;

public class ExcelUsingWord {

	public static int columnNumber(String columnLabel) {
		int result = 0;
		for (int i = 0; i < columnLabel.length(); i++) {
			char c = columnLabel.charAt(i);
			result = result * 26 + (c - 'A' + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		String columnLabel = "AB";
		int columnNumber = columnNumber(columnLabel);
		System.out.println("Column Label: " + columnLabel);
		System.out.println("Column Number: " + columnNumber);
	}
}
