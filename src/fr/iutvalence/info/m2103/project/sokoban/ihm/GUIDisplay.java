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
public class GUIDisplay implements Display, ActionListener, Player{

	private JFrame frame;
	private JPanel pan1;
	private JPanel pan2;
	private JPanel pan3;
	private JSplitPane secondarySplitPane;
	private JSplitPane mainSplitPane;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	private JLabel textArea; 
	private ControlPanel controlPan;
	private Direction direction;
	
	
	
	public GUIDisplay (){
		
		this.frame = new JFrame();
		this.pan1 = new JPanel();
		this.pan2 = new JPanel();
		this.pan3 = new JPanel();
		this.controlPan = new ControlPanel(this);
		this.secondarySplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan2, pan3);
		this.mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan1, secondarySplitPane);
		this.textArea = new JLabel("Game in process");
		
		
		
		this.textArea.setOpaque(true);
		this.textArea.setBackground(Color.WHITE);
		this.textArea.setHorizontalAlignment(SwingConstants.RIGHT);
	
	    this.pan1.setBackground(Color.GRAY);
		this.pan1.setLayout(new GridLayout(16,16));
		
		this.pan2.setLayout(new GridLayout(2, 2));
		this.up = new JButton("UP");
		this.up.addActionListener(this);
		this.down = new JButton("DOWN");
		this.down.addActionListener(this);
		this.left = new JButton("LEFT");
		this.left.addActionListener(this);
		this.right = new JButton("RIGHT");
		this.right.addActionListener(this);
		this.pan2.add(up);
		this.pan2.add(down);
		this.pan2.add(left);
		this.pan2.add(right);
		
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
	/**
	 * display the application in GUI
	 */
	//TODO Finsih to code the GUI
	public void displayMap(String mapAscii){
		
		
		

	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.up)
		{
			this.direction = Direction.UP;
		}
		
		if (e.getSource() == this.down)
		{
			this.direction = Direction.DOWN;
		}
		
		if (e.getSource() == this.left)
		{
			this.direction = Direction.LEFT;
		}
		
		if (e.getSource() == this.right)
		{
			this.direction = Direction.RIGHT;
		}
	}
	
	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
		
	
	
	
}