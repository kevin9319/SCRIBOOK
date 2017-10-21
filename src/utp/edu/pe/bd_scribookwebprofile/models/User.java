package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String username;
    private String firtname;
    private String lastname;
    private String password;
    private String email;
    private String nickname;
    private String gender;
    private int status;

    public User(int id, String username, String firtname, String lastname, String password, String email, String nickname, String gender, int status) {
        this.id = id;
        this.username = username;
        this.firtname = firtname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.status = status;
    }


    public User() {
    }



    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public static User from(ResultSet rs) {
        try {
            return new User(
                    rs.getInt("Id_users"),
                    rs.getString("UserName"),
                    rs.getString("Firt_name"),
                    rs.getString("Last_name"),
                    rs.getString("Password"),
                    rs.getString("Email"),
                    rs.getString("Nickname"),
                    rs.getString("Gender"),
                    rs.getInt("Status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
