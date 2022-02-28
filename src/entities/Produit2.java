/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author slimd
 */
public class Produit2 {
    public static String pathfile; 
    public static String filename="";
    private int idp2;
    private String nom;
    private String description;
    private String categorie;
    private Date date;
    private String image;
    private int prix;
 
    public Produit2() {
    }

    public Produit2(int idact, String nom, String description, String categorie, Date date, String image, int prix) {
        this.idp2 = idact;
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
        this.prix = prix;
    }

    public Produit2(String nom, String description, String categorie, Date date, String image, int prix) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
        this.prix = prix;
    }

    public int getIdp2() {
        return idp2;
    }

    public void setIdp2(int idp2) {
        this.idp2 = idp2;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idp2;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.categorie);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.image);
        hash = 97 * hash + this.prix;
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
        final Produit2 other = (Produit2) obj;
        if (this.idp2 != other.idp2) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

    public String nomProduit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}

