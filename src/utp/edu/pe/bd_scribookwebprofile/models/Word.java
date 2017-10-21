package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Word {


    private int id;
    private String palabra1;
    private String palabra2;
    private String palabra3;
    private int status;

    public Word(int id, String palabra1, String palabra2, String palabra3, int status) {
        this.id = id;
        this.palabra1 = palabra1;
        this.palabra2 = palabra2;
        this.palabra3 = palabra3;
        this.status = status;
    }

    public Word() {
    }

    public int getId() {
        return id;
    }

    public Word setId(int id) {
        this.id = id;
        return this;
    }

    public String getPalabra1() {
        return palabra1;
    }

    public Word setPalabra1(String palabra1) {
        this.palabra1 = palabra1;
        return this;
    }

    public String getPalabra2() {
        return palabra2;
    }

    public Word setPalabra2(String palabra2) {
        this.palabra2 = palabra2;
        return this;
    }

    public String getPalabra3() {
        return palabra3;
    }

    public Word setPalabra3(String palabra3) {
        this.palabra3 = palabra3;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Word setStatus(int status) {
        this.status = status;
        return this;
    }

    public static Word from(ResultSet rs) {
        try {
            return new Word(
                    rs.getInt("Id_Words"),
                    rs.getString("Palabra1"),
                    rs.getString("Palabra2"),
                    rs.getString("Palabra3"),
                    rs.getInt("Status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


}
