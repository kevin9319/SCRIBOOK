package pe.edu.utp.scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {

    private int id;
    private String description;
    private String shortDescription;
    private int Status;



    public Category(){}

    public Category(int id, String description, String shortDescription, int status) {
        this.id = id;
        this.description = description;
        this.shortDescription = shortDescription;
        Status = status;
    }

    public int getId() {
        return id;
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Category setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public int getStatus() {
        return Status;
    }

    public Category setStatus(int status) {
        Status = status;
        return this;
    }

    public static Category from(ResultSet rs) {
        try {
            return new Category(
                    rs.getInt("Id"),
                    rs.getString("Description"),
                    rs.getString("ShortDescription"),
                    rs.getInt("Status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
