package zoho;

class Shared {
	int i;
	synchronized void SharedMethod() throws Exception {
		Thread t = Thread.currentThread();

		for (i = 0; i <= 10; i++) {
			Thread.sleep(1000);
			System.out.println(t.getName() + " : " + i);
		}
	}
}

public class ThreadsInJava {
	public static void main(String[] args) {
		final Shared s1 = new Shared();

		Thread t1 = new Thread("Thread - 1") {
			@Override
			public void run() {
				try {
					s1.SharedMethod();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread("Thread - 2") {
			@Override
			public void run() {
				try {
					s1.SharedMethod();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
	}
}