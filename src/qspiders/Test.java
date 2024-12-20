package qspiders;

import java.util.Properties;

public class Test {
	
	  private static final String JAVA_HOME;
	    private static final String USER_HOME;
	    private static final String USER_DIR;
	    private static final String USER_NAME;
	    private static Properties props;
	    static {
	    	props = System.getProperties();
	        JAVA_HOME = getProperty(props, "java.home");
	        USER_HOME = getProperty(props, "user.home");
	        USER_DIR  = getProperty(props, "user.dir");
	        USER_NAME = getProperty(props, "user.name");
	    }
	
	public static void main(String[] args) {
		System.out.println("JAVA_HOME --> "+JAVA_HOME);
		System.out.println("USER_HOME --> "+USER_HOME);
		System.out.println("USER_DIR --> "+USER_DIR);
		System.out.println("USER_NAME --> "+USER_NAME);
	}
	
	private static String getProperty(Properties props, String key) {
        String v = props.getProperty(key);
        if (v == null) {
            throw new InternalError("null property: " + key);
        }
        return v;
    }

}
