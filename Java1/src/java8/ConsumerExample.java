package java8;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerExample {

	public static void main(String[] args) {
		Thread thread=new Thread(() -> System.out.println("Thread running"));
		
		thread.start();
		}
}
