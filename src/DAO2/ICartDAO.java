package DAO2;

import entities2.Cart;

import javax.ejb.Remote;

@Remote
public interface ICartDAO extends IGenericDAO<Cart> {
    @Override
    void remove(Cart entity);
    Cart getCart(Long idCart);

}
