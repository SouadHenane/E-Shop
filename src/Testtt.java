import DAO2.ICategorieDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Testtt", urlPatterns = "/testtt")
public class Testtt extends HttpServlet {





    @EJB
    private ICategorieDAO c;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        try{
            out.println("<html><head><Title>Servler SearchDepartement</Title></head>");
            //out.println("<body>");
            out.println("<body><h1>Ajouter un Departement</h1>");
           /* Projet p1 = new Projet();
            p1.setNom("Peace");
            p1.setDateDebut(new Date());
            p1.setDateFin(new Date());


                 Pr.create(p1);

        /*   Employe c=new Employe();

            c.setNom("Asmaa"); c.setPrenom("Soniaa");
            c.setEmail("asmaa@gmail.com");
            c.setAdresse(new Adresse("hydra",41,"alger"));
            c.setDateNaissance(new Date());
            c.setDateEmbauche(new Date());
            c.setNumsecurite(6);
            c.setGenre(Civility.Mme);
            c.setAge(22);
            Ec.create(c);*/


            out.println("<h1>Liste des Departements</h1>");

            out.println("<ul>");


            out.println("</ul></body></html>");
        }finally {
            out.close();
        }
    }
}
