package domino;

import java.util.*;

public class Game {
	
	public Game() {};

	public static LinkedList<Tile> dock = new LinkedList<Tile>();
	public static LinkedList<Tile> field = new LinkedList<Tile>();
	
	Turn turn = new Turn();
	
	public static ArrayList<Integer> takeTurn = new ArrayList<Integer>();
	
	public void determineTurn() {
	if ((takeTurn.size()%2) == 0) {turn.p1turn = true; turn.p2turn = false;}
	else if ((takeTurn.size()%2) == 1) {turn.p2turn = true; turn.p1turn = false;}
	}
	
	DominoSet myDominoSet = new DominoSet();
	
	public void drawCards() {
		/*myDominoSet.shuffle();*/
		for (int i=0; i < 28; i++)
			if (i < 7) {player1.playerTiles.add(myDominoSet.dealTile());}
			else if (i < 14) {player2.playerTiles.add(myDominoSet.dealTile());}
			else {Game.dock.add(myDominoSet.dealTile());}
		determineTurn();
	}
	
	Player player1 = new Player();
	Player player2 = new Player();
	
	public void p1move(int position, String where) {
		if ((turn.p1turn) && (player1.checkAll(player1.playerTiles)))
			{player1.nextMove(position, where);} determineTurn();
	}
	public void p2move (int position, String where) {
		if ((turn.p2turn) && (player2.checkAll(player2.playerTiles)))
			{player2.nextMove(position, where);} determineTurn();
	}
	
	public void p1move() {
		if ((turn.p1turn) && (!player1.checkAll(player1.playerTiles)))
		{player1.takeFromTheDock();}
		determineTurn();
	}
	public void p2move() {
		if ((turn.p2turn) && (!player2.checkAll(player2.playerTiles)))
		{player2.takeFromTheDock();}
		determineTurn();
	}
}