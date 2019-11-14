package Controller;

import DAO2.IUserDAO;
import entities2.User;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class UserController implements Serializable {


    public UserController() {
    }

    public IUserDAO getU() {

        return u;
    }

    public void setU(IUserDAO u) {
        this.u = u;
    }

    @EJB

    private IUserDAO u;

    public List<User> findAll(){return this.u.findAll();}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setAdresse(String adresse) {

        this.adresse = adresse;
    }

    User user=new User();

    private String nom,prenom,email,adresse;

private Date date_naissance;
    public String add() {

        user.setNom(user.getNom());
        user.setPrenom(user.getPrenom());
        user.setDate_naissance(user.getDate_naissance());
        user.setEmail(user.getEmail());
        user.setAdresse(user.getAdresse());
        this.u.create(user);
        return "Welcome";}
}
