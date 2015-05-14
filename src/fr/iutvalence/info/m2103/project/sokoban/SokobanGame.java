package fr.iutvalence.info.m2103.project.sokoban;
 
/**
 * A Sokoban game
 * Rules : http://en.wikipedia.org/wiki/Sokoban
 * @author hugo, virgil
 *
 */
public class SokobanGame {
	
	
	/* game's map */
	private Map map;
	/* game's player */
	private Player player;
	/* game's display */
	private Display display;

	
	
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
			
			
			/*try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		
		}
		
		}

/**
 * Do a move of one square in one direction. Check if this move is possible and push the box if necessary
 * 
 */
	private void processMove(Move move) {
		Position newPosChar;
		Position newPosBox;
		switch(move.getDirection()){
		/* if direction is up */
		case UP:
			
			newPosChar = new Position(this.map.getCharPos().getX(),this.map.getCharPos().getY()-1);
			/* check there is no wall upper */
			if(this.map.getElementOfGrid(this.map.getCharPos().getX(), this.map.getCharPos().getY()-1) == SquareType.WALL)
				break;
			/* check if there is a box */
			if(newPosChar.equals(this.map.getBoxPos()))
			{
				/* check the box is not in front of a wall */
				if(this.map.getElementOfGrid(this.map.getBoxPos().getX(), this.map.getBoxPos().getY()-1) == SquareType.WALL)
					break;
				/* push the box */
				newPosBox = new Position(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1);
				if(newPosBox.equals(this.map.getBoxPos2()))
					break;
				this.map.setBoxPos(newPosBox);
			}
			else if(newPosChar.equals(this.map.getBoxPos2()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(), this.map.getBoxPos2().getY()-1) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()-1);
				if(newPosBox.equals(this.map.getBoxPos()))
					break;
				this.map.setBoxPos2(newPosBox);
			}
			/* push the character */
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
				if(newPosBox.equals(this.map.getBoxPos2()))
					break;
				this.map.setBoxPos(newPosBox);
			}
			else if(newPosChar.equals(this.map.getBoxPos2()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(), this.map.getBoxPos2().getY()+1) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()+1);
				if(newPosBox.equals(this.map.getBoxPos()))
					break;
				this.map.setBoxPos2(newPosBox);
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
				if(newPosBox.equals(this.map.getBoxPos2()))
					break;
				this.map.setBoxPos(newPosBox);
			}
			else if(newPosChar.equals(this.map.getBoxPos2()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()-1, this.map.getBoxPos2().getY()) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos2().getX()-1,this.map.getBoxPos2().getY());
				if(newPosBox.equals(this.map.getBoxPos()))
					break;
				this.map.setBoxPos2(newPosBox);
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
				if(newPosBox.equals(this.map.getBoxPos2()))
					break;
				this.map.setBoxPos(newPosBox);
			}
			else if(newPosChar.equals(this.map.getBoxPos2()))
			{
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()+1, this.map.getBoxPos2().getY()) == SquareType.WALL)
					break;
				newPosBox = new Position(this.map.getBoxPos2().getX()+1,this.map.getBoxPos2().getY());
				if(newPosBox.equals(this.map.getBoxPos()))
					break;
				this.map.setBoxPos2(newPosBox);
			}
			this.map.setCharPos(newPosChar);
			break;
		
		}
	}

