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
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Skill where skillId =" + skillId);
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
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), sql);
        return rs;
    }

    public ResultSet listSkills() {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Skill");
        return rs;
    }

    public void createSkill() {
        Connection conn = DBConnection.connectDb();
        String sql = "INSERT INTO Skill (skillId, name) VALUES (null, " + '"' + name + '"' + ")";
        DBConnection.queryDatabase(conn, sql);
        try {
            setSkillId(DBConnection.queryDatabase(conn, "SELECT LAST_INSERT_ROWID() FROM Skill").getInt("last_insert_rowid()"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteSkill(int skillId) {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from Skill where skillId=" + skillId);
    }

    public void updateSkill(int skillId, String fieldName, String value) {
        String sql = "update Skill \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere skillId=" + skillId;
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }

    public static void main(String[] args) {

    }
}
