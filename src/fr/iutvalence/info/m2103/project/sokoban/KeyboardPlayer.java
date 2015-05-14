package fr.iutvalence.info.m2103.project.sokoban;
/**
 *  Class ask to a player to play with the keyboard.
 */
import java.util.Scanner;

public class KeyboardPlayer implements Player{
	
	public Direction getDirection(){
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
	}
	
	

}
