package model;

public class Resume {
    private String name;
    private String path;
    private int resumeID;
    private int userId;

    public Resume() {
    }

    public Resume(String name, String path, int resumeID, int userId) {
        this.name = name;
        this.path = path;
        this.resumeID = resumeID;
        this.dateUploaded = dateUploaded;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getResumeID() {
        return resumeID;
    }

    public void setResumeID(int resumeID) {
        this.resumeID = resumeID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

