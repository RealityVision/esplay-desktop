/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tools.MaConnexion;
import entities.User;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author slimd
 */
public class OrderService {
     private Statement ste;
   private PreparedStatement pst;
   private ResultSet rs;
   
     Connection MCN;
     ProductService productService = new ProductService();
        
    public OrderService() {
        MCN= MaConnexion.instconn().getcnx();
    }
    
    public void add(Order t) {
        String req = "insert into commande (id,id_product,date,id_client,etat) values (?,?,?,?,?)";
         
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, t.getOrderId());
            pst.setInt(2, 2);
            pst.setDate(3, t.getOrderDate());
            pst.setInt(4, t.getClient().getId_user());
            pst.setString(5, t.getEtat());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Order rechercheID(Integer id) {
        Order or = null;
        String req = "select * from commande where id =?";
        try {
            pst = MCN.prepareStatement(req);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                or = new Order(rs.getInt("id"), rs.getDate("date"),
                        /*//  new UserService().findById(rs.getInt("id_customer")),*/
                        productService.findById(rs.getInt("id_product")),
                        rs.getString("etat"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return or;
    }
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        String req = "select * from commande";
     
        try {
            pst = MCN.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order or = new Order(rs.getInt("id"), rs.getDate("date"),
                        //new CustomerServices().findById(resultSet.getInt("id_customer")),
                        rs.getString("etat"));
                orders.add(or);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;

    }
    public void supprimerOrder(int id) {
       try {
            ste=MCN.createStatement();
            String query="delete from commande WHERE id='"+id+"'";
           
            ste.executeUpdate(query);
            
       } catch (SQLException ex) {
           Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
}
