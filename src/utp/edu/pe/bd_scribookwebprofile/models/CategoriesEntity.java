package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesEntity extends BaseEntity {

    public CategoriesEntity()
    {
        super();
        setTableName("category");
    }

    public CategoriesEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public Category findById(int id) {
        return findByCriteria(
                String.format("WHERE Id_category = %d", id)).get(0);
    }

    public List<Category> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Category> categorys = new ArrayList<>();
            while(rs.next())
                categorys.add(Category.from(rs));

            return categorys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
