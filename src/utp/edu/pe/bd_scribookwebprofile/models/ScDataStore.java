package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class ScDataStore {

    private Connection connection;
    private UsersEntity usersEntity;
    private CategoriesEntity categoriesEntity;
    private KeywordsEntity keywordsEntity;

    private ChallengeEntity challengeEntity;
    private ChallengesKeywordsEntity challengesKeywordsEntity;

    private WinnersEntity winnersEntity;

    private StoriesEntity storiesEntity;

    private ScoresEntity scoresEntity;

    public ScDataStore(Connection connection) {
        this.connection = connection;
    }

    public ScDataStore() {
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    //------------------User---------------------------------------------

    private UsersEntity getUsersEntity() {
        if(usersEntity == null) {
            usersEntity = new UsersEntity();
            usersEntity.setConnection(connection);
        }
        return usersEntity;
    }



    public User findUserById(int id) {
        if(connection == null) return null;
        return getUsersEntity().findById(id);
    }

    public User findUserByNamePassword(String UserName,String Password) {
        if(connection == null) return null;
        return getUsersEntity().findByNamePassword(UserName,Password);
    }


    public List<User> findAllUsers() {
        return connection == null ? null: getUsersEntity().findAll();
    }

    public User createUser(String UserName, String FirstName, String LastName, String Password, String Email, String NickName, String Gender, int Status) {
        return connection == null ?
                null :
                getUsersEntity().create(UserName,FirstName,LastName,Password,Email,NickName,Gender,Status);
    }

    public boolean updateUser(int id, String FirstName, String LastName, String Email, String NickName, String Gender) {
        return connection == null ?
                false :
                getUsersEntity().update(id, FirstName,LastName,Email,NickName,Gender);
    }

    public boolean updateUser(User user) {
        return updateUser(user.getId(), user.getFirstName(),user.getLastName(),user.getEmail(),user.getNickName(),user.getGender());
    }

    public int getUserCountUser(String userName) {
        if(connection == null) return 0;
        return getUsersEntity().getCountUser(userName);
    }



    //------------------Category---------------------------------------------------------------
    private CategoriesEntity getCategoriesEntity() {
        if(categoriesEntity == null) {
            categoriesEntity = new CategoriesEntity();
            categoriesEntity.setConnection(connection);
        }
        return categoriesEntity;
    }


    public Category findCategoryById(int id) {
        if(connection == null) return null;
        return getCategoriesEntity().findById(id);
    }

    public List<Category> findAllCategories() {
        return connection == null ? null: getCategoriesEntity().findAll();
    }

    public boolean createCategory(Category category){ return getCategoriesEntity().add(category); }

    public boolean deleteCategory(int id){
        return getCategoriesEntity().delete(id);
    }

    public boolean updateCategory(Category category){
        return getCategoriesEntity().update(category);
    }

    //------------------Keyword-------------------------------------------------

    private KeywordsEntity getKeywordsEntity() {
        if(keywordsEntity == null) {
            keywordsEntity = new KeywordsEntity();
            keywordsEntity.setConnection(connection);
        }
        return keywordsEntity;
    }

    public Keyword findKeywordById(int id) {
        if(connection == null) return null;
        return getKeywordsEntity().findById(id);
    }



    public List<Keyword> findAllKeywords() {
        return connection == null ? null: getKeywordsEntity().findAll();
    }


    //------------------Challenge-----------------------------------------------------
    private ChallengeEntity getChallengeEntity() {
        if(challengeEntity == null) {
            challengeEntity = new ChallengeEntity();
            challengeEntity.setConnection(connection);
        }
        return challengeEntity;
    }


    public Challenge findChallengeById(int id) {
        if(connection == null) return null;
        return getChallengeEntity().findById(id,getCategoriesEntity(),getUsersEntity());
    }

    public Challenge findChallengeByCategory(int id) {
        if(connection == null) return null;
        return getChallengeEntity().findByCategory(id,getCategoriesEntity(),getUsersEntity());
    }


    public List<Challenge> findAllChallenges() {
        return connection == null ? null: getChallengeEntity().findAll(getCategoriesEntity(),getUsersEntity());
    }

    public Challenge createChallenge(String Title, String Description, int Status, Date CreateDate, Date LastDate,Category category, User user) {
        return connection == null ?
                null :
                getChallengeEntity().create(Title,Description,Status,CreateDate,LastDate,category,user);
    }

    public boolean updateChallenge(int id, String Title,String Description,Date LastDate) {
        return connection == null ?
                false :
                getChallengeEntity().update(id, Title,Description,LastDate);
    }

    public boolean updateChallenge(Challenge challenge) {
        return updateChallenge(challenge.getId(),challenge.getTitle(),challenge.getDescription(),challenge.getLastDate());
    }


    public boolean updateChallengeStatus(int id, int Status) {
        return connection == null ?
                false :
                getChallengeEntity().updateStatus(id, Status);
    }

    public boolean updateChallengeStatus(Challenge challenge) {
        return updateChallengeStatus(challenge.getId(),challenge.getStatus());
    }




    //------------------ChallengeKeyword---------------------------------------------------

    private ChallengesKeywordsEntity getChallengesKeywordsEntity() {
        if(challengesKeywordsEntity == null) {
            challengesKeywordsEntity = new ChallengesKeywordsEntity();
            challengesKeywordsEntity.setConnection(connection);
        }
        return challengesKeywordsEntity;
    }

    public ChallengeKeyword findChallengeKeywordById(int id) {
        if(connection == null) return null;
        return getChallengesKeywordsEntity().findById(id,getKeywordsEntity(),getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }

    public ChallengeKeyword findChallengeKeywordByKeyword(int id) {
        if(connection == null) return null;
        return getChallengesKeywordsEntity().findByKeyword(id,getKeywordsEntity(),getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }



    public ChallengeKeyword createChallengeKeyword(Keyword keyword, Challenge challenge) {
        return connection == null ?
                null :
                getChallengesKeywordsEntity().create(keyword, challenge);
    }




    //------------------Winner---------------------------------------------------------

    private WinnersEntity getWinnersEntity() {
        if(winnersEntity == null) {
            winnersEntity = new WinnersEntity();
            winnersEntity.setConnection(connection);
        }
        return winnersEntity;
    }

    public Winner findWinnerById(int id) {
        if(connection == null) return null;
        return getWinnersEntity().findById(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }

    public Winner findWinnerByChallenge(int id) {
        if(connection == null) return null;
        return getWinnersEntity().findByChallenge(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }

    public Winner findWinnerByUser(int id) {
        if(connection == null) return null;
        return getWinnersEntity().findByUser(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }

    public Winner createWinner(Challenge challenge,User user) {
        return connection == null ?
                null :
                getWinnersEntity().create(challenge,user);
    }

    public int getWinnerCountChallenge(Challenge challenge) {
        if(connection == null) return 0;
        return getWinnersEntity().getCountChallenge(challenge);
    }




    //------------------Story-------------------------------------------------------------------

    private StoriesEntity getStoriesEntity() {
        if(storiesEntity == null) {
            storiesEntity = new StoriesEntity();
            storiesEntity.setConnection(connection);
        }
        return storiesEntity;
    }

    public Story findStoryById(int id) {
        if(connection == null) return null;
        return getStoriesEntity().findById(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }

    public Story findStoryByUser(int id) {
        if(connection == null) return null;
        return getStoriesEntity().findByUser(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }

    public Story findStoryByChallenge(int id) {
        if(connection == null) return null;
        return getStoriesEntity().findByChallenge(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }

    public Story findStoryByTitleORStory(String TitleORStory) {
        if(connection == null) return null;
        return getStoriesEntity().findByTitleORStory(TitleORStory,getChallengeEntity(),getUsersEntity(),getCategoriesEntity());
    }


    public Story createStory(String Title, String Description, int ScoreTotal, Date CreateDate,User user,Challenge challenge) {
        return connection == null ?
                null :
                getStoriesEntity().create(Title,Description,ScoreTotal,CreateDate,user,challenge);
    }


    public boolean updateStory(int id, String Title,String Description) {
        return connection == null ?
                false :
                getStoriesEntity().update(id, Title,Description);
    }

    public boolean updateStory(Story story) {
        return updateStory(story.getId(),story.getTitle(),story.getDescription());
    }

    public boolean deleteStory(int id){
        return getStoriesEntity().delete(id);
    }

    //------------------Score------------------------------------------------------------------------

    private ScoresEntity getScoresEntity() {
        if(scoresEntity == null) {
            scoresEntity = new ScoresEntity();
            scoresEntity.setConnection(connection);
        }
        return scoresEntity;
    }

    public Score findScoreById(int id) {
        if(connection == null) return null;
        return getScoresEntity().findById(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity(),getStoriesEntity());
    }

    public Score findScoreByUser(int id) {
        if(connection == null) return null;
        return getScoresEntity().findByUser(id,getChallengeEntity(),getUsersEntity(),getCategoriesEntity(),getStoriesEntity());
    }

    public Score createScore(int Status,Story story,User user) {
        return connection == null ?
                null :
                getScoresEntity().create(Status,story,user);
    }


    public int getScoreCountScore(Story story) {
        if(connection == null) return 0;
        return getScoresEntity().getCountScore(story);
    }


    public int getScoreCountUser(User user) {
        if(connection == null) return 0;
        return getScoresEntity().getCountUser(user);
    }

    public boolean updateScore(int id, int Status) {
        return connection == null ?
                false :
                getScoresEntity().update(id, Status);
    }

    public boolean updateScore(Score score) {
        return updateScore(score.getId(),score.getStatus());
    }



}
