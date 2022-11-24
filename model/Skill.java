package model;

public class Skill {
    private String name;
    private int skillID;

    public Skill(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public Skill(String name, int skillID) {
        this.name = name;
        this.skillID = skillID;
    }
}
