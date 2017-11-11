package utp.edu.pe.bd_scribookwebprofile.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ScService {

    private Connection connection;
    private ScDataStore dataStore;

    public ScService() {
        try {
            InitialContext context = new InitialContext();
            dataStore = new ScDataStore();
            connection = ((DataSource) context
                    .lookup("jdbc/MySQLDataSource"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ScDataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(ScDataStore dataStore) {
        this.dataStore = dataStore;
    }





    //------------------User----------------------------------------------------------------
    public User findUserById(int id) {
        return dataStore.findUserById(id);
    }

    public User findUserByNamePassword(String UserName,String Password) {
        return dataStore.findUserByNamePassword(UserName,Password);
    }

    public List<User> findAllUsers() { return dataStore.findAllUsers(); }

    public User createUser(String UserName, String FirstName, String LastName, String Password, String Email, String NickName, String Gender, int Status) {
        return dataStore.createUser(UserName,FirstName,LastName,Password,Email,NickName,Gender,Status);
    }

    public boolean updateUser(int id, String FirstName, String LastName, String Email, String NickName, String Gender) {
        return dataStore.updateUser(id, FirstName,LastName,Email,NickName,Gender);
    }

    public int getUserCountUser(String userName) {
        return dataStore.getUserCountUser(userName);
    }



    //------------------Category----------------------------------------------------------------

    public Category findCategoryById(int id) {
        return dataStore.findCategoryById(id);
    }

    public List<Category> findAllCategories() { return dataStore.findAllCategories(); }

    public boolean createCategory(Category category){
        return getDataStore().createCategory(category);
    }

    public boolean deleteCategory(int id){
        return getDataStore().deleteCategory(id);
    }

    public boolean updateCategory(Category category){
        return getDataStore().updateCategory(category);
    }

    //------------------Keyword----------------------------------------------------------------


    public Keyword findKeywordById(int id) {
        return dataStore.findKeywordById(id);
    }

    public List<Keyword> findAllKeywords() { return dataStore.findAllKeywords(); }


    //------------------Challenge----------------------------------------------------------------

    public Challenge findChallengeById(int id) {
        return dataStore.findChallengeById(id);
    }

    public Challenge findChallengeByCategory(int id) {
        return dataStore.findChallengeByCategory(id);
    }

    public List<Challenge> findAllChallenges() { return dataStore.findAllChallenges(); }

    public Challenge createChallenge(String Title, String Description, int Status, Date CreateDate, Date LastDate, Category category, User user) {
        return dataStore.createChallenge(Title,Description,Status,CreateDate,LastDate,category,user);
    }


    public boolean updateChallenge(int id, String Title,String Description,Date LastDate) {
        return dataStore.updateChallenge(id, Title,Description,LastDate);
    }

    public boolean updateChallengeStatus(int id, int Status) {
        return dataStore.updateChallengeStatus(id, Status);
    }



    //------------------ChallengeKeyword----------------------------------------------------------------
    public ChallengeKeyword findChallengeKeywordById(int id) {
        return dataStore.findChallengeKeywordById(id);
    }

    public ChallengeKeyword findChallengeKeywordByKeyword(int id) {
        return dataStore.findChallengeKeywordByKeyword(id);
    }

    public ChallengeKeyword createChallengeKeyword(Keyword keyword, Challenge challenge) {
        return dataStore.createChallengeKeyword(keyword, challenge);
    }


    //------------------Winner----------------------------------------------------------------

    public Winner findWinnerById(int id) {
        return dataStore.findWinnerById(id);
    }

    public Winner findWinnerByChallenge(int id) {
        return dataStore.findWinnerByChallenge(id);
    }

    public Winner findWinnerByUser(int id) {
        return dataStore.findWinnerByUser(id);
    }

    public Winner createWinner(Challenge challenge,User user) {
        return dataStore.createWinner(challenge,user);
    }


    public int getWinnerCountChallenge(Challenge challenge) {
        return dataStore.getWinnerCountChallenge(challenge);
    }

    //------------------Story----------------------------------------------------------------

    public Story findStoryById(int id) {
        return dataStore.findStoryById(id);
    }


    public Story findStoryByUser(int id) {
        return dataStore.findStoryByUser(id);
    }

    public Story findStoryByChallenge(int id) {
        return dataStore.findStoryByChallenge(id);
    }

    public Story findStoryByTitleORStory(String TitleORStory) {
        return dataStore.findStoryByTitleORStory(TitleORStory);
    }

    public Story createStory(String Title, String Description, int ScoreTotal, Date CreateDate,User user,Challenge challenge) {
        return dataStore.createStory(Title,Description,ScoreTotal,CreateDate,user,challenge);
    }

    public boolean updateStory(int id, String Title,String Description) {
        return dataStore.updateStory(id, Title,Description);
    }

    public boolean deleteStory(int id){
        return dataStore.deleteStory(id);
    }


    //------------------Score----------------------------------------------------------------
    public Score findScoreById(int id) {
        return dataStore.findScoreById(id);
    }

    public Score findScoreByUser(int id) {
        return dataStore.findScoreByUser(id);
    }


    public Score createScore(int Status,Story story,User user) {
        return dataStore.createScore(Status,story,user);
    }


    public int getScoreCountScore(Story story) {
        return dataStore.getScoreCountScore(story);
    }


    public int getScoreCountUser(User user) {
        return dataStore.getScoreCountUser(user);
    }

    public boolean updateScore(int id, int Status) {
        return dataStore.updateScore(id, Status);
    }


}
