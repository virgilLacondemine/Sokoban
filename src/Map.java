// TODO fix comment: this class creates nothing, tell what it represents
/**
 * Class wich create a map. A map is a grid with a width and a height. On this
 * grid there are some objects (walls, boxes, character, ... ).
 * 
 * @author hugo, virgil
 *
 */
public class Map {

	// TODO rename constant (NUMBER_OF_COLUMNS)
	/**
	 * map's width (fixed).
	 */
	private final static int FIXED_COLUMN = 64;
	
	// TODO rename constant (NUMBER_OF_LINES)
	/**
	 * map's height (fixed).
	 */
	private final static int FIXED_LINES = 64;

	/**
	 * map's grid (can contain squares)
	 */
	private Square[][] grid;
	
	// TODO fix comment : write a more accurate comment that describe what the returned map looks like
	/**
	 * constructor which makes a new map WIDTH by HEIGHT.
	 */
	public Map()
	{
		this.build();
		this.fill();
	}
	
	// TODO fix comment: write a more detail comment (this one is not really understandable)
	/**
	 * build a new grid as a map.
	 */
	private void build()
	{
		this.grid = new Square[FIXED_COLUMN][FIXED_LINES];
		for (int columnNumber = 0; columnNumber < FIXED_COLUMN; columnNumber++)
			for (int lineNumber = 0; lineNumber < FIXED_LINES; lineNumber++)
				this.grid[columnNumber][lineNumber]= new Square();
	
		
	}
	
	/**
	 * fill the grid with objects
	 */
	private void fill()
	{

	}
}
