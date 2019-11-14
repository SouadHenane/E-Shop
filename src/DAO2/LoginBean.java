package DAO2;

import entities2.Login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "LoginEJB")
public class LoginBean extends GenericFacadeBean<Login> implements ILoginDao{
    public LoginBean() {
    }
    @PersistenceContext(unitName = "NewPersistenceUnit2")
    private EntityManager em;


@Override
    public String Username() {
        Query query = em.createQuery("Select e.Username FROM Login e");
        return (String) query.getSingleResult( );

    }

@Override
    public String Password() {
        Query query = em.createQuery("Select e.Password FROM Login e  ");
        return (String) query.getSingleResult();
    }

}
