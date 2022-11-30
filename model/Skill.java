package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Skill {
    private String name;
    private int skillId;

    public Skill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public Skill(String name, int skillId) {
        this.name = name;
        this.skillId = skillId;
    }

    public static ResultSet getSkill(int skillId) {
        ResultSet rs = DBConnection.queryDatabase("select * from Skill where skillId =" + skillId);
        return rs;
    }

    public static ResultSet getSkill(ArrayList<Integer> skillIds) {
        String sql = "select * from Skill where skillId in (";
        for (int i = 0; i < skillIds.size(); i++) {
            if (i == 0) {
                sql += skillIds.get(i);
            } else {
                sql += String.format(", %o", skillIds.get(i));
            }
        }
        sql += ")";
        System.out.println(sql);
        ResultSet rs = DBConnection.queryDatabase(sql);
        return rs;
    }

    public ResultSet listSkills() {
        ResultSet rs = DBConnection.queryDatabase( "select * from Skill");
        return rs;
    }

    public void createSkill() {
        DBConnection conn = DBConnection.get();
        String sql = "INSERT INTO Skill (skillId, name) VALUES (null, " + '"' + name + '"' + ")";
        conn.executeQuery(sql);
        try {
            setSkillId(conn.getLatestItemId("Skill"));
        } catch (Exception e) {
            System.err.println("createSkill failed: " + e);
        }
    }

    public void deleteSkill(int skillId) {
        DBConnection.queryDatabase("delete from Skill where skillId=" + skillId);
    }

    public void updateSkill(int skillId, String fieldName, String value) {
        String sql = "update Skill \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere skillId=" + skillId;
        System.out.println(sql);
        DBConnection.queryDatabase(sql);
    }

    public static void main(String[] args) {

    }
}
