/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.BlockBreaker;

/**
 *
 * @author fadhe
 */
import java.awt.Color;

import javax.swing.JFrame;

public class BrickBreaker {
	public static void main(String[] args) {
		JFrame obj=new JFrame();
		Gameplay gamePlay = new Gameplay();
		
		obj.setSize(700,600);
                obj.setLocationRelativeTo(null);
		obj.setTitle("ESPLAY BlockBreacker");		
		obj.setResizable(false);
               /* obj.setUndecorated(true);*/
		obj.setVisible(true);
		obj.add(gamePlay);
                obj.setVisible(true);
		
	}
}