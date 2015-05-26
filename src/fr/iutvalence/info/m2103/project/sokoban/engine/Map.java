package fr.iutvalence.info.m2103.project.sokoban.engine;


public interface Map
{
	public Position getCharPos();
	
	public void setCharPos(Position pos);
	
	public SquareType getElementOfGrid(int x, int y);
	
	public boolean searchEqualInBoxList(Position obj);
	
	public Position getEqualInBoxList(Position obj);
	
	public int getSizeOfBoxList();
	
	public Position getElementOfBoxList(int index);
	
	public void changeBoxPosition(Position actual, Position newPos);
	
	public boolean searchEqualInReachPointList(Position obj);
	
	public Position getEqualInReachPointList(Position obj);
	
	public int getSizeOfReachPointList();
	
	public Position getElementOfReachPointList(int index);
	
	public String toString();
}
