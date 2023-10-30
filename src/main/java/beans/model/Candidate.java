package beans.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class Candidate {
    
    private String name;
    private String lastname;
    private int desiredSalary;
    private Date birthdate;
    private String postalCode;
    private String city;
    private String comment;
    private int coloniaId;
    
    Logger log = LogManager.getRootLogger();

    public Candidate() {
        log.info("Creating the Candidate object");
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
        log.info("Modifying the lastname property: " + this.lastname);
    }
    
    public int getDesiredSalary() {
        return desiredSalary;
    }
    public void setDesiredSalary(int desiredSalary) {
        this.desiredSalary = desiredSalary;
    }
    
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        log.info("Modifying the name property: " + this.name);
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getColoniaId() {
        return coloniaId;
    }
    public void setColoniaId(int coloniaId) {
        this.coloniaId = coloniaId;
    }
}
