/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;

/**
 *
 * @author slimd
 */
public class ProductService {
   private Statement ste;
   private PreparedStatement pst;
   private ResultSet rs;
   
     Connection MCN;
     
     
    public ProductService() {
        MCN= MaConnexion.instconn().getcnx();
    }
    public Boolean add(Product p) {

        try {
            String req = "INSERT INTO `product` ( reference, description, prix, image, categorie , id_client) VALUES (?,?,?,?,?,?,?)";
            
            pst = MCN.prepareStatement(req);
            pst.setString(1, p.getRefernce());
            pst.setString(2, p.getDescription());
            pst.setFloat(3, p.getPrix());
            pst.setString(4, p.getImage());
           // pst.setString(4, OverviewController.imgurl);
            pst.setString(5, p.getCategorie());
            pst.setInt(6, 11);

            pst.executeUpdate();
            System.out.println("ajout terminé");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("probleme d ajout");
            return false;
        }
    }
        public List<Product> showProduit() {
            
        String req = "select * from product where activer = 1 ";
        List<Product> Lproduits = new ArrayList<>();
        try {
            pst = MCN.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product produit = new Product(rs.getString("reference"), rs.getString("description"),
                        rs.getFloat("prix"), rs.getString("image"),
                        rs.getString("categorie"));
                Lproduits.add(produit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Lproduits;
    }
         public boolean delete(int id) {
        try {
            String req = "DELETE FROM `product` WHERE id=" + id;

            pst = MCN.prepareStatement(req);

            pst.executeUpdate();
            System.out.println("Produit supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("Problème de suppression");
            ex.printStackTrace();
            return false;
        }

    }
          public boolean update(int id, String description, float prix, int quantite, float promotion) {

        String req = "UPDATE product SET description = ? ,prix = ?  WHERE id =?";

        try {

            pst = MCN.prepareStatement(req);

            pst.setString(1, description);
            pst.setFloat(2, prix);
            pst.setInt(3, id);

            pst.executeUpdate();
            System.out.println("Modification terminé");
            return true;

        } catch (SQLException ex) {
            System.out.println("Problème de Modification");
            ex.printStackTrace();
            return false;
        }

    }
           public void updateActiver(int id) {
         
        String req = "UPDATE product SET activer =? WHERE id =?";
        try {         
             pst = MCN.prepareStatement(req);
            pst.setBoolean(1, true); 
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
            public List <Product> tri() throws SQLException
    {
         ste = MCN.createStatement(); 
        String query= "SELECT * from repas ORDER BY NOM";
        
               List <Product> list = new ArrayList<>(); 

        
        Product product = new Product();
        try {
            rs = ste.executeQuery(query);
           // while(rs.next()){
            rs.next();
                product.setId(rs.getInt("id"));
                product.setRefernce(rs.getString("Refernce"));
                product.setDescription(rs.getString("description"));
                product.setPrix(rs.getInt("price"));
                product.setCategorie(rs.getString("category"));
                product.setImage(rs.getString("img"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;


    }
          public int getIDByRef(String reference) throws SQLException {
        String req = "SELECT * FROM `product` WHERE reference= ?";
        pst = MCN.prepareStatement(req);
        pst.setString(1, reference);
        rs = pst.executeQuery();
        while (rs.next()) {
            Product produit = new Product(rs.getInt("id"),
                    rs.getString("reference"), 
                    rs.getString("description"), 
                    rs.getFloat("prix"), 
                    rs.getString("image"),  
                    rs.getString("categorie"), 
                    rs.getInt("id_client"));
            return produit.getId();
        }

        return 0;

    }
            public String getImgById(int id) throws SQLException {
        String req = "SELECT * FROM `product` WHERE id= ?";
           pst = MCN.prepareStatement(req);
        pst.setInt(1, id);
        rs = pst.executeQuery();
        while (rs.next()) {
            Product produit = new Product(
                    rs.getString("reference"), 
                    rs.getString("description"),
                    rs.getFloat("prix"),
                    rs.getString("image"),
                    rs.getString("categorie"));
            return produit.getImage();

        }

        return null;

    }
               public List<Product> SearchProd(String rech) throws SQLException {

         List<Product> LSearchProd = new ArrayList<>();
        pst = MCN.prepareStatement("SELECT * FROM product WHERE reference like ? or description like ?  or prix like ? or categorie like ?  ");
        pst.setString(1, "%" + rech + "%");
        pst.setString(2, "%" + rech + "%");
        pst.setString(3, "%" + rech + "%");
        pst.setString(4, "%" + rech + "%");
        
        rs = pst.executeQuery();

        while (rs.next()) {

            Product produitSCH = new Product(rs.getString("reference"), rs.getString("description"),
                    rs.getFloat("prix"), rs.getString("image"), 
                    rs.getString("categorie"));
            produitSCH.setId(rs.getInt("id"));
            LSearchProd.add(produitSCH);
        }
        return LSearchProd;

    }
          public List<Product> AfficherParCu(int id_client) {

         List<Product> LAfficherParCu = new ArrayList<>();
        String req = "select * from product where id_client = ?";
        
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, id_client);

            rs = pst.executeQuery();
            while (rs.next()) {
                Product produit = new Product(
                        rs.getString("reference"),
                        rs.getString("description"),
                        rs.getFloat("prix"),
                        rs.getString("image"),
                        rs.getString("categorie"));
                LAfficherParCu.add(produit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LAfficherParCu;

    }
           public List<Product> AfficherParCat(int categorie) {

         List<Product> LAfficherParCat = new ArrayList<>();
        String req = "select * from product categorie = ?";
        
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, categorie);

            rs = pst.executeQuery();
            while (rs.next()) {
                Product produit = new Product(
                        rs.getString("reference"),
                        rs.getString("description"),
                        rs.getFloat("prix"),
                        rs.getString("image"),
                        rs.getString("categorie"));
                LAfficherParCat.add(produit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LAfficherParCat;

    }
           public int TestProduit(int id_produit) throws SQLException {

        String req = "select id_client from `product` where  id= ?   ";
        pst = MCN.prepareStatement(req);

        pst.setInt(1, id_produit);
        rs = pst.executeQuery();
        while (rs.next()) {
            int id_cust = rs.getInt("id_client");

            return id_cust;
        }

        return 0;
    }
           public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        String req = "select * from product ";
    
        try {
            pst = MCN.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"),
                         rs.getString("reference"),
                         rs.getString("description"),
                         rs.getFloat("prix"),
                         rs.getString("image"),
                         rs.getString("categorie"),
                         rs.getInt("id_client"),
                         rs.getBoolean("activer"));

                productList.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productList;
    }
               public Product findById(int id_produit) {
        Product p = null;
        String req = "select * from product where id =?";
     
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, id_produit);
            rs = pst.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt("id"),
                        rs.getString("reference"),
                        rs.getString("description"),
                        rs.getFloat("prix"),
                        rs.getString("image"),
                        rs.getString("categorie"),
                        rs.getInt("id_client"), 
                        rs.getBoolean("activer"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;

    }
    }
    
    
    

