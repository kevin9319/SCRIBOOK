package pe.edu.utp.scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Keyword {

private int id;
private String name;
private int status;


    public Keyword() {
    }


    public Keyword(int id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public Keyword setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Keyword setName(String name) {
        this.name = name;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Keyword setStatus(int status) {
        this.status = status;
        return this;
    }


    public static Keyword from(ResultSet rs) {
        try {
            return new Keyword(
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getInt("Status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
