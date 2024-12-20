package leetcodeZoho;

class Rectangle {
	int x1, y1, x2, y2; // Coordinates of the bottom-left and top-right corners
	Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;	
		this.x2 = x2;
		this.y2 = y2;
	}
}

public class Z_LastClippedRectangle {
	public static int calculateOverlapArea(Rectangle rect1, Rectangle rect2) {
		// Find the coordinates of the overlapping rectangle
		int x1 = Math.max(rect1.x1, rect2.x1);
		int y1 = Math.max(rect1.y1, rect2.y1);
		int x2 = Math.min(rect1.x2, rect2.x2);
		int y2 = Math.min(rect1.y2, rect2.y2);

		// Calculate the width and height of the overlapping rectangle
		int width = x2 - x1;
		int height = y2 - y1;

		// If width or height is non-positive, there's no overlap
		if (width <= 0 || height <= 0) {
			return 0;
		}
		// Calculate the area of the overlapping rectangle
		return width * height;
	}

	public static void main(String[] args) {
		// Example rectangles
		Rectangle rect1 = new Rectangle(0, 0, 5, 5);
		Rectangle rect2 = new Rectangle(3, 3, 8, 8);

		// Calculate the area of overlap
		int overlapArea = calculateOverlapArea(rect1, rect2);
		System.out.println("Area of overlap: " + overlapArea);
	}
}
