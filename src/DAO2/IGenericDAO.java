package DAO2;

import entities2.Categorie;
import entities2.Produit;

import java.util.List;

public interface IGenericDAO<T> {
    void create(T entity);
    void edit(T entity);
    void remove(T entity);

    T find(Object id);
    List<T> findAll();
    List<T> listSelectionne();
    Long count();
List<T>listProduitsParCategorie(Long idCat);
    List<Produit> Findnom(String designation);
    List<Produit> FindDescription(String description);
    public Produit getProduit(Long idPro);
}
