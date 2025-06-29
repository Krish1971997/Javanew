package codetesting;

public class Main {
	public static void main(String[] args) {
		// Create Layouts
		Layout layout1 = new Layout(1, "Layout1");
		Layout layout2 = new Layout(2, "Layout2");
		Layout layout3 = new Layout(3, "Layout3");

		// Create Screens
		Screen screen1 = new Screen(1, "Screen1");
		Screen screen2Layout1 = new Screen(2, "Screen2"); // Screen2 for Layout 1
		Screen screen2Layout2 = new Screen(2, "Screen2"); // Screen2 for Layout 2
		Screen screen3 = new Screen(3, "Screen3");
		Screen screen4 = new Screen(4, "Screen4");

		// Add Data to Screens
		screen1.addData(new Data(1, "FID1", "Screen1_Data1"));
		screen1.addData(new Data(2, "FID2", "Screen1_Data2"));
		screen2Layout1.addData(new Data(3, "FID3", "Screen2_Data1"));
		screen2Layout2.addData(new Data(4, "FID4", "Screen2_Data2"));
		screen3.addData(new Data(5, "FID5", "Screen3_Data1"));
		screen4.addData(new Data(6, "FID6", "Screen4_Data1"));

		// Assign Screens to Layouts
		layout1.addScreen(screen1);
		layout1.addScreen(screen2Layout1);
		layout2.addScreen(screen2Layout2);
		layout2.addScreen(screen3);
		layout3.addScreen(screen4);

		// Print Layouts
		System.out.println(layout1);
		System.out.println(layout2);
		System.out.println(layout3);
	}
}