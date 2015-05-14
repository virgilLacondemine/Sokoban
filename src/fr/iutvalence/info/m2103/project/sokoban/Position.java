package fr.iutvalence.info.m2103.project.sokoban;
/**
 * This is the position for some object on the map. Build with two coordinates x and y * @author hugo, virgil
 *
 */
public class Position {

	private int x;
	
	private int y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
	/**
	 * Check if two positions are equals: x1 = x2 and y1 = y2
	 */
	 public boolean equals(Position position) {
	       
	        if (position==this) {
	            return true;
	        }
	 
	        if (position instanceof Position) {
	            
	            Position pos = (Position) position;
	 
	            
	            if (this.x != position.x) {
	                return false; 
	            }
	 
	            if (this.y != position.y) {
	            	return false;
	            }

	            return true;
	        }
	 
	        return false;
	    }
	
	
	
}
