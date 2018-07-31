import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board implements ActionListener {
	//The title of the program
	private static final String TITLE = "3D - Tic Tac Toe";
	//Text representing player 1 and player 2
	private static final String PLAYER_1_TEXT = "Player 1", PLAYER_2_TEXT = "Player 2";
	//Text on the Reset Button
	private static final String RESET = "Reset";
	//Welcome message
	private static final String WELCOME = "Welcome to 3D Tic Tac Toe, Red indicates player turn";
	//Taken message
	private static final String TAKEN = "This spot is already taken";
	//Regular expression representing all letters
	private static final String LETTER_REGEX = "[a-zA-Z]", BLANK = " ";
	//The width and height of the program window
	private static final int WIDTH = 800, HEIGHT = 400;
	//Integers associated player turns
	private static final int PLAYER_1 = 1, PLAYER_2 = 2;
	//The main JFrame in which the panels are added
	private JFrame brd;
	//JPanels representing a button panel and an options panel
	private JPanel btnPnl, optPnl;
	//JLabels representing which turn the game is on and the scores of the players
	private JLabel p1Text, p2Text, p1Score, p2Score;
	//Players 1 and 2
	private Player player1, player2;
	//Button to reset the grid, and buttons
	private JButton reset;
	//The grid used to check win conditions
	private Grid grid;
	//The integer representing the players turn,
	private int playerTurn = PLAYER_1;

	public Board (Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		grid = new Grid();
		p1Text = new JLabel(PLAYER_1_TEXT);
		p2Text = new JLabel(PLAYER_2_TEXT);
		initializeFrame();
		initializePanels();
	}

	public void actionPerformed(ActionEvent e) {

		String actionEvent = e.getActionCommand();

		JButton btn = (JButton) e.getSource();

		boolean isThere;

		if(actionEvent.equals(RESET)){

			for (Component c : btnPnl.getComponents())
			       ((JButton)c).setText(BLANK);

			grid.resetGrid();

			p1Score.setText("Score: " + player1.getScore() + "");
			p2Score.setText("Score: " + player2.getScore() + "");

			return;
		}

		if(playerTurn == PLAYER_1) {
			isThere = textHelper(Integer.parseInt(actionEvent),player1.getSymbol(),btn);
			if(!isThere){
				playerTurn = PLAYER_2;
				p2Text.setForeground(Color.RED);
				p1Text.setForeground(Color.BLACK);
			}
			if(player1.checkWin(grid)){
				System.out.println("Player 1 wins");
				actionPerformed(new ActionEvent((Object)reset,0,RESET));
			}

		} else if (playerTurn == PLAYER_2) {
			isThere = textHelper(Integer.parseInt(actionEvent),player2.getSymbol(),btn);
			if(!isThere) {
				playerTurn = PLAYER_1;
				p1Text.setForeground(Color.RED);
				p2Text.setForeground(Color.BLACK);
			}
			if(player2.checkWin(grid)){
				System.out.println("Player 2 wins");
				actionPerformed(new ActionEvent((Object)reset,0,RESET));
			}
		}
	}

	private void initializePanels(){

		btnPnl = new JPanel();
		optPnl = new JPanel();

		p1Score = new JLabel("Score: " + player1.getScore() + "");
		p2Score = new JLabel("Score: " + player2.getScore() + "");

		btnPnl.setLayout(new GridLayout(3,9));

		btnPnl.setPreferredSize(new Dimension(WIDTH,HEIGHT - 100));

		for(JButton btn: grid.getValues()){
			btn.addActionListener(this);
			btnPnl.add(btn);
		}


		reset = new JButton(RESET);
		reset.addActionListener(this);


		p1Text.setForeground(Color.RED);


		optPnl.add(p1Text);
		optPnl.add(p1Score);
		optPnl.add(reset);
		optPnl.add(p2Text);
		optPnl.add(p2Score);
		brd.add(btnPnl, BorderLayout.NORTH);
		brd.add(optPnl, BorderLayout.SOUTH);

	}


	private void initializeFrame(){

		brd = new JFrame(TITLE);
		brd.setSize(WIDTH,HEIGHT);
		brd.setLayout(new BorderLayout());
		brd.setResizable(false);
		brd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		brd.setVisible(true);
	}

	private boolean textHelper(int index, String symbol, JButton btn){
		if(!btn.getText().matches(LETTER_REGEX)){
			btn.setText(symbol);
			grid.updateGrid(index, symbol);
			return false;
		}else {
			System.out.println(TAKEN);
			return true;
		}
	}

	public void printWelcome(){
		System.out.println(WELCOME);
	}
}
