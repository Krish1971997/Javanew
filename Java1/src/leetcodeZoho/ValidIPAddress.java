package leetcodeZoho;

public class ValidIPAddress {
	public static void main(String[] args) {
		ValidIPAddress address=new ValidIPAddress();
		String IP="172.16.254.1";
		//String IP="2001:0db8:85a3:0:0:8A2E:0370:7334";
		System.out.println(address.validIPAddress(IP));
	}
	    public String validIPAddress(String IP) {
	        if (isIPv4(IP)) {
	            return "IPv4";
	        } else if (isIPv6(IP)) {
	            return "IPv6";
	        } else {
	            return "Neither";
	        }
	    }
	    
	    private boolean isIPv4(String IP) {
	        if (IP.endsWith(".") || IP.startsWith(".")) {
	            return false;
	        }
	        String[] parts = IP.split("\\.");
	        if (parts.length != 4) {
	            return false;
	        }
	        for (String part : parts) {
	            if (!isIPv4Part(part)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    private boolean isIPv4Part(String part) {
	        if (part.isEmpty() || part.length() > 3 || (part.length() > 1 && part.charAt(0) == '0')) {
	            return false;
	        }
	        try {
	            int num = Integer.parseInt(part);
	            if (num < 0 || num > 255) {
	                return false;
	            }
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        return true;
	    }
	    
	    private boolean isIPv6(String IP) {
	        if (IP.endsWith(":") || IP.startsWith(":")) {
	            return false;
	        }
	        String[] parts = IP.split(":");
	        if (parts.length != 8) {
	            return false;
	        }
	        for (String part : parts) {
	            if (!isIPv6Part(part)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    private boolean isIPv6Part(String part) {
	        if (part.isEmpty() || part.length() > 4) {
	            return false;
	        }
	        for (char c : part.toCharArray()) {
	            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
	                return false;
	            }
	        }
	        return true;
	    }
	}

