package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChallengeEntity extends BaseEntity{

    public ChallengeEntity()
    {
        super();
        setTableName("Challenges");
    }

    public ChallengeEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public Challenge findById(String id, CategoriesEntity categoriesEntity, WordsEntity wordsEntity) {
        return findByCriteria(
                String.format("WHERE Id_challenges = '%s'", id), categoriesEntity, wordsEntity).get(0);
    }

    public List<Challenge> findByCriteria(String criteria, CategoriesEntity categoriesEntity, WordsEntity wordsEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Challenge> challenges = new ArrayList<>();
            while(rs.next())
                challenges.add(Challenge.from(rs, categoriesEntity, wordsEntity));

            return challenges;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
