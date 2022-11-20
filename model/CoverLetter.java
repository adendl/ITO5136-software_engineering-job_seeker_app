package model;

public class CoverLetter {
    private int coverLetterID;
    private String name;
    private String path;

    public CoverLetter(){
    }

    public CoverLetter(int coverLetterID){
        this.coverLetterID = coverLetterID;
    }

    public int getCoverLetterID() {
        return coverLetterID;
    }

    public void setCoverLetterID(int coverLetterID) {
        this.coverLetterID = coverLetterID;
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
