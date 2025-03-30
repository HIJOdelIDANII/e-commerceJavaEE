package com.ecommerce.metier;

public interface IGestionUser {

    void creerUser(User user);

    User getUserById(int id);
    boolean login(String username, String password);

    void updateUser(User user);

    void deleteUser(int id);
}
