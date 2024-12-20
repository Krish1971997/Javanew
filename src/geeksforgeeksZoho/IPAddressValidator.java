package geeksforgeeksZoho;

public class IPAddressValidator {

    public static boolean isValidIPv4(String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            return false;
        }

        String[] parts = ipAddress.split("\\.");

        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            try {
                int value = Integer.parseInt(part);

                if (value < 0 || value > 255) {
                    return false;
                }
                System.out.println("part length -> "+part.length());
                if (part.length() > 1 && part.startsWith("0")) {
                    return false; // Leading zeros are not allowed
                }
            } catch (NumberFormatException e) {
                return false; // Not a valid integer
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        String ipAddress = "172.16.254.1";

        if (isValidIPv4(ipAddress)) {
            System.out.println(ipAddress + " is a valid IPv4 address.");
        } else {
            System.out.println(ipAddress + " is NOT a valid IPv4 address.");
        }
    }
}
