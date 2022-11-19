public class Invitation{
    private String invitationMessageText;
    private int jobId;
    private int jobSeeekerId;
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

    public int getJobSeeekerId() {
        return jobSeeekerId;
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

    public void setJobSeeekerId(int jobSeeekerId) {
        this.jobSeeekerId = jobSeeekerId;
    }

    public void setMatchScore(float matchScore) {
        this.matchScore = matchScore;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }
}