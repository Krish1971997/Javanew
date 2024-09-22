package statickeyword;

import java.util.ArrayList;

public class ClassLoaderExample {
    public static void main(String[] args) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
        // Get the system class loader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("System ClassLoader: " + systemClassLoader);

        // Get the extension class loader (parent of system class loader)
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println("Extension ClassLoader: " + extensionClassLoader);

        // Get the bootstrap class loader (parent of extension class loader)
        // This will return null because the bootstrap class loader is implemented natively
        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        System.out.println("Bootstrap ClassLoader: " + bootstrapClassLoader);
    }
}

