package com.ecommerce.dao;

import com.ecommerce.metier.User;

public interface IGestionUserDAO {
    boolean verifierIdentifiants(String username, String password);
    void ajouterUser(User user);
    User trouverUserParId(int id);
    void modifierUser(User user);
    void supprimerUser(int id);
}
