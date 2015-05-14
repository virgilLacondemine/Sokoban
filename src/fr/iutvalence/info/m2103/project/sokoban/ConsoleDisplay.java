package fr.iutvalence.info.m2103.project.sokoban;
/**
 * Display the map in the console
 * @author hugo
 *
 */
public class ConsoleDisplay implements Display{
	
	public void displayMap(String mapAscii){
		System.out.println(mapAscii);
	}

}
