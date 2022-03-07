package services;

import entities.Game;
import entities.Ratingsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;




public class RatingController {

     Connection MCN;
    PreparedStatement ste;
    
    public RatingController() {
        MCN= MaConnexion.instconn().getcnx();
    }
    public void ajouterRate(Ratingsystem g) {
        try {
            String requete = "INSERT INTO ratingsystem (stars) VALUES (?)";
            PreparedStatement ste = MCN.prepareStatement(requete);
            ste.setInt(1, g.getStars());
            
            ste.executeUpdate();
            System.out.println("Game is rated!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public List<Ratingsystem> afficherGame(){
        List<Ratingsystem> Rate = new ArrayList<>();
        String sql="select * from ratingsystem";
        try {
            ste=MCN.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Ratingsystem g = new Ratingsystem();
                g.setStars(rs.getInt("Stars"));
                Rate.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Rate;
    }
     public void supprimerRate(int ref){
        
        try {
            PreparedStatement ste = MCN.prepareStatement("delete from ratingsystem where idRate=?");
            ste.setInt(1, ref);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void modifierGame(int ref){
        try {
            PreparedStatement ste  =MCN.prepareStatement("update ratingsystem set where idRate=?");
            ste.setInt(1, ref);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
