package fr.iutvalence.info.m2103.project.sokoban.display;


import fr.iutvalence.info.m2103.project.sokoban.engine.*;
/**
 * Display the map in the console
 * @author hugo, virgil
 *
 */
public class ConsoleDisplay implements Display{
	
	/**
	 * Display the map in Ascii Art in the console
	 */
	public void displayMap(Map map){
		String newMap;
		newMap = map.toString();
		System.out.println(newMap);
	}
	
	public void gameIsWin()
	{
		System.out.println("You win !");
	}
	
	public void gameIsLose()
	{
		System.out.println("You Lose ...");
	}
	
}
