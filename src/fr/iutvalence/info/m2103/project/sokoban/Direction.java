package fr.iutvalence.info.m2103.project.sokoban;

import java.util.Random;
import java.util.Scanner;

public enum Direction {
	
	UP, DOWN, LEFT, RIGHT;

	public static Direction getRandomDirection(){
		Random random = new Random();
        return values()[random.nextInt(values().length)];
	}
	
}
