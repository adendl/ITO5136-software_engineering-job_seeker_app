package model;

public class Resume {
    private String name;
    private String path;
    private int resumeId;
    private int userId;

    public Resume() {
    }

    public Resume(String name, String path, int resumeId, int userId) {
        this.name = name;
        this.path = path;
        this.resumeId = resumeId;
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

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

