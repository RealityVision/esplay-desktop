/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.Pinball;

/**
 * 
 *
 * @author fadhe
 */

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pinball {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Esplay Pinball");
        frame.setSize(12 * 26 + 10, 26 * 23 + 25);
        frame.setLocationRelativeTo(null);
        GamePlay panel = new GamePlay();
        frame.add(panel);
        frame.setVisible(true);
       frame.setResizable(false);

    }

}
