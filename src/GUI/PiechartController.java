/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Addproduit2Controller;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author slimd
 */
public class PiechartController implements Initializable {
   @FXML
    private PieChart piechart;
    private Statement stm;
    private ResultSet rs;
    private Connection MCN;
    
    
    ObservableList<PieChart.Data>data=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          MCN= MaConnexion.instconn().getcnx();
        stat();
    }    
     private void stat()
    {
          
           
      try {
           
          String query = "SELECT COUNT(*),categorie FROM Produit2 GROUP BY categorie" ;
       
             PreparedStatement PreparedStatement = MCN.prepareStatement(query);
             rs = PreparedStatement.executeQuery();
            
                     
            while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("categorie"),rs.getInt("COUNT(*)")));
            }     
        } catch (SQLException ex) {
            Logger.getLogger(Addproduit2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        piechart.setTitle("**Statistiques par catégories**");
        piechart.setLegendSide(Side.LEFT);
        piechart.setData(data);
    
    }
    
}
