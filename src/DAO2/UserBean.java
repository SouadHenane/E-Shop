package DAO2;


import entities2.User;

import javax.ejb.Stateless;

@Stateless(name = "UserEJB")
public class UserBean extends GenericFacadeBean<User> implements IUserDAO,IUserDAOLoal{
}
