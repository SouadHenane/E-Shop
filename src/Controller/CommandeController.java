package Controller;


import DAO2.ICategorieDAO;
import DAO2.IClientDAO;
import DAO2.ICommandeDAO;
import DAO2.IProduitDAO;
import entities2.Categorie;
import entities2.Client;
import entities2.Commande;
import entities2.Produit;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class CommandeController  implements Serializable {

    @EJB
    private ICommandeDAO c;
    @EJB
    private IClientDAO clientDAO;


    Commande commande=new Commande();

    public ICommandeDAO getC() {
        return c;
    }

    public void setC(ICommandeDAO c) {
        this.c = c;

    }

    public IClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Commande getCommande() {
        return commande;
    }

    public CommandeController(Commande commande, Client client, Long idClient) {
        this.commande = commande;
        this.client = client;
        this.idClient = idClient;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    Client client;
    Long idClient;


//    @EJB
//    private IProduitDAOLocal p;

//    private Produit produit=new Produit();
//
//    public IProduitDAOLocal getP() {
//        return p;
//    }

    public CommandeController(Commande commande) {
        this.commande = commande;
    }

//    public void setP(IProduitDAOLocal p) {
//        this.p = p;
//    }

    public CommandeController() {
    }
    public List<Commande> findAll(){return this.c.findAll();}

    //public List<Commande> listSelectionne(){return this.c.listSelectionne();}
   // public List<Commande> listProduitsParCategorie (Long idClient){return this.c.listProduitsParCategorie(idClient);}
    public String add2(){

        this.commande.setClient(this.clientDAO.find(idClient));
        this.c.create(this.commande);
        return "Commandes";


    }


}




