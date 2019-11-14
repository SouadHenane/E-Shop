package DAO2;


import entities2.Commande;

import javax.ejb.Remote;

@Remote
public interface ICommandeDAO extends IGenericDAO<Commande> {
}
