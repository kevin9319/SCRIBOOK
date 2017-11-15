package pe.edu.utp.scribookwebprofile.actions;

import pe.edu.utp.scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ChallengeAction extends ActionSupport{

    private int id;
    private String title;
    private String description;
    private int status;
    private Date createDate;
    private Date lastDate;
    private Category category;
    private User user;
    private String dateeeee;

    public String getDateeeee() {
        return dateeeee;
    }

    public void setDateeeee(String dateeeee) {
        this.dateeeee = dateeeee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() {

            ScService scservice = new ScService();
            scservice.createChallenge(title,description,status,createDate,lastDate,category,user);


        return SUCCESS;
    }

    public String showChallenge(){
        try {
            ScService scservice = new ScService();
            Challenge challenge = scservice.findChallengeByCategory(category.getId());
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }
}
