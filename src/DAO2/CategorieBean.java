package DAO2;


import entities2.Categorie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless(name = "CategorieEJB")
public class CategorieBean extends GenericFacadeBean<Categorie> implements ICategorieDAO, ICategorieDAOLocal{

    private EntityManager em;

    public CategorieBean() {
    }

    public Long ajouterCategorie(Categorie c) {
        // TODO Auto-generated method stub
        em.persist(c);
        return c.getIdCategorie();
      //  return (Integer) query.getSingleResult( );
    }
}
