package entities2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Commande implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;
	private Date dateCommande;
	//private User user;
	
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> lignes;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<LigneCommande> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<LigneCommande> lignes) {
		this.lignes = lignes;
	}
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	
	public Commande() {
		super();
	}
	
	

}
