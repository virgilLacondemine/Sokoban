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
		for(int i = 0; i < 40; i++)
		{
			System.out.println("\n");
		}
		System.out.println(mapAscii);
	}

}
