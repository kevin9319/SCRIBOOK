package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KeywordsEntity extends BaseEntity {

    public KeywordsEntity() {
        super();
        setTableName("keyword");
    }

    public KeywordsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }


    public Keyword findById(int id) {
        return findByCriteria(
                String.format("WHERE id = %d", id)).get(0);
    }

    public List<Keyword> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Keyword> keywords = new ArrayList<>();
            while(rs.next())
                keywords.add(Keyword.from(rs));

            return keywords;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Keyword> findAll() {
        return findByCriteria("");
    }



}
