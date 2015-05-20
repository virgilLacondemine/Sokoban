package fr.iutvalence.info.m2103.project.sokoban;
 
/**
 * A Sokoban game
 * Rules : http://en.wikipedia.org/wiki/Sokoban
 * @author hugo, virgil
 *
 */
public class SokobanGame {
	
	
	/**
	 * game's map
	 */
	private Map map;
	/**
	 * game's player
	 */
	private Player player;
	/**
	 * game's display
	 */
	private Display display;

	
	/**
	 * build a new map and define player type and display type
	 * @param display
	 * @param player
	 */
	public SokobanGame(Display display, Player player, Map map){
		this.display = display;
		this.player = player;
		this.map = map;
		
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
			if(this.gameIsLost()) return false;
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
	 * @param move
	 */
	private void processMove(Move move) {
		Position newPosChar;
		Position boxPos;
		Position box2Pos;
		switch(move.getDirection()){
		/* if direction is up */
		case UP:
			
			newPosChar = new Position(this.map.getCharPos().getX(),this.map.getCharPos().getY()-1);
			
			/* check there is no wall upper */
			if(this.map.getElementOfGrid(this.map.getCharPos().getX(), this.map.getCharPos().getY()-1) == SquareType.WALL)
				break;
			
			/* check if there is a box */
			if(this.map.searchEqualInBoxList(newPosChar))
			{
				boxPos = this.map.getEqualInBoxList(newPosChar); /*new Position(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1);*/
				
				/* check the box is not in front of a wall */
				if(this.map.getElementOfGrid(boxPos.getX(), boxPos.getY()-1) == SquareType.WALL)
					break;
				
				box2Pos = new Position(boxPos.getX(), boxPos.getY()-1);
				
				/* check the box is not front of a box */
				if(this.map.searchEqualInBoxList(box2Pos))
					break;
				/* push the box */
				this.map.changeBoxPosition(boxPos, box2Pos);
			}
			/* push the character */
			this.map.setCharPos(newPosChar);
			break;
			
		/* direction is down*/
		case DOWN:
			newPosChar = new Position(this.map.getCharPos().getX(),this.map.getCharPos().getY()+1);
			
			/* check there is no wall upper */
			if(this.map.getElementOfGrid(this.map.getCharPos().getX(), this.map.getCharPos().getY()+1) == SquareType.WALL)
				break;
			
			/* check if there is a box */
			if(this.map.searchEqualInBoxList(newPosChar))
			{
				boxPos = this.map.getEqualInBoxList(newPosChar); /*new Position(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1);*/
				
				/* check the box is not in front of a wall */
				if(this.map.getElementOfGrid(boxPos.getX(), boxPos.getY()+1) == SquareType.WALL)
					break;
				
				box2Pos = new Position(boxPos.getX(), boxPos.getY()+1);
				
				/* check the box is not front of a box */
				if(this.map.searchEqualInBoxList(box2Pos))
					break;
				/* push the box */
				this.map.changeBoxPosition(boxPos, box2Pos);
			}
			/* push the character */
			this.map.setCharPos(newPosChar);
			break;
			
		case LEFT:
			newPosChar = new Position(this.map.getCharPos().getX()-1,this.map.getCharPos().getY());
			
			/* check there is no wall upper */
			if(this.map.getElementOfGrid(this.map.getCharPos().getX()-1, this.map.getCharPos().getY()) == SquareType.WALL)
				break;
			
			/* check if there is a box */
			if(this.map.searchEqualInBoxList(newPosChar))
			{
				boxPos = this.map.getEqualInBoxList(newPosChar); /*new Position(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1);*/
				
				/* check the box is not in front of a wall */
				if(this.map.getElementOfGrid(boxPos.getX()-1, boxPos.getY()) == SquareType.WALL)
					break;
				
				box2Pos = new Position(boxPos.getX()-1, boxPos.getY());
				
				/* check the box is not front of a box */
				if(this.map.searchEqualInBoxList(box2Pos))
					break;
				/* push the box */
				this.map.changeBoxPosition(boxPos, box2Pos);
			}
			/* push the character */
			this.map.setCharPos(newPosChar);
			break;
			
		case RIGHT:
			newPosChar = new Position(this.map.getCharPos().getX()+1,this.map.getCharPos().getY());
			
			/* check there is no wall upper */
			if(this.map.getElementOfGrid(this.map.getCharPos().getX()+1, this.map.getCharPos().getY()) == SquareType.WALL)
				break;
			
			/* check if there is a box */
			if(this.map.searchEqualInBoxList(newPosChar))
			{
				boxPos = this.map.getEqualInBoxList(newPosChar); /*new Position(this.map.getBoxPos().getX(),this.map.getBoxPos().getY()-1);*/
				
				/* check the box is not in front of a wall */
				if(this.map.getElementOfGrid(boxPos.getX()+1, boxPos.getY()) == SquareType.WALL)
					break;
				
				box2Pos = new Position(boxPos.getX()+1, boxPos.getY());
				
				/* check the box is not front of a box */
				if(this.map.searchEqualInBoxList(box2Pos))
					break;
				/* push the box */
				this.map.changeBoxPosition(boxPos, box2Pos);
			}
			/* push the character */
			this.map.setCharPos(newPosChar);
			break;
		
		}
	}

	//TODO adapt gameIsLost() for ArrayList<Position>
	/**
	 * Check if the box is stuck and return true if there are no way to win.
	 * @return
	 */
	private boolean gameIsLost() {
		int nbFaces = 0;
		int nbBlocked = 0;
		Position temp_pos;
		for(int index = 0; index < this.map.getSizeOfBoxList(); index++)
		{
			//Object at top of box
			temp_pos = new Position(this.map.getElementOfBoxList(index).getX(),this.map.getElementOfBoxList(index).getY()+1);
			if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
			{
				//Object at left of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX()-1,this.map.getElementOfBoxList(index).getY());
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
				
				//Object at right of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX()+1,this.map.getElementOfBoxList(index).getY());
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
			}
				
			//Object at bottom of box
			temp_pos = new Position(this.map.getElementOfBoxList(index).getX(),this.map.getElementOfBoxList(index).getY()-1);
			if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
			{
				//Object at left of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX()-1,this.map.getElementOfBoxList(index).getY());
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
				
				//Object at right of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX()+1,this.map.getElementOfBoxList(index).getY());
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
			}
				
			//Object at left of box
			temp_pos = new Position(this.map.getElementOfBoxList(index).getX()-1,this.map.getElementOfBoxList(index).getY());
			if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
			{
				//Object at top of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX(),this.map.getElementOfBoxList(index).getY()+1);
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
				
				//Object at bottom of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX(),this.map.getElementOfBoxList(index).getY()-1);
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
			}
				
				
			//Object at right of box
			temp_pos = new Position(this.map.getElementOfBoxList(index).getX()+1,this.map.getElementOfBoxList(index).getY());
			if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
			{
				//Object at top of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX(),this.map.getElementOfBoxList(index).getY()+1);
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
				
				//Object at bottom of box
				temp_pos = new Position(this.map.getElementOfBoxList(index).getX(),this.map.getElementOfBoxList(index).getY()-1);
				if(this.map.getElementOfGrid(temp_pos.getX(),temp_pos.getY()) == SquareType.WALL || this.map.searchEqualInBoxList(temp_pos))
					nbFaces++;
			}
			
			if(nbFaces >= 2)
				{
					nbBlocked++;
					nbFaces = 0;
				}
				
		}
		if(nbBlocked >= this.map.getSizeOfBoxList())
		{
			System.out.println("You Lose !");
			return true;
		}
		return false;
	}

	/**
	 * check if the game is win: return true if the boxes are on the reach point.
	 * @return
	 */
	private boolean gameIsWon() {
		int nbGood = 0;
		for(int boxIndex = 0; boxIndex < this.map.getSizeOfBoxList(); boxIndex++)
		{
			for(int reachPointIndex = 0; reachPointIndex < this.map.getSizeOfReachPointList(); reachPointIndex++)
			{
				if(this.map.getElementOfBoxList(boxIndex).equals(this.map.getElementOfReachPointList(reachPointIndex)))
					nbGood++;
			}
		}
		if(nbGood == this.map.getSizeOfBoxList())
		{
			System.out.println("You Win !");
			return true;
		}
		return false;
	}
	
}
