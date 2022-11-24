package model;

public class CoverLetter {
    private int coverLetterId;
    private String name;
    private String path;

    public CoverLetter(){
    }

    public CoverLetter(int coverLetterId){
        this.coverLetterId = coverLetterId;
    }

    public int getCoverLetterId() {
        return coverLetterId;
    }

    public void setCoverLetterId(int coverLetterId) {
        this.coverLetterId = coverLetterId;
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
}
