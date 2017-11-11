package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Score {

    private int id;
    private int status;
    private Story story;
    private User user;


    public Score() {
    }

    public Score(int id, int status, Story story, User user) {
        this.id = id;
        this.status = status;
        this.story = story;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public Score setId(int id) {
        this.id = id;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Score setStatus(int status) {
        this.status = status;
        return this;
    }

    public Story getStory() {
        return story;
    }

    public Score setStory(Story story) {
        this.story = story;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Score setUser(User user) {
        this.user = user;
        return this;
    }


    public static Score from(ResultSet rs,ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity, StoriesEntity storiesEntity) {
        Score score =new Score();
        try {
            return score.setId(rs.getInt("Id"))
                    .setStatus(rs.getInt("Status"))
                    .setStory(storiesEntity.findById(rs.getInt("Story"),challengeEntity,usersEntity,categoriesEntity))
                    .setUser(usersEntity.findById(rs.getInt("User")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
