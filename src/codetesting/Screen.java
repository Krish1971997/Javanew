package codetesting;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int screenId;
    private String screenName;
    private List<Data> dataList;

    // Constructor
    public Screen(int screenId, String screenName) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.dataList = new ArrayList<>();
    }

    // Getters and Setters
    public int getScreenId() { return screenId; }
    public void setScreenId(int screenId) { this.screenId = screenId; }
    public String getScreenName() { return screenName; }
    public void setScreenName(String screenName) { this.screenName = screenName; }
    public List<Data> getDataList() { return dataList; }
    public void addData(Data data) { this.dataList.add(data); }

    @Override
    public String toString() {
        return "Screen{screenId=" + screenId + ", screenName='" + screenName + "', dataList=" + dataList + "}";
    }
}