

import entities2.Client;

import javax.persistence.*;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Test {

    public static void main(String ...args){

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em=emf.createEntityManager();

        EntityTransaction trans = null;
        try {
            trans = em.getTransaction( );
            Client c = new Client( );

            trans.begin();

            c.setNomClient("tyy1dduzz");
            c.setEmail("a.malki1fzzfffd@esi-sba.dz");
            //  c.setTelephone("0797125648");

            // DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
            // c.setDateNaissance(df.parse("2019-10-10"));

            // ad.setNumero(121);            ad.setRue("da");
            //  ad.setCodePostal("22000");   ad.setVille("sidi bel abbes");
            // c.setAdresse(ad);

            em.persist(c);
            trans.commit( );



            /*em.getTransaction().begin();

            Employe emp =new Employe();
           /* e.setNom("Henane");
            e.setPrenom("Souad");
            e.setGenre(Genre.Melle);
            e.setEmail("s.henane@esi-sba.dz");
            e.setDateNaissance(new Date());

            em.persist(e);

            emp.setNom("esdfgh");
            emp.setPrenom("xcvbn");
            emp.setGenre(Genre.Melle);
            emp.setEmail("s.wxcvbn,@esi-sba.dz");
            emp.setDateNaissance(new Date());

            em.persist(emp);

            em.getTransaction().commit();*/


        }catch (Exception e){

            e.printStackTrace();// em.getTransaction().rollback();
        }
    }

}
