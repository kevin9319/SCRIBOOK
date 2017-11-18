package pe.edu.utp.scribookwebprofile.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class ChallengeEntity extends BaseEntity{

    public ChallengeEntity()
    {
        super();
        setTableName("challenge");
    }

    public ChallengeEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public Challenge findById(int id, CategoriesEntity categoriesEntity, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE Id = %d", id), categoriesEntity, usersEntity).get(0);
    }


    public List<Challenge> findByCriteria(String criteria, CategoriesEntity categoriesEntity, UsersEntity usersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Challenge> challenges = new ArrayList<>();
            while(rs.next())
                challenges.add(Challenge.from(rs, categoriesEntity, usersEntity));

            return challenges;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Challenge> findAll(CategoriesEntity categoriesEntity,UsersEntity usersEntity) {
        return findByCriteria("", categoriesEntity,usersEntity);
    }

    public List<Challenge> findByCategory(int id, CategoriesEntity categoriesEntity, UsersEntity usersEntity) {
        return findByCriteria(
                String.format("WHERE Category = %d", id), categoriesEntity, usersEntity);
    }

    public Challenge create(Challenge challenge) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Title, Description, Status,CreateDate,LastDate, Category, User) VALUES('%s','%s',%d,CURDATE(),' " + challenge.getLastDate() +" ',%d,%d)",
                getTableName(),challenge.getTitle(),challenge.getDescription(),1,challenge.getCategory().getId(),challenge.getUser().getId())) ?
                challenge : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id) AS max_id FROM challenge";
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


    public Challenge create(String Title, String Description, int Status, Date CreateDate, Date LastDate, Category category, User user) {
        return create(getMaxId()+1, Title,Description,Status,CreateDate,LastDate,category,user);
    }

    public Challenge create(int id, String Title, String Description, int Status, Date CreateDate, Date LastDate, Category category, User user) {
        return create(new Challenge(id, Title,Description,Status,CreateDate,LastDate,category,user));
    }


    public boolean update(int id, String Title,String Description,Date LastDate) {
        return executeUpdate(String.format(
                "UPDATE %s SET Title = '%s', Description = '%s', LastDate = '%tF' WHERE Id = %d", getTableName(), Title, Description, LastDate, id));
    }

    public boolean update(Challenge challenge) {
        return update(challenge.getId(), challenge.getTitle(),challenge.getDescription(),challenge.getLastDate());
    }

   public boolean updateStatus(int id, int Status){
       return executeUpdate(String.format(
               "UPDATE %s SET Status = %d WHERE Id = %d", getTableName(), Status, id));
   }


    public boolean updateStatus(Challenge challenge) {
        return updateStatus(challenge.getId(), challenge.getStatus());
    }



}
