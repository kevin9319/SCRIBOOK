package utp.edu.pe.bd_scribookwebprofile.actions;
import utp.edu.pe.bd_scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String nickName;
    private String gender;
    private int status;


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


    public String execute() {
        return SUCCESS;
    }


    public String addUser(){
        try {
            ScService service = new ScService();
            User user = service.createUser(getUserName(), getFirstName(),getLastName(),getPassword(),getEmail(),getNickName(),getGender(),getStatus());
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String login(){
        try {
                ScService scservice = new ScService();
                User user = scservice.findUserByNamePassword(userName, password);
                id=user.getId();
                userName=user.getUserName();
                return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String logout(){
        id = 0;
        userName = "";
        return SUCCESS;
    }


}
