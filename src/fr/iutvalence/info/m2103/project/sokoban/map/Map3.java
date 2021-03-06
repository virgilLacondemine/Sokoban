package fr.iutvalence.info.m2103.project.sokoban.map;

import fr.iutvalence.info.m2103.project.sokoban.engine.*;

import java.util.ArrayList;

/**
 * Class representing a Sokoban game map. A map is a 2D grid where are placed
 * some objects (walls, boxes, character, ... ).
 * 
 * @author hugo, virgil
 *
 */

public class Map3 implements Map{

	/**
	 * map's width (fixed).
	 */
	private static final int NUMBER_OF_COLUMNS = 9;

	/**
	 * map's height (fixed).
	 */
	private final static int NUMBER_OF_LINES = 9;

	/**
	 * Character's column position.
	 */
	private final static int CHAR_X = 6;

	/**
	 * Character's line position.
	 */
	private final static int CHAR_Y = 4;
		
	/**
	 * map's grid (can contain objects (square types ))
	 */
	private SquareType[][] grid;
	
	/**
	 * character position on the map (can evolve)
	 */
	private Position char_pos;
	
	/**
	 * 
	 */
	private ArrayList<Position> boxList;
	
	/**
	 * 
	 */
	private ArrayList<Position> reachPointList;
	
	/**
	 * constructor which makes a new map COLUMNS by LINES filled with squares.
	 */
	public Map3() {
		this.createBlankMap();
		this.fillMap();
		this.char_pos = new Position(CHAR_X,CHAR_Y);
		this.boxList = new ArrayList<Position>();
		this.boxList.add(new Position(5,2));
		this.boxList.add(new Position(5,3));
		this.boxList.add(new Position(4,6));
		this.boxList.add(new Position(5,6));
		this.reachPointList = new ArrayList<Position>();
		this.reachPointList.add(new Position(2,5));
		this.reachPointList.add(new Position(3,5));
		this.reachPointList.add(new Position(2,6));
		this.reachPointList.add(new Position(3,6));
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
			this.grid[columnNumber][NUMBER_OF_LINES-1] = SquareType.WALL;
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
			this.grid[0][lineNumber] = SquareType.WALL;
		for (int lineNumber = 0; lineNumber < NUMBER_OF_LINES; lineNumber++)
			this.grid[NUMBER_OF_COLUMNS-1][lineNumber] = SquareType.WALL;
		for (int columnNumber = 1; columnNumber < 4; columnNumber++)
			this.grid[columnNumber][1] = SquareType.WALL;
		for (int lineNumber = 1; lineNumber < 4; lineNumber++)
			this.grid[7][lineNumber] = SquareType.WALL;
		for (int lineNumber = 3; lineNumber < 6; lineNumber++)
			this.grid[4][lineNumber] = SquareType.WALL;
		for (int lineNumber = 6; lineNumber < 8; lineNumber++)
			this.grid[7][lineNumber] = SquareType.WALL;
		this.grid[1][4] = SquareType.WALL;
		this.grid[1][7] = SquareType.WALL;
		this.grid[4][7] = SquareType.WALL;
		this.grid[3][4] = SquareType.WALL;
		this.grid[6][3] = SquareType.WALL;
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
	 * get the element who was on the x,y square
	 * @param x
	 * @param y
	 * @return
	 */
	public SquareType getElementOfGrid(int x, int y){
		return this.grid[x][y];
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public boolean searchEqualInBoxList(Position obj)
	{
		for(int index = 0; index < boxList.size(); index++)
		{
			if(this.boxList.get(index).equals(obj))
				return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Position getEqualInBoxList(Position obj)
	{
		for(int index = 0; index < boxList.size(); index++)
		{
			if(this.boxList.get(index).equals(obj))
				return this.boxList.get(index);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSizeOfBoxList()
	{
		return this.boxList.size();
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Position getElementOfBoxList(int index)
	{
		return this.boxList.get(index);
	}
	
	/**
	 * 
	 * @param actual
	 * @param newPos
	 */
	public void changeBoxPosition(Position actual, Position newPos)
	{
		for(int index = 0; index < boxList.size(); index++)
		{
			if(this.boxList.get(index).equals(actual))
				{
					this.boxList.get(index).setX(newPos.getX());
					this.boxList.get(index).setY(newPos.getY());
				}
				
		}
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public boolean searchEqualInReachPointList(Position obj)
	{
		for(int index = 0; index < reachPointList.size(); index++)
		{
			if(this.reachPointList.get(index).equals(obj))
				return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Position getEqualInReachPointList(Position obj)
	{
		for(int index = 0; index < reachPointList.size(); index++)
		{
			if(this.reachPointList.get(index).equals(obj))
				return this.reachPointList.get(index);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSizeOfReachPointList()
	{
		return this.reachPointList.size();
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Position getElementOfReachPointList(int index)
	{
		return this.reachPointList.get(index);
	}
	
	public int getNumberOfColumn()
	{
		return this.NUMBER_OF_COLUMNS;
	}
	
	public int getNumberOfLine()
	{
		return this.NUMBER_OF_LINES;
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
				
				if(searchEqualInBoxList(temp_pos))
					newMap = newMap+"#";
				
				else if (temp_pos.equals(char_pos))
					newMap = newMap+"O";
				
				else if(searchEqualInReachPointList(temp_pos))
					newMap = newMap+"+";
				
				else {
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
