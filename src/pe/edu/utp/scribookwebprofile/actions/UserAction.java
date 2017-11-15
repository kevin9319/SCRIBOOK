package pe.edu.utp.scribookwebprofile.actions;
import pe.edu.utp.scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


public class UserAction extends ActionSupport implements SessionAware{

    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String nickName;
    private String gender;
    private int status;
    private int acti;


    private SessionMap<String,Object> sessionMap;

    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public int getActi() {
        return acti;
    }

    public void setActi(int acti) {
        this.acti = acti;
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


    public String execute() {
        id=0;

        if (acti==1) {
            HttpSession session = ServletActionContext.getRequest().getSession(true);

            try {
                ScService scservice = new ScService();
                User user = scservice.findUserByNamePassword(userName, password);
                id=user.getId();
                userName=user.getUserName();
                sessionMap.put("userId", id);
                sessionMap.put("userUserName", userName);
                return SUCCESS;
            }catch (Exception e){
                e.printStackTrace();
                return "input";
            }

        }

        if (acti==2) {
            sessionMap.remove("userId");
            sessionMap.remove("userUserName");
            sessionMap.invalidate();
        }


        return SUCCESS;
    }



}
