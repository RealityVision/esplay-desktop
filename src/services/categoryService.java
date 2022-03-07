/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Category;
import entities.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MaConnexion;

/**
 *
 * @author fadhe
 */
public class categoryService {
    
      Connection MCN;
    PreparedStatement ste;

    public categoryService() {
        MCN = MaConnexion.instconn().getcnx();
    }

    public ObservableList<Category> afficherCat() {
        ObservableList<Category> categories = FXCollections.observableArrayList();
        String sql = "select * from category";
        try {
            ste = MCN.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
           
            while (rs.next()) {
                Category c = new Category();
                c.setId_cat(rs.getInt("category_id"));
                c.setCategory(rs.getString("Category_name"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return categories;
    }
    
    
    
    public int afficher(String cat) throws SQLException {
        int k = 0 ;
        String sql = "SELECT `category_id` FROM `category` WHERE `category`.`Category_name`= ? ";
        ste = MCN.prepareStatement(sql);
            ste.setString(1, cat);
             
            ResultSet rs = ste.executeQuery();
            System.out.println(rs);
         while(rs.next()){
             k = rs.getInt("category_id");
             System.out.println(rs.getInt("category_id"));
            }
           return k;
         
       

       
    }
      public String afficherS(int cat) throws SQLException {
        String k = "" ;
        String sql = "SELECT `Category_name` FROM `category` WHERE `category`.`category_id`= ? ";
        ste = MCN.prepareStatement(sql);
            ste.setInt(1, cat);
             
            ResultSet rs = ste.executeQuery();
            System.out.println(rs);
         while(rs.next()){
             k = rs.getString("Category_name");
            
            }
           return k;
         
       

       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
