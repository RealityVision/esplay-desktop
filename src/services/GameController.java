package services;

import entities.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;





public class GameController {

     Connection MCN;
    PreparedStatement ste;
    
    public GameController() {
        MCN= MaConnexion.instconn().getcnx();
    }
    public void ajouterGame(Game g) {
        try {
            String requete = "INSERT INTO game (title,description,size,rate,category) VALUES (?,?,?,?,?)";
            PreparedStatement ste = MCN.prepareStatement(requete);
            ste.setString(1, g.getTitle());
            ste.setString(2, g.getDescription());
            ste.setFloat(3, g.getSize());
            ste.setString(4, g.getRate());
            ste.setInt(5, g.getCategory());
            ste.executeUpdate();
            System.out.println("Game Added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public List<Game> afficherGame(){
        List<Game> games = new ArrayList<>();
        String sql="select * from game";
        try {
            ste=MCN.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Game g = new Game();
                g.setIdGame(rs.getInt("id_game"));
                g.setTitle(rs.getString("title"));
                g.setDescription(rs.getString("description"));
                g.setSize(rs.getFloat("size"));
                g.setRate(rs.getString("rate"));
                g.setCategory(rs.getInt("category"));
                games.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return games;
    }
     public void supprimerGame(int ref){
        
        try {
            PreparedStatement ste = MCN.prepareStatement("delete from game where idGame=?");
            ste.setInt(1, ref);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void modifierGame(int ref, String titre){
        try {
            PreparedStatement ste  =MCN.prepareStatement("update game set title =? where idGame=?");
            ste.setString(1, titre);
            ste.setInt(2, ref);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}