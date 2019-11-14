package DAO2;


import entities2.User;

import javax.ejb.Remote;

@Remote
public interface IUserDAO extends IGenericDAO<User> {
}
