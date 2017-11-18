package pe.edu.utp.scribookwebprofile.actions;
import pe.edu.utp.scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.util.List;

public class StoryAction extends ActionSupport{

    private int id;
    private String title;
    private String description;
    private int scoreTotal;
    private Date createDate;
    private User user;
    private Challenge challenge;

    private int chStory;

    private List<Story> stories;


    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public int getChStory() {
        return chStory;
    }

    public void setChStory(int chStory) {
        this.chStory = chStory;
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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public String execute() {
        //Buscar todas las historias relacionadas a un reto
        if (chStory==1) {
            ScService service = new ScService();
            stories=service.findStoryByChallenge(challenge.getId());
        }


        return SUCCESS;
    }



}
