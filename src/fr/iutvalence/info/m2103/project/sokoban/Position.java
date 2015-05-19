package fr.iutvalence.info.m2103.project.sokoban;
/**
 * This is the position for some object on the map. Build with two coordinates x and y 
 * @author hugo, virgil
 *
 */
public class Position {

	/**
	 * x cordonate of the position
	 */
	private int x;
	
	/**
	 * y cordonate of the position
	 */
	private int y;
	
	/**
	 * create a position
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * get x coredonate of the position
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * get y cordonate of the position
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * set x cordonate of the position
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * set y cordonate of the position
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	 /**
	  * Check if two positions are equals: x1 = x2 and y1 = y2
	  * @param position
	  * @return
	  */
	 public boolean equals(Object position) {
	       
	        if (position==this) {
	            return true;
	        }
	 
	        if (position instanceof Position) {
	            
	            Position pos = (Position) position;
	 
	            
	            if (this.x != pos.x) {
	                return false; 
	            }
	 
	            if (this.y != pos.y) {
	            	return false;
	            }

	            return true;
	        }
	 
	        return false;
	    }
	
	
	
}
