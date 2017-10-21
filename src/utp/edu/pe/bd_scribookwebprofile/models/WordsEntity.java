package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordsEntity extends BaseEntity{

    public WordsEntity() {
        super();
        setTableName("words");
    }

    public WordsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public Word findById(int id) {
        return findByCriteria(
                String.format("WHERE Id_Words = %d", id)).get(0);
    }

    public List<Word> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Word> words = new ArrayList<>();
            while(rs.next())
                words.add(Word.from(rs));

            return words;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Word findByName(String name) {
        return findByCriteria(
                String.format("WHERE UserName = '%s'", name)).get(0);
    }

    public List<Word> findAll() {
        return findByCriteria("");
    }

    public List<Word> findAllWithWords() {
        return findByCriteria("Id_users IN (SELECT DISTINCT Id_users FROM users)");
    }

    public Word create(Word word) {
        return executeUpdate(String.format(
                "INSERT INTO %s(Id_users, UserName) VALUES(%d, '%s')",
                getTableName(), word.getId(), word.getPalabra1(),word.getPalabra2(),word.getPalabra3(),word.getStatus())) ?
                word : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(Id_Words) AS max_id FROM words";
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

    public Word create(String palabra_1,String palabra_2,String palabra_3,int status) {
        return create(getMaxId()+1, palabra_1,palabra_2,palabra_3,status);
    }



    public Word create(int id, String palabra_1,String palabra_2,String palabra_3,int status) {
        return create(new Word(id, palabra_1,palabra_2,palabra_3,status));
    }

    public boolean update(int id, String name) {
        return executeUpdate(String.format(
                "UPDATE %s SET UserName = '%s' WHERE Id_Words = %d", getTableName(), name, id));
    }

    public boolean update(User user) {
        return update(user.getId(), user.getUsername());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE Id_Words = %d",
                getTableName(), id));
    }

    public boolean erase(User user) {
        return executeUpdate(String.format("DELETE FROM %s WHERE Id_Words = %d",
                getTableName(), user.getId()));
    }

}
