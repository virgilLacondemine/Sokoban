// TODO (done) fix comment: this class creates nothing, tell what it represents

/**
 * Class wich return a map. A map is a grid with a width and a height. On this
 * grid there are some objects (walls, boxes, character, ... ).
 * 
 * @author hugo, virgil
 *
 */
public class Map {

	// TODO (done) rename constant (NUMBER_OF_COLUMNS)

	/**
	 * map's width (fixed).
	 */
	private final static int NUMBER_OF_COLUMNS = 64;
	
	// TODO (done) rename constant (NUMBER_OF_LINES)

	/**
	 * map's height (fixed).
	 */
	private final static int NUMBER_OF_LINES = 64;

	/**
	 * map's grid (can contain squares)
	 */
	private Square[][] grid;
	
	// TODO (done) fix comment : write a more accurate comment that describe what the returned map looks like

	/**
	 * constructor which makes a new map COLUMNS by LINES felt with squares.
	 */
	public Map()
	{
		this.build();
		this.fill();
	}
	
	// TODO (done) fix comment: write a more detail comment (this one is not really understandable)
	/**
	 * fill the grid with void squares.
	 */
	private void build()
	{
		this.grid = new Square[NUMBER_OF_COLUMNS][NUMBER_OF_LINES];
		for (int columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++)
			for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
				this.grid[columnNumber][lineNumber]= new Square();
	
		
	}
	
	/**
	 * replace some void squares by other type of squares
	 */
	private void fill()
	{

	}
}
