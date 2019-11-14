package DAO2;

import entities2.Client;

import javax.ejb.Stateless;

@Stateless(name = "ClientEJB")
public class ClientBean extends GenericFacadeBean<Client> implements IClientDAO, IClientDAOLocal{}
