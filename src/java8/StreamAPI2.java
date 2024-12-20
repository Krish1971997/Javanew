	package java8;
	import java.util.*;  
    import java.util.stream.*;
    public class StreamAPI2{  
    public static void main(String args[]){  
    Stack<String> stack = new Stack<String>();  
    stack.push("Ayush");  
    stack.push("Garvit");  
    stack.push("Amit");  
    stack.push("Ashish");  
    stack.push("Garima");  
    stack.stream().forEach(n-> System.out.println(n));
    }
    }