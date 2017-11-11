package utp.edu.pe.bd_scribookwebprofile.actions;
import utp.edu.pe.bd_scribookwebprofile.models.*;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction  extends ActionSupport {

    private int id;
    private String description;
    private String shortDescription;
    private int Status;
    private Category category;

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

    public String execute() {
        return SUCCESS;
    }

    public String showCategory(){
        try {
            ScService scservice = new ScService();
            scservice.findAllCategories();
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String add(){
        category = new Category(id,description,shortDescription,Status);
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



}
