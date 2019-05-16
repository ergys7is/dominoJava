package domino;

import java.util.*;

public class Player {

	String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public Player() {};
	Tile tile = new Tile();
	
	public ArrayList<Tile> playerTiles = new ArrayList<Tile>();
	
	public void takeFromTheDock(){
		if (!checkAll(playerTiles) && Game.dock.size() > 2) {
		playerTiles.add(Game.dock.get(0));
		Game.dock.poll();}
		else {Game.takeTurn.add(1);}
	}
	
	public boolean checkAll(ArrayList<Tile> playerTiles) {
		for (Tile tile:playerTiles)
			if (check(tile) == true)
			break;
			{return true;}
	}
	
	public boolean check(Tile tile) {
		if (tile.getLeft() == Turn.leftPossibleSpot ||
			tile.getLeft() == Turn.rightPossibleSpot ||	
			tile.getRight() == Turn.leftPossibleSpot ||
			tile.getRight() == Turn.rightPossibleSpot)
			{return true;}
		else {return false;}
	}
	
	public int canPutTile(Tile tile, String where) {
		if(where.equals("left") && (Turn.leftPossibleSpot == tile.getLeft())) {return 1;}
		else if(where.equals("left") && (Turn.leftPossibleSpot == tile.getRight())) {return 2;}
		else if(where.equals("right") && (Turn.rightPossibleSpot == tile.getRight())) {return 3;}
		else if(where.equals("right") && (Turn.rightPossibleSpot == tile.getLeft())) {return 4;}
		else {return 5;}
		}
		
	public void nextMove(int position, String where) {
		Tile tile = playerTiles.get(position);
		 if ((where.equals("left") && 
				 ((canPutTile(tile, "left") == 1 || canPutTile(tile, "left") == 2))) 
		 ||
		 (where.equals("right") && 
				 ((canPutTile(tile, "right") == 3 || canPutTile(tile, "right") == 4)))) 
		 {putTile(position); Game.takeTurn.add(1);}
	}
	
	public void putTile(int position) {
		Tile tile = playerTiles.get(position);
		if (canPutTile(tile, "left") == 1) {
			tile.flip(); Turn.leftPossibleSpot = tile.getRight();
			Game.field.addFirst(playerTiles.get(position));}
		else if (canPutTile(tile, "left") == 2) {
			tile.flip(); Turn.leftPossibleSpot = tile.getLeft();
			Game.field.addFirst(playerTiles.get(position));}
		else if (canPutTile(tile, "right") == 3) {
			tile.flip(); Turn.rightPossibleSpot = tile.getLeft();
			Game.field.addLast(playerTiles.get(position));}
		else if (canPutTile(tile, "right") == 4) {
			tile.flip(); Turn.rightPossibleSpot = tile.getRight();
			Game.field.addLast(playerTiles.get(position));}
		playerTiles.remove(position);
		if (playerTiles.size() == 0) {System.out.print("Player won the game");}
	}
	
	public int calculatePoints() {
		int points = 0;
		for(Tile thisTile : playerTiles) {
			int theTile = thisTile.getLeft() + thisTile.getRight();
			points = points + theTile;}
		return points;}
}