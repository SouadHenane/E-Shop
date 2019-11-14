package Controller;

import DAO2.ICategorieDAO;
import DAO2.ICategorieDAOLocal;
import entities2.Categorie;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@RequestScoped
public class CatgorieController implements Serializable {

    @EJB

    private ICategorieDAO c;
    private Categorie cat=new Categorie();

    public CatgorieController() {
    }

    public CatgorieController(Categorie cat) {
        this.cat = cat;
    }

    public void setC(ICategorieDAOLocal c) {
        this.c = c;
    }

    public ICategorieDAO getC() {
        return c;
    }

    public void setC(ICategorieDAO c) {
        this.c = c;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    public List<Categorie> findAll(){return this.c.findAll();}

    public String add() {

        cat.setNomCategorie(cat.getNomCategorie());
        cat.setDescription(cat.getDescription());
        this.c.create(cat);
        return null;
//
//        this.c.create(this.cat);
//
//        this.cat= new Categorie();
//        return "Categorie";
    }

}


