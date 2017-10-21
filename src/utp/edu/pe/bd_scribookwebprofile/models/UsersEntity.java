package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity{

    public UsersEntity() {
        super();
        setTableName("users");
    }

    public UsersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public User findById(int id) {
        return findByCriteria(
                String.format("WHERE Id_users = %d", id)).get(0);
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
    public User findByName(String name) {
        return findByCriteria(
                String.format("WHERE UserName = '%s'", name)).get(0);
    }

    public List<User> findAll() {
        return findByCriteria("");
    }

    public List<User> findAllWithUsers() {
        return findByCriteria("Id_users IN (SELECT DISTINCT Id_users FROM users)");
    }

    public User create(User user) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Id_users, UserName) VALUES(%d, '%s')",
                getTableName(), user.getId(), user.getUsername())) ?
                user : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id_users) AS max_id FROM users";
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

    public User create(String name) {
        return create(getMaxId()+1, name);
    }

    public User create(int id, String name) {
        return create(new User(id, name"falta las demas variables"));
    }

    public boolean update(int id, String name) {
        return executeUpdate(String.format(
                "UPDATE %s SET UserName = '%s' WHERE Id_users = %d", getTableName(), name, id));
    }

    public boolean update(User user) {
        return update(user.getId(), user.getUsername());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE region_id = %d",
                getTableName(), id));
    }

    public boolean erase(User user) {
        return executeUpdate(String.format("DELETE FROM %s WHERE region_id = %d",
                getTableName(), user.getId()));
    }
}

