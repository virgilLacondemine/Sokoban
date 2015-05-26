package fr.iutvalence.info.m2103.project.sokoban.ihm;

import fr.iutvalence.info.m2103.project.sokoban.engine.*;
import fr.iutvalence.info.m2103.project.sokoban.ihm.*;
import fr.iutvalence.info.m2103.project.sokoban.player.*;
import fr.iutvalence.info.m2103.project.sokoban.map.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * display the application in GUI
 * @author hugo, virgil
 *
 */
public class GUIDisplay implements Display, ActionListener{

	JFrame frame = new JFrame();
	JPanel pan1 = new JPanel();
	JPanel pan3 = new JPanel();
	JSplitPane secondarySplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new ControlPanel(this), pan3);
	JSplitPane mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan1, secondarySplitPane);
	
	JLabel textArea = new JLabel("Game in process");
	
	
	/**
	 * display the application in GUI
	 */
	//TODO Finsih to code the GUI
	public void displayMap(String mapAscii){
		
		this.textArea.setOpaque(true);
		this.textArea.setBackground(Color.WHITE);
		this.textArea.setHorizontalAlignment(SwingConstants.RIGHT);
	
	    this.pan1.setBackground(Color.GRAY);
		this.pan1.setLayout(new GridLayout(11,11));
		
		this.pan3.setBackground(Color.WHITE);
		this.pan3.add(textArea);
		
		this.secondarySplitPane.setDividerLocation(200);
		this.secondarySplitPane.setDividerSize(0);
		this.secondarySplitPane.setBorder(null);
		
		this.mainSplitPane.setDividerLocation(500);
		this.mainSplitPane.setDividerSize(0);
		this.mainSplitPane.setBorder(null);
		
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(600, 800);
		this.frame.setLocationRelativeTo(null);
		this.frame.setTitle("Sokoban");
		this.frame.setResizable(false);
		this.frame.getContentPane().add(this.mainSplitPane);
		this.frame.setJMenuBar(new Menu(this.frame));
		

	}

			public void actionPerformed(ActionEvent e)
		{

		}
	
	
}
