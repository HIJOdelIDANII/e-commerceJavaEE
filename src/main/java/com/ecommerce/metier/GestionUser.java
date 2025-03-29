package com.ecommerce.metier;

import com.ecommerce.dao.IGestionUserDAO;
import com.ecommerce.dao.GestionUserDAO;

public class GestionUser implements IGestionUser {

    private IGestionUserDAO userDAO;

    /**
     * No-args constructor for default usage in controllers:
     * e.g.  this.gestionUser = new GestionUser();
     */
    public GestionUser() {
        this.userDAO = new GestionUserDAO();
    }

    /**
     * Optional constructor to allow explicit DAO injection.
     */
    public GestionUser(IGestionUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void creerUser(User user) {
        userDAO.ajouterUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.trouverUserParId(id);
    }

    @Override
    public boolean login(String username, String password) {
        return userDAO.verifierIdentifiants(username, password);
    }

    @Override
    public void updateUser(User user) {
        userDAO.modifierUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.supprimerUser(id);
    }
}
