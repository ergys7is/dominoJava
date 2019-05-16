package domino;

import java.util.*;


public class DominoSet {
	public Tile[] theSet;
	private int currentTile;
	private static final int NUMBER_OF_TILES = 28;
	private static final Random randomNumbers = new Random();
	
	public DominoSet() {
		currentTile = 0;
		theSet = new Tile[NUMBER_OF_TILES];
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		while (count3 < NUMBER_OF_TILES){
			theSet[count3] = new Tile(count1, count2);
			count3++;
			count1++;
			if (count1 == 7) {count2++; count1=count2;}
		}
	}
	
	public void shuffle() {
		currentTile = 0;
		for (int first = 0; first<theSet.length; first++) {
			int second = randomNumbers.nextInt(NUMBER_OF_TILES);
			Tile temp = theSet[first];
			theSet[first] = theSet[second];
			theSet[second] = temp;
		}
	}
	/*private boolean tileExist(Tile tile, ArrayList<Tile> theSet) {
		boolean doesExist = false;
		for(Tile thisTile : theSet) {
			if (thisTile.getLeft() == tile.getRight() 
					&& thisTile.getRight() == tile.getLeft() ||
			(thisTile.getLeft() == tile.getLeft() 
			&& thisTile.getRight() == tile.getRight()))
			{doesExist = true;}}
		return doesExist;
	}*/
	
	
	
	public Tile dealTile() {
		if(currentTile < theSet.length)
			return theSet[currentTile++];
		else
			return null;
	}
}