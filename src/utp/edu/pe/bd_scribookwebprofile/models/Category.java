package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {

    private int Id_category;
    private int IdObjeto;
    private String Description;
    private String Short_Description;
    private int Status;

    public Category(int id_category, int idObjeto, String description, String short_Description, int status) {
        this.Id_category = id_category;
        this.IdObjeto = idObjeto;
        this.Description = description;
        this.Short_Description = short_Description;
        this.Status = status;
    }

    public Category(){}

    public int getId_category() {
        return Id_category;
    }

    public Category setId_category(int id_category) {
        this.Id_category = id_category;
        return  this;
    }

    public int getIdObjeto() {
        return IdObjeto;
    }

    public Category setIdObjeto(int idObjeto) {
        this.IdObjeto = idObjeto;
        return  this;
    }

    public String getDescription() {
        return Description;
    }

    public Category setDescription(String description) {
        this.Description = description;
        return  this;
    }

    public String getShort_Description() {
        return Short_Description;
    }

    public Category setShort_Description(String short_Description) {
        this.Short_Description = short_Description;
        return this;
    }

    public int getStatus() {
        return Status;
    }

    public Category setStatus(int status) {
        this.Status = status;
        return this;
    }

    public static Category from(ResultSet rs)
    {
        try {
            return new Category(
                    rs.getInt("Id_category"),
                    rs.getInt("IdObjeto"),
                    rs.getString("Description"),
                    rs.getString("Short_Description"),
                    rs.getInt("Status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
