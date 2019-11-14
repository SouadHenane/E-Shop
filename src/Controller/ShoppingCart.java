package Controller;


import entities2.Produit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ShoppingCart implements Serializable {
    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    private List<Item> carts =new ArrayList<>();
    private double total;

    Produit p=new Produit();

    public List<Item> getCarts() {
        return carts;
    }

    public void setCarts(List<Item> carts) {
        this.carts = carts;
    }

    public double getTotal() {
        total=0.0;
        for(Item item: carts){
            total=total+(item.getQuantite()*item.getP().getPrix());
        }

        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCartsize() {
        cartsize= carts.size();
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }

    public ShoppingCart() {
    }

    public ShoppingCart(List<Item> carts, double total, int cartsize, String item) {
        this.carts = carts;
        this.total = total;
        this.cartsize = cartsize;
        this.item = item;
    }

    public String getItem() {


        if(cartsize>1){
            item="items";
        }
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String addToCart(Produit p) {
        if (carts.size() > 0) {
            for (Item item : carts) {
                if (item.getP().getIdProduit().equals(p.getIdProduit())) {
                    item.setQuantite(item.getQuantite() + 1);
                    return "carts";
                }
            }
        }
        Item i=new Item();
        i.setQuantite(1);
        i.setP(p);
        carts.add(i);
        System.out.println("I am here ...................");
        return "carts";
    }

    public void removeCart(Item i){
        for(Item item: carts){
            if(item.equals(i)){
                carts.remove(i);
                break;
            }
        }
    }


    int cartsize;
    String item="item";



}
