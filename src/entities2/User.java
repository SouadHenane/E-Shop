package entities2;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="users" )
public class User implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="user_id")
	private Long idUser;
	@Column(nullable = false, length = 20)
	private String Nom;


	@Column(nullable = false, length = 20)
	private String Prenom;

	@Past
	private Date date_naissance;


	private String adresse;

	@Column(unique = true)
	private String email;
	private boolean activated;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public User(String nom, String prenom, @Past Date date_naissance, String adresse, String email, Collection<Role> roles, Login login) {
		Nom = nom;
		Prenom = prenom;

		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.email = email;
		this.roles = roles;
		this.login = login;
	}

	@OneToMany
		@JoinColumn(name="user_id")

	private Collection<Role> roles;

	@OneToOne
	private Login login;


	public User() {
	}
}
