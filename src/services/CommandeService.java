/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commande;
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
public class CommandeService {
    
     private Statement ste; 
    private PreparedStatement pst; 
    private ResultSet rs; 
    
    private Connection MCN; 
    
    public CommandeService()
    {         MCN= MaConnexion.instconn().getcnx();

    }
    
    public void ajoutercommande(Commande c)
    {
        String req = "insert into commande1 (date, quantite, prix_total) values  ('" + c.getDate()+"','" + c.getQuantite()+  "','" + c.getPrixT()+ "')"; 
   
    try 
    {
        ste=MCN.createStatement(); 
        ste.executeUpdate(req); 
    }
    
    catch (SQLException ex)
    {
    Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public List <Commande> readAll()
    {
        String req = "select * from commande1"; 
        
       List <Commande> list = new ArrayList<>(); 
       try {
       ste = MCN.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Commande(rs.getInt("id"), rs.getString("date"), rs.getInt("quantite"), rs.getInt("prix_total"))); 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    public List <Commande> liste2()
    {
        String req = "select id, date, quantite, prix_total from commande1"; 
        
       List <Commande> list = new ArrayList<>(); 
       try {
       ste = MCN.createStatement(); 
       rs=ste.executeQuery(req); 
       
       while (rs.next())
       {
           list.add(new Commande(rs.getInt("id"), rs.getString("date"), rs.getInt("quantite"), rs.getInt("prix_total"))); 
       }
       
       }
       catch (SQLException ex)
       {
       Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
       }
    return list; 
    }
    
    
     public void supprimercommande(int id) {
       try {
            Statement stm=MCN.createStatement();
            String query="delete from commande1 WHERE id='"+id+"'";
           
            stm.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
     
       
      public void modifiercommande (int id, String date, int quantite, int prix_total){
         String requete="UPDATE commande1 SET date='"+date+"', quantite='"+quantite+"', prix_total='"+prix_total+"' WHERE id='"+id+"'";
         
         
         try{
             ste = MCN.createStatement();
            ste.executeUpdate(requete);
            System.out.println("commande modifié");
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ObservableList<Commande> getCommandeList() throws SQLException {
           
        ObservableList<Commande> commandelist = FXCollections.observableArrayList();
        
         List <Commande> id = new ArrayList<>(); 
        Statement stm = MCN.createStatement();
        String query = "select id, date, quantite, prix_total from commande1";

        //ResultSet rs;
        rs = stm.executeQuery(query);
        Commande Commande;
        while (rs.next()) {
           Commande= new Commande(rs.getInt("id"), rs.getString("date"), rs.getInt("quantite"), rs.getInt("prix_total")); 
            commandelist.add(Commande);

        }
        return commandelist;

    }
     
    public ObservableList<Commande> getCommandeListnew() throws SQLException {
        String req = "select  id,date, quantite, prix_total  from commande1";
        ObservableList<Commande> list = FXCollections.observableArrayList();

        try {
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Commande c = new Commande();
                c.setId(rs.getInt("id"));
                c.setDate(rs.getString("date"));
                c.setQuantite(rs.getInt("quantite"));
                c.setPrixT(rs.getInt("prix_total"));
                list.add(c);

            }

        } catch (SQLException ex) {
                Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

     
    
    
    
}
