package entities2;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="categorie")
public class Categorie implements Serializable{
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
		@NotEmpty
		@Size( min = 4 , max = 20)
	private String nomCategorie;
		@Size(min = 5, max= 500)
	private String description;
		@Lob
	private byte[] photo;
	private String nomPhoto;
	
	@OneToMany(mappedBy = "categorie")
	private Collection<Produit> produits;
	
	
	
	public Categorie() {
		//super();
	}
	public Categorie(Long idCategorie, String nomCategorie, String description, byte[] photo, String nomPhoto,
			Collection<Produit> produits) {
		//super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;

		this.produits = produits;
	}
	
	
	/*public Categorie(String nomCategorie, String description, byte[] photo, String nomPhoto) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}*/
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	
	

}
