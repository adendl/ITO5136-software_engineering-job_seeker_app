package model;

public class Invitation{
    private String invitationMessageText;
    private int jobId;
    private int jobSeekerId;
    private float matchScore;
    private int recruiterId;

    public Invitation() {
    }

    public String getInvitationMessageText() {
        return invitationMessageText;
    }

    public int getJobId() {
        return jobId;
    }

    public int getJobSeekerId() {
        return jobSeekerId;
    }

    public float getMatchScore() {
        return matchScore;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setInvitationMessageText(String invitationMessageText) {
        this.invitationMessageText = invitationMessageText;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setJobSeekerId(int jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public void setMatchScore(float matchScore) {
        this.matchScore = matchScore;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }
}