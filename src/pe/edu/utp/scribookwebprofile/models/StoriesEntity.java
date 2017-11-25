package pe.edu.utp.scribookwebprofile.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoriesEntity extends BaseEntity{


    public StoriesEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public StoriesEntity() {
        super();
        setTableName("story");
    }

    public Story findById(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Id = %d", id), challengeEntity, usersEntity, categoriesEntity).get(0);
    }

    public List<Story> findByUser(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE User = %d", id), challengeEntity, usersEntity, categoriesEntity);
    }

    public List<Story> findByChallenge(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Challenge = %d", id), challengeEntity, usersEntity, categoriesEntity);
    }

    public Story findByChallengeWinner(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Challenge = %d ORDER BY ScoreTotal DESC LIMIT 1", id), challengeEntity, usersEntity, categoriesEntity).get(0);
    }



    public List<Story> findByTitleORStory(String TitleORStory,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Title LIKE '%%%s%%' OR Description LIKE '%%%s%%'", TitleORStory,TitleORStory), challengeEntity, usersEntity, categoriesEntity);
    }


    public List<Story> findByCriteria(String criteria, ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Story> stories = new ArrayList<>();
            while(rs.next())
                stories.add(Story.from(rs, challengeEntity, usersEntity, categoriesEntity));

            return stories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public Story create(Story story) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Title, Description, ScoreTotal, CreateDate, User, Challenge) VALUES('%s', '%s', %d,CURDATE(), %d, %d)",
                getTableName(),story.getTitle(),story.getDescription(),0,story.getUser().getId(),story.getChallenge().getId())) ?
                story : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id) AS max_id FROM story";
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getCountScore(int id) {
        String sql = "SELECT SUM(Status) AS sum_score FROM score WHERE Story="+id;
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("sum_score") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean updatescore(int id) {
        return executeUpdate(String.format(
                "UPDATE %s SET ScoreTotal = %d WHERE Id = %d", getTableName(), getCountScore(id), id));
    }

    public boolean updatescore(Story story) {
        return updatescore(story.getId());
    }


    public Story create(String Title, String Description, int ScoreTotal, Date CreateDate,User user, Challenge challenge) {
        return create(getMaxId()+1, Title, Description, ScoreTotal, CreateDate,user, challenge);
    }


    public Story create(int id, String Title, String Description, int ScoreTotal, Date CreateDate,User user, Challenge challenge) {
        return create(new Story(id,Title, Description, ScoreTotal, CreateDate,user, challenge));
    }


    public boolean update(int id, String Title,String Description) {
        return executeUpdate(String.format(
                "UPDATE %s SET Title = '%s', Description = '%s' WHERE Id = %d", getTableName(), Title, Description, id));
    }

    public boolean update(Story story) {
        return update(story.getId(), story.getTitle(),story.getDescription());
    }

    public boolean delete(int id){
        String sql = "DELETE FROM story WHERE id = " + id;
        return executeUpdate(sql);
    }

}
