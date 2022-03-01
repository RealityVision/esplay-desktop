/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;


/**
 *
 * @author nadee ben cheikh
 */
public class UserService {
    Connection mc;
    PreparedStatement ps;
    public UserService(){
        mc=MaConnexion.instconn().getcnx();
    }
    
    public void CreateUser(User u){
      String sql ="INSERT INTO `user` ( `username`, `first_name`, `last_name`, `email`, `password`,`salt`) VALUES ( ?, ?, ?, ? ,?,?)";
   
        try {
            String salt = PasswordUtils.getSalt(20);
            String mySecurePassword = PasswordUtils.generateSecurePassword(u.getPassword(), salt);
            ps= mc.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getFirst_name());
            ps.setString(3, u.getLast_name());
            ps.setString(4, u.getEmail());
            ps.setString(5,mySecurePassword );
            ps.setString(6, salt);
            
            ps.executeUpdate();
            System.out.println("User ajouté avec succés");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    
    }
     public void CreateUserADMIN(User u){
      String sql ="INSERT INTO `user` ( `username`, `first_name`, `last_name`, `email`, `password`,`salt`,`role`) VALUES ( ?, ?, ?, ? ,?,?,?)";
   
        try {
            String salt = PasswordUtils.getSalt(20);
            String mySecurePassword = PasswordUtils.generateSecurePassword(u.getPassword(), salt);
            ps= mc.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getFirst_name());
            ps.setString(3, u.getLast_name());
            ps.setString(4, u.getEmail());
            ps.setString(5,mySecurePassword );
            ps.setString(6, salt);
            ps.setString(7, u.getRole());
            
            ps.executeUpdate();
            System.out.println("User ajouté avec succés");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    
    }
 
