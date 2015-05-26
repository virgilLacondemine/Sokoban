package fr.iutvalence.info.m2103.project.sokoban.ihm;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Menu extends JMenuBar implements ActionListener
{
	private JFrame frame;
	
	private JMenuItem ExitMenuItem;
	
	public Menu(JFrame frame)
	{
		this.frame = frame;
		JMenu menu = new JMenu("Menu");
		this.ExitMenuItem = new JMenuItem("Exit");
		menu.add(this.ExitMenuItem);
		this.ExitMenuItem.addActionListener(this);
		this.add(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JMenuItem selectedItem = (JMenuItem) e.getSource();
		
		if (selectedItem == this.ExitMenuItem)
		{
			if (JOptionPane.showConfirmDialog(this.frame, "Close Application ?", "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.frame.dispose();
			return;
		}
		
	}
	
	
	
}
