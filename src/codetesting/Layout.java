package codetesting;

import java.util.ArrayList;
import java.util.List;

public class Layout {
	private int layoutId;
	private String layoutName;
	private List<Screen> screens;

	// Constructor
	public Layout(int layoutId, String layoutName) {
		this.layoutId = layoutId;
		this.layoutName = layoutName;
		this.screens = new ArrayList<>();
	}

	// Getters and Setters
	public int getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(int layoutId) {
		this.layoutId = layoutId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void set573LayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void addScreen(Screen screen) {
		this.screens.add(screen);
	}

	@Override
	public String toString() {
		return "Layout{layoutId=" + layoutId + ", layoutName='" + layoutName + "', screens=" + screens + "}";
	}
}