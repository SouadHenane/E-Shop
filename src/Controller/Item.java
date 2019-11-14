package Controller;

import entities2.Produit;

public class Item {
    private Produit p;
    private int quantite;

    public Produit getP() {
        return p;
    }

    public Item(Produit p, int quantite) {
        this.p = p;
        this.quantite = quantite;
    }

    public void setP(Produit p) {

        this.p = p;
    }

    public Item() {
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
