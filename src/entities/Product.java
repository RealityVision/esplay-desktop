/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author slimd
 */
public class Product {
    private  int id;
    private String refernce;
    private String description;
    private float prix;
    private String image;
    private String categorie;
    private int id_client;
    private boolean activer;
    
    
    public Product() {
    }

    public Product(int id, String refernce, String description, float prix, String image, String categorie, int id_customer, boolean activer) {
        this.id = id;
        this.refernce = refernce;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.categorie = categorie;
        this.id_client = id_client;
        this.activer = activer;
    }

    public Product(int id, String refernce, String description, float prix, String image, String categorie, int id_client) {
        this.id = id;
        this.refernce = refernce;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.categorie = categorie;
        this.id_client = id_client;
    }

    public Product(String refernce, String description, float prix, String image, String categorie, int id_client) {
        this.refernce = refernce;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.categorie = categorie;
        this.id_client = id_client;
    }

    public Product(String refernce, String description, float prix, String image, String categorie) {
        this.refernce = refernce;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.categorie = categorie;
    }

    public Product(String refernce, String description, float prix, String categorie) {
        this.refernce = refernce;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefernce() {
        return refernce;
    }

    public void setRefernce(String refernce) {
        this.refernce = refernce;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public boolean isActiver() {
        return activer;
    }

    public void setActiver(boolean activer) {
        this.activer = activer;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", refernce=" + refernce + ", description=" + description + ", prix=" + prix + ", image=" + image + ", categorie=" + categorie + ", id_client=" + id_client + ", activer=" + activer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.refernce);
        hash = 71 * hash + this.id_client;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id_client != other.id_client) {
            return false;
        }
        if (!Objects.equals(this.refernce, other.refernce)) {
            return false;
        }
        return true;
    }

    
    
}
