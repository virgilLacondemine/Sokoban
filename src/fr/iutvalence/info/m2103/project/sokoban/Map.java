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
	public SquareType[][] grid;
	


	// TODO (done) (felt? you mean filled?)
	/**
	 * constructor which makes a new map COLUMNS by LINES filled with squares.
	 */
	public Map() {
		this.createBlankMap();
		this.fillMap();
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

		this.grid[CHAR_X][CHAR_Y] = SquareType.CHARACTER;
		this.grid[BOX_X][BOX_Y] = SquareType.BOX;
		this.grid[RP_X][RP_Y] = SquareType.REACHPOINT;

	}
	
	
	public String toString() {
		
		String newMap = "";
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
		{
			newMap = newMap+"\n";
			for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
				switch (this.grid[columnNumber][lineNumber])
				{
					case WALL:
						newMap = newMap+"X";
						break;
					case BOX:
						newMap = newMap+"#";
						break;
					case CHARACTER:
						newMap = newMap+"O";
						break;
					case REACHPOINT:
						newMap = newMap+"+";
						break;
					case VOID: 
						newMap = newMap+" ";
				}
		}
		
		return newMap;
	}

}
