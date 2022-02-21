/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;


/**
 *
 * @author nadee ben cheikh
 */
public class AuthService {
    Connection mc;
    PreparedStatement ps;
    
    public AuthService(){
    mc=MaConnexion.instconn().getcnx();
}
   public int authentification(String login, String password){
       int i=0 ;
       String sql ="SELECT * FROM user";
        try {
            ps= mc.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                if (login.equals(rs.getString("username"))== false){
                    i= -1;  
                }
               
                else if (PasswordUtils.verifyUserPassword(password,rs.getString("password"),rs.getString("salt"))== false){
                    i= 0;
                    break;
                }
                else{
                    i=1;
                    break;
                }
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
          if (i==-1){
                    System.out.print("user n'existe pas");
                }
                else if (i==0){
                    System.out.print("mot de passe incorrect");
                }
                else{
                    i=1;
                     System.out.print("user authentifié avec succés");
                }
       
      return i ;     
   }
   
}
