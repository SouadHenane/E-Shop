package Controller;

import DAO2.ICartDAO;
import DAO2.IProduitDAO;
import entities2.Cart;
import entities2.Produit;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped
public class CartController implements Serializable {

    @EJB
       private ICartDAO cartDAO;

    @EJB
            private IProduitDAO p;
    Produit produit;

    Long idProduit;

    public void delete(Cart c){
        this.cartDAO.remove(c);
    }



@ManagedProperty("#{cart}")
    Cart cartt=new Cart();

    public CartController(Cart cartt, List<Cart> cartList, Produit produit, String productName, int productId, int quantite, String selectedzone, double price, double total, Map<Integer, Cart> map, int cartsize, String item) {
        this.cartt = cartt;
        this.cartList = cartList;
        this.produit = produit;
        this.productName = productName;
        this.productId = productId;
        this.quantite = quantite;
        this.selectedzone = selectedzone;
        this.price = price;
        this.total = total;
        this.map = map;
        this.cartsize = cartsize;
        this.item = item;
    }

   private List<Cart> cartList =new ArrayList<Cart>();



    public ICartDAO getCartDAO() {
        return cartDAO;
    }

    public void setCartDAO(ICartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public Cart getCartt() {
        return cartt;
    }

    public void setCartt(Cart cartt) {
        this.cartt = cartt;
    }

    public CartController() {

    }

  private String productName;

    public String getSelectedzone() {
        return selectedzone;
    }

    public void setSelectedzone(String selectedzone) {
        this.selectedzone = selectedzone;
    }

  private   int productId;
    int quantite;
  private   String selectedzone;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
 double price;
    double total;

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setTotal(double total) {
        this.total = total;
    }

    public Map<Integer, Cart> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Cart> map) {
        this.map = map;
    }

    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;

    }

    public CartController(Cart cartt) {
        this.cartt = cartt;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    Map<Integer, Cart> map=new HashMap<Integer, Cart>();
    int cartsize;
    String item="item";

    public IProduitDAO getP() {
        return p;
    }

    public void setP(IProduitDAO p) {
        this.p = p;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }





    public double getTotal() {

        return    total;
    }

    public List<Cart> findAll(){return this.cartDAO.findAll();}

    public String processCart(int qty){

        quantite=qty;
        cartt.setProductId(productId);
        cartt.setProductName(productName);
        System.out.println(quantite+"--------------");
        cartt.setPrice(price);
        cartt.setQuantite(quantite);
        cartt.setTotal(cartt.getPrice() * cartt.getQuantite());

        cartList.add(cartt);

        map.size();
        map.put(productId,cartt);
        cartsize= cartList.size();
        this.cartDAO.create(this.cartt);
        this.cartt=new Cart();


        return null;
    }

    private List<Item> carts=new ArrayList<>();

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cart Edited", ((Cart) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Cart c = (Cart) event.getObject();
        this.cartDAO.edit(c);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Cart) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Cart c = (Cart) event.getObject();
        cartDAO.remove(c);

    }

    public String edit(Cart cartt){
        this.cartt=cartt;
        return "edit";
    }
    public String edit(){
        this.cartDAO.edit(this.cartt);
        return "viewcart";
    }


    public String payment(){
        return "payment";
    }
//int quantite=1;


}
