package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Challenge {

    private int Id_challenges;
    private String Title;
    private String Description;
    private int Status;
    private Category category;
    private Word word;

    public Challenge(int id_challenges, String title, String description, int status, Category category, Word word) {
        this.Id_challenges = id_challenges;
        this.Title = title;
        this.Description = description;
        this.Status = status;
        this.category = category;
        this.word = word;
    }

    public Challenge(){}

    public int getId_challenges() {
        return Id_challenges;
    }

    public Challenge setId_challenges(int id_challenges) {
        this.Id_challenges = id_challenges;
        return this;
    }

    public String getTitle() {
        return Title;
    }

    public Challenge setTitle(String title) {
        this.Title = title;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public Challenge setDescription(String description) {
        this.Description = description;
        return this;
    }

    public int getStatus() {
        return Status;
    }

    public Challenge setStatus(int status) {
        this.Status = status;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Challenge setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Word getWord() {
        return word;
    }

    public Challenge setWord(Word word) {
        this.word = word;
        return this;
    }

    public static Challenge from(ResultSet rs, CategoriesEntity categoriesEntity, WordsEntity wordsEntity)
    {
        Challenge challenge = new Challenge();
        try {
            return challenge.setId_challenges(rs.getInt("Id_challenges"))
                    .setTitle(rs.getString("Title"))
                    .setDescription(rs.getString("Description"))
                    .setStatus(rs.getInt("Status"))
                    .setCategory(categoriesEntity.findById(rs.getInt("Id_category")))
                    .setWord(wordsEntity.findById(rs.getInt("Id_Words")));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  null;
    }

}
