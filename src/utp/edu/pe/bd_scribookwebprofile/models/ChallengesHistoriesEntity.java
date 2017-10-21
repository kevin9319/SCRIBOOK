package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChallengesHistoriesEntity extends BaseEntity{

    public ChallengesHistoriesEntity()
    {
        super();
        setTableName("ChallengesHistories");
    }

    public ChallengesHistoriesEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public ChallengeHistory findById(String id, UsersEntity usersEntity, ChallengeEntity challengeEntity, HistoriesEntity historiesEntity) {
        return findByCriteria(
                String.format("WHERE Id_ChallengesHistories = '%s'", id), usersEntity, challengeEntity, historiesEntity).get(0);
    }

    public List<ChallengeHistory> findByCriteria(String criteria, UsersEntity usersEntity, ChallengeEntity challengeEntity, HistoriesEntity historiesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<ChallengeHistory> challengeHistorys = new ArrayList<>();
            while(rs.next())
                challengeHistorys.add(ChallengeHistory.from(rs, usersEntity, challengeEntity, historiesEntity));

            return challengeHistorys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
