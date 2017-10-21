package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class History {

    private int Id_Histories;
    private String Title;
    private String Description;
    private String History;
    private Category category;

    public History(int id_Histories, String title, String description, String history, Category category) {
        this.Id_Histories = id_Histories;
        this.Title = title;
        this.Description = description;
        this.History = history;
        this.category = category;
    }

    public History(){}

    public int getId_Histories() {
        return Id_Histories;
    }

    public History setId_Histories(int id_Histories) {
        this.Id_Histories = id_Histories;
        return this;
    }

    public String getTitle() {
        return Title;
    }

    public History setTitle(String title) {
        this.Title = title;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public History setDescription(String description) {
        this.Description = description;
        return this;
    }

    public String getHistory() {
        return History;
    }

    public History setHistory(String history) {
        this.History = history;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public History setCategory(Category category) {
        this.category = category;
        return this;
    }

    public static History from(ResultSet rs, CategoriesEntity categoriesEntity)
    {
        History history = new History();
        try {
            return history.setId_Histories(rs.getInt("Id_Histories"))
                    .setTitle(rs.getString("Title"))
                    .setDescription(rs.getString("Description"))
                    .setHistory(rs.getString("History"))
                    .setCategory(categoriesEntity.findById(rs.getInt("Id_category")));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  null;
    }

}
