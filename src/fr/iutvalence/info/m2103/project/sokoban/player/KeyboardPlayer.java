package fr.iutvalence.info.m2103.project.sokoban.player;

import fr.iutvalence.info.m2103.project.sokoban.*;
import java.util.Scanner;

/**
 * Class ask to a player to play with the keyboard.
 * @author hugo, virgil
 *
 */
public class KeyboardPlayer implements Player{
	
	private Scanner sc;

	/**
	 * get a direction from a real player
	 */
	public Direction getDirection(){
		sc = new Scanner(System.in);
		String str = sc.nextLine();
		char letter = str.charAt(0);
		switch (letter)
		{
			case 'z':
				return Direction.UP;
			case 's':
				return Direction.DOWN;
			case 'q':
				return Direction.LEFT;
			case 'd':
				return Direction.RIGHT;
			default:
				return Direction.UP;
		}
		
	}
	
	

}
