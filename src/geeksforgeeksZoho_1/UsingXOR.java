package geeksforgeeksZoho_1;

class point{
	int X;
	int Y;
	
	public point(int x, int y) {
		X = x;
		Y = y;
	}
}

public class UsingXOR {

	public static void main(String[] args) {
		point p1=new point(20,10);
		point p2=new point(10,20);
		point p3=new point(20,20);
		
		int x=p1.X^p2.X^p3.X;
		int y=p1.Y^p2.Y^p3.Y;
		System.out.println("Output : {"+x+","+y+"}");
		
	}
}
