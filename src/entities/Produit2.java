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
    public static String file; 
    public static String filename="";
    private int idp2;
    private String nom;
    private String description;
    private String categorie;
    private Date date;
    private String image;
    private int prix;
 
    
    
        public static int id_pModifier;
        private int stockProduit;

   
  
    public Produit2() {
    }

    public Produit2(int idact, String nom, String description, String categorie, Date date, String image, int prix) {
        this.idp2 = idact;
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.date = date;
      
        this.prix = prix;
        this.image= image;
    }

    public Produit2(String nom, String description, String categorie, Date date, String image, int prix,String file) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.date = date;
        
        this.prix = prix;
        this.image=file;
    }
    public Produit2(String nom, String description, String categorie, Date date, String image, int prix,int stockProduit,String file) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.date = date;
         this.stockProduit = stockProduit;
        this.prix = prix;
        this.image=file;
    }

    public Produit2(int idp2, String nom, String description, String categorie, Date date, String image, int prix, int stockProduit) {
        this.idp2 = idp2;
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
        this.prix = prix;
        this.stockProduit = stockProduit;
    }

    public Produit2(String nom, String description, String categorie, Date date, String image, int prix, int stockProduit) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
        this.prix = prix;
        this.stockProduit = stockProduit;
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

    public static String getPathfile() {
        return file;
    }

    public static void setPathfile(String pathfile) {
        Produit2.file = file;
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        Produit2.filename = filename;
    }

    public static int getId_pModifier() {
        return id_pModifier;
    }

    public static void setId_pModifier(int id_pModifier) {
        Produit2.id_pModifier = id_pModifier;
    }

    public int getStockProduit() {
        return stockProduit;
    }

    public void setStockProduit(int stockProduit) {
        this.stockProduit = stockProduit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.idp2;
        hash = 73 * hash + Objects.hashCode(this.nom);
        hash = 73 * hash + Objects.hashCode(this.description);
        hash = 73 * hash + Objects.hashCode(this.categorie);
        hash = 73 * hash + Objects.hashCode(this.date);
        hash = 73 * hash + Objects.hashCode(this.image);
        hash = 73 * hash + this.prix;
        hash = 73 * hash + this.stockProduit;
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
        if (this.stockProduit != other.stockProduit) {
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
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

   
   @Override
    public String toString() {
        return "Produit2{" + "idp2=" + idp2 + ", nom=" + nom + ", description=" + description + ", categorie=" + categorie + ", date=" + date + ", image=" + image + ", prix=" + prix + ", stockProduit=" + stockProduit + '}';
    }


    
    
    
}

