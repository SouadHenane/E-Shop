import DAO2.IProduitDAO;
import entities2.Produit;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class RingView implements Serializable {


    @EJB
    private IProduitDAO p;

    public RingView() {
    }

    Produit produit=new Produit();
    private Produit selectionne;
    private List<Produit> produits;

    public IProduitDAO getP() {
        return p;
    }

    public void setP(IProduitDAO p) {
        this.p = p;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Produit getSelectionne() {
        return selectionne;
    }

    public void setSelectionne(Produit selectionne) {
        this.selectionne = selectionne;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @PostConstruct
    public void init() {
        produits = new ArrayList<Produit>();

        produits.add(new Produit("Eye Glasses","A rounded eye glasses for more fashion,with coloe purple",3165.00,4656,"women1.jpg"));
        produits.add(new Produit("Eye Glasses","A rounded eye glasses for more fashion,with coloe purple",3165.00,4656,"women2.jpg"));
        produits.add(new Produit("Eye Glasses","A rounded eye glasses for more fashion,with coloe purple",3165.00,4656,"women3.jpg"));
        produits.add(new Produit("Eye Glasses","A rounded eye glasses for more fashion,with coloe purple",3165.00,4656,"women4.jpg"));
        produits.add(new Produit("Eye Glasses","A rounded eye glasses for more fashion,with coloe purple",3165.00,4656,"women5.jpg"));

    }

}