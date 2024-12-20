package statickeyword;

class ThreadJoinClass extends Thread {
	public void run() {
		System.out.println("Thread is started");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		System.out.println("Thread is ended");
	}
}

public class ThreadJoin {
	public static void main(String[] args) {
		ThreadJoinClass t=new ThreadJoinClass();
		t.start();
		try {
			t.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("My main thread is ending...");
	}
}
