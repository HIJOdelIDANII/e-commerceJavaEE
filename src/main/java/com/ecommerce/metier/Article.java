package com.ecommerce.metier;

public class Article {
    private int id;
    private String titre;
    private String description;
    private double prix;


    public Article() {}

    public Article(int id, String titre, String description, double prix) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
}
