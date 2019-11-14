package Controller;

import DAO2.IClientDAOLocal;
import entities2.Client;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Named
@ViewScoped
public class ContactController implements Serializable {

    private String nom, email, tel;

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    private String adress;

    private Date date_naissance;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private ArrayList<Client> lesClients;

    private String message;
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public IClientDAOLocal getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(IClientDAOLocal clientDAO) {
        this.clientDAO = clientDAO;
    }

    private String company;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setLesClients(ArrayList<Client> lesClients) {
        this.lesClients = lesClients;
    }

    @EJB
    IClientDAOLocal clientDAO ;

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Client Edited", ((Client) event.getObject()).getNomClient());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Client c = (Client) event.getObject();
        clientDAO.edit(c);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Client) event.getObject()).getNomClient());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Client c = (Client) event.getObject();
        clientDAO.remove(c);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String add() {
        Client c = new Client();
        c.setNomClient(this.nom);
        c.setEmail(this.email);
        c.setTel(this.tel);
        clientDAO.create(c);
        return "GestionClient.xhtml";
    }

    @PostConstruct
    public void init() {
        lesClients = (ArrayList<Client>) clientDAO.findAll();
    }


    public ArrayList <Client> getLesClients() {
        return lesClients;
    }
//
//    public void setLesClients(ArrayList <Client> lesClients) {
//        this.lesClients = lesClients;
//    }
//
//    public void onRowCancel (RowEditEvit event){
//
//        Client c=((Client) event.getObject();
//    }
}
