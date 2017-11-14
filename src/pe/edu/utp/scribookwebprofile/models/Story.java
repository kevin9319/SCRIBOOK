package pe.edu.utp.scribookwebprofile.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Story {

    private int id;
    private String title;
    private String description;
    private int scoreTotal;
    private Date createDate;
    private User user;
    private Challenge challenge;

    public Story() {
    }

    public Story(int id, String title, String description, int scoreTotal, Date createDate, User user, Challenge challenge) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.scoreTotal = scoreTotal;
        this.createDate = createDate;
        this.user = user;
        this.challenge = challenge;
    }

    public int getId() {
        return id;
    }

    public Story setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Story setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Story setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public Story setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Story setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Story setUser(User user) {
        this.user = user;
        return this;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public Story setChallenge(Challenge challenge) {
        this.challenge = challenge;
        return this;
    }


    public static Story from(ResultSet rs,ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        Story story =new Story();
        try {
            return story.setId(rs.getInt("Id"))
                    .setTitle(rs.getString("Title"))
                    .setDescription(rs.getString("Description"))
                    .setScoreTotal(rs.getInt("ScoreTotal"))
                    .setCreateDate(rs.getDate("CreateDate"))
                    .setChallenge(challengeEntity.findById(rs.getInt("Challenge"),categoriesEntity,usersEntity))
                    .setUser(usersEntity.findById(rs.getInt("User")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
