package fr.iutvalence.info.m2103.project.sokoban;
 
/**
 * A Sokoban game
 * Rules : http://en.wikipedia.org/wiki/Sokoban
 * @author hugo, virgil
 *
 */
public class SokobanGame {
	
	// TODO (READ) (think about it) this class has no field and no constructor, it sounds quite weird

	private Map map;

	

	// TODO (done) write a more accurate comment
	// TODO (done) this method is not supposed to build anything but to start the game (consider re-reading the very first TODO of this class)
	
	
	public SokobanGame(){
		this.map = new Map();
		
		this.play();
		
	}	
	
	/**
	 * start a Sokoban game : build a map, set character, boxes, reach point,..
	 */
	public boolean play() {
		
		while (true)
		{
			// test if game is won or lost
			if (this.gameIsWon()) return true;
			if (this.gameIsLost()) return false;
			// ask user for a move
			Move move = new Move(Direction.UP);
			// process the move
			this.processMove(move);
			// ...
			// display map
			System.out.println(map.toString());
		}
		
		}


	private void processMove(Move move) {
		switch(move.getDirection()){
		
		case UP:
			
			break;
		
		case DOWN:
			
			break;
			
		case LEFT:
			
			break;
			
		case RIGHT:
			
			break;
		
		}
	}


	private boolean gameIsLost() {
		// TODO Auto-generated method stub
		return false;
	}


	private boolean gameIsWon() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
