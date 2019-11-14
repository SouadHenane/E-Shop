package DAO2;


import entities2.Commande;

import javax.ejb.Stateless;

@Stateless(name = "CommandeEJB")
public class CommandeBean extends GenericFacadeBean<Commande> implements ICommandeDAO, ICommandeDAOLocal{}
