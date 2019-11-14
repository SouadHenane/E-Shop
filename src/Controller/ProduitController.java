package Controller;

import DAO2.ICategorieDAO;
import DAO2.IProduitDAO;
import DAO2.IProduitDAOLocal;
import com.sun.faces.action.RequestMapping;
import entities2.Categorie;
import entities2.Produit;
import org.apache.commons.io.FileUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ProduitController  implements Serializable {

    @EJB
    private IProduitDAO p;
    @EJB
    private ICategorieDAO categorieDAO;


//    public void onRowEdit(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Client Edited", ((Produit) event.getObject()).getDesignation());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        Produit pro = (Produit) event.getObject();
//        p.edit(pro);
//    }
//
//    public void onRowCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Produit) event.getObject()).getDesignation());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        Produit pro = (Produit) event.getObject();
//        p.remove(pro);
//    }


    private String SearchWord;
    private List<Produit> produitResult =new ArrayList<>();

    public String getSearchWord() {
        return SearchWord;
    }

    public void setSearchWord(String searchWord) {
        SearchWord = searchWord;
    }

    public List<Produit> getProduitResult() {
        return produitResult;
    }

    public void setProduitResult(List<Produit> produitResult) {
        this.produitResult = produitResult;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }
    ;

    private Long idProduit;
    public String SearchBydesgination(){

        if(String.valueOf(SearchWord)==null)
        {
            this.produitResult=p.findAll();
        }
        else
        {
            this.produitResult=p.Findnom(SearchWord);
        }
        return "liste";


    }


    Produit produit=new Produit();

    Categorie categorie;
    Long idCat;



    private byte[] photo;
    private String namePhoto;

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    private Produit selectionne;

    public Produit getSelectionne() {
        return selectionne;
    }

    public void setSelectionne(Produit selectionne) {
        this.selectionne = selectionne;
    }

    public IProduitDAO getP() {
        return p;
    }

    public void setP(IProduitDAO p) {
        this.p = p;
    }


    public ICategorieDAO getCategorieDAO() {
        return categorieDAO;
    }

    public void setCategorieDAO(ICategorieDAO categorieDAO) {
        this.categorieDAO = categorieDAO;
    }

    public Categorie getCategorie() {

        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

//    private Produit produit=new Produit();
//
//    public IProduitDAOLocal getP() {
//        return p;
//    }

    public ProduitController(Produit produit) {
        this.produit = produit;
    }

//    public void setP(IProduitDAOLocal p) {
//        this.p = p;
//    }

    public Produit getProduit() {
        return produit;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public ProduitController() {
    }
    public List<Produit> findAll(){return this.p.findAll();}

    public List<Produit> listSelectionne(){return this.p.listSelectionne();}
    public List<Produit> listProduitsParCategorie (Long idCat){return this.p.listProduitsParCategorie(idCat);}
//    public void supprimerProduit(Long idPro){
//        this.produit=produit;
//    }
//
//    public String add() {
//
//        this.p.create(this.produit);
//
//        this.produit= new Produit();
//        return "Produit";
//    }


    public String add2(){

        upload();

        this.produit.setCategorie(this.categorieDAO.find(idCat));
        this.p.create(this.produit);

        return "Produit";


    }

//    public String delete(){
//
//        this.produit.setCategorie(this.categorieDAO.find(idCat));
//        this.p.remove(this.produit);
//        return "Produit";
//
//
//    }



    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload(){
        if(file!=null){
            try{
                FacesContext context=FacesContext.getCurrentInstance();
                ServletContext servletcontext=(ServletContext)context.getExternalContext().getContext();
                String dbpath=servletcontext.getRealPath("/");
                String webcut=dbpath.substring(0,dbpath.lastIndexOf("\\"));
                String buildcut=webcut.substring(0,webcut.lastIndexOf("\\"));
                String mainURLPath=buildcut.substring(0,buildcut.lastIndexOf("\\"));
                InputStream inputStream =file.getInputstream();
                String path=mainURLPath+"\\TestJPA_DAO\\web\\resources\\images\\"+ file.getFileName();
                File destFile=new File(path);
                FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);

                if(!destFile.exists()){
                    FileUtils.copyInputStreamToFile(inputStream,destFile);
                }
                produit.setNamePhoto(file.getFileName().toString());
            }catch(Exception e){
               e.printStackTrace();
            }
        }
    }
}







