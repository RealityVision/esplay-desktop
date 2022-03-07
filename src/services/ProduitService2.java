/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Produit2;
import java.sql.Connection;
import java.sql.Date;
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
public class ProduitService2 {
 private Statement ste;
   private PreparedStatement pst;
   private ResultSet rs;
   
     Connection MCN;
     
     
    public ProduitService2() {
        MCN= MaConnexion.instconn().getcnx();
    }

    public ProduitService2(Connection MCN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public void ajouterProduit2Pst (Produit2 a) {
        String req = "insert into Produit2 (nom,description,categorie,date,image,prix,stock_produit) values (?,?,?,?,?,?,?)";

        try {
            pst = MCN.prepareStatement(req);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getDescription());
            pst.setString(3, a.getCategorie());
            pst.setDate(4, (Date) a.getDate());
            pst.setString(5, a.getImage());
            pst.setInt(6, a.getPrix());
            pst.setInt(7, a.getStockProduit());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List<Produit2> readAll() {
        String req = "select * from Produit2";

        List<Produit2> list = new ArrayList<>();
        try {
            ste = MCN.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
           list.add(new Produit2(rs.getInt("idp2"),
                   rs.getString("nom"),
                   rs.getString("description"),
                   rs.getString("categorie"), 
                   rs.getDate("date"),
                   rs.getString("image"), 
                   rs.getInt("prix"), rs.getInt("stock_produit") )); 
       }

        } catch (SQLException ex) {
            Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public List <Produit2> liste2()
    {
        String req = "select idp2, nom, description, categorie, date, image, prix, stock_produit from Produit2"; 
        
       List <Produit2> list = new ArrayList<>(); 
       try {
       ste = MCN.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Produit2(rs.getInt("idp2"), rs.getString("nom"), rs.getString("description"), rs.getString("categorie"), rs.getDate("date"), rs.getString("image"), rs.getInt("prix"), rs.getInt("stock_produit") )); 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    
     public void deleteproduit2(int idp2) {
       try {
            Statement stm=MCN.createStatement();
            String query="delete from Produit2 where idp2 = '"+idp2+"'";
           
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
     
       
     public void updateproduit2 (Produit2 a){
         String req = "update produit2 set nom=?, description=?, categorie=?, date=?, image=?, prix=?, stock_produit=?";

        try {
            pst = MCN.prepareStatement(req);
            
            pst.setString(1, a.getNom());
            pst.setString(2, a.getDescription());
            pst.setString(3, a.getCategorie());
            pst.setDate(4, (Date) a.getDate());
             pst.setString(5, a.getImage());
             pst.setInt(6, a.getPrix()); 
             pst.setInt(7, a.getStockProduit());
   
           
            pst.execute();
        } catch (Exception e) {
            Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, e);
        }
        }
      public void updateproduitstock(int id, int nb){
         String req = "update produit2 set stock_produit=stock_produit-? where idp2= ? ";

        try {
            pst = MCN.prepareStatement(req);
            
            pst.setInt(1, nb);
            pst.setInt(2,id);
           
   
           
            pst.execute();
        } catch (Exception e) {
            Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, e);
        }
        }
     
     
      
         
     
     public ObservableList<Produit2> getProduit2List() throws SQLException {
           
        ObservableList<Produit2> Produit2list = FXCollections.observableArrayList();
        
         List <Produit2> idp2 = new ArrayList<>(); 
        Statement stm = MCN.createStatement();
        String query = "select idp2, nom, description, categorie, date, image, prix , stock_produit from Produit2";

        //ResultSet rs;
        rs = stm.executeQuery(query);
      
        while (rs.next()) {
          Produit2 produit2= new Produit2(rs.getInt("idp2"), 
                   rs.getString("nom"), 
                   rs.getString("description"),
                   rs.getString("categorie"), 
                   rs.getDate("date"), 
                   rs.getString("image"),
                   rs.getInt("prix"), 
                   rs.getInt("stock_produit"));
           
            Produit2list.add(produit2);

        }
        return Produit2list;

    }
     
    public ObservableList<Produit2> getProduit2listnew() throws SQLException {
        String req = "select idp2, nom, description, categorie, date, image, prix , stock_produit from Produit2";
        ObservableList<Produit2> Produit2list = FXCollections.observableArrayList();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Produit2 a = new Produit2();
                a.setIdp2(rs.getInt("idp2"));
                a.setNom(rs.getString("nom"));
                a.setDescription(rs.getString("description"));
                a.setCategorie(rs.getString("categorie"));
                a.setDate(rs.getDate("date"));
                a.setImage(rs.getString("image"));
                a.setPrix(rs.getInt("prix"));
                a.setPrix(rs.getInt("stock_produit"));

                Produit2list.add(a);

            }

        }
        catch (SQLException ex) {
                Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Produit2list;

    }
    /////////////////////
    ////////////////////////
    ////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////////
    /////////////////////////////////////////////
    
    public Produit2 AfficherDetailProduit(int idp2) {
        ArrayList<Produit2> listN = new ArrayList<Produit2>();
        try {
            ste = MCN.createStatement();
          rs = ste.executeQuery("Select * from produit2 WHERE produit2.`idp2` = '" + idp2 + "'");
            while (rs.next()) {
                listN.add(new Produit2(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                             
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)
               
                
              ));
            }
            ste.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listN.get(0);
    }    
     public void quantiteApresCommande(Produit2 p, int stockn) {

        try {
           
            System.out.println("produit"+p.getIdp2());
            System.out.println("Stock aprés Commande ****** ");
            String req = "UPDATE produit2 SET stock_produit= stock_produit-" + stockn + "'WHERE id_produit='" + p.getIdp2() + "'";
             pst = MCN.prepareStatement(req);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProduitService2.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    

}
