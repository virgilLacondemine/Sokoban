package fr.iutvalence.info.m2103.project.sokoban;

/**
 * This class represents a move (square by square). A move is defined by a
 * position and a direction
 * 
 * @author leprunih
 *
 */
public class Move {

	private Position position;

	private Direction direction;

	public Move(Direction direction) {
		super();
		
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Move [direction=" + direction + "]";
	}
	

	
}
