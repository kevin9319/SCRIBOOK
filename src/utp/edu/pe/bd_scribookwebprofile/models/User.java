package utp.edu.pe.bd_scribookwebprofile.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String nickName;
    private String gender;
    private int status;




    public User() {
    }

    public User(int id, String userName, String firstName, String lastName, String password, String email, String nickName, String gender, int status) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.gender = gender;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static User from(ResultSet rs) {
        try {
            return new User(
                    rs.getInt("Id"),
                    rs.getString("UserName"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
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
