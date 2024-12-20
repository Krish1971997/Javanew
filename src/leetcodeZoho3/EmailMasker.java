package leetcodeZoho3;

public class EmailMasker {

	public static void main(String[] args) {
		String email1 = "management@example.com";
		String email2 = "info@test.com";

		System.out.println(maskEmail(email1));
		System.out.println(maskEmail(email2));
	}

	public static String maskEmail(String email) {
		String[] parts = email.split("@");
		if (parts.length != 2)
			throw new IllegalArgumentException("Invalid email format");

		String username = parts[0];
		String domain = parts[1];
		String[] subDomain = domain.split("\\.");

		String maskedUsername = maskPart(username);
		String maskedDomain = maskPart(subDomain[0]);

		return maskedUsername + "@" + maskedDomain + "." + subDomain[1];
	}

	private static String maskPart(String part) {
		int length = part.length();
		int defaultKey = 2;
		if (length <= 4)
			defaultKey = 1;

		StringBuilder masked = new StringBuilder();
		masked.append(part.substring(0, defaultKey)); // First two characters

		for (int i = defaultKey; i < length - defaultKey; i++)
			masked.append('*');

		masked.append(part.substring(length - defaultKey));

		return masked.toString();
	}
}
