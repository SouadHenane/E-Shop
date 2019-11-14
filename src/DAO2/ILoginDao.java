package DAO2;

import entities2.Login;

import javax.ejb.Remote;

@Remote
public interface ILoginDao extends IGenericDAO<Login> {

    String Username();
    String Password();
}
