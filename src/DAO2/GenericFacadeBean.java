package DAO2;


import entities2.Categorie;
import entities2.Produit;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Stateless(name = "GenericFacadeEJB")
public class GenericFacadeBean<T> implements IGenericDAO<T> {

    @PersistenceContext(unitName = "NewPersistenceUnit2")
    private EntityManager em;
    private Class<T> entityClass;

    private IGenericDAO dao;

    public GenericFacadeBean() {
        Type t=getClass().getGenericSuperclass();
        ParameterizedType pt=(ParameterizedType) t;
        this.entityClass=(Class<T>) pt.getActualTypeArguments()[0];
        }

    public void create(T entity) {
        em.persist(entity);
        }

    public void edit(T entity){
        em.merge(entity);
    };

    public void remove(T entity)
    {
        em.remove(em.contains(entity) ? entity : em.merge(entity));

    }

    public T find(Object id){
        return em.find(entityClass, id);
    };
    public List<T> findAll(){
        Query q = em.createQuery("select c from " + entityClass.getSimpleName() + " c");
        return q.getResultList( );
    };

    public Long count(){
        Query q = em.createQuery("select count(c) from " + entityClass.getSimpleName() + " c");
        return (Long) q.getSingleResult( );
    };

public List<T> listSelectionne() {

    Query q = em.createQuery("select p from " + entityClass.getSimpleName() + " p where p.selectionne = true");
    return q.getResultList( );
}

/*public int checkIfQueryExists(String query){
    List<T> products=em.createQuery("select p  from " +entityClass.getSimpleName()+ "p where p.idCategorie=:idCategorie").setParameter("idCategorie",query).getResultList();
    return products.size();
}*/

    public List<T> listProduitsParCategorie(Long idCat) {

        Query q = em.createQuery("select p from"+ entityClass.getSimpleName()+" p where  p.idCategorie = :x");
        q.setParameter("x", idCat);
        return q.getResultList();
    }

    public Produit getProduit(Long idProduit) {

        return em.find(Produit.class, idProduit);
    }

    public IGenericDAO getDao() {
        return dao;
    }

    public void setDao(IGenericDAO dao) {
        this.dao = dao;
    }


    public List<Produit> Findnom(String designation) {
        Query query = em.createQuery("SELECT l FROM Produit l where l.designation like :designation");
        query.setParameter("designation", designation);
        return query.getResultList();
    }

    public List<Produit> FindDescription(String description) {


        Query query = em.createQuery("SELECT l FROM Produit l where l.description like :description");
        query.setParameter("description", description);
        return query.getResultList();

    }
}