   public List<User> ReadALLUsers(){
       List<User> users = new ArrayList<>();
       String sql = "select * from user";
        try {
            ps= mc.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
             while(rs.next()){
               User u = new User();
               u.setId_user(rs.getInt("id_user"));
               u.setUsername(rs.getString("username"));
               u.setFirst_name(rs.getString("first_name"));
               u.setLast_name(rs.getString("last_name"));
               u.setPhone(rs.getInt("phone"));
               u.setEmail(rs.getString("email"));
               u.setPassword(rs.getString("password"));
               u.setPassword(rs.getString("salt"));
               u.setCountry(rs.getString("country"));
               u.setBirthdate(rs.getDate("birth_date"));
               u.setPicture(rs.getString("picture"));
               u.setAddress(rs.getString("address"));
               u.setGender(rs.getString("gender"));
               u.setRole(rs.getString("role"));
               
               users.add(u);
               }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return users;
       
   }
   
     public User ReadUser(int id_user){
       String sql="SELECT * FROM `user` WHERE `user`.`id_user` = ?";
       User u = new User();
        try {
            ps= mc.prepareStatement(sql);
            ps.setInt(1, id_user);
            ResultSet rs= ps.executeQuery();
             while(rs.next()){
               u.setId_user(rs.getInt("id_user"));
               u.setUsername(rs.getString("username"));
               u.setFirst_name(rs.getString("first_name"));
               u.setLast_name(rs.getString("last_name"));
               u.setPhone(rs.getInt("phone"));
               u.setEmail(rs.getString("email"));
               u.setPassword(rs.getString("password"));
               u.setSalt(rs.getString("salt"));
               u.setCountry(rs.getString("country"));
               u.setBirthdate(rs.getDate("birth_date"));
               u.setPicture(rs.getString("picture"));
               u.setAddress(rs.getString("address"));
               u.setGender(rs.getString("gender"));
               u.setRole(rs.getString("role"));
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
       return u;
   }
     
     public User ReadUser(String Username){
       String sql="SELECT * FROM `user` WHERE `user`.`username` = ?";
       User u = new User();
        try {
            ps= mc.prepareStatement(sql);
            ps.setString(1, Username);
            ResultSet rs= ps.executeQuery();
             while(rs.next()){
               u.setId_user(rs.getInt("id_user"));
               u.setUsername(rs.getString("username"));
               u.setFirst_name(rs.getString("first_name"));
               u.setLast_name(rs.getString("last_name"));
               u.setPhone(rs.getInt("phone"));
               u.setEmail(rs.getString("email"));
               u.setPassword(rs.getString("password"));
               u.setCountry(rs.getString("country"));
               u.setBirthdate(rs.getDate("birth_date"));
               u.setPicture(rs.getString("picture"));
               u.setAddress(rs.getString("address"));
               u.setGender(rs.getString("gender"));
               u.setRole(rs.getString("role"));
             }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
       return u;
   }
     public void UpdateUser(User u){
      String sql ="UPDATE `user` SET `username` = ?, `first_name` = ?, `last_name` = ?, `phone` = ?, "
              + "`email` = ?, `password` = ?,`salt` = ?, `country` = ?, `birth_date` = ?, `address` = ?,"
              + " `gender` = ?   WHERE `user`.`id_user` = ?;";
      if (!u.getPassword().isEmpty() ){ 
            String salt = PasswordUtils.getSalt(20);
            String mySecurePassword = PasswordUtils.generateSecurePassword(u.getPassword(), salt);
            u.setPassword(mySecurePassword);
            u.setSalt(salt);
      }else {
         User u1 = ReadUser(u.getId_user());
         u.setPassword(u1.getPassword());
         u.setSalt(u1.getSalt());

      }
   
        try {
            ps= mc.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getFirst_name());
            ps.setString(3, u.getLast_name());
            ps.setInt(4, u.getPhone());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getPassword());
            ps.setString(7, u.getSalt());
            ps.setString(8, u.getCountry());
            ps.setDate(9, u.getBirthdate());
            ps.setString(10, u.getAddress());
            ps.setString(11, u.getGender());
            ps.setInt(12, u.getId_user());
            
            ps.executeUpdate();
            System.out.println("User modifier avec succés");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    
    }
     public void UpdateUserAdmin(User u){
      String sql ="UPDATE `user` SET `username` = ?, `first_name` = ?, `last_name` = ?, `phone` = ?, "
              + "`email` = ?, `password` = ?,`salt` = ?, `country` = ?, `birth_date` = ?, `address` = ?,"
              + " `gender` = ? , `role` = ? WHERE `user`.`id_user` = ?;";
      if (!u.getPassword().isEmpty() ){ 
            String salt = PasswordUtils.getSalt(20);
            String mySecurePassword = PasswordUtils.generateSecurePassword(u.getPassword(), salt);
            u.setPassword(mySecurePassword);
            u.setSalt(salt);
      }else {
         User u1 = ReadUser(u.getId_user());
         u.setPassword(u1.getPassword());
         u.setSalt(u1.getSalt());

      }
   
        try {
            ps= mc.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getFirst_name());
            ps.setString(3, u.getLast_name());
            ps.setInt(4, u.getPhone());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getPassword());
            ps.setString(7, u.getSalt());
            ps.setString(8, u.getCountry());
            ps.setDate(9, u.getBirthdate());
            ps.setString(10, u.getAddress());
            ps.setString(11, u.getGender());
            ps.setString(12, u.getRole());
            ps.setInt(13, u.getId_user());
            
            ps.executeUpdate();
            System.out.println("User modifier avec succés");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    
    }
     
    public void DeleteUser(int id_user){
       String sql="DELETE FROM `user` WHERE `user`.`id_user` = ?";
        try {
            ps= mc.prepareStatement(sql);
            ps.setInt(1, id_user);
            ps.executeUpdate();
            System.out.println("User supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
       
   }
    public void UpdatePassword(String password, int id_user){
        String salt = PasswordUtils.getSalt(20);
        String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt);
      String sql ="UPDATE `user` SET `password` = ?, `salt` = ? WHERE `user`.`id_user` = ?";
        try {
            ps= mc.prepareStatement(sql);
            
            ps.setString(1,mySecurePassword);
            ps.setString(2, salt);
            ps.setInt(3, id_user);
            
            ps.executeUpdate();
            System.out.println("Mot de passe modifier avec succés");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    
    }
   

    
}