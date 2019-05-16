package domino;

public class Tile {
	private int left;
	private int right;
	
	public Tile(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public Tile() {};
	
	private boolean flipped = false;
	
	public int getLeft() {
		return left;
	}
	public int getRight() {
		return right;
	}	
	
	public String toString() {
		return left + "|" + right;
	}
	
	/*public String toString() {
		if (left < right) 
		return left + "|" + right;
		else return right + "|" + left;
	}*/
	
	
	public boolean isFlipped() {
		return flipped;
	}
	public void flip() {
		if (flipped == false) {flipped = true;}
		else {flipped = false;};
	}
		
}