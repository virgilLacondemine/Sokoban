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
	
	private Player player;
	
	private Display display;

	// TODO (done) write a more accurate comment
	// TODO (done) this method is not supposed to build anything but to start the game (consider re-reading the very first TODO of this class)
	
	
	public SokobanGame(Display display, Player player){
		this.display = display;
		this.player = player;
		this.map = new Map();
		
	}	
	
	/**
	 * start a Sokoban game : build a map, set character, boxes, reach point,..
	 */
	public boolean play() {
		while (true)
		{
			// display map
			display.displayMap(this.map.toString());
			// test if game is won or lost
			if (this.gameIsWon()) return true;
			if(this.gameIsLost()) return true;
			// ask user for a move
			Move move = new Move(player.getDirection());
			// process the move
			this.processMove(move);
			// ...
			
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
		}


	private void processMove(Move move) {
		Position newPosChar;
		Position newPosBox;
		switch(move.getDirection()){
		case UP:
			newPosChar = new Position(this.map.getCharPos().getX(),this.map.getCharPos().getY()-1);
			if(this.map.getElementOfGrid(this.map.getCharPos().getX(), this.map.getCharPos().getY()-1) == SquareType.WALL)
				break;
			if(newPosChar.equals(this.map.getBoxPos()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos().getX(), this.map.getBoxPos().getY()-1) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1);
				this.map.setBoxPos(newPosBox);
			}
			this.map.setCharPos(newPosChar);
			break;
		
		case DOWN:
			newPosChar = new Position(this.map.getCharPos().getX(),this.map.getCharPos().getY()+1);
			if(this.map.getElementOfGrid(this.map.getCharPos().getX(), this.map.getCharPos().getY()+1) == SquareType.WALL)
				break;
			if(newPosChar.equals(this.map.getBoxPos()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos().getX(), this.map.getBoxPos().getY()+1) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()+1);
				this.map.setBoxPos(newPosBox);
			}
			this.map.setCharPos(newPosChar);
			break;
			
		case LEFT:
			newPosChar = new Position(this.map.getCharPos().getX()-1,this.map.getCharPos().getY());
			if(this.map.getElementOfGrid(this.map.getCharPos().getX()-1, this.map.getCharPos().getY()) == SquareType.WALL)
				break;
			if(newPosChar.equals(this.map.getBoxPos()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos().getX()-1, this.map.getBoxPos().getY()) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos().getX()-1,this.map.getBoxPos().getY());
				this.map.setBoxPos(newPosBox);
			}
			this.map.setCharPos(newPosChar);
			break;
			
		case RIGHT:
			newPosChar = new Position(this.map.getCharPos().getX()+1,this.map.getCharPos().getY());
			if(this.map.getElementOfGrid(this.map.getCharPos().getX()+1, this.map.getCharPos().getY()) == SquareType.WALL)
				break;
			if(newPosChar.equals(this.map.getBoxPos()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos().getX()+1, this.map.getBoxPos().getY()) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos().getX()+1,this.map.getBoxPos().getY());
				this.map.setBoxPos(newPosBox);
			}
			this.map.setCharPos(newPosChar);
			break;
		
		}
	}


	private boolean gameIsLost() {
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1) == SquareType.WALL)
		{
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()-1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				System.out.println("You lose !");
				return true;
				
			}
				
		}
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1) == SquareType.WALL)
		{
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()+1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				System.out.println("You lose !");
				return true;
			}
		}
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()+1) == SquareType.WALL)
		{
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()-1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				System.out.println("You lose !");
				return true;
			}
		}
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()+1) == SquareType.WALL)
		{
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()+1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				System.out.println("You lose !");
				return true;
			}
		}
		return false;
	}


	private boolean gameIsWon() {
		if(this.map.getBoxPos().equals(this.map.getRPpos()))
		{
			System.out.println("You win !");
			return true;
		}
			
		return false;
		
	}
	
}
