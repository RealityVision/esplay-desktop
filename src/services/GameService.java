package services;

import entities.Game;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MaConnexion;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class GameService {

    Connection MCN;
    PreparedStatement ste;
    private PreparedStatement pst;
    public ResultSet rs;

    public GameService() {
        MCN = MaConnexion.instconn().getcnx();
    }

    public void ajouterGame(Game g) {
        try {
            String requete = "INSERT INTO game (title,description,size,category,image_g) VALUES (?,?,?,?,?)";
            PreparedStatement ste = MCN.prepareStatement(requete);
            ste.setString(1, g.getTitle());
            ste.setString(2, g.getDescription());
            ste.setFloat(3, g.getSize());
            ste.setInt(4, g.getCategory());
            ste.setString(5, g.getImage());

            ste.executeUpdate();
            System.out.println("Game Added !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    
    public List<Game>readGames(){
        String req = "select * from game";

        List<Game> list = new ArrayList<>();
        try {
            Statement stee=MCN.createStatement();
            rs = stee.executeQuery(req);
            while (rs.next()) {
                list.add(new Game(rs.getInt("id_game"),rs.getString("title"),
                        rs.getString("description"),rs.getInt("size"), rs.getDouble("rate"),
                        rs.getInt("category"),rs.getString("image_g"),rs.getInt("rate_nbr")));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Game> afficherGame() {
        List<Game> games = new ArrayList<>();
        String sql = "select * from game";
        try {
            ste = MCN.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                Game g = new Game();
                g.setIdGame(rs.getInt("id_game"));
                g.setTitle(rs.getString("title"));
                g.setDescription(rs.getString("description"));
                g.setSize(rs.getInt("size"));
                g.setRate(rs.getDouble("rate"));
                g.setCategory(rs.getInt("category"));
                games.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return games;
    }

    public void supprimerGame(int idgame) {

        try {
            Statement ste = MCN.createStatement();
            String query = "delete from game where id_game= '" + idgame + "'";
            ste.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierGame(Game a) {
        String query= "UPDATE game set title=?, description=?, size=?, category=? where date_g= ? ";
        try {
            PreparedStatement pst = MCN.prepareStatement(query);
            pst.setString(1, a.getTitle());
            pst.setString(2, a.getDescription());
            pst.setInt(3, a.getSize()); 
            pst.setInt(4, a.getCategory());
            pst.setTimestamp(5, a.getDate());
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Game> afficherGameList() throws SQLException {
        ObservableList<Game> games = FXCollections.observableArrayList();
        String sql = "select * from game";
        try {
            ste = MCN.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                Game g = new Game();
                g.setIdGame(rs.getInt("id_game"));
                g.setTitle(rs.getString("title"));
                g.setDescription(rs.getString("description"));
                g.setSize(rs.getInt("size"));
                g.setRate(rs.getDouble("rate"));
                g.setCategory(rs.getInt("category"));
                g.setDate(rs.getTimestamp("date_g"));
                games.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return games;
    }
    
    public void updateRate(String name,Double r) {
        String query= "UPDATE game set rate=rate +? ,rate_nbr=rate_nbr+1 where title= ?";
        try {
            PreparedStatement pst = MCN.prepareStatement(query);
            pst.setDouble(1,r);
            pst.setString(2,name);
            
            
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(GameService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
