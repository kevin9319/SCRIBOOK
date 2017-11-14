package pe.edu.utp.scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WinnersEntity extends BaseEntity{


    public WinnersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public WinnersEntity() {
        super();
        setTableName("winner");
    }

    public Winner findById(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Id = %d", id), challengeEntity, usersEntity, categoriesEntity).get(0);
    }

    public Winner findByChallenge(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE User = %d", id), challengeEntity, usersEntity, categoriesEntity).get(0);
    }

    public Winner findByUser(int id,ChallengeEntity challengeEntity, UsersEntity usersEntity,CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Challenge = %d", id), challengeEntity, usersEntity, categoriesEntity).get(0);
    }




    public List<Winner> findByCriteria(String criteria, ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Winner> winners = new ArrayList<>();
            while(rs.next())
                winners.add(Winner.from(rs, challengeEntity, usersEntity, categoriesEntity));

            return winners;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Winner create(Winner winner) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Id, Challenge, User) VALUES(%d, %d, %d)",
                getTableName(),winner.getId(),winner.getChallenge().getId(),winner.getUser().getId())) ?
                winner : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id) AS max_id FROM winner";
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

    public int getCountChallenge(Challenge challenge) {
        String sql = "SELECT COUNT(Id) AS count_id FROM winner WHERE Challenge="+challenge.getId();
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


    public Winner create(Challenge challenge, User user) {
        return create(getMaxId()+1, challenge,user);
    }

    public Winner create(int id, Challenge challenge, User user) {
        return create(new Winner(id,challenge,user));
    }





}
