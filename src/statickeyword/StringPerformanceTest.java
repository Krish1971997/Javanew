package statickeyword;

public class StringPerformanceTest {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		String str = new String("Java");
		for (int i = 0; i < 100000000; i++) {
			//Thread.sleep(10);
			str.concat("Technology");
		}
		System.out.println("Time taken by String: " + (System.currentTimeMillis() - startTime)/1000 + " sec");
		
		startTime = System.currentTimeMillis();
		String str1 = "Java";
		for (int i = 0; i < 100000000; i++) {
			//Thread.sleep(10);
			str1.concat("Technology");
		}
		System.out.println("Time taken by String1: " + (System.currentTimeMillis() - startTime)/1000 + " sec");

		startTime = System.currentTimeMillis();
		StringBuffer sbuffer = new StringBuffer("Java");
		for (int i = 0; i < 100000000; i++) {
			//Thread.sleep(10);
			sbuffer.append("Technology");
		}
		System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime)/1000 + " sec");

		startTime = System.currentTimeMillis();
		StringBuilder sbuilder = new StringBuilder("Java");
		for (int i = 0; i < 100000000; i++) {
			//Thread.sleep(10);
			sbuilder.append("Technology");
		}
		System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime)/1000 + " sec");
	}
}
