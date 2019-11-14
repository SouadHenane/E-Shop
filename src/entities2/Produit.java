package entities2;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="produits")
public class Produit implements Serializable {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
		@NotEmpty
		@Size(min=4, max=15)
	private String designation;
	private String description;
	private double prix;
	private int quantite;


	private boolean selectionne;
	@Lob
	private byte[] photo;
	private String namePhoto;

	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;

	public Cart getCartt() {
		return cartt;
	}

	public void setCartt(Cart cartt) {
		this.cartt = cartt;
	}

	//private Collection<LigneCommande> lignes;
	@ManyToOne
	@JoinColumn(name="idCart")
	private Cart cartt;
	


	public Produit() {
		super();
	}

	public byte[] getPhoto() {
		return photo;
	}

	public Produit(@NotEmpty @Size(min = 4, max = 15) String designation, String description, double prix, int quantite, String namePhoto) {
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;

		this.namePhoto = namePhoto;

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

	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public boolean isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
