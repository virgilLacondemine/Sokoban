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
	private static final int NUMBER_OF_COLUMNS = 12;

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
	 * Box's column position.
	 */
	private final static int BOX2_X = 6;

	/**
	 * Box's line position.
	 */
	private final static int BOX2_Y = 5;
	
	/**
	 * Reach point's column position.
	 */
	private static final int RP_X = 10;

	/**
	 * Reach point's line position.
	 */
	private static final int RP_Y = 1;
	
	/**
	 * Reach point's column position.
	 */
	private final static int RP2_X = 10;

	/**
	 * Reach point's line position.
	 */
	private final static int RP2_Y = 10;
	
	
	/**
	 * map's grid (can contain objects (square types ))
	 */
	private SquareType[][] grid;
	
	/**
	 * character position on the map (can evolve)
	 */
	private Position char_pos;
	
	/**
	 * first box position on the map (can evolve)
	 */
	private Position box_pos;
	
	/**
	 * second box position on the map (can evolve)
	 */
	private Position box_pos2;
	
	/**
	 * first reach point position on the map
	 */
	private Position reachPoint_pos;
	
	/**
	 * second reach point position on the map
	 */
	private Position reachPoint_pos2;


	
	/**
	 * constructor which makes a new map COLUMNS by LINES filled with squares.
	 */
	public Map() {
		this.createBlankMap();
		this.fillMap();
		this.reachPoint_pos = new Position(this.RP_X,this.RP_Y);
		this.reachPoint_pos2 = new Position(this.RP2_X, this.RP2_Y);
		this.box_pos = new Position(this.BOX_X,this.BOX_Y);
		this.box_pos2 = new Position(this.BOX2_X, this.BOX2_Y);
		this.char_pos = new Position(this.CHAR_X,this.CHAR_Y);
	}

	
	/**
	 * create a blank map (fill the grid with void squares).
	 */
	private void createBlankMap() {
		this.grid = new SquareType[NUMBER_OF_COLUMNS][NUMBER_OF_LINES];
		for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
				this.grid[columnNumber][lineNumber] = SquareType.VOID;

	}

	
	/**
	 * replace some void squares by other type of squares
	 */
	private void fillMap() {
		for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			this.grid[columnNumber][0] = SquareType.WALL;
		for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			this.grid[columnNumber][NUMBER_OF_COLUMNS-1] = SquareType.WALL;
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
			this.grid[0][lineNumber] = SquareType.WALL;
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
			this.grid[NUMBER_OF_LINES-1][lineNumber] = SquareType.WALL;

	}
	
	/**
	 * get the character position
	 * @return
	 */
	public Position getCharPos(){
		return this.char_pos;
	}
	
	/**
	 * set the new character position 
	 * @param pos
	 */
	public void setCharPos(Position pos) {
			this.char_pos = pos;
	}
	
	/**
	 * get the first box position
	 * @return
	 */
	public Position getBoxPos(){
		return this.box_pos;
	}
	
	/**
	 * set the first box position
	 * @param pos
	 */
	public void setBoxPos(Position pos){
		this.box_pos = pos;
	}
	
	/**
	 * get the second box position
	 * @return
	 */
	public Position getBoxPos2(){
		return this.box_pos2;
	}
	
	/**
	 * set the second box position
	 * @param pos
	 */
	public void setBoxPos2(Position pos){
		this.box_pos2 = pos;
	}
	
	/**
	 * get the first reach point position
	 * @return
	 */
	public Position getRPpos(){
		return this.reachPoint_pos;
	}
	
	/**
	 * get the second reach point position
	 * @return
	 */
	public Position getRPpos2(){
		return this.reachPoint_pos2;
	}
	
	/**
	 * get the element who was on the x,y square
	 * @param x
	 * @param y
	 * @return
	 */
	public SquareType getElementOfGrid(int x, int y){
		return this.grid[x][y];
	}
	

	/**
	 * return the map in Ascii Art
	 */
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
				else if (temp_pos.equals(box_pos) || temp_pos.equals(box_pos2))
				{
					newMap = newMap+"#";
				}
				else if (temp_pos.equals(reachPoint_pos) || temp_pos.equals(reachPoint_pos2))
				{
					newMap = newMap+"+";
				}
				else{
				switch (this.grid[columnNumber][lineNumber])
				{
					case WALL:
						newMap = newMap+"X";
						break;
					case VOID: 
						newMap = newMap+" ";
				}
				}
			}
		}
		
		return newMap;
	}

	
}
