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
    private String msgstory;
    private Story story;
    private String TitleORStory;
    private Winner winner;
    private List<Challenge> challenges;
    private int countw;


    public int getCountw() {
        return countw;
    }

    public void setCountw(int countw) {
        this.countw = countw;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public String getTitleORStory() {
        return TitleORStory;
    }

    public void setTitleORStory(String titleORStory) {
        TitleORStory = titleORStory;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public String getMsgstory() {
        return msgstory;
    }

    public void setMsgstory(String msgstory) {
        this.msgstory = msgstory;
    }

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
        //Buscar todas los cuentos relacionadas a un reto
        if (chStory==1) {

            ScService service = new ScService();
            stories=null;

            stories=service.findStoryByChallenge(challenge.getId());


            ScService winservice = new ScService();
            countw=winservice.getWinnerCountChallenge(challenge);
            if(countw>0){
                winner=null;
                ScService wiservice = new ScService();
                winner=new Winner();
                winner=wiservice.findWinnerByUser(challenge.getId());
            }




        }

        //crear cuento
        if (chStory==2) {
            msgstory="";
            ScService service = new ScService();
            service.createStory(title,description,scoreTotal,createDate,user,challenge);
            msgstory="Cuento Creado";

        }


        //ir jsp para crear cuento
        if (chStory==3){


        }

        //puntuación de los cuentos
        if (chStory==4){
            ScService servicecountuser = new ScService();
            int us=servicecountuser.getScoreCountUser(story,user);
            int status=1;

            if (us<1){
                ScService service = new ScService();
                service.createScore(status,story,user);
                ScService serviceupdate = new ScService();
                serviceupdate.updateStoryScore(story.getId());
            }

            stories=null;

            ScService serviceall = new ScService();
            stories=serviceall.findStoryByChallenge(challenge.getId());



        }

        //Mostrar mis Cuentos
        if (chStory==5){
            stories=null;
            ScService service = new ScService();
            stories=service.findStoryByUser(user.getId());

        }


        if (chStory==6){
            stories=null;
            ScService service = new ScService();
            stories=service.findStoryByTitleORStory(TitleORStory);
        }

        if (chStory==7){
            story=null;
            ScService service = new ScService();
            story=new Story();
            story=service.findStoryByChallengeWinner(challenge.getId());
            ScService createservice = new ScService();
            createservice.createWinner(challenge,story.getUser());
            ScService updateservice = new ScService();
            updateservice.updateChallengeStatus(challenge.getId(),1);
            challenges=null;

            ScService showservice = new ScService();
            challenges=showservice.findChallengeByUser(user.getId());

        }



        return SUCCESS;
    }



}
