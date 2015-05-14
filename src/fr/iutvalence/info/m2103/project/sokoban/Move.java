package fr.iutvalence.info.m2103.project.sokoban;

/**
 * This class represents a move (square by square). A move is defined by a
 * position and a direction
 * 
 * @author hugo, virgil
 *
 */
public class Move {
	
	/**
	 * direction of the move
	 */
	private Direction direction;
	
	/**
	 * set the move
	 * @param direction
	 */
	public Move(Direction direction) {
		this.direction = direction;
	}
	
	/**
	 * get the direction of the move
	 * @return
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * set the direction of the move
	 * @param direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Move [direction=" + direction + "]";
	}
	

	
}