/** 
 * Check if the box is stuck and return true if there are no way to win.
 * 
 */
	private boolean gameIsLost() {
		Position boxPosA;
		Position boxPosB;
		
		
		/* Box are in top left corner or top*/
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1) == SquareType.WALL)
		{
			boxPosA = new Position(this.map.getBoxPos().getX()+1, this.map.getBoxPos().getY());
			boxPosB = new Position(this.map.getBoxPos().getX()-1, this.map.getBoxPos().getY());
			
			/* Box and Box2 are in top and Box2 is right to Box */
			if(boxPosA.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			/* Box and Box2 are in top and Box2 is left to Box */
			if(boxPosB.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()-1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				/* Box2 are in top right corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()-1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()+1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in bottom left corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()+1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()-1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in bottom right corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()+1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()+1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
			}
				
		}
		
		/* Box are in top right corner*/
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1) == SquareType.WALL)
		{
			
			boxPosA = new Position(this.map.getBoxPos().getX()+1, this.map.getBoxPos().getY());
			boxPosB = new Position(this.map.getBoxPos().getX()-1, this.map.getBoxPos().getY());
			
			/* Box and Box2 are in top and Box2 is right to Box */
			if(boxPosA.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			/* Box and Box2 are in top and Box2 is left to Box */
			if(boxPosB.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()+1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				/* Box2 are in top left corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()-1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()-1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in bottom left corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()+1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()-1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in bottom right corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()+1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()+1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
			}
		}
		
		/* Box are in bottom left corner*/
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()+1) == SquareType.WALL)
		{
			
			boxPosA = new Position(this.map.getBoxPos().getX()+1, this.map.getBoxPos().getY());
			boxPosB = new Position(this.map.getBoxPos().getX()-1, this.map.getBoxPos().getY());
			
			/* Box and Box2 are in bottom and Box2 is right to Box */
			if(boxPosA.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			/* Box and Box2 are in bottom and Box2 is left to Box */
			if(boxPosB.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()-1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				/* Box2 are in top right corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()-1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()+1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in top left corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()-1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()-1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in bottom right corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()+1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()+1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
			}
		}
		
		/* Box are in bottom right corner*/
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()+1) == SquareType.WALL)
		{
			
			boxPosA = new Position(this.map.getBoxPos().getX()+1, this.map.getBoxPos().getY());
			boxPosB = new Position(this.map.getBoxPos().getX()-1, this.map.getBoxPos().getY());
			
			/* Box and Box2 are in bottom and Box2 is right to Box */
			if(boxPosA.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			/* Box and Box2 are in bottom and Box2 is left to Box */
			if(boxPosB.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			if(this.map.getElementOfGrid(this.map.getBoxPos().getX()+1,this.map.getBoxPos().getY()) == SquareType.WALL)
			{
				/* Box2 are in top right corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()-1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()+1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in top left corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()-1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()-1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
				
				/* Box2 are in bottom left corner*/
				if(this.map.getElementOfGrid(this.map.getBoxPos2().getX(),this.map.getBoxPos2().getY()+1) == SquareType.WALL)
				{
					if(this.map.getElementOfGrid(this.map.getBoxPos2().getX()-1,this.map.getBoxPos2().getY()) == SquareType.WALL)
					{
						System.out.println("You lose !");
						return true;
					}
				}
			}
		}
		/*Box are in left*/
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX()-1,this.map.getBoxPos().getY()) == SquareType.WALL)
		{
			boxPosA = new Position(this.map.getBoxPos().getX(), this.map.getBoxPos().getY()-1);
			boxPosB = new Position(this.map.getBoxPos().getX(), this.map.getBoxPos().getY()+1);
			
			/* Box and Box2 are in bottom and Box2 is right to Box */
			if(boxPosA.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			/* Box and Box2 are in bottom and Box2 is left to Box */
			if(boxPosB.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
		}
		
		/*Box are in right*/
		if(this.map.getElementOfGrid(this.map.getBoxPos().getX()+1,this.map.getBoxPos().getY()) == SquareType.WALL)
		{
			boxPosA = new Position(this.map.getBoxPos().getX(), this.map.getBoxPos().getY()-1);
			boxPosB = new Position(this.map.getBoxPos().getX(), this.map.getBoxPos().getY()+1);
			
			/* Box and Box2 are in bottom and Box2 is right to Box */
			if(boxPosA.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
			
			/* Box and Box2 are in bottom and Box2 is left to Box */
			if(boxPosB.equals(this.map.getBoxPos2()))
			{
				System.out.println("You lose !");
				return true;
			}
		}
		
		return false;
	}

/**
 * check if the game is win: return true if the boxe is on the reach point.
 * 
 */
	private boolean gameIsWon() {
		if(this.map.getBoxPos().equals(this.map.getRPpos()) && this.map.getBoxPos2().equals(this.map.getRPpos2()))
		{
			System.out.println("You win !");
			return true;
		}
		if(this.map.getBoxPos2().equals(this.map.getRPpos()) && this.map.getBoxPos().equals(this.map.getRPpos2()))
		{
			System.out.println("You win !");
			return true;
		}
			
		return false;
		
	}
	
}
