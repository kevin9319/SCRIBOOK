package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChallengeHistory {

    private int Id_ChallengesHistories;
    private int Views;
    private int Score;
    private String Cover;
    private Date CreateDate;
    private User user;
    private Challenge challenge;
    private History history;

    public ChallengeHistory(int id_ChallengesHistories, int views, int score, String cover, Date createDate, User user, Challenge challenge, History history) {
        this.Id_ChallengesHistories = id_ChallengesHistories;
        this.Views = views;
        this.Score = score;
        this.Cover = cover;
        this.CreateDate = createDate;
        this.user = user;
        this.challenge = challenge;
        this.history = history;
    }

    public ChallengeHistory(){}

    public int getId_ChallengesHistories() {
        return Id_ChallengesHistories;
    }

    public ChallengeHistory setId_ChallengesHistories(int id_ChallengesHistories) {
        this.Id_ChallengesHistories = id_ChallengesHistories;
        return this;
    }

    public int getViews() {
        return Views;
    }

    public ChallengeHistory setViews(int views) {
        this.Views = views;
        return this;
    }

    public int getScore() {
        return Score;
    }

    public ChallengeHistory setScore(int score) {
        this.Score = score;
        return this;
    }

    public String getCover() {
        return Cover;
    }

    public ChallengeHistory setCover(String cover) {
        this.Cover = cover;
        return this;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public ChallengeHistory setCreateDate(Date createDate) {
        this.CreateDate = createDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ChallengeHistory setUser(User user) {
        this.user = user;
        return this;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public ChallengeHistory setChallenge(Challenge challenge) {
        this.challenge = challenge;
        return this;
    }

    public History getHistory() {
        return history;
    }

    public ChallengeHistory setHistory(History history) {
        this.history = history;
        return this;
    }

    public static ChallengeHistory from(ResultSet rs, UsersEntity usersEntity, ChallengeEntity challengeEntity, HistoriesEntity historiesEntity)
    {
        ChallengeHistory challengeHistory = new ChallengeHistory();
        try {
            return challengeHistory.setId_ChallengesHistories(rs.getInt("Id_ChallengesHistories"))
                    .setViews(rs.getInt("Views"))
                    .setScore(rs.getInt("Score"))
                    .setCover(rs.getString("Cover"))
                    .setCreateDate(rs.getDate("CreateDate"))
                    .setUser(usersEntity.findById(rs.getInt("Id_users")))
                    .setChallenge(challengeEntity.findById(rs.getInt("Id_challenges"),,))
                    .setHistory(historiesEntity.findById(rs.getInt("Id_Histories"),,));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  null;
    }

}