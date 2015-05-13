package fr.iutvalence.info.m2103.project.sokoban;

public class RandomPlayer implements Player {

	public Direction getDirection(){
		return Direction.getRandomDirection();
	}
	
}
