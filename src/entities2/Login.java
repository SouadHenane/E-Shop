package entities2;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity

@XmlRootElement
@NamedQueries({
        @NamedQuery(name="login.control",query = "select l from Login l where l.Username=:username and l.Password=:password")
})

public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idlogin;


    @Column( length = 20)
    private String Username;




    @Column( length = 20)
    private String Password;

    @OneToOne
    private User user;


    public Login() {
    }

    public Login(String username, String password) {
        Username = username;
        Password = password;
    }


    public String getUsername() {
        return Username;
    }

    public int getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(int idlogin) {
        this.idlogin = idlogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Login(String username, String password, User user) {
        Username = username;
        Password = password;
        this.user = user;
    }
}
