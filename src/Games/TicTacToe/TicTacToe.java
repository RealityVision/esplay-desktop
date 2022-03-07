/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Games.TicTacToe;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {

	public static int BOARD_SIZE = 3;

	public static enum GameStatus {
		Incomplete, XWins, ZWins, Tie
	}

	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

	boolean crossTurn = true;

	public TicTacToe() {
                
		super.setTitle("ESPLAY TicTacToe");
                super.setUndecorated(true);
		super.setSize(550, 400);
		GridLayout gridLayout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(gridLayout);
                setLocationRelativeTo(null);
                
		Font font = new Font("Comic Sans", 1, 150);
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton("");
				buttons[row][col] = button;
				button.setFont(font);
				button.addActionListener(this);
				super.add(button);

			}
		}
		super.setResizable(false);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		makeMove(clickedButton);
		GameStatus gs = this.getGameStatus();
		if (gs == GameStatus.Incomplete) {
			return;
		}
		declareWinner(gs);

		int choice = JOptionPane.showConfirmDialog(this, "T3awed tor7?");
		if (choice == JOptionPane.YES_OPTION) {
			for (int row = 0; row < BOARD_SIZE; row++) {
				for (int col = 0; col < BOARD_SIZE; col++) {
					buttons[row][col].setText("");
				}
			}
			crossTurn = true;
		} else
			super.dispose();
	}

	private void makeMove(JButton clickedButton) {
		String btntext = clickedButton.getText();
		if (btntext.length() > 0) {
			JOptionPane.showMessageDialog(this, "Douwiw");
		} else {
			if (crossTurn) {
				clickedButton.setText("X");
			} else {
				clickedButton.setText("0");
			}
			crossTurn = !crossTurn;
		}
	}

	private GameStatus getGameStatus() {
		String text1 = "", text2 = "";
		int row = 0, col = 0;

		// text inside row
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE - 1; col++) {
				text1 = buttons[row][col].getText();
				text2 = buttons[row][col + 1].getText();
				if (!text1.equals(text2) || text1.length() == 0) {
					break;
				}
			}
			if (col == BOARD_SIZE - 1) {
				if (text1.equals("X"))
					return GameStatus.XWins;
				else
					return GameStatus.ZWins;
			}
		}
		// text inside col
		for (col = 0; col < BOARD_SIZE; col++) {
			for (row = 0; row < BOARD_SIZE - 1; row++) {
				text1 = buttons[row][col].getText();
				text2 = buttons[row + 1][col].getText();
				if (!text1.equals(text2) || text1.length() == 0) {
					break;
				}
			}
			if (row == BOARD_SIZE - 1) {
				if (text1.equals("X"))
					return GameStatus.XWins;
				else
					return GameStatus.ZWins;
			}
		}

		// text inside first diagonal
		for (row = 0, col = 0; row < BOARD_SIZE - 1; row++, col++) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row + 1][col + 1].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
		}
		if (row == BOARD_SIZE - 1) {
			if (text1.equals("X"))
				return GameStatus.XWins;
			else
				return GameStatus.ZWins;
		}

		// text inside second diagonal
		for (row = BOARD_SIZE - 1, col = 0; row > 0; row--, col++) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row - 1][col + 1].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
		}
		if (row == 0) {
			if (text1.equals("X"))
				return GameStatus.XWins;
			else
				return GameStatus.ZWins;
		}

		String text = "";
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE; col++) {
				text = buttons[row][col].getText();
				if (text.length() == 0) {
					return GameStatus.Incomplete;
				}
			}
		}
		return GameStatus.Tie;
	}

	private void declareWinner(GameStatus gs) {
		if (gs == GameStatus.XWins)
			JOptionPane.showMessageDialog(this, "X Rbe7!");
		else if (gs == GameStatus.ZWins)
			JOptionPane.showMessageDialog(this, "0 Rbe7!");
		else
			JOptionPane.showMessageDialog(this, "7ad ma rbe7!");
	}
        

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe t = new TicTacToe();
	

}
}