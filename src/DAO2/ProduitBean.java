package DAO2;


import entities2.Produit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "ProduitEJB")
public class ProduitBean extends GenericFacadeBean<Produit> implements IProduitDAO, IProduitDAOLocal {


    private EntityManager em;

    @Override
    public List<Produit> FindTitreById(String designation) {
        Query query = em.createQuery("SELECT p FROM Produit p where p.designation like :designation");
        query.setParameter("designation", designation);
        return query.getResultList();
    }
}
