package fr.iutvalence.info.m2103.project.sokoban;
/**
 * Class simulate a player who play randomly.
 * @author hugo, virgil
 *
 */
public class RandomPlayer implements Player {
	
	/**
	 * get a direction from an artificial player (random)
	 */
	public Direction getDirection(){
		return Direction.getRandomDirection();
	}
	
}
