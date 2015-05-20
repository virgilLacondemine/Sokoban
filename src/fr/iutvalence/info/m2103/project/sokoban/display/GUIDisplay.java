package fr.iutvalence.info.m2103.project.sokoban.display;

import fr.iutvalence.info.m2103.project.sokoban.*;
import java.awt.Color;

import javax.swing.*;

/**
 * display the application in GUI
 * @author hugo, virgil
 *
 */
public class GUIDisplay implements Display{

	/**
	 * display the application in GUI
	 */
	//TODO Finsih to code the GUI
	public void displayMap(String mapAscii){
		JFrame frame = new JFrame();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Sokoban");
		
		splitPane.removeAll();
		
		pan1.setBackground(Color.cyan);
		pan2.setBackground(Color.darkGray);
		
		splitPane.add(pan1);
		splitPane.add(pan2);
		
		frame.setContentPane(splitPane);
		
		
	}
	
}
