/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MaConnexion;

/**
 *
 * @author slimd
 */
public class StoreService {
     private Statement ste; 
    private PreparedStatement pst; 
    private ResultSet rs; 
    
    private Connection MCN; 
    
    public StoreService()
    { 
        MCN= MaConnexion.instconn().getcnx();
    }
    
    
    
    //fonction ajouter au store
    public void ajouterstore(Store s)
    {
        String req = "insert into store (nom, description, categorie, prix, image) values  ('" + s.getNom() +"','" + s.getDescription() +  "','" + s.getCategorie() + "','" + s.getPrix() +  "','" + s.getImg() + "')"; 
   
    try 
    {
        ste=MCN.createStatement(); 
        ste.executeUpdate(req); 
    }
    
    catch (SQLException ex)
    {
    Logger.getLogger(StoreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
     public List <Store> readAll()
    {
        String req = "select * from store"; 
        
       List <Store> list = new ArrayList<>(); 
       try {
       ste = MCN.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Store(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getString("categorie"), rs.getInt("prix"), rs.getString("img"))); 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(StoreService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    public List <Store> liste2()
    {
        String req = "select id, nom, description, categorie, prix from store"; 
        
       List <Store> list = new ArrayList<>(); 
       try {
       ste = MCN.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Store(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getString("categorie"), rs.getInt("prix"))); 
; 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(StoreService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    
     public void supprimerstore(int id) {
       try {
            Statement stm=MCN.createStatement();
            String query="delete from store where id = '"+id+"'";
           
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(StoreService.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
     
       
      public void modifierstore (int id, String nom, String description,String categorie, int prix, String image){
         String requete="UPDATE store SET nom='"+nom+"', description='"+description+"', categorie='"+categorie+"',prix='"+prix+"',image='"+image+"'  WHERE id='"+id+"'";
         
         
         try{
             ste = MCN.createStatement();
            ste.executeUpdate(requete);
            System.out.println("Store modifié");
        } catch (SQLException ex) {
            Logger.getLogger(StoreService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ObservableList<Store> getStoreListe() throws SQLException {
           
        ObservableList<Store> storeliste = FXCollections.observableArrayList();
        
         List <Store> id = new ArrayList<>(); 
        Statement stm = MCN.createStatement();
        String query = "select id, nom, description, categorie, prix from store";

        //ResultSet rs;
        rs = stm.executeQuery(query);
        Store Store;
        while (rs.next()) {
             Store = new Store(rs.getInt("id"), rs.getString("nom"), rs.getString("description"), rs.getString("categorie"), rs.getInt("prix")); 
            storeliste.add(Store);

        }
        return storeliste;

    }
         public ObservableList<Store> getStoreListenew() throws SQLException {

        String req = "select  id,nom, description, categorie , prix, image from store";
        ObservableList<Store> list = FXCollections.observableArrayList();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Store s = new Store();
                s.setId(rs.getInt("id"));
                s.setNom(rs.getString("nom"));
                s.setDescription(rs.getString("description"));
                s.setCategorie(rs.getString("categorie"));
                s.setPrix(rs.getInt("prix"));
                s.setImg(rs.getString("image"));
                list.add(s);

               
            }

        } catch (SQLException ex) {
                Logger.getLogger(StoreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
