package qspiders;

public class StaticVariable_NonStaticMethod {

	/*Static variable whether access in non static method or not*/
	
		static int a=1;

		public static void main(String args[]){
		a++;
		System.out.println("A = "+a);
		StaticVariable_NonStaticMethod test=new StaticVariable_NonStaticMethod();
		test.ran();
		}

		public void ran(){
		System.out.println("A = "+a);

		}

		}
	
