package pe.edu.utp.scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChallengeKeyword {

    private int id;
    private Keyword keyword;
    private Challenge challenge;

    public ChallengeKeyword(int id, Keyword keyword, Challenge challenge) {
        this.id = id;
        this.keyword = keyword;
        this.challenge = challenge;
    }

    public ChallengeKeyword() {
    }

    public int getId() {
        return id;
    }

    public ChallengeKeyword  setId(int id) {
        this.id = id;
        return this;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public ChallengeKeyword setKeyword(Keyword keyword) {
        this.keyword = keyword;
        return this;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public ChallengeKeyword setChallenge(Challenge challenge) {
        this.challenge = challenge;
        return this;
    }


    public static ChallengeKeyword from(ResultSet rs, KeywordsEntity keywordsEntity, ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        ChallengeKeyword challengekeyword =new ChallengeKeyword();
        try {
            return challengekeyword.setId(rs.getInt("Id"))
                    .setKeyword(keywordsEntity.findById(rs.getInt("Keyword")))
                    .setChallenge(challengeEntity.findById(rs.getInt("Challenge"),categoriesEntity,usersEntity));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
