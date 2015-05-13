package fr.iutvalence.info.m2103.project.sokoban;

import javax.swing.*;

public class GUIDisplay implements Display{

	public void displayMap(String mapAscii){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Sokoban");
	}
	
}
