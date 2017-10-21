package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.Connection;
import java.util.List;

public class ScDataStore {

    private Connection connection;


    public ScDataStore(Connection connection) {
        this.connection = connection;
    }

    public ScDataStore() {
    }






    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }



}
