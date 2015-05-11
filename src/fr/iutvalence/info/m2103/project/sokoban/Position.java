package fr.iutvalence.info.m2103.project.sokoban;

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
