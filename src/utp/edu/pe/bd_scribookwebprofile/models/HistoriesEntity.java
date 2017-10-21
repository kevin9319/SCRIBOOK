package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoriesEntity extends BaseEntity{

    public HistoriesEntity()
    {
        super();
        setTableName("Histories");
    }

    public HistoriesEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public History findById(String id, CategoriesEntity categoriesEntity) {
        return findByCriteria(
                String.format("WHERE Id_Histories = '%s'", id), categoriesEntity).get(0);
    }

    public List<History> findByCriteria(String criteria, CategoriesEntity categoriesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<History> historys = new ArrayList<>();
            while(rs.next())
                historys.add(History.from(rs, categoriesEntity));

            return historys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
