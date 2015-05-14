package fr.iutvalence.info.m2103.project.sokoban;
/**
 * Display the map in the console
 * @author hugo, virgil
 *
 */
public class ConsoleDisplay implements Display{
	
	/**
	 * Display the map in Ascii Art in the console
	 */
	public void displayMap(String mapAscii){
		System.out.println(mapAscii);
	}

}
