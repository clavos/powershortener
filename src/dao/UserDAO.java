package dao;

import bean.User;

public interface UserDAO {

    void creer( User utilisateur ) throws DAOException;

    User trouver( String email ) throws DAOException;

}