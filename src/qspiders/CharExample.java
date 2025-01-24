package qspiders;

public class CharExample {
    char instanceChar;  // Instance variable, default value is '\u0000'
    
    public static void main(String[] args) {
        CharExample example = new CharExample();
        System.out.println("Default value of instance char: " + (int) example.instanceChar);  // Output: 0 (ASCII value of '\u0000')
    }
}

