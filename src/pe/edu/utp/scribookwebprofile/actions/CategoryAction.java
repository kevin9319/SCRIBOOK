package pe.edu.utp.scribookwebprofile.actions;
import pe.edu.utp.scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
public class CategoryAction  extends ActionSupport {
    private int id;
    private String description;
    private String shortDescription;
    private int Status;

    private List<Category> categories;


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    private int act;

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }





    public String showCategory(){
        try {
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String add(){
        Category category = new Category(id,description,shortDescription,Status);
        try {
            ScService service = new ScService();
            service.createCategory(category);
            return SUCCESS;
        }catch(Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String delete(){
        try {
            ScService service = new ScService();
            service.deleteCategory(id);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }


    public String execute() {
        if (act==1) {
            ScService service = new ScService();
            Category category = service.findCategoryById(1);
            id = category.getId();
            description = category.getDescription();
            category=null;
        }

        if (act==2) {
            ScService service = new ScService();
            Category category = service.findCategoryById(2);
            id = category.getId();
            description = category.getDescription();
            category=null;
        }

        if (act==3) {
            categories=null;
            ScService service = new ScService();
            categories= service.findAllCategories();

        }


        return SUCCESS;
    }

}
