package fr.iutvalence.info.m2103.project.sokoban.luncher;

import fr.iutvalence.info.m2103.project.sokoban.map.*;
import fr.iutvalence.info.m2103.project.sokoban.display.*;
import fr.iutvalence.info.m2103.project.sokoban.player.*;
import fr.iutvalence.info.m2103.project.sokoban.engine.*;

/**
 * Launcher for a Sokoban game
 * 
 * @author hugo, virgil
 * 
 *
 */
public class ConsoleLuncher {
	/**
	 * Create a new Sokoban game and play it
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		/**
		 * way to play (keyboard, random, other)
		 */
		Player player = new KeyboardPlayer();
		/**
		 * way to display
		 */
		Display display = new ConsoleDisplay();
		
		/**
		 * map chosen to play
		 */
		Map map = new Map1();
		
		/**
		 * create a sokoban game with the way to display and way to play
		 */
		new SokobanGame(display, player, map).play();
		
		
		
	}

}
