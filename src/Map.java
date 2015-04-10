/**
 * Class wich create a map. A map is a grid with a width and a height. On this
 * grid there are some objects (walls, boxes, character, ... ).
 * 
 * @author leprunih
 *
 */
public class Map {

	/**
	 * map's width (fixed).
	 */
	private final static int FIXED_COLUMN = 64;
	/**
	 * map's height (fixed).
	 */
	private final static int FIXED_LINES = 64;

	private Square[][] grid;
	/**
	 * builder wich make a new map WIDTH by HEIGHT.
	 */
	public Map()
	{
		this.build();
		this.fill();
	}

	private void build()
	{
		this.grid = new Square[FIXED_COLUMN][FIXED_LINES];
		for (int columnNumber = 0; columnNumber < FIXED_COLUMN; columnNumber++)
			for (int lineNumber = 0; lineNumber < FIXED_LINES; lineNumber++)
				this.grid[columnNumber][lineNumber]= new Square();
	
		
	}

	private void fill()
	{

	}
}
