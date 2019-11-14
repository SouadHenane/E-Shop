package Controller;

import DAO2.ILoginDao;
import entities2.Login;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.eclipse.persistence.exceptions.OptimisticLockException;
import org.eclipse.persistence.queries.DataModifyQuery;
import org.eclipse.persistence.queries.DatabaseQuery;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named
@ViewScoped
public class LoginControlleur implements Serializable {

    @EJB
    ILoginDao loginDao;


    Login login = new Login();

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
//
//    String username;
//    String password;
//
//    public LoginControlleur(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    public LoginControlleur() {
    }


//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }


    public String log() {
        if (login.getUsername().equals("name") && login.getPassword().equals("password"))
            return "Produit";

        return "Produit";
}
//    public String log() {
//        if (login.getUsername().equals("name") && login.getPassword().equals("password"))
//            return "adminProduit";
//
//
//        return "adminProduit";
//    }

//     public String log(){
//        if(loginDao.log()==true)
//            return "Employe";
//        return "Employe";
//     }
//}
}