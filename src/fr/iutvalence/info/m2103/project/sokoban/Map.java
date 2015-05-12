package fr.iutvalence.info.m2103.project.sokoban;

/**
 * Class representing a Sokoban game map. A map is a 2D grid where are placed
 * some objects (walls, boxes, character, ... ).
 * 
 * @author hugo, virgil
 *
 */

public class Map {

	/**
	 * map's width (fixed).
	 */
	private final static int NUMBER_OF_COLUMNS = 12;

	/**
	 * map's height (fixed).
	 */
	private final static int NUMBER_OF_LINES = 12;

	/**
	 * Character's column position.
	 */
	private final static int CHAR_X = 1;

	/**
	 * Character's line position.
	 */
	private final static int CHAR_Y = 10;

	/**
	 * Box's column position.
	 */
	private final static int BOX_X = 5;

	/**
	 * Box's line position.
	 */
	private final static int BOX_Y = 6;

	/**
	 * Reach point's column position.
	 */
	private final static int RP_X = 10;

	/**
	 * Reach point's line position.
	 */
	private final static int RP_Y = 1;
	
	
	/**
	 * map's grid (can contain objects (square types ))
	 */
	private SquareType[][] grid;
	
	private Position char_pos;
	
	private Position box_pos;
	
	private Position reachPoint_pos;
	


	// TODO (done) (felt? you mean filled?)
	/**
	 * constructor which makes a new map COLUMNS by LINES filled with squares.
	 */
	public Map() {
		this.createBlankMap();
		this.fillMap();
		this.reachPoint_pos = new Position(this.RP_X,this.RP_Y);
		this.box_pos = new Position(this.BOX_X,this.BOX_Y);
		this.char_pos = new Position(this.CHAR_X,this.CHAR_Y);
	}

	// TODO (done)rename this method (confusing)
	/**
	 * create a blank map (fill the grid with void squares).
	 */
	private void createBlankMap() {
		this.grid = new SquareType[NUMBER_OF_COLUMNS][NUMBER_OF_LINES];
		for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
				this.grid[columnNumber][lineNumber] = SquareType.VOID;

	}

	// TODO (done) rename this method (confusing)
	/**
	 * replace some void squares by other type of squares
	 */
	private void fillMap() {
		for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			this.grid[columnNumber][0] = SquareType.WALL;
		for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			this.grid[columnNumber][11] = SquareType.WALL;
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
			this.grid[0][lineNumber] = SquareType.WALL;
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
			this.grid[11][lineNumber] = SquareType.WALL;

	}
	
	public Position getCharPos(){
		return this.char_pos;
	}
	
	public void setCharPos(Position pos) {
			this.char_pos = pos;
	}

	public Position getBoxPos(){
		return this.box_pos;
	}
	
	public void setBoxPos(Position pos){
		this.box_pos = pos;
	}
	
	public Position getRPpos(){
		return this.reachPoint_pos;
	}
	
	public SquareType[][] getGrid(){
		return this.grid;
	}
	
	public SquareType getElementOfGrid(int x, int y){
		return this.grid[x][y];
	}
	
	
	public String toString() {
		
		String newMap = "";
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
		{
			newMap = newMap+"\n";
			for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			{
				Position temp_pos = new Position(columnNumber,lineNumber);
				if (temp_pos.equals(char_pos))
				{
					newMap = newMap+"O";
				}
				else if (temp_pos.equals(box_pos))
				{
					newMap = newMap+"#";
				}
				else if (temp_pos.equals(reachPoint_pos))
				{
					newMap = newMap+"+";
				}
				else{
				switch (this.grid[columnNumber][lineNumber])
				{
					case WALL:
						newMap = newMap+"X";
						break;
					/* case BOX:
						newMap = newMap+"#";
						break;
					case CHARACTER:
						newMap = newMap+"O";
						break;
					case REACHPOINT:
						newMap = newMap+"+";
						break; */
					case VOID: 
						newMap = newMap+" ";
				}
				}
			}
		}
		
		return newMap;
	}

	
}
