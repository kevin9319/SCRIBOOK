package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{

    public UsersEntity() {
        super();
        setTableName("user");
    }

    public UsersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public User findById(int id) {
        return findByCriteria(
                String.format("WHERE Id = %d", id)).get(0);
    }

    public List<User> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<User> users = new ArrayList<>();
            while(rs.next())
                users.add(User.from(rs));

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User findByNamePassword(String UserName,String Password) {
        return findByCriteria(
                String.format("WHERE UserName = '%s' AND Password = '%s'", UserName,Password)).get(0);
    }

    public List<User> findAll() {
        return findByCriteria("");
    }


    public User create(User user) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Id, UserName, FirsName, LastName, Password, Email, NickName, Gender, Status) VALUES(%d, '%s','%s','%s','%s','%s','%s','%s',%d)",
                getTableName(), user.getId(), user.getUserName(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getEmail(),user.getNickName(),user.getGender(),user.getStatus())) ?
                user : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id) AS max_id FROM user";
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

    public int getCountUser(User user) {
        String sql = "SELECT COUNT(Id) AS count_id FROM User WHERE UserName='"+user.getUserName()+"'";
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

    public User create(String UserName, String FirstName, String LastName, String Password, String Email, String NickName, String Gender, int Status) {
        return create(getMaxId()+1, UserName,FirstName,LastName,Password,Email,NickName,Gender,Status);
    }

    public User create(int id, String UserName, String FirstName, String LastName, String Password, String Email, String NickName, String Gender, int Status) {
        return create(new User(id, UserName,FirstName,LastName,Password,Email,NickName,Gender,Status));
    }

    public boolean update(int id, String FirstName, String LastName, String Email, String NickName, String Gender) {
        return executeUpdate(String.format(
                "UPDATE %s SET FirstName = '%s', LastName = '%s', Email = '%s', NickName = '%s', Gender = '%c' WHERE Id = %d",
                getTableName(), FirstName,LastName,Email,NickName,Gender, id));
    }

    public boolean update(User user) {
        return update(user.getId(), user.getFirstName(),user.getLastName(),user.getEmail(),user.getNickName(),user.getGender());
    }


}

