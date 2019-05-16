package domino;

import java.util.*;

public class DominoTest {
	public static void main(String[] args) {
		Game game = new Game();
		game.drawCards();
		

			System.out.println("Dock: " + Game.dock);
			System.out.println("Player1: " + game.player1.playerTiles);
			System.out.println("Player2: " + game.player2.playerTiles);
			game.p1move(5, "left");
			game.p2move(4, "left");
			game.p1move(5, "right");
			game.p2move(0, "left");
			game.p1move(1, "left");
			game.p2move(3, "right");
			game.p1move(0, "left");
			game.p2move(2, "right");
			
			
			
			/*game.p1move(2, "right");
			
			
			/*game.p2move();*/
			
			System.out.println("Player1: " + game.player1.playerTiles);
			System.out.println("Player2: " + game.player2.playerTiles);
			System.out.println(game.turn.p1turn);
			System.out.println(game.turn.p2turn);
			System.out.println(Game.field);
			System.out.println("leftPossibleSpot = " + Turn.leftPossibleSpot);
			System.out.println("rightPossibleSpot = " + Turn.rightPossibleSpot);
			
	}	
}