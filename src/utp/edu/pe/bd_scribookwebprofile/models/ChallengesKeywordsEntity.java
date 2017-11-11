package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ChallengesKeywordsEntity extends BaseEntity{


    public ChallengesKeywordsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public ChallengesKeywordsEntity() {
        super();
        setTableName("challengekeyword");
    }

    public ChallengeKeyword findById(int id,KeywordsEntity keywordsEntity, ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Id = %d", id), keywordsEntity, challengeEntity, usersEntity, categoriesEntity).get(0);
    }


    public List<ChallengeKeyword> findByCriteria(String criteria,KeywordsEntity keywordsEntity, ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<ChallengeKeyword> challengeKeywords = new ArrayList<>();
            while(rs.next())
                challengeKeywords.add(ChallengeKeyword.from(rs,keywordsEntity, challengeEntity, usersEntity, categoriesEntity));

            return challengeKeywords;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public ChallengeKeyword findByKeyword(int id,KeywordsEntity keywordsEntity, ChallengeEntity challengeEntity, UsersEntity usersEntity, CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Challenge = %d", id), keywordsEntity, challengeEntity, usersEntity, categoriesEntity).get(0);
    }




    public ChallengeKeyword create(ChallengeKeyword challengeKeyword) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Id, Keyword, Challenge) VALUES(%d, %d, %d)",
                getTableName(),challengeKeyword.getId(),challengeKeyword.getKeyword().getId(),challengeKeyword.getChallenge().getId())) ?
                challengeKeyword : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id) AS max_id FROM challengeKeyword";
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


    public ChallengeKeyword create(Keyword keyword, Challenge challenge) {
        return create(getMaxId()+1,keyword, challenge);
    }

    public ChallengeKeyword create(int id, Keyword keyword, Challenge challenge) {
        return create(new ChallengeKeyword(id,keyword, challenge));
    }



}
