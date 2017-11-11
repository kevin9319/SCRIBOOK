package utp.edu.pe.bd_scribookwebprofile.actions;
import utp.edu.pe.bd_scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
public class KeywordAction extends ActionSupport{

    private int id;
    private String name;
    private int status;
    private Keyword keyword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String showKeyword(){
        try {
            ScService scservice = new ScService();
            scservice.findAllKeywords();
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }


}
