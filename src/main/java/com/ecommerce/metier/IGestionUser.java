package com.ecommerce.metier;

public interface IGestionUser {
    // Créer un nouvel utilisateur
    void creerUser(User user);

    // Récupérer un utilisateur par son ID
    User getUserById(int id);

    // Vérifier login (retourne true si correct, false sinon)
    boolean login(String username, String password);

    // Mettre à jour les informations d'un utilisateur
    void updateUser(User user);

    // Supprimer un utilisateur
    void deleteUser(int id);
}
