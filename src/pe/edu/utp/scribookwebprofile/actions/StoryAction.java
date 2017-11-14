package pe.edu.utp.scribookwebprofile.actions;
import pe.edu.utp.scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;

public class StoryAction extends ActionSupport{

    private int id;
    private String title;
    private String description;
    private int scoreTotal;
    private Date createDate;
    private int user;
    private int challenge;
    private Story story;

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

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getChallenge() {
        return challenge;
    }

    public void setChallenge(int challenge) {
        this.challenge = challenge;
    }

    public String execute() {
        return SUCCESS;
    }


    public String showStory(){
        try {
            ScService scservice = new ScService();
            Story story = scservice.findStoryByChallenge(id);
            id=story.getId();
            title=story.getTitle();
            description=story.getDescription();
            scoreTotal=story.getScoreTotal();
            createDate=story.getCreateDate();
            user=story.getUser().getId();
            challenge=story.getChallenge().getId();
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String createStory(){

        try {
            ScService service = new ScService();
            service.createStory(title,description,scoreTotal,createDate,story.getUser(),story.getChallenge());
            return SUCCESS;
        }catch(Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String updateStory(){
        try {
            ScService scservice = new ScService();
            scservice.updateStory(id,getTitle(),getDescription());
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String delete(){
        try {
            ScService service = new ScService();
            service.deleteStory(id);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }



}
