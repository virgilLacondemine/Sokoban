package fr.iutvalence.info.m2103.project.sokoban;
/**
 * enum of the possible direction chosen to do a move.
 */
import java.util.Random;
import java.util.Scanner;

public enum Direction{
	
	UP, DOWN, LEFT, RIGHT;

	public static Direction getRandomDirection(){
		Random random = new Random();
        return values()[random.nextInt(values().length)];
	}
	
	/*public static Direction getKeyboardDirection(){
		Scanner sc = new Scanner(System.in);
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
		}
		return null;
	}*/
	
}
