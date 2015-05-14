package fr.iutvalence.info.m2103.project.sokoban;

import java.util.Random;

/**
 * enum of the possible direction chosen to do a move.
 * @author hugo, virgil
 *
 */
public enum Direction{
	
	UP, DOWN, LEFT, RIGHT;
	
	/**
	 * get a random direction
	 * @return
	 */
	public static Direction getRandomDirection(){
		Random random = new Random();
        return values()[random.nextInt(values().length)];
	}
}
