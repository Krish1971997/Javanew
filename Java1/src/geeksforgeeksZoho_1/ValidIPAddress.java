package geeksforgeeksZoho_1;

public class ValidIPAddress {

    public static boolean inRange(int n) {
        if (n >= 0 && n <= 255)
            return true;
        return false;
    }

    public static boolean hasLeadingZero(String n) {
        if (n.length() > 1) {
            if (n.charAt(0) == '0')
                return true;
        }
        return false;
    }

    public static boolean isValid(String s) {
	        String[] parts = s.split("\\.");
	        if (parts.length != 4) {
	            return false;
	        }
	        for (String part : parts) {
	            if (hasLeadingZero(part)) {
	                return false;
	            }
	            if (part.length() == 0) {
	                return false;
	            }
	            try {
	                int num = Integer.parseInt(part);
	                if (!inRange(num)) {
	                    return false;
	                }
	            } catch (NumberFormatException e) {
	                return false;
	            }
	        }
	        return true;
    }

    public static void main(String[] args) {
        String ip1 = "00.00.00.00";
        String ip2 = "5555..555";
        String ip3 = "0000.0000.0000.0000";
        String ip4 = "1.1.1.1";
        System.out.println(isValid(ip1));
        System.out.println(isValid(ip2));
        System.out.println(isValid(ip3));
        System.out.println(isValid(ip4));
    }
}
