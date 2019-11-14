package DAO2;


import entities2.Client;

import javax.ejb.Remote;

@Remote
public interface IClientDAO extends IGenericDAO<Client> {
}
