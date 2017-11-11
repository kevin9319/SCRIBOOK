package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Winner {

    private int id;
    private Challenge challenge;
    private User user;


    public Winner() {
    }

    public Winner(int id, Challenge challenge, User user) {
        this.id = id;
        this.challenge = challenge;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public Winner setId(int id) {
        this.id = id;
        return this;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public Winner setChallenge(Challenge challenge) {
        this.challenge = challenge;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Winner setUser(User user) {
        this.user = user;
        return this;
    }

    public static Winner from(ResultSet rs,ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        Winner winner =new Winner();
        try {
            return winner.setId(rs.getInt("Id"))
                    .setChallenge(challengeEntity.findById(rs.getInt("Challenge"),categoriesEntity,usersEntity))
                    .setUser(usersEntity.findById(rs.getInt("User")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
