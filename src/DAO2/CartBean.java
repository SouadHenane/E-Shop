package DAO2;

import entities2.Cart;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Stateless(name = "CartEJB")
public class CartBean extends GenericFacadeBean<Cart> implements ICartDAO, ICartDAOLocal{
    public CartBean() {
    }
    @PersistenceContext(unitName = "NewPersistenceUnit2")
    private EntityManager em;

    @Override
    public Cart getCart(Long idCart) {
        // TODO Auto-generated method stub
        return em.find(Cart.class, idCart);
    }


}
