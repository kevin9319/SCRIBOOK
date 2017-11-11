package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Challenge {

    private int id;
    private String title;
    private String description;
    private int status;
    private Date createDate;
    private Date lastDate;
    private Category category;
    private User user;


    public Challenge(){}

    public Challenge(int id, String title, String description, int status, Date createDate, Date lastDate, Category category, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.lastDate = lastDate;
        this.category = category;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public Challenge setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Challenge setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Challenge setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Challenge setStatus(int status) {
        this.status = status;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Challenge setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public Challenge setLastDate(Date lastDate) {
        this.lastDate = lastDate;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Challenge setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Challenge setUser(User user) {
        this.user = user;
        return this;
    }

    public static Challenge from(ResultSet rs,CategoriesEntity categoriesEntity, UsersEntity usersEntity) {
        Challenge challenge =new Challenge();
        try {
            return challenge.setId(rs.getInt("Id"))
                    .setTitle(rs.getString("Title"))
                    .setDescription(rs.getString("Description"))
                    .setStatus(rs.getInt("Status"))
                    .setCreateDate(rs.getDate("CreateDate"))
                    .setLastDate(rs.getDate("LastDate"))
                    .setCategory(categoriesEntity.findById(rs.getInt("Category")))
                    .setUser(usersEntity.findById(rs.getInt("User")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
