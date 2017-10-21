package utp.edu.pe.bd_scribookwebprofile.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ScService {

    private Connection connection;
    private ScDataStore dataStore;

    public ScService() {
        try {
            InitialContext context = new InitialContext();
            dataStore = new ScDataStore();
            connection = ((DataSource) context
                    .lookup("jdbc/MySQLDataSource"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ScDataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(ScDataStore dataStore) {
        this.dataStore = dataStore;
    }

}
