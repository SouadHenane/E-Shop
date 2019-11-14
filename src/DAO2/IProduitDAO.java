package DAO2;


import entities2.Produit;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IProduitDAO extends IGenericDAO<Produit> {

//    Produit returnProducts(String query);

    public List<Produit> FindTitreById(String designation);
}

