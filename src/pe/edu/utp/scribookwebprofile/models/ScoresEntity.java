package pe.edu.utp.scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoresEntity extends BaseEntity{

    public ScoresEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public ScoresEntity() {
        super();
        setTableName("score");
    }


    public Score findById(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity, StoriesEntity storiesEntity) {
        return findByCriteria(
                String.format("WHERE Id = %d", id), challengeEntity, usersEntity, categoriesEntity, storiesEntity).get(0);
    }

    public Score findByUser(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity, StoriesEntity storiesEntity) {
        return findByCriteria(
                String.format("WHERE User = %d", id), challengeEntity, usersEntity, categoriesEntity, storiesEntity).get(0);
    }


    public List<Score> findByCriteria(String criteria, ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity, StoriesEntity storiesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Score> scores = new ArrayList<>();
            while(rs.next())
                scores.add(Score.from(rs,challengeEntity,usersEntity,categoriesEntity,storiesEntity));

            return scores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Score create(Score score) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Status, Story, User) VALUES(1, %d, %d)",
                getTableName(),score.getStory().getId(),score.getUser().getId())) ?
                score : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id) AS max_id FROM score";
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


    public Score create(int Status,Story story, User user) {

        return create(getMaxId()+1,Status, story,user);
    }

    public Score create(int id, int Status, Story story, User user) {

        return create(new Score(id,Status,story,user));
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


    public int getCountUser(Story story,User user) {
        String sql = "SELECT COUNT(Id) AS count_id FROM score WHERE Story="+story.getId()+" AND User="+user.getId();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("count_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public boolean update(int id, int Status) {
        return executeUpdate(String.format(
                "UPDATE %s SET Status = %d WHERE User = %d", getTableName(), Status, id));
    }

    public boolean update(Score score) {
        return update(score.getId(), score.getStatus());
    }



}
