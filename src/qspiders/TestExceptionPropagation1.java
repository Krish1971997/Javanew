package qspiders;

class CustomerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerException(String str) {
		super(str);
	}
}

public class TestExceptionPropagation1 {
	void m() throws CustomerException {
		throw new CustomerException("Test");
	}

	void n() throws CustomerException {
		m();
	}

	void p() {
		try {
			n();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
	}

	public static void main(String args[]) {
		TestExceptionPropagation1 obj = new TestExceptionPropagation1();
		obj.p();
		System.out.println("normal flow...");
	}
}