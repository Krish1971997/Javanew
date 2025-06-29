package codetesting;

public class Data {
    private int dataId;
    private String fid;
    private String fname;

    // Constructor
    public Data(int dataId, String fid, String fname) {
        this.dataId = dataId;
        this.fid = fid;
        this.fname = fname;
    }

    // Getters and Setters
    public int getDataId() { return dataId; }
    public void setDataId(int dataId) { this.dataId = dataId; }
    public String getFid() { return fid; }
    public void setFid(String fid) { this.fid = fid; }
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    @Override
    public String toString() {
        return "Data{dataId=" + dataId + ", fid='" + fid + "', fname='" + fname + "'}";
    }
}