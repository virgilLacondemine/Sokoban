package fr.iutvalence.info.m2103.project.sokoban.ihm;

import fr.iutvalence.info.m2103.project.sokoban.engine.*;
import fr.iutvalence.info.m2103.project.sokoban.ihm.*;
import fr.iutvalence.info.m2103.project.sokoban.player.*;
import fr.iutvalence.info.m2103.project.sokoban.map.*;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


/**
 * display the application in GUI
 * @author hugo, virgil
 *
 */
public class GUI implements Display, ActionListener, Player, KeyListener{

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
	private JLabel label;
	private JLabel[][] labelGrid;
	private JButton imageVoid;
	private JButton imageWall;
	private JButton imageBox;
	private JButton imageReachPoint;
	private JButton imageCharacter;
	private Direction direction;
	private int columnNumber;
	private int lineNumber;
	
	
	
	
	public GUI (int columnNumber, int lineNumber){
		
		this.columnNumber = columnNumber;
		this.lineNumber = lineNumber;
		
		this.frame = new JFrame();
		this.pan1 = new JPanel();
		this.pan2 = new JPanel();
		this.pan3 = new JPanel();		
		
		this.textArea = new JLabel("Game in process");
		this.textArea.setOpaque(true);
		this.textArea.setBackground(Color.WHITE);
		this.textArea.setHorizontalAlignment(SwingConstants.RIGHT);
	
	    this.pan1.setBackground(Color.GRAY);
		this.pan1.setLayout(new GridLayout(this.columnNumber,this.lineNumber));
		
		this.labelGrid = new JLabel[this.lineNumber][this.columnNumber];
		
		for(int column = 0; column < this.columnNumber; column++)
		{
			for(int line = 0; line < this.lineNumber; line++)
			{
				this.labelGrid[line][column] = new JLabel();
				this.pan1.add(this.labelGrid[line][column]);
			}
	
		}
		
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
		
		this.secondarySplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan2, pan3);
		this.mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan1, secondarySplitPane);
		
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
		this.frame.addKeyListener(this);
		
	}
	/**
	 * display the application in GUI
	 */
	//TODO Finsih to code the GUI
	public void displayMap(Map map){
		for (int line = 0; line < this.lineNumber; line++)
		{
			for (int column = 0; column < this.columnNumber; column++)
			{
				Position tempPos = new Position(column,line);
				if(map.searchEqualInBoxList(tempPos))
				{
					this.labelGrid[line][column].setIcon((Icon) new ImageIcon("img/box.png"));
				}
				
				else if(tempPos.equals(map.getCharPos()))
				{
					this.labelGrid[line][column].setIcon(new ImageIcon("img/char.png"));
				}
				
				else if(map.searchEqualInReachPointList(tempPos))
				{
					this.labelGrid[line][column].setIcon(new ImageIcon("img/RP.png"));
				}
				
				else
				{
					switch (map.getElementOfGrid(column, line))
					{
						case WALL:
							this.labelGrid[line][column].setIcon(new ImageIcon("img/wall.png"));
							break;
						case VOID:
							this.labelGrid[line][column].setIcon(new ImageIcon("img/voide.png"));
							break;
					}
				}
				
			}
			this.frame.repaint();
		}
	}
	
	synchronized public void actionPerformed(ActionEvent e)
	{
			
		this.frame.requestFocus();
		
			if (e.getSource() == this.up)
			{
				this.direction = Direction.UP;
				this.notify();
			}
			
			if (e.getSource() == this.down)
			{
				this.direction = Direction.DOWN;
				this.notify();
			}
			
			if (e.getSource() == this.left)
			{
				this.direction = Direction.LEFT;
				this.notify();
			}
			
			if (e.getSource() == this.right)
			{
				this.direction = Direction.RIGHT;
				this.notify();
			}
			
	}
	
	@Override
	synchronized public Direction getDirection(){
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return this.direction;
	}
	
	@Override
	synchronized public void keyPressed(KeyEvent e)
	{
		if(e.getKeyChar() == 'z')
		{
			this.direction = Direction.UP;
			this.notify();
		}
		
		if(e.getKeyChar() == 's')
		{
			this.direction = Direction.DOWN;
			this.notify();
		}
		
		if(e.getKeyChar() == 'q')
		{
			this.direction = Direction.LEFT;
			this.notify();
		}
		
		if(e.getKeyChar() == 'd')
		{
			this.direction = Direction.RIGHT;
			this.notify();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	synchronized public void keyTyped(KeyEvent e)
	{
	
	}
	
	public void gameIsWin()
	{
		JOptionPane.showMessageDialog(this.frame, "You win !");
		this.textArea.setText("Congratulation you win the game !");
	}
	
	public void gameIsLose()
	{
		JOptionPane.showMessageDialog(this.frame, "You Lose ...");
		this.textArea.setText("Sorry but you lose the game ...");
	}
		
	
	
	
}
