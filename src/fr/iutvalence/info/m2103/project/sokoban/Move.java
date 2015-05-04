package fr.iutvalence.info.m2103.project.sokoban;

/**
 * This class represents a move (square by square). A move is defined by a
 * position and a direction
 * 
 * @author leprunih
 *
 */
public class Move {

	private final Position position;

	private Direction direction;

	public Move(Position position, Direction direction) {
		super();
		this.position = position;
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Move [position=" + position + ", direction=" + direction + "]";
	}

	
}
