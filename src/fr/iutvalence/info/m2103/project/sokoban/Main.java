package fr.iutvalence.info.m2103.project.sokoban;

/**
 * Launcher for a Sokoban game
 * 
 * @author hugo, virgil
 * 
 *
 */
public class Main {
	/**
	 * Create a new Sokoban game and play it
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		/**
		 * way to play (keyboard, random, other)
		 */
		Player player = new RandomPlayer();
		/**
		 * way to display
		 */
		Display display = new ConsoleDisplay();
		
		/**
		 * map chosen to play
		 */
		Map map = new Map2();
		
		/**
		 * create a sokoban game with the way to display and way to play
		 */
		new SokobanGame(display, player, map).play();
		
		
		
	}

}
