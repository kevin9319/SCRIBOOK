package pe.edu.utp.scribookwebprofile.actions;

import pe.edu.utp.scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class ChallengeAction extends ActionSupport{

    private int id;
    private String title;
    private String description;
    private int status;
    private Date createDate;
    private Date lastDate;
    private Category category;
    private User user;
    private int chAct;
    private String dateeeee;
    private List<Challenge> challenges;
    private List<Category> categories;
    private String msgalerta;


    public String getMsgalerta() {
        return msgalerta;
    }

    public void setMsgalerta(String msgalerta) {
        this.msgalerta = msgalerta;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public int getChAct() {
        return chAct;
    }

    public void setChAct(int chAct) {
        this.chAct = chAct;
    }



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

            //ScService scservice = new ScService();
            //scservice.createChallenge(title,description,status,createDate,lastDate,category,user);
        //Buscar los retos por categoria
        if (chAct==1) {
                ScService service = new ScService();
                challenges=service.findChallengeByCategory(category.getId());

                category=service.findCategoryById(category.getId());



        }

        //Crear reto
        if (chAct==2) {
            ScService service = new ScService();
            service.createChallenge(title,description,status,createDate,lastDate,category,user);
            msgalerta="Reto Creado";
        }


        //Mostrar Categorias
        if (chAct==3) {
            ScService service = new ScService();
            categories=service.findAllCategories();

        }

        //Mostrar Mis Retos
        if (chAct==4) {
            ScService service = new ScService();
            challenges=service.findChallengeByUser(user.getId());


        }



        return SUCCESS;
    }



}
