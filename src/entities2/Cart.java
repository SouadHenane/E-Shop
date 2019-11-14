package entities2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCart;
    private String productName;
    int quantite;
    String selectedzone;

    double price;
    double total= quantite *price;

    @OneToMany(mappedBy = "cartt")
    private Collection<Produit> produitss;

    int productId;

    public int getProductId() {
        return productId;
    }

    public Cart(String productName, int quantite, String selectedzone, double price, double total, Collection<Produit> produitss, int productId) {
        this.productName = productName;
        this.quantite = quantite;
        this.selectedzone = selectedzone;
        this.price = price;
        this.total = total;
        this.produitss = produitss;
        this.productId = productId;
    }

    public void setProductId(int productId) {

        this.productId = productId;

    }

    public Collection<Produit> getProduitss() {
        return produitss;
    }

    public void setProduitss(Collection<Produit> produitss) {
        this.produitss = produitss;
    }

    public Long getIdCart() {
        return idCart;
    }

    public Cart(Collection<Produit> produitss, double total) {
        this.produitss = produitss;

        this.total = total;
    }

    public void setIdCart(Long idCart) {

        this.idCart = idCart;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getSelectedzone() {
        return selectedzone;
    }

    public void setSelectedzone(String selectedzone) {
        this.selectedzone = selectedzone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cart() {
    }



    public double getTotal() {
        return total+=quantite*price;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
