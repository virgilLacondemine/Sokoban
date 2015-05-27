package fr.iutvalence.info.m2103.project.sokoban.launcher;

import fr.iutvalence.info.m2103.project.sokoban.map.*;
import fr.iutvalence.info.m2103.project.sokoban.display.*;
import fr.iutvalence.info.m2103.project.sokoban.player.*;
import fr.iutvalence.info.m2103.project.sokoban.engine.*;
import fr.iutvalence.info.m2103.project.sokoban.ihm.*;

/**
 * Launcher for a Sokoban game
 * 
 * @author hugo, virgil
 * 
 *
 */
public class GUILauncher {
	/**
	 * Create a new Sokoban game and play it
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		
		/**
		 * map chosen to play
		 */
		Map map = new Map2();
		
		/**
		 * way to play (keyboard, random, other)
		 */
		GUI gui = new GUI(map.getNumberOfColumn(), map.getNumberOfLine());
		
		Display display = new ConsoleDisplay();
						
		/**
		 * create a sokoban game with the way to display and way to play
		 */
		new SokobanGame(display, gui, map).play();
		
		
		
	}

}
